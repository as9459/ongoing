



CREATE OR REPLACE PROCEDURE InsertLocataire(
      p_id_locataire IN NUMBER  DEFAULT GetNextId('Locataire','id_locataire'),
      p_nom IN VARCHAR2,
      p_prenom IN VARCHAR2,
      p_date_de_naissance IN VARCHAR2,
      p_telephone IN VARCHAR2,
      p_e_mail IN VARCHAR2,
      p_statut IN VARCHAR2 DEFAULT 'NoN'
   ) AS
   BEGIN
      INSERT INTO Locataire (id_locataire, nom, prenom, telephone, date_de_naissance, statut, e_mail)
      VALUES (p_id_locataire, p_nom, p_prenom, p_telephone, TO_DATE( p_date_de_naissance , 'YYYY-MM-DD'), p_statut, p_e_mail);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Locataire inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertLocataire;
/



CREATE OR REPLACE PROCEDURE InsertCorrespondre(
      p_id_facture IN NUMBER,
      p_date_facture IN VARCHAR2,
      p_id_charges IN NUMBER,
      p_date_charges IN VARCHAR2,
      p_charges_dues IN NUMBER,
      p_charges_regularises IN NUMBER,
      p_id_Type_Charges IN NUMBER
   ) AS
   BEGIN
      INSERT INTO correspondre (id_facture, date_facture, id_charges, date_charges, charges_dues, charges_regularises, id_Type_Charges)
      VALUES (p_id_facture, TO_DATE( p_date_facture , 'YYYY-MM-DD'), p_id_charges, TO_DATE( p_date_charges , 'YYYY-MM-DD'), p_charges_dues, p_charges_regularises, p_id_Type_Charges);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('correspondre inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertCorrespondre;
/



CREATE OR REPLACE PROCEDURE InsertGarantie(
      p_id_locataire IN NUMBER,
      p_id_garant IN NUMBER
   ) AS
   BEGIN
      INSERT INTO Garantie (id_locataire, id_garant)
      VALUES (p_id_locataire, p_id_garant);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Garantie inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertGarantie;
/



CREATE OR REPLACE PROCEDURE InsertEDL(
      p_id_bail IN NUMBER,
      p_id_EDL IN NUMBER  DEFAULT GetNextId('EDL','id_EDL'),
      p_statut_entree IN VARCHAR2 DEFAULT 'NoN',
      p_statut_sortie IN VARCHAR2 DEFAULT 'NoN'
   ) AS
   BEGIN
      INSERT INTO EDL (id_bail, id_EDL, Statut_entree, Statut_sortie)
      VALUES (p_id_bail, p_id_EDL, p_statut_entree, p_statut_sortie);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('EDL inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertEDL;
/



CREATE OR REPLACE PROCEDURE InsertLogCharge(
      p_id_batiment IN NUMBER,
      p_id_logement IN NUMBER,
      p_id_charges IN NUMBER,
      p_date_charges IN VARCHAR2,
      p_id_Type_Charges IN NUMBER
   ) AS
   BEGIN
      INSERT INTO log_charge (id_batiment, id_logement, id_charges, date_charges, id_Type_Charges)
      VALUES (p_id_batiment, p_id_logement, p_id_charges, TO_DATE( p_date_charges , 'YYYY-MM-DD'), p_id_Type_Charges);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('log_charge inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertLogCharge;
/



CREATE OR REPLACE PROCEDURE InsertFactLogement(
      p_id_facture IN NUMBER,
      p_id_batiment IN NUMBER,
      p_id_logement IN NUMBER,
      p_date_facture IN VARCHAR2,
      p_id_locataire IN NUMBER,
      p_reference_du_paiement IN VARCHAR2,
      p_paiement IN NUMBER,
      p_type_Paiment IN VARCHAR2,
      p_Date_de_paiement IN VARCHAR2
   ) AS
   BEGIN
      INSERT INTO fact_logement (id_facture, id_batiment, id_logement, date_facture, id_locataire, reference_du_paiement, paiement, type_Paiment, Date_de_paiement)
      VALUES (p_id_facture, p_id_batiment, p_id_logement, TO_DATE( p_date_facture , 'YYYY-MM-DD'), p_id_locataire, p_reference_du_paiement, p_paiement, p_type_Paiment, TO_DATE( p_Date_de_paiement , 'YYYY-MM-DD'));

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('fact_logement inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertFactLogement;
/



CREATE OR REPLACE PROCEDURE InsertBatCharge(
      p_id_batiment IN NUMBER,
      p_id_charges IN NUMBER,
      p_date_charges IN VARCHAR2,
      p_id_Type_Charges IN NUMBER
   ) AS
   BEGIN
      INSERT INTO bat_charge (id_batiment, id_charges, date_charges, id_Type_Charges)
      VALUES (p_id_batiment, p_id_charges, TO_DATE( p_date_charges , 'YYYY-MM-DD'), p_id_Type_Charges);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('bat_charge inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertBatCharge;
/



CREATE OR REPLACE PROCEDURE InsertFactBatiment(
      p_id_facture IN NUMBER,
      p_id_batiment IN NUMBER,
      p_date_facture IN VARCHAR2,
      p_reference_du_paiement IN VARCHAR2,
      p_paiement IN NUMBER,
      p_type_Paiment IN VARCHAR2,
      p_Date_de_paiement IN VARCHAR2
   ) AS
   BEGIN
      INSERT INTO fact_batiment (id_facture, id_batiment, date_facture, reference_du_paiement, paiement, type_Paiment, Date_de_paiement)
      VALUES (p_id_facture, p_id_batiment, TO_DATE( p_date_facture , 'YYYY-MM-DD'), p_reference_du_paiement, p_paiement, p_type_Paiment, TO_DATE( p_Date_de_paiement , 'YYYY-MM-DD'));

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('fact_batiment inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertFactBatiment;
/



CREATE OR REPLACE PROCEDURE InsertSigner(
      p_id_bail IN NUMBER,
      p_id_locataire IN NUMBER
   ) AS
   BEGIN
      INSERT INTO Signer (id_bail, id_locataire)
      VALUES (p_id_bail, p_id_locataire);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Signer inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertSigner;
/



CREATE OR REPLACE PROCEDURE InsertContratBail(
      p_id_bail IN NUMBER,
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
      dateFin date;
   BEGIN
      if(p_date_fin is null) then
         dateFin := null;
      else
         dateFin := TO_DATE( p_date_fin , 'YYYY-MM-DD');
      end if;

      INSERT INTO Contrat_bail (id_bail, date_debut, date_fin, frais_d_agence, loyer, charges_fixes, jour_Paiement, solod_TC, id_batiment, id_logement)
      VALUES (p_id_bail, TO_DATE( p_date_debut , 'YYYY-MM-DD'), dateFin, p_frais_d_agence, p_loyer, p_charges_fixes, p_jour_Paiement, p_solod_TC, p_id_batiment, p_id_logement);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Contrat_bail inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertContratBail;
/



CREATE OR REPLACE PROCEDURE InsertFicheDiagnostic(
      p_ref IN VARCHAR2,
      p_id_batiment IN NUMBER,
      p_id_logement IN NUMBER,
      p_amiante IN NUMBER DEFAULT 0,
      p_date_amiante IN VARCHAR2,
      p_plomb IN NUMBER DEFAULT 0,
      p_date_plomb IN VARCHAR2,
      p_date_debut_ERP IN VARCHAR2,
      p_date_fin_ERP IN VARCHAR2,
      p_date_debut_DPE IN VARCHAR2,
      p_date_fin_DPE IN VARCHAR2
   ) AS

   BEGIN


      INSERT INTO Fiche_diagnostic (ref, id_batiment, id_logement, amiante, date_amiante, plomb, date_plomb, date_debut_ERP, date_fin_ERP, date_debut_DPE, date_fin_DPE)
      VALUES (p_ref, p_id_batiment, p_id_logement, p_amiante, TO_DATE( p_date_amiante , 'YYYY-MM-DD'), p_plomb, TO_DATE( p_date_plomb , 'YYYY-MM-DD'), 
               TO_DATE( p_date_debut_ERP , 'YYYY-MM-DD'), TO_DATE( p_date_fin_ERP , 'YYYY-MM-DD'), TO_DATE( p_date_debut_DPE , 'YYYY-MM-DD'), TO_DATE( p_date_fin_DPE , 'YYYY-MM-DD'));

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Fiche_diagnostic inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertFicheDiagnostic;
/



CREATE OR REPLACE PROCEDURE InsertCharges(
      p_id_charges IN NUMBER DEFAULT GetNextId('Charges','id_charges'),
      p_date_charges IN VARCHAR2,
      p_consommation IN NUMBER,
      p_id_Type_Charges IN NUMBER
   ) AS
   BEGIN
      INSERT INTO Charges (id_charges, date_charges, consommation, id_Type_Charges)
      VALUES (p_id_charges, TO_DATE( p_date_charges , 'YYYY-MM-DD'), p_consommation, p_id_Type_Charges);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Charges inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertCharges;
/



CREATE OR REPLACE PROCEDURE InsertFacture(
      p_id_facture IN NUMBER DEFAULT GetNextId('Facture','id_facture'),
      p_date_facture IN VARCHAR2,
      p_description IN VARCHAR2,
      p_aide IN NUMBER DEFAULT 0,
      p_montant_de_l_aide IN NUMBER DEFAULT 0.0,
      p_montant_HT IN NUMBER,
      p_TVA IN NUMBER DEFAULT 20.0,
      p_type IN VARCHAR2,
      p_SIREN IN VARCHAR2
   ) AS
   BEGIN
      INSERT INTO Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN)
      VALUES (p_id_facture,TO_DATE( p_date_facture , 'YYYY-MM-DD') , p_description, p_aide, p_montant_de_l_aide, p_montant_HT, p_TVA, p_type, p_SIREN);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Facture inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertFacture;
/



CREATE OR REPLACE PROCEDURE InsertLogement(
      p_id_batiment IN NUMBER,
      p_id_logement IN NUMBER  DEFAULT GetNextId('Logement','id_logement'),
      p_type IN VARCHAR2,
      p_etage IN NUMBER,
      p_surface IN NUMBER,
      p_colocation IN NUMBER DEFAULT 0,
      p_ICC IN NUMBER,
      p_garage IN NUMBER DEFAULT 0,
      p_jardin IN NUMBER DEFAULT 0,
      p_balcon IN NUMBER DEFAULT 0
   ) AS
   BEGIN
      INSERT INTO Logement (id_batiment, id_logement, type, etage, surface, colocation, ICC, garage, jardin, balcon)
      VALUES (p_id_batiment, p_id_logement, p_type, p_etage, p_surface, p_colocation, p_ICC, p_garage, p_jardin, p_balcon);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Logement inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertLogement;
/



CREATE OR REPLACE PROCEDURE InsertGarant(
      p_id_garant IN NUMBER DEFAULT GetNextId('Garant','id_garant'),
      p_nom IN VARCHAR2,
      p_adresse IN VARCHAR2,
      p_e_mail IN VARCHAR2,
      p_telephone IN VARCHAR2
   ) AS
   BEGIN
      INSERT INTO Garant (id_garant, nom, adresse, e_mail, telephone)
      VALUES (p_id_garant, p_nom, p_adresse, p_e_mail, p_telephone);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Garant inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertGarant;
/



CREATE OR REPLACE PROCEDURE InsertTypeCharges(
      p_id_Type_Charges IN NUMBER  DEFAULT GetNextId('Type_Charges','id_Type_Charges'),
      p_prix_unitaire IN NUMBER,
      p_nom IN VARCHAR2
   ) AS
   BEGIN
      INSERT INTO Type_Charges (id_Type_Charges, prix_unitaire, nom)
      VALUES (p_id_Type_Charges, p_prix_unitaire, p_nom);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Type_Charges inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertTypeCharges;
/



CREATE OR REPLACE PROCEDURE InsertEntreprise(
      p_SIREN IN VARCHAR2,
      p_nom IN VARCHAR2,
      p_serves IN VARCHAR2,
      p_adresse IN VARCHAR2,
      p_CP IN VARCHAR2,
      p_IBAN IN VARCHAR2,
      p_ville IN VARCHAR2,
      p_e_mail IN VARCHAR2,
      p_telephone IN VARCHAR2
   ) AS
   BEGIN
      INSERT INTO Entreprise (SIREN, nom, serves, adresse, CP, IBAN, ville, e_mail, telephone)
      VALUES (p_SIREN, p_nom, p_serves, p_adresse, p_CP, p_IBAN, p_ville, p_e_mail, p_telephone);

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Entreprise inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertEntreprise;
/



CREATE OR REPLACE PROCEDURE InsertBatiment(
      p_id_batiment IN NUMBER  DEFAULT GetNextId('Batiment','id_batiment'),
      p_adresse IN VARCHAR2,
      p_code_postal IN CHAR,
      p_ville IN VARCHAR2,
      p_regime_juridique IN VARCHAR2,
      p_date_construction IN VARCHAR2
   ) AS
   BEGIN
      INSERT INTO Batiment (id_batiment, adresse, code_postal, ville, regime_juridique, date_construction)
      VALUES (p_id_batiment, p_adresse, p_code_postal, p_ville, p_regime_juridique, TO_DATE( p_date_construction , 'YYYY-MM-DD'));

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('Batiment inserted successfully.');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
         ROLLBACK;
END InsertBatiment;
/
