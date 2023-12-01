

CREATE TABLE Locataire(
   id_locataire NUMBER(10),
   nom VARCHAR2(50)    constraint nn_Locataire_nom Not null,
   prenom VARCHAR2(50) constraint nn_Locataire_prenom Not null,
   telephone VARCHAR2(10) ,
   date_de_naissance DATE constraint nn_Locataire_Date_de_naissance Not null,
   statut VARCHAR2(50) DEFAULT 'NoN',
   e_mail VARCHAR2(50) constraint ck_Locataire_mail check ( E_mail like '%@%.%'),
   constraint pk_Locataire PRIMARY KEY(id_locataire)
);


CREATE TABLE Batiment(
   id_batiment NUMBER(3),
   adresse VARCHAR2(100) constraint nn_Batiment_Adresse Not null,
   code_postal CHAR(5) constraint nn_Batiment_code_postal Not null,
   ville VARCHAR2(50) constraint nn_Batiment_ville Not null,
   regime_juridique VARCHAR2(50) ,
   date_construction DATE ,
   constraint pk_Batiment PRIMARY KEY(id_batiment)
);


CREATE TABLE Entreprise(
   SIREN VARCHAR2(9) ,
   nom VARCHAR2(50) constraint nn_Entreprise_Nom Not null,
   serves VARCHAR2(50) constraint nn_Entreprise_serves Not null,
   adresse VARCHAR2(50) constraint nn_Entreprise_Adresse Not null,
   CP VARCHAR2(50) constraint nn_Entreprise_CP Not null,
   IBAN VARCHAR2(50) ,
   ville VARCHAR2(50) constraint nn_Entreprise_Ville Not null,
   e_mail VARCHAR2(50) constraint ck_Entreprise_mail check ( e_mail like '%@%.%' ),
   telephone VARCHAR2(10) constraint nn_Entreprise_telephone Not null,
   constraint pk_Entreprise PRIMARY KEY(SIREN)
);


CREATE TABLE Type_Charges(
   id_Type_Charges NUMBER(10) ,
   prix_unitaire NUMBER(19,4) constraint nn_Type_Charges_Prix_unit Not null,
   nom VARCHAR2(50) constraint nn_Type_Charges_nom Not null,
   constraint pk_Type_Charges PRIMARY KEY(Id_Type_Charges),
   constraint un_Type_Charges_nom unique ( nom )
);


CREATE TABLE Garant(
   id_garant NUMBER(10) ,
   nom VARCHAR2(50) constraint nn_Garant_Nom Not null,
   adresse VARCHAR2(150) ,
   e_mail VARCHAR2(150) constraint ck_Garant_mail check ( e_mail like '%@%.%' ),
   telephone VARCHAR2(10) constraint nn_Garant_Telephone Not null,
   constraint pk_Garant PRIMARY KEY(id_garant),
   constraint un_Garant_Nom unique ( nom )
);


CREATE TABLE Logement(
   id_batiment NUMBER(3)   constraint nn_Logement_id_batiment Not null,
   id_logement NUMBER(10),
   type VARCHAR2(4)        constraint nn_Logement_type Not null,
   etage VARCHAR2(50)      constraint nn_Logement_etage Not null,
   surface  NUMBER(10,3)   constraint nn_Logement_surface Not null,
   colocation NUMBER(1)    DEFAULT 0,
   ICC NUMBER(3) ,
   garage NUMBER(1)        DEFAULT 0,
   jardin NUMBER(1)        DEFAULT 0,
   balcon NUMBER(1)        DEFAULT 0,
   constraint pk_Logement PRIMARY KEY(id_batiment, id_logement),
   constraint fk_Logement_batiment FOREIGN KEY(id_batiment) REFERENCES Batiment(id_batiment)
);


CREATE TABLE Facture(
   id_facture NUMBER(10) ,
   date_facture DATE constraint nn_Facture_date_facture Not null,
   description VARCHAR2(250) ,
   montant_HT NUMBER(19,4) constraint nn_Facture_montant_HT Not null,
   TVA NUMBER(15,2)  DEFAULT 20.0,
   type VARCHAR2(50)  constraint nn_Facture_type Not null,
   SIREN VARCHAR2(9) ,
   constraint pk_Facture PRIMARY KEY(id_facture),
   constraint fk_Facture_SIREN FOREIGN KEY(SIREN) REFERENCES Entreprise(SIREN)
);


CREATE TABLE Charges(
   id_charges NUMBER(10) ,
   date_charges DATE constraint nn_Charges_Date_charges Not null,
   consommation NUMBER(10) constraint nn_Charges_consommation Not null,
   id_Type_Charges NUMBER(10) constraint nn_Charges_Id_Type Not null,
   constraint pk_Charges PRIMARY KEY(id_charges),
   constraint fk_Charges_Type_Charges FOREIGN KEY(id_Type_Charges ) REFERENCES Type_Charges(Id_Type_Charges)
);


CREATE TABLE Fiche_diagnostic(
   ref NUMBER(10) ,
   id_batiment NUMBER(10) constraint nn_Fiche_diagnostic_id_bat NOT NULL,
   id_logement NUMBER(10) constraint nn_Fiche_diagnostic_id_log NOT NULL,
   amiante NUMBER(1) DEFAULT 0,
   date_Amiante DATE,
   plomb NUMBER(1) DEFAULT 0,
   date_Plomb DATE,
   date_debut_ERP DATE,
   date_fin_ERP DATE,
   date_debut_DPE DATE,
   date_fin_DPE DATE,
   constraint pk_Fiche_diagnostic PRIMARY KEY(ref),
   constraint fk_Fiche_diagnostic_id_bat_log FOREIGN KEY(id_batiment, id_logement) REFERENCES Logement(id_batiment, id_logement)
);


CREATE TABLE Contrat_bail(
   id_bail NUMBER(10),
   date_debut DATE constraint nn_Contrat_bail_date_debut Not null,
   date_fin DATE ,
   frais_d_agence NUMBER(19,4),
   loyer NUMBER(19,4) constraint nn_Contrat_bail_Loyer Not null,
   charges_fixes NUMBER(19,4) constraint nn_Contrat_bail_charges_fixes Not null,
   montant_aide NUMBER(10,3) DEFAULT 0.0,
   jour_Paiement NUMBER(3)  DEFAULT 1,
   solod_TC NUMBER(1)  DEFAULT 0,
   id_batiment NUMBER(10) constraint nn_Contrat_bail_id_bat NOT NULL,
   id_logement NUMBER(10) constraint nn_Contrat_bail_id_log NOT NULL,
   constraint pk_Contrat_bail PRIMARY KEY(id_bail),
   constraint fk_Contrat_bail_id_bat_log FOREIGN KEY(id_batiment, id_logement) REFERENCES Logement(id_batiment, id_logement)
);


CREATE TABLE Signer(
   id_bail NUMBER(10),
   id_locataire NUMBER(10),
   constraint pk_signer PRIMARY KEY(id_bail, id_locataire),
   constraint fk_signer_id_bail FOREIGN KEY(id_bail) REFERENCES Contrat_bail(id_bail),
   constraint fk_signer_id_locataire FOREIGN KEY(id_locataire) REFERENCES Locataire(id_locataire)
);


CREATE TABLE fact_batiment(
   id_facture NUMBER(10),
   id_batiment NUMBER(3),
   reference_du_paiement VARCHAR2(50) ,
   paiement NUMBER(11,2) ,
   type_Paiment VARCHAR2(50) ,
   Date_de_paiement DATE ,
   constraint pk_fact_batiment PRIMARY KEY(id_facture, id_batiment),
   constraint fk_fact_batiment_id_facture FOREIGN KEY(id_facture) REFERENCES Facture(id_facture),
   constraint fk_fact_batiment_id_batiment FOREIGN KEY(id_batiment) REFERENCES Batiment(id_batiment)
);


CREATE TABLE bat_charge(
   id_batiment NUMBER(3),
   id_charges NUMBER(10) ,
   date_charges date,
   constraint pk_bat_charge PRIMARY KEY(id_batiment, id_charges),
   constraint fk_bat_charge_id_bat FOREIGN KEY(id_batiment) REFERENCES Batiment(id_batiment),
   constraint fk_bat_charge_id_charges FOREIGN KEY(id_charges) REFERENCES Charges(id_charges)
);


CREATE TABLE fact_logement(
   id_facture NUMBER(10) ,
   id_batiment NUMBER(3),
   id_logement NUMBER(10),
   id_locataire NUMBER(10),
   reference_du_paiement VARCHAR2(50) ,
   paiement NUMBER(11,2) ,
   type_Paiment VARCHAR2(50) ,
   Date_de_paiement DATE ,
   constraint pk_fact_logement PRIMARY KEY(id_facture,id_batiment, id_logement,id_locataire),
   constraint fk_fact_logement_id_bat_log FOREIGN KEY(id_batiment, id_logement) REFERENCES Logement(id_batiment, id_logement),
   constraint fk_fact_logement_id_facture FOREIGN KEY(id_facture) REFERENCES Facture(id_facture),
   constraint fk_fact_logement_id_locataire FOREIGN KEY(id_locataire) REFERENCES Locataire(id_locataire)
);


CREATE TABLE log_charge(
   id_batiment NUMBER(3),
   id_logement NUMBER(10),
   id_charges NUMBER(10) ,
   constraint pk_log_charge PRIMARY KEY(id_batiment, id_logement, id_charges),
   constraint fk_log_charge_id_bat_log FOREIGN KEY(id_batiment, id_logement) REFERENCES Logement(id_batiment, id_logement),
   constraint fk_log_charge_id_charges FOREIGN KEY(id_charges) REFERENCES Charges(id_charges)
);


CREATE TABLE correspondre(
   id_facture NUMBER(10) ,
   id_charges NUMBER(10) ,
   charges_dues NUMBER(6,2)  ,
   charges_regularises NUMBER(6,2),
   constraint pk_correspondre PRIMARY KEY(id_facture, id_charges),
   constraint fk_correspondre_id_facture FOREIGN KEY(id_facture) REFERENCES Facture(id_facture),
   constraint fk_correspondre_id_charges FOREIGN KEY(id_charges) REFERENCES Charges(id_charges)
);


CREATE TABLE EDL(
   id_bail NUMBER(10),
   id_EDL NUMBER(10),
   Statut_entree VARCHAR2(250) DEFAULT 'NoN',
   Statut_sortie VARCHAR2(250) DEFAULT 'NoN',
   constraint pk_EDL PRIMARY KEY(id_EDL, id_bail),
   constraint fk_EDL_id_bail FOREIGN KEY(id_bail) REFERENCES Contrat_bail(id_bail)
);


CREATE TABLE Garantie(
   id_locataire NUMBER(10),
   id_garant NUMBER(10) ,
   constraint pk_Garantie PRIMARY KEY(id_locataire, id_garant),
   constraint fk_Garantie_id_locataire FOREIGN KEY(id_locataire) REFERENCES Locataire(id_locataire),
   constraint fk_Garantie_id_garant FOREIGN KEY(id_garant) REFERENCES Garant(id_garant)
);
