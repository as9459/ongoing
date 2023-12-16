



create or replace FUNCTION GetLocateurIdByLogement(
    p_id_batiment IN NUMBER,
    p_id_logement IN NUMBER
    ) RETURN NUMBER AS
    v_id_locataire NUMBER;
    v_current_date DATE := SYSDATE; 
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



CREATE OR REPLACE FUNCTION IsLocataireExistant(
        p_nom IN VARCHAR2,
        p_prenom IN VARCHAR2,
        p_date_de_naissance IN VARCHAR2
    )  RETURN NUMBER AS
    v_nb NUMBER;
    
    BEGIN
        SELECT count(*) into v_nb from locataire
        WHERE  lower(nom) =  lower(p_nom)
        AND lower(prenom) = lower(p_prenom)
        AND date_de_naissance =  TO_DATE( p_date_de_naissance , 'YYYY-MM-DD');
        
        if(v_nb > 0) then
        
            SELECT id_locataire into v_nb from locataire
            WHERE  lower(nom) =  lower(p_nom)
            AND lower(prenom) = lower(p_prenom)
            AND date_de_naissance =  TO_DATE( p_date_de_naissance , 'YYYY-MM-DD');
            
            RETURN v_nb;
        else
            RETURN 0;
        end if;

    EXCEPTION
        WHEN OTHERS THEN
            -- Display error message and rollback the transaction
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END IsLocataireExistant;
/



CREATE OR REPLACE PROCEDURE AddLocataire(
        p_nom IN VARCHAR2,
        p_prenom IN VARCHAR2,
        p_date_de_naissance IN VARCHAR2,
        p_telephone IN VARCHAR2,
        p_e_mail IN VARCHAR2,
        p_statut IN VARCHAR2 DEFAULT 'NoN',
        p_date_debut IN VARCHAR2,
        p_date_fin IN VARCHAR2,
        p_frais_d_agence IN NUMBER,
        p_loyer IN NUMBER,
        p_charges_fixes IN NUMBER,
        p_montant_aide IN NUMBER,
        p_jour_Paiement IN NUMBER DEFAULT 1,
        p_id_batiment IN NUMBER,
        p_id_logement IN NUMBER
    ) AS
    v_id_bail NUMBER;
    v_id_locataire NUMBER;
    
    BEGIN
    
    v_id_locataire := IsLocataireExistant(p_nom,p_prenom,p_date_de_naissance);
    if(0 = v_id_locataire) then 
    
        v_id_locataire := GetNextId('Locataire','id_locataire');
        InsertLocataire(
            p_nom,
            p_prenom,
            p_date_de_naissance,
            p_telephone,
            p_e_mail,
            p_statut,
            v_id_locataire
        );
    end if;
    
    
    
    
    v_id_bail := GetNextId('Contrat_Bail','id_bail');

        InsertContratBail(
            p_id_batiment,
            p_id_logement,
            p_date_debut,
            p_date_fin,
            p_frais_d_agence,
            p_loyer,
            p_charges_fixes,
            p_montant_aide,
            p_jour_Paiement,
            0,
            v_id_bail
        );

        InsertSigner(
            v_id_bail,
            v_id_locataire
        );

        InsertEDL(
            v_id_bail
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


CREATE OR REPLACE FUNCTION IsGarantExistant(
        p_nom IN VARCHAR2,
        p_adresse IN VARCHAR2,
        p_e_mail IN VARCHAR2,
        p_telephone IN VARCHAR2
    )  RETURN NUMBER AS
    v_nb NUMBER;
    
    BEGIN
        SELECT count(*) into v_nb from Garant
        WHERE  lower(nom) =  lower(p_nom)
        AND lower(adresse) = lower(p_adresse)
        AND lower(e_mail) = lower(p_e_mail)
        AND lower(telephone) = lower(p_telephone);
        
        if(v_nb > 0) then
        
            SELECT id_garant into v_nb from Garant
            WHERE  lower(nom) =  lower(p_nom)
            AND lower(adresse) = lower(p_adresse)
            AND lower(e_mail) = lower(p_e_mail)
            AND lower(telephone) = lower(p_telephone);
            
            RETURN v_nb;
        else
            RETURN 0;
        end if;

    EXCEPTION
        WHEN OTHERS THEN
            -- Display error message and rollback the transaction
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END IsGarantExistant;
/


CREATE OR REPLACE PROCEDURE AddGarant(
        p_id_locataire IN NUMBER,
        p_nom IN VARCHAR2,
        p_adresse IN VARCHAR2,
        p_e_mail IN VARCHAR2,
        p_telephone IN VARCHAR2
    ) AS
    v_id_garant NUMBER;
    BEGIN
        v_id_garant := IsGarantExistant(p_nom,p_adresse,p_e_mail,p_telephone);
        
        if (0 = v_id_garant) then
            v_id_garant := GetNextId('Garant','id_garant');
            InsertGarant(
                p_nom ,
                p_adresse ,
                p_e_mail ,
                p_telephone,
                v_id_garant
            );
        end if;

        InsertGarantie(
            p_id_locataire ,
            v_id_garant 
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


CREATE OR REPLACE PROCEDURE AddLogemontCharge(
        p_id_batiment IN NUMBER,
        p_id_logement IN NUMBER,
        p_date_charges IN VARCHAR2 DEFAULT SYSDATE,
        p_indexCompteur IN NUMBER,
        p_id_Type_Charges IN NUMBER,
        p_id_charges IN NUMBER DEFAULT GetNextId('Charges','id_charges')
        ) AS
        BEGIN
        InsertCharges(
            p_date_charges,
            p_indexCompteur,
            p_id_Type_Charges,
            p_id_charges
        );

        InsertLogCharge(
            p_id_batiment,
            p_id_logement,
            p_id_charges
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
    p_id_batiment IN NUMBER,
    p_id_logement IN NUMBER,
    p_date_facture IN VARCHAR2 DEFAULT SYSDATE,
    p_description IN VARCHAR2,
    p_montant_HT IN NUMBER,
    p_TVA IN NUMBER DEFAULT 20.0,
    p_type IN VARCHAR2,
    p_SIREN IN VARCHAR2,
    p_reference_du_paiement IN VARCHAR2 DEFAULT 'NoN',
    p_paiement IN NUMBER DEFAULT 0,
    p_type_Paiment IN VARCHAR2 DEFAULT 'NoN',
    p_Date_de_paiement IN VARCHAR2 DEFAULT null,
    p_id_facture IN NUMBER DEFAULT GetNextId('Facture','id_facture')
    ) AS
    BEGIN
        InsertFacture(
            p_date_facture,
            p_description,
            p_montant_HT,
            p_TVA,
            p_type,
            p_SIREN,
            p_id_facture
        );

        InsertFactLogement(
            p_id_facture,
            p_id_batiment,
            p_id_logement,
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
    p_reference_du_paiement IN VARCHAR2 DEFAULT null,
    p_paiement IN NUMBER DEFAULT null,
    p_type_Paiment IN VARCHAR2 DEFAULT null,
    p_Date_de_paiement IN VARCHAR2 DEFAULT SYSDATE,
      p_id_locataire IN NUMBER DEFAULT null
   ) AS
   v_id_locataire  NUMBER ;
   BEGIN
   
    if(p_id_locataire is null) then
        v_id_locataire := GetLocateurIdByLogement(p_id_batiment, p_id_logement);
    else
        v_id_locataire := p_id_locataire;
    end if;
    UPDATE fact_logement
    SET reference_du_paiement = p_reference_du_paiement, 
        paiement = p_paiement,
        type_Paiment = p_type_Paiment
    WHERE id_facture = p_id_facture
    And id_batiment = p_id_batiment
    And id_logement = p_id_logement
    And id_locataire = v_id_locataire;
    
    if(p_Date_de_paiement is not null) then
        UPDATE fact_logement
        SET Date_de_paiement = TO_DATE( p_Date_de_paiement , 'YYYY-MM-DD')
        WHERE id_facture = p_id_facture
        And id_batiment = p_id_batiment
        And id_logement = p_id_logement
        And id_locataire = v_id_locataire;
    end if;
       
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
        p_date_charges IN VARCHAR2 DEFAULT SYSDATE,
        p_indexCompteur IN NUMBER,
        p_id_Type_Charges IN NUMBER,
        p_id_charges IN NUMBER DEFAULT GetNextId('Charges','id_charges')
        ) AS
        BEGIN
        InsertCharges(
            p_date_charges,
            p_indexCompteur,
            p_id_Type_Charges,
            p_id_charges
        );

        InsertBatCharge(
            p_id_batiment,
            p_id_charges
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
    p_id_batiment IN NUMBER,
    p_date_facture IN VARCHAR2 DEFAULT SYSDATE,
    p_description IN VARCHAR2,
    p_montant_HT IN NUMBER,
    p_TVA IN NUMBER DEFAULT 20.0,
    p_type IN VARCHAR2,
    p_SIREN IN VARCHAR2,
    p_reference_du_paiement IN VARCHAR2 DEFAULT 'NoN',
    p_paiement IN NUMBER DEFAULT 0,
    p_type_Paiment IN VARCHAR2 DEFAULT 'NoN',
    p_Date_de_paiement IN VARCHAR2 DEFAULT null,
    p_id_facture IN NUMBER  DEFAULT GetNextId('Facture','id_facture')
    ) AS
    BEGIN
        InsertFacture(
            p_date_facture,
            p_description,
            p_montant_HT,
            p_TVA,
            p_type,
            p_SIREN,
            p_id_facture
        );

        InsertFactBatiment(
            p_id_facture,
            p_id_batiment,
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
    p_reference_du_paiement IN VARCHAR2,
    p_paiement IN NUMBER,
    p_type_Paiment IN VARCHAR2,
    p_Date_de_paiement IN VARCHAR2 DEFAULT SYSDATE 
    ) AS
    BEGIN
    
    UPDATE fact_batiment
    SET reference_du_paiement = p_reference_du_paiement, 
        paiement = p_paiement,
        type_Paiment = p_type_Paiment
    WHERE id_facture = p_id_facture
    And id_batiment = p_id_batiment;
    
    if(p_Date_de_paiement is not null) then
        UPDATE fact_batiment
        SET Date_de_paiement = TO_DATE( p_Date_de_paiement , 'YYYY-MM-DD')
        WHERE id_facture = p_id_facture
        And id_batiment = p_id_batiment;
    end if;
       
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('paiement fact_batiment inserted successfully.');
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END SetBatimentFacturePaiement;
/




CREATE OR REPLACE PROCEDURE SetStatutSorti(
      p_id_locataire IN NUMBER,
      p_statut_sortie IN VARCHAR2 
    ) AS
    v_id_bail NUMBER;
    v_current_date DATE := SYSDATE; 
    BEGIN
    
    SELECT s.id_bail
    INTO v_id_bail
    FROM Signer s ,Contrat_bail cb
    WHERE s.id_bail = cb.id_bail
    AND s.id_locataire = p_id_locataire
    AND v_current_date BETWEEN cb.date_debut AND NVL(cb.date_fin, v_current_date);

    
    
    UPDATE EDL
    SET statut_sortie = p_statut_sortie
    WHERE id_bail = v_id_bail;
       
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('statut sorti inserted successfully.');
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END SetStatutSorti;
/



CREATE OR REPLACE PROCEDURE SetStatutEntree(
      p_id_locataire IN NUMBER,
      p_statut_entree IN VARCHAR2
    ) AS
    v_id_bail NUMBER;
    v_current_date DATE := SYSDATE; 
    BEGIN
    
    SELECT s.id_bail
    INTO v_id_bail
    FROM Signer s ,Contrat_bail cb
    WHERE s.id_bail = cb.id_bail
    AND s.id_locataire = p_id_locataire
    AND v_current_date BETWEEN cb.date_debut AND NVL(cb.date_fin, v_current_date);

    
    UPDATE EDL
    SET statut_entree = p_statut_entree
    WHERE id_bail = v_id_bail;
       
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('statut entree inserted successfully.');
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
END SetStatutEntree;
/



CREATE OR REPLACE FUNCTION getTableData(p_table_name IN VARCHAR2, p_columns IN VARCHAR2 DEFAULT NULL) RETURN SYS_REFCURSOR AS
    v_sql_query VARCHAR2(1000);
    my_cursor SYS_REFCURSOR;
BEGIN
    IF p_columns IS NULL THEN
        -- If columns are not specified, retrieve all columns
        v_sql_query := 'SELECT * FROM ' || p_table_name;
    ELSE
        -- If columns are specified, construct a dynamic query with specified columns
        v_sql_query := 'SELECT ' || p_columns || ' FROM ' || p_table_name;
    END IF;

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
        -- V�rifie le nombre de contrats actifs pour le logement sp�cifi�
        SELECT COUNT(*)
        INTO v_count
        FROM Contrat_bail
        WHERE id_batiment = p_id_batiment
            AND id_logement = p_id_logement
            AND p_date_debut_contrat BETWEEN date_debut AND NVL(date_fin, SYSDATE + 1);

        -- Si le nombre de contrats actifs est �gal � 0, le logement est consid�r� comme vide
        RETURN v_count = 0;
    EXCEPTION
        WHEN OTHERS THEN
            RETURN FALSE; -- G�rer les exceptions selon les besoins
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
            SELECT fl.ID_LOCATAIRE, fl.ID_BATIMENT, fl.ID_LOGEMENT, fl.ID_FACTURE, f.DATE_FACTURE,fl.PAIEMENT as payer,((f.montant_HT + (f.montant_HT * (f.TVA / 100)) - c.montant_aide)-fl.PAIEMENT) as Reste

            FROM fact_logement fl, facture f, contrat_bail c, Signer s
            WHERE fl.id_facture = f.id_facture 
            AND fl.paiement < (f.montant_HT + (f.montant_HT * (f.TVA / 100)) - c.montant_aide)
            AND c.ID_BATIMENT = fl.ID_BATIMENT
            AND c.ID_LOGEMENT = fl.ID_LOGEMENT
            AND c.id_bail = s.id_bail
            AND s.ID_LOCATAIRE = fl.ID_LOCATAIRE;

        RETURN v_cursor;
END GetLogementUnpaidFacts;
/



create or replace FUNCTION GetBatimentUnpaidFacts RETURN SYS_REFCURSOR IS
        v_cursor SYS_REFCURSOR;
    BEGIN
        OPEN v_cursor FOR
            SELECT fl.ID_BATIMENT, fl.ID_FACTURE, f.DATE_FACTURE, fl.REFERENCE_DU_PAIEMENT,fl.PAIEMENT as payer, ((f.montant_HT + (f.montant_HT * (f.TVA / 100)) )-fl.PAIEMENT) as Reste

            FROM fact_batiment fl, facture f
            WHERE fl.id_facture = f.id_facture 
            AND fl.paiement < (f.montant_HT + (f.montant_HT * (f.TVA / 100)));

        RETURN v_cursor;
END GetBatimentUnpaidFacts;
/



create or replace FUNCTION GetLogementsByBatiment(p_id_paiement NUMBER) RETURN SYS_REFCURSOR IS
        v_cursor SYS_REFCURSOR;
    BEGIN
        OPEN v_cursor FOR
        SELECT
        l.*,
        CASE
            WHEN TO_NUMBER(TO_CHAR(cb.date_fin, 'YYYYMMDD')) <= TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMMDD')) THEN 'Libre'
            ELSE 'Occupe'
        END AS state
        FROM
            Logement l
        JOIN
            Contrat_bail cb ON l.id_batiment = cb.id_batiment AND l.id_logement = cb.id_logement
        WHERE
            l.id_batiment = p_id_paiement;
        RETURN v_cursor;
END GetLogementsByBatiment;
/



CREATE OR REPLACE FUNCTION GetNbLogBatiment(
        p_id_batiment IN NUMBER
    ) RETURN NUMBER IS
        v_count NUMBER;
    BEGIN
        -- Count the number of housing units in the specified building
        SELECT COUNT(DISTINCT id_logement)
        INTO v_count
        FROM Logement
        WHERE id_batiment = p_id_batiment;

        -- Return the count
        RETURN v_count;
    EXCEPTION
        WHEN OTHERS THEN
            -- Handle exceptions as needed
        RETURN NULL; -- or another appropriate value
END GetNbLogBatiment;
/



create or replace FUNCTION GetLogementALouer(
        p_id_batiment IN NUMBER
    ) RETURN SYS_REFCURSOR IS
        v_cursor SYS_REFCURSOR;
    BEGIN
        OPEN v_cursor FOR
            SELECT id_batiment, id_logement
            FROM Logement
            WHERE id_batiment = p_id_batiment
            AND (id_batiment, id_logement) NOT IN (
                SELECT id_batiment, id_logement
                FROM Contrat_bail
                WHERE SYSDATE BETWEEN date_debut AND NVL(date_fin, SYSDATE)
                AND id_batiment = p_id_batiment
            )
            OR id_logement IN (
                SELECT id_logement
                FROM Logement
                WHERE COLOCATION = 1
                AND id_batiment = p_id_batiment
            );

    RETURN v_cursor;
END GetLogementALouer;
/



create or replace FUNCTION GetBatementALouer
    RETURN SYS_REFCURSOR IS
        v_cursor SYS_REFCURSOR;
    BEGIN
        OPEN v_cursor FOR
            SELECT DISTINCT id_batiment
            FROM Logement
            WHERE (id_batiment, id_logement) NOT IN (
                SELECT id_batiment, id_logement
                FROM Contrat_bail
                WHERE SYSDATE BETWEEN date_debut AND NVL(date_fin, SYSDATE)
            )
            OR id_logement IN (
                SELECT id_logement
                FROM Logement
                WHERE COLOCATION = 1
            );

    RETURN v_cursor;
END GetBatementALouer;
/


