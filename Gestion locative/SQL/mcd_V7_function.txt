
CREATE OR REPLACE FUNCTION GetNextId(
        p_table_name IN VARCHAR2,
        p_colom_id IN VARCHAR2
    ) RETURN NUMBER IS
    v_sql_query VARCHAR2(1000);
    v_next_id NUMBER;
    BEGIN
    
    v_sql_query := 'SELECT NVL(MAX('|| p_colom_id ||'), 0) + 1 FROM ' || p_table_name;

    EXECUTE IMMEDIATE v_sql_query INTO v_next_id; 
    RETURN v_next_id;
    EXCEPTION
    WHEN OTHERS THEN
        RETURN NULL; -- Handle exceptions as needed
END GetNextId;
/



create or replace FUNCTION GetLocateurIdByLogement(
    p_id_batiment IN NUMBER,
    p_id_logement IN NUMBER
    ) RETURN NUMBER AS
    v_id_locataire NUMBER;
    v_current_date DATE := SYSDATE; -- Current date
    BEGIN
    SELECT s.id_locataire
    INTO v_id_locataire
    FROM Signer s ,Contrat_bail cb
    WHERE s.id_bail = cb.id_bail
    AND cb.id_batiment = p_id_batiment
    AND cb.id_logement = p_id_logement
    AND v_current_date BETWEEN cb.date_debut AND NVL(cb.date_fin, v_current_date);

    RETURN v_id_locataire;
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        RETURN NULL;
END GetLocateurIdByLogement;
/



CREATE OR REPLACE PROCEDURE AddLocataire(
        p_id_locataire IN NUMBER DEFAULT GetNextId('Locataire','id_locataire'),
        p_nom IN VARCHAR2,
        p_prenom IN VARCHAR2,
        p_date_de_naissance IN VARCHAR2,
        p_telephone IN VARCHAR2,
        p_e_mail IN VARCHAR2,
        p_statut IN VARCHAR2 DEFAULT 'NoN',
        p_id_bail IN NUMBER DEFAULT GetNextId('Contrat_Bail','id_bail'),
        p_date_debut IN VARCHAR2,
        p_date_fin IN VARCHAR2,
        p_frais_d_agence IN NUMBER,
        p_loyer IN NUMBER,
        p_charges_fixes IN NUMBER,
        p_jour_Paiement IN NUMBER DEFAULT 1,
        p_solod_TC IN NUMBER DEFAULT 0,
        p_id_batiment IN NUMBER,
        p_id_logement IN NUMBER
    ) AS
    BEGIN

        InsertLocataire(
            p_id_locataire,
            p_nom,
            p_prenom,
            p_date_de_naissance,
            p_telephone,
            p_e_mail,
            p_statut
        );

        InsertContratBail(
            p_id_bail,
            p_date_debut,
            p_date_fin,
            p_frais_d_agence,
            p_loyer,
            p_charges_fixes,
            p_jour_Paiement,
            p_solod_TC,
            p_id_batiment,
            p_id_logement
        );

        InsertSigner(
            p_id_bail,
            p_id_locataire
        );

        InsertEDL(
            p_id_bail,
            GetNextId('EDL','id_EDL')
        );

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Locataire inserted successfully.');

    EXCEPTION
        WHEN OTHERS THEN
            -- Display error message and rollback the transaction
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END AddLocataire;
/



CREATE OR REPLACE PROCEDURE AddLogemontCharge(
        p_id_batiment IN NUMBER,
        p_id_logement IN NUMBER,
        p_id_charges IN NUMBER DEFAULT GetNextId('Charges','id_charges'),
        p_date_charges IN VARCHAR2,
        p_consommation IN NUMBER,
        p_id_Type_Charges IN NUMBER
        ) AS
        BEGIN
        InsertCharges(
            p_id_charges,
            p_date_charges,
            p_consommation,
            p_id_Type_Charges
        );

        InsertLogCharge(
            p_id_batiment,
            p_id_logement,
            p_id_charges,
            p_date_charges,
            p_id_Type_Charges
        );

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('log_charge inserted successfully.');
        EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END AddLogemontCharge;
/



CREATE OR REPLACE PROCEDURE AddLogementFacture(
    p_id_facture IN NUMBER DEFAULT GetNextId('Facture','id_facture'),
    p_id_batiment IN NUMBER,
    p_id_logement IN NUMBER,
    p_date_facture IN VARCHAR2,
    p_description IN VARCHAR2,
    p_aide IN NUMBER DEFAULT 0,
    p_montant_de_l_aide IN NUMBER DEFAULT 0.0,
    p_montant_HT IN NUMBER,
    p_TVA IN NUMBER DEFAULT 20.0,
    p_type IN VARCHAR2,
    p_SIREN IN VARCHAR2,
    p_reference_du_paiement IN VARCHAR2 DEFAULT 'NoN',
    p_paiement IN NUMBER DEFAULT 0,
    p_type_Paiment IN VARCHAR2 DEFAULT 'NoN',
    p_Date_de_paiement IN VARCHAR2 DEFAULT 'null'
    ) AS
    BEGIN
        InsertFacture(
            p_id_facture,
            p_date_facture,
            p_description,
            p_aide,
            p_montant_de_l_aide,
            p_montant_HT,
            p_TVA,
            p_type,
            p_SIREN
        );

        InsertFactLogement(
            p_id_facture,
            p_id_batiment,
            p_id_logement,
            p_date_facture,
            GetLocateurIdByLogement(p_id_batiment, p_id_logement),
            p_reference_du_paiement,
            p_paiement ,
            p_type_Paiment ,
            p_Date_de_paiement
        );

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('fact_logement inserted successfully.');
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END AddLogementFacture;
/



CREATE OR REPLACE PROCEDURE SetLogementFacturePaiement(
    p_id_facture IN NUMBER,
    p_id_batiment IN NUMBER,
    p_id_logement IN NUMBER,
    p_date_facture IN VARCHAR2,
    p_reference_du_paiement IN VARCHAR2,
    p_paiement IN NUMBER,
    p_type_Paiment IN VARCHAR2,
    p_Date_de_paiement IN VARCHAR2
    ) AS
    BEGIN
    UPDATE fact_logement
    SET reference_du_paiement = p_reference_du_paiement, 
        paiement = p_paiement,
        type_Paiment = p_type_Paiment,
        Date_de_paiement = p_Date_de_paiement
    WHERE id_facture = p_id_facture
    And id_batiment = p_id_batiment
    And id_logement = p_id_logement
    And date_facture = TO_DATE( p_date_facture , 'YYYY-MM-DD')
    And id_locataire = GetLocateurIdByLogement(p_id_batiment, p_id_logement);
       
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('paiement fact_logement inserted successfully.');
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END SetLogementFacturePaiement;
/


CREATE OR REPLACE PROCEDURE AddBatimentCharge(
        p_id_batiment IN NUMBER,
        p_id_charges IN NUMBER DEFAULT GetNextId('Charges','id_charges'),
        p_date_charges IN VARCHAR2,
        p_consommation IN NUMBER,
        p_id_Type_Charges IN NUMBER
        ) AS
        BEGIN
        InsertCharges(
            p_id_charges,
            p_date_charges,
            p_consommation,
            p_id_Type_Charges
        );

        InsertBatCharge(
            p_id_batiment,
            p_id_charges,
            p_date_charges,
            p_id_Type_Charges
        );

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('log_charge inserted successfully.');
        EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END AddBatimentCharge;
/



CREATE OR REPLACE PROCEDURE AddBatimentFacture(
    p_id_facture IN NUMBER  DEFAULT GetNextId('Facture','id_facture'),
    p_id_batiment IN NUMBER,
    p_id_logement IN NUMBER,
    p_date_facture IN VARCHAR2,
    p_description IN VARCHAR2,
    p_aide IN NUMBER DEFAULT 0,
    p_montant_de_l_aide IN NUMBER DEFAULT 0.0,
    p_montant_HT IN NUMBER,
    p_TVA IN NUMBER DEFAULT 20.0,
    p_type IN VARCHAR2,
    p_SIREN IN VARCHAR2,
    p_reference_du_paiement IN VARCHAR2 DEFAULT 'NoN',
    p_paiement IN NUMBER DEFAULT 0,
    p_type_Paiment IN VARCHAR2 DEFAULT 'NoN',
    p_Date_de_paiement IN VARCHAR2 DEFAULT 'null'
    ) AS
    BEGIN
        InsertFacture(
            p_id_facture,
            p_date_facture,
            p_description,
            p_aide,
            p_montant_de_l_aide,
            p_montant_HT,
            p_TVA,
            p_type,
            p_SIREN
        );

        InsertFactBatiment(
            p_id_facture,
            p_id_batiment,
            p_date_facture,
            p_reference_du_paiement,
            p_paiement,
            p_type_Paiment,
            p_Date_de_paiement
        );

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('fact_logement inserted successfully.');
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END AddBatimentFacture;
/



CREATE OR REPLACE PROCEDURE SetBatimentFacturePaiement(
    p_id_facture IN NUMBER,
    p_id_batiment IN NUMBER,
    p_date_facture IN VARCHAR2,
    p_reference_du_paiement IN VARCHAR2,
    p_paiement IN NUMBER,
    p_type_Paiment IN VARCHAR2,
    p_Date_de_paiement IN VARCHAR2
    ) AS
    BEGIN
    
    UPDATE fact_batiment
    SET reference_du_paiement = p_reference_du_paiement, 
        paiement = p_paiement,
        type_Paiment = p_type_Paiment,
        Date_de_paiement = p_Date_de_paiement
    WHERE id_facture = p_id_facture
    And id_batiment = p_id_batiment
    And date_facture = TO_DATE( p_date_facture , 'YYYY-MM-DD');
       
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('paiement fact_batiment inserted successfully.');
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END SetBatimentFacturePaiement;
/



CREATE OR REPLACE PROCEDURE AddGarant(
        p_id_locataire IN NUMBER,
        p_id_garant IN NUMBER DEFAULT GetNextId('Garant','id_garant'),
        p_nom IN VARCHAR2,
        p_adresse IN VARCHAR2,
        p_e_mail IN VARCHAR2,
        p_telephone IN VARCHAR2
    ) AS
    BEGIN

        InsertGarant(
            p_id_garant,
            p_nom ,
            p_adresse ,
            p_e_mail ,
            p_telephone
        );

        InsertGarantie(
            p_id_locataire ,
            p_id_garant 
        );
        

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Locataire inserted successfully.');

    EXCEPTION
        WHEN OTHERS THEN
            -- Display error message and rollback the transaction
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END AddGarant;
/



CREATE OR REPLACE PROCEDURE SetStatutSorti(
      p_id_bail IN NUMBER,
      p_id_EDL IN NUMBER,
      p_statut_sortie IN VARCHAR2 
    ) AS
    BEGIN
    UPDATE EDL
    SET statut_sortie = p_statut_sortie
    WHERE id_bail = p_id_bail
    And id_EDL = p_id_EDL;
       
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('statut sorti inserted successfully.');
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END SetStatutSorti;
/



CREATE OR REPLACE PROCEDURE SetStatutEntree(
      p_id_bail IN NUMBER,
      p_id_EDL IN NUMBER,
      p_statut_entree IN VARCHAR2
    ) AS
    BEGIN
    UPDATE EDL
    SET statut_entree = p_statut_entree
    WHERE id_bail = p_id_bail
    And id_EDL = p_id_EDL;
       
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('statut entree inserted successfully.');
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END SetStatutEntree;
/



CREATE OR REPLACE FUNCTION getTableData(p_table_name IN VARCHAR2) RETURN SYS_REFCURSOR AS
    v_sql_query VARCHAR2(1000);
    my_cursor SYS_REFCURSOR;
    BEGIN
    v_sql_query := 'SELECT * FROM ' || p_table_name;

    OPEN my_cursor FOR v_sql_query;

    RETURN my_cursor;
END getTableData;
/


CREATE OR REPLACE FUNCTION IsLogementEmpty(
        p_id_batiment IN NUMBER,
        p_id_logement IN NUMBER,
        p_date_debut_contrat IN DATE
    ) RETURN BOOLEAN IS
        v_count NUMBER;
    BEGIN
        -- Vérifie le nombre de contrats actifs pour le logement spécifié
        SELECT COUNT(*)
        INTO v_count
        FROM Contrat_bail
        WHERE id_batiment = p_id_batiment
            AND id_logement = p_id_logement
            AND p_date_debut_contrat BETWEEN date_debut AND NVL(date_fin, SYSDATE + 1);

        -- Si le nombre de contrats actifs est égal à 0, le logement est considéré comme vide
        RETURN v_count = 0;
    EXCEPTION
        WHEN OTHERS THEN
            RETURN FALSE; -- Gérer les exceptions selon les besoins
END IsLogementEmpty;
/


CREATE OR REPLACE FUNCTION GetLogementEmptys
    RETURN SYS_REFCURSOR IS
        v_cursor SYS_REFCURSOR;
    BEGIN
        OPEN v_cursor FOR
            SELECT id_batiment, id_logement
            FROM Logement
            WHERE (id_batiment, id_logement) NOT IN (
                SELECT id_batiment, id_logement
                FROM Contrat_bail
                WHERE SYSDATE BETWEEN date_debut AND NVL(date_fin, SYSDATE)
            );

        RETURN v_cursor;
END GetLogementEmptys;
/



create or replace FUNCTION GetLogementUnpaidFacts RETURN SYS_REFCURSOR IS
        v_cursor SYS_REFCURSOR;
    BEGIN
        OPEN v_cursor FOR
            SELECT fl.ID_LOCATAIRE, fl.ID_BATIMENT, fl.ID_LOGEMENT, fl.ID_FACTURE, fl.DATE_FACTURE, fl.REFERENCE_DU_PAIEMENT,fl.PAIEMENT as payé, ((f.montant_HT + (f.montant_HT * (f.TVA / 100)) - f.montant_de_l_aide)-fl.PAIEMENT) as Reste

            FROM fact_logement fl, facture f
            WHERE fl.id_facture = f.id_facture AND fl.date_facture = f.date_facture
            AND fl.paiement < (f.montant_HT + (f.montant_HT * (f.TVA / 100)) - f.montant_de_l_aide);

        RETURN v_cursor;
END GetLogementUnpaidFacts;
/

create or replace FUNCTION GetBatimentUnpaidFacts RETURN SYS_REFCURSOR IS
        v_cursor SYS_REFCURSOR;
    BEGIN
        OPEN v_cursor FOR
            SELECT fl.ID_BATIMENT, fl.ID_FACTURE, fl.DATE_FACTURE, fl.REFERENCE_DU_PAIEMENT,fl.PAIEMENT as payé, ((f.montant_HT + (f.montant_HT * (f.TVA / 100)) - f.montant_de_l_aide)-fl.PAIEMENT) as Reste

            FROM fact_batiment fl, facture f
            WHERE fl.id_facture = f.id_facture AND fl.date_facture = f.date_facture
            AND fl.paiement < (f.montant_HT + (f.montant_HT * (f.TVA / 100)) - f.montant_de_l_aide);

        RETURN v_cursor;
END GetBatimentUnpaidFacts;
/








