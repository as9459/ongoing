



insert into Locataire (id_locataire, nom, prenom, telephone, Date_de_naissance, statut, E_mail) values (1, 'Ahmed', 'Mohamed', '123456789', TO_DATE('1990-05-15', 'YYYY-MM-DD'),'NoN', 'ahmed@example.com');
insert into Locataire (id_locataire, nom, prenom, telephone, Date_de_naissance, statut, E_mail) values (2, 'Fatima', 'Ali', '987654321', TO_DATE('1985-08-20', 'YYYY-MM-DD'),'NoN', 'fatma@example.com');
insert into Locataire (id_locataire, nom, prenom, telephone, Date_de_naissance, statut, E_mail) values (3, 'Mahmoud', 'Ahmed', '555555555', TO_DATE('1995-02-10', 'YYYY-MM-DD'),'NoN', 'mahmoud@example.com');
insert into Locataire (id_locataire, nom, prenom, telephone, Date_de_naissance, statut, E_mail) values (4, 'Laila', 'Abdullah', '777777777', TO_DATE('1980-12-03', 'YYYY-MM-DD'),'NoN', 'leila@example.com');
insert into Locataire (id_locataire, nom, prenom, telephone, Date_de_naissance, statut, E_mail) values (5, 'Abdulrahman', 'Khalid', '888888888', TO_DATE('1978-04-25', 'YYYY-MM-DD'),'Etudiant(e)', 'abdulrahman@example.com');
insert into Locataire (id_locataire, nom, prenom, telephone, Date_de_naissance, statut, E_mail) values (6, 'Sara', 'Abdulrahman', '666666666', TO_DATE('1998-07-30', 'YYYY-MM-DD'),'Salarie(e)', 'sarah@example.com');
insert into Locataire (id_locataire, nom, prenom, telephone, Date_de_naissance, statut, E_mail) values (7, 'Karim', 'Mustafa', '222222222', TO_DATE('1993-09-12', 'YYYY-MM-DD'),'Etudiant(e)', 'karim@example.com');
insert into Locataire (id_locataire, nom, prenom, telephone, Date_de_naissance, statut, E_mail) values (8, 'Reem', 'Abdelmajid', '333333333', TO_DATE('1997-03-05', 'YYYY-MM-DD'),'Salarie(e)', 'reem@example.com');
insert into Locataire (id_locataire, nom, prenom, telephone, Date_de_naissance, statut, E_mail) values (9, 'Nadia', 'Ahmed', '444444444', TO_DATE('1996-06-20', 'YYYY-MM-DD'),'Etudiant(e)', 'nadia@example.com');
insert into Locataire (id_locataire, nom, prenom, telephone, Date_de_naissance, statut, E_mail) values (10, 'Mustafa', 'Lateef', '999999999', TO_DATE('1987-01-17', 'YYYY-MM-DD'),'NoN', 'mustafa@example.com');
Commit;


insert into Batiment(id_batiment , Adresse , code_postal , ville , regime_juridique, date_construction) values (1, '123 Rue de la Republique', '75001', 'Paris', 'non', TO_DATE('2000-01-01', 'YYYY-MM-DD'));
insert into Batiment(id_batiment , Adresse , code_postal , ville , regime_juridique, date_construction) values (2, '456 Avenue des Champs-elysees', '75008', 'Paris', 'non', TO_DATE('1995-10-15', 'YYYY-MM-DD'));
insert into Batiment(id_batiment , Adresse , code_postal , ville , regime_juridique, date_construction) values (3, '789 Boulevard Saint-Michel', '75005', 'Paris', 'non', TO_DATE('2005-07-20', 'YYYY-MM-DD'));
insert into Batiment(id_batiment , Adresse , code_postal , ville , regime_juridique, date_construction) values (4, '101 Rue du Faubourg Saint-Antoine', '75011', 'Paris', 'non', TO_DATE('2010-03-30', 'YYYY-MM-DD'));
Commit;


insert into Entreprise( SIREN,   Nom, serves ,  Adresse ,   CP,   IBAN,   Ville ,   e_mail,  telephone )  values ('123456789', 'Entreprise 1', 'Plombier' ,'10 Rue de la Liberte', '75002', 'FR123456', 'Paris', 'contact@example1.com', '0123456789');
insert into Entreprise( SIREN,   Nom, serves ,  Adresse ,   CP,   IBAN,   Ville ,   e_mail,  telephone )  values ('987654321', 'Entreprise 2', 'Multiservice','20 Avenue de la Republique', '75003', 'FR987654', 'Paris', 'contact@example2.com', '0987654321');
insert into Entreprise( SIREN,   Nom, serves ,  Adresse ,   CP,   IBAN,   Ville ,   e_mail,  telephone )  values ('456789123', 'Entreprise 3', 'Multiservice','30 Boulevard Saint-Michel', '75005', 'FR456789', 'Paris', 'contact@example3.com', '0543219876');
insert into Entreprise( SIREN,   Nom, serves ,  Adresse ,   CP,   IBAN,   Ville ,   e_mail,  telephone )  values ('321654987', 'Entreprise 4', 'Maintenance','40 Rue du Faubourg Saint-Antoine', '75011', 'FR321654', 'Paris', 'contact@example4.com', '0456781234');
Commit;


insert into Type_Charges( Id_Type_Charges, Prix_unitaire, nom)  values (1, 10.0, 'electricite');
insert into Type_Charges( Id_Type_Charges, Prix_unitaire, nom)  values (2, 5.0, 'eau');
insert into Type_Charges( Id_Type_Charges, Prix_unitaire, nom)  values (3, 1.0, 'Internet');
insert into Type_Charges( Id_Type_Charges, Prix_unitaire, nom)  values (4, 3.0, 'telephone');
Commit;


insert into Garant ( id_garant  , Nom  ,Adresse  ,  e_mail , telephone ) values (1, 'Jean Dupont', '25 Rue de Paris', 'jean@example.com', '0123456789');
insert into Garant ( id_garant  , Nom  ,Adresse  ,  e_mail , telephone ) values (2, 'Marie Martin', '15 Avenue des Lilas', 'marie@example.com', '0987654321');
insert into Garant ( id_garant  , Nom  ,Adresse  ,  e_mail , telephone ) values (3, 'Pierre Lambert', '7 Boulevard de la Paix', 'pierre@example.com', '0543219876');
insert into Garant ( id_garant  , Nom  ,Adresse  ,  e_mail , telephone ) values (4, 'Isabelle Leclerc', '34 Rue de la Liberte', 'isabelle@example.com', '0456781234');
insert into Garant ( id_garant  , Nom  ,Adresse  ,  e_mail , telephone ) values (5, 'Pauline Dubois', '50 Quai de la Seine', 'pauline@example.com', '0321654987');
Commit;


insert into Logement (id_batiment, id_logement, type, etage, surface, colocation , ICC, garage, jardin, balcon) values  (1, 11, 'T1', 2, 17.9, 1, 0, 0, 0, 0);
insert into Logement (id_batiment, id_logement, type, etage, surface, colocation , ICC, garage, jardin, balcon) values  (1, 12, 'T1', 2, 18.3, 1, 0, 0, 0, 1);
insert into Logement (id_batiment, id_logement, type, etage, surface, colocation , ICC, garage, jardin, balcon) values  (1, 13, 'T3', 3, 25.1, 0, 0, 0, 0, 0);
insert into Logement (id_batiment, id_logement, type, etage, surface, colocation , ICC, garage, jardin, balcon) values  (2, 21, 'T4', 5, 27.3, 0, 0, 0, 0, 0);
insert into Logement (id_batiment, id_logement, type, etage, surface, colocation , ICC, garage, jardin, balcon) values  (2, 22, 'T5', 4, 31.9, 0, 0, 0, 0, 1);
insert into Logement (id_batiment, id_logement, type, etage, surface, colocation , ICC, garage, jardin, balcon) values  (2, 23, 'T6', 6, 35.3, 0, 0, 0, 0, 1);
insert into Logement (id_batiment, id_logement, type, etage, surface, colocation , ICC, garage, jardin, balcon) values  (3, 31, 'T1', 2, 19.9, 0, 0, 0, 0, 0);
insert into Logement (id_batiment, id_logement, type, etage, surface, colocation , ICC, garage, jardin, balcon) values  (3, 32, 'T2', 3, 22.9, 0, 0, 0, 0, 0);
insert into Logement (id_batiment, id_logement, type, etage, surface, colocation , ICC, garage, jardin, balcon) values  (3, 33, 'T3', 1, 25.9, 0, 0, 0, 0, 0);
insert into Logement (id_batiment, id_logement, type, etage, surface, colocation , ICC, garage, jardin, balcon) values  (4, 41, 'T4', 0, 28.9, 0, 0, 1, 1, 0);
Commit;


insert into Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN) values (101, TO_DATE('2023-01-15', 'YYYY-MM-DD'), 'Facture 1',  0, 0.0, 125.0, 20.0, 'Frais de nettoyage', '123456789');
insert into Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN) values (102, TO_DATE('2023-02-15', 'YYYY-MM-DD'), 'Facture 2',  1, 50.0, 340.0, 8.0, 'Loyer', '987654321');
insert into Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN) values (103, TO_DATE('2023-03-25', 'YYYY-MM-DD'), 'Facture 3',  0, 0.0, 105.0, 15.0, 'Frais de dossier', '456789123');
insert into Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN) values (104, TO_DATE('2023-04-15', 'YYYY-MM-DD'), 'Facture 4',  1, 60.0, 395.0, 10.0, 'Loyer', '321654987');
insert into Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN) values (105, TO_DATE('2023-05-16', 'YYYY-MM-DD'), 'Facture 5',  1, 60.0, 360.0, 15.0, 'Loyer', '123456789');
insert into Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN) values (106, TO_DATE('2023-06-15', 'YYYY-MM-DD'), 'Facture 6',  0, 0.0, 120.0, 18.0, 'depôt de garantie', '987654321');
insert into Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN) values (107, TO_DATE('2023-07-15', 'YYYY-MM-DD'), 'Facture 7',  1, 70.0, 435.0, 8.0, 'Loyer', '456789123');
insert into Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN) values (108, TO_DATE('2023-08-15', 'YYYY-MM-DD'), 'Facture 8',  0, 0.0, 135.0, 20.0, 'Travau', '321654987');
insert into Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN) values (109, TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'Facture 9',  0, 0.0, 35.0, 10.0, 'Travau', '123456789');
insert into Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN) values (110, TO_DATE('2023-10-15', 'YYYY-MM-DD'), 'Facture 10', 1, 30.0, 140.0, 10.0, 'Loyer', '987654321');
insert into Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN) values (111, TO_DATE('2023-01-01', 'YYYY-MM-DD'), 'Facture charge le eau', 0, 0.0, 228.0, 10.0, 'charge', '123456789');
insert into Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN) values (112, TO_DATE('2023-02-01', 'YYYY-MM-DD'), 'Facture charge le eau', 0, 0.0, 245.5, 10.0, 'charge', '123456789');
insert into Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN) values (113, TO_DATE('2023-03-01', 'YYYY-MM-DD'), 'Facture charge le eau', 0, 0.0, 89.5, 10.0, 'charge', '123456789');
insert into Facture (id_facture, date_facture, description, aide, montant_de_l_aide, montant_HT, TVA, type, SIREN) values (114, TO_DATE('2023-04-01', 'YYYY-MM-DD'), 'Facture charge le eau', 0, 0.0, 244.0, 10.0, 'charge', '123456789');
Commit;


insert into Charges (id_charges, Date_charges, consommation, Id_Type_Charges) values (1, TO_DATE('2023-02-05', 'YYYY-MM-DD'), 35.6, 3);
insert into Charges (id_charges, Date_charges, consommation, Id_Type_Charges) values (2, TO_DATE('2023-02-10', 'YYYY-MM-DD'), 635, 1);
insert into Charges (id_charges, Date_charges, consommation, Id_Type_Charges) values (3, TO_DATE('2023-04-10', 'YYYY-MM-DD'), 236, 1);
insert into Charges (id_charges, Date_charges, consommation, Id_Type_Charges) values (4, TO_DATE('2023-05-10', 'YYYY-MM-DD'), 348, 1);
insert into Charges (id_charges, Date_charges, consommation, Id_Type_Charges) values (5, TO_DATE('2023-07-10', 'YYYY-MM-DD'), 634, 1);
insert into Charges (id_charges, Date_charges, consommation, Id_Type_Charges) values (6, TO_DATE('2023-10-10', 'YYYY-MM-DD'), 345, 1);
insert into Charges (id_charges, Date_charges, consommation, Id_Type_Charges) values (11, TO_DATE('2022-12-28', 'YYYY-MM-DD'), 456, 2);
insert into Charges (id_charges, Date_charges, consommation, Id_Type_Charges) values (12, TO_DATE('2023-01-28', 'YYYY-MM-DD'), 956, 2);
insert into Charges (id_charges, Date_charges, consommation, Id_Type_Charges) values (13, TO_DATE('2023-02-28', 'YYYY-MM-DD'), 1135, 2);
insert into Charges (id_charges, Date_charges, consommation, Id_Type_Charges) values (14, TO_DATE('2023-03-28', 'YYYY-MM-DD'), 1623, 2);
Commit;


insert into Fiche_diagnostic (Ref, id_batiment, id_logement, Amiante, Date_Amiante, Plomb, Date_plomb, date_debut_ERP, Date_fin_ERP, Date_debut_DPE, Date_fin_DPE) values  (1, 1, 11, 0, null, 1, TO_DATE('2023-01-05', 'YYYY-MM-DD'), TO_DATE('2023-01-01', 'YYYY-MM-DD'), TO_DATE('2023-02-01', 'YYYY-MM-DD'), TO_DATE('2023-02-01', 'YYYY-MM-DD'), TO_DATE('2023-03-01', 'YYYY-MM-DD'));
insert into Fiche_diagnostic (Ref, id_batiment, id_logement, Amiante, Date_Amiante, Plomb, Date_plomb, date_debut_ERP, Date_fin_ERP, Date_debut_DPE, Date_fin_DPE) values  (2, 1, 12, 1, TO_DATE('2023-02-10', 'YYYY-MM-DD'), 0, null, TO_DATE('2023-02-01', 'YYYY-MM-DD'), TO_DATE('2023-03-01', 'YYYY-MM-DD'), TO_DATE('2023-03-01', 'YYYY-MM-DD'), TO_DATE('2023-04-01', 'YYYY-MM-DD'));
insert into Fiche_diagnostic (Ref, id_batiment, id_logement, Amiante, Date_Amiante, Plomb, Date_plomb, date_debut_ERP, Date_fin_ERP, Date_debut_DPE, Date_fin_DPE) values  (3, 1, 13, 0, null, 1, TO_DATE('2023-03-05', 'YYYY-MM-DD'), TO_DATE('2023-03-01', 'YYYY-MM-DD'), TO_DATE('2023-04-01', 'YYYY-MM-DD'), TO_DATE('2023-04-01', 'YYYY-MM-DD'), TO_DATE('2023-05-01', 'YYYY-MM-DD'));
insert into Fiche_diagnostic (Ref, id_batiment, id_logement, Amiante, Date_Amiante, Plomb, Date_plomb, date_debut_ERP, Date_fin_ERP, Date_debut_DPE, Date_fin_DPE) values  (4, 2, 21, 1, TO_DATE('2023-04-10', 'YYYY-MM-DD'), 0, null, TO_DATE('2023-04-01', 'YYYY-MM-DD'), TO_DATE('2023-05-01', 'YYYY-MM-DD'), TO_DATE('2023-05-01', 'YYYY-MM-DD'), TO_DATE('2023-06-01', 'YYYY-MM-DD'));
insert into Fiche_diagnostic (Ref, id_batiment, id_logement, Amiante, Date_Amiante, Plomb, Date_plomb, date_debut_ERP, Date_fin_ERP, Date_debut_DPE, Date_fin_DPE) values  (5, 2, 22, 0, null, 1, TO_DATE('2023-05-05', 'YYYY-MM-DD'), TO_DATE('2023-05-01', 'YYYY-MM-DD'), TO_DATE('2023-06-01', 'YYYY-MM-DD'), TO_DATE('2023-06-01', 'YYYY-MM-DD'), TO_DATE('2023-07-01', 'YYYY-MM-DD'));
insert into Fiche_diagnostic (Ref, id_batiment, id_logement, Amiante, Date_Amiante, Plomb, Date_plomb, date_debut_ERP, Date_fin_ERP, Date_debut_DPE, Date_fin_DPE) values  (6, 2, 23, 1, TO_DATE('2023-06-10', 'YYYY-MM-DD'), 0, null, TO_DATE('2023-06-01', 'YYYY-MM-DD'), TO_DATE('2023-07-01', 'YYYY-MM-DD'), TO_DATE('2023-07-01', 'YYYY-MM-DD'), TO_DATE('2023-08-01', 'YYYY-MM-DD'));
insert into Fiche_diagnostic (Ref, id_batiment, id_logement, Amiante, Date_Amiante, Plomb, Date_plomb, date_debut_ERP, Date_fin_ERP, Date_debut_DPE, Date_fin_DPE) values  (7, 3, 31, 0, null, 1, TO_DATE('2023-07-05', 'YYYY-MM-DD'), TO_DATE('2023-07-01', 'YYYY-MM-DD'), TO_DATE('2023-08-01', 'YYYY-MM-DD'), TO_DATE('2023-08-01', 'YYYY-MM-DD'), TO_DATE('2023-09-01', 'YYYY-MM-DD'));
insert into Fiche_diagnostic (Ref, id_batiment, id_logement, Amiante, Date_Amiante, Plomb, Date_plomb, date_debut_ERP, Date_fin_ERP, Date_debut_DPE, Date_fin_DPE) values  (8, 3, 32, 1, TO_DATE('2023-08-10', 'YYYY-MM-DD'), 0, null, TO_DATE('2023-08-01', 'YYYY-MM-DD'), TO_DATE('2023-09-01', 'YYYY-MM-DD'), TO_DATE('2023-09-01', 'YYYY-MM-DD'), TO_DATE('2023-10-01', 'YYYY-MM-DD'));
insert into Fiche_diagnostic (Ref, id_batiment, id_logement, Amiante, Date_Amiante, Plomb, Date_plomb, date_debut_ERP, Date_fin_ERP, Date_debut_DPE, Date_fin_DPE) values  (9, 3, 33, 0, null, 1, TO_DATE('2023-09-05', 'YYYY-MM-DD'), TO_DATE('2023-09-01', 'YYYY-MM-DD'), TO_DATE('2023-10-01', 'YYYY-MM-DD'), TO_DATE('2023-10-01', 'YYYY-MM-DD'), TO_DATE('2023-11-01', 'YYYY-MM-DD'));
insert into Fiche_diagnostic (Ref, id_batiment, id_logement, Amiante, Date_Amiante, Plomb, Date_plomb, date_debut_ERP, Date_fin_ERP, Date_debut_DPE, Date_fin_DPE) values  (10, 4, 41, 1, TO_DATE('2023-10-10', 'YYYY-MM-DD'), 0, null, TO_DATE('2023-10-01', 'YYYY-MM-DD'), TO_DATE('2023-11-01', 'YYYY-MM-DD'), TO_DATE('2023-11-01', 'YYYY-MM-DD'), TO_DATE('2023-12-01', 'YYYY-MM-DD'));
Commit;


insert into Contrat_bail (id_bail, date_debut, date_fin, frais_d_agence, Loyer, charges_fixes, Jour_Paiement, solod_TC, id_batiment, id_logement) values (1, TO_DATE('2023-01-15', 'YYYY-MM-DD'), TO_DATE('2024-01-14', 'YYYY-MM-DD'), 500.0, 800.0, 50.0, 5, 0, 1, 11);
insert into Contrat_bail (id_bail, date_debut, date_fin, frais_d_agence, Loyer, charges_fixes, Jour_Paiement, solod_TC, id_batiment, id_logement) values (2, TO_DATE('2023-01-20', 'YYYY-MM-DD'), TO_DATE('2024-02-19', 'YYYY-MM-DD'), 400.0, 700.0, 60.0, 10, 0, 1, 12);
insert into Contrat_bail (id_bail, date_debut, date_fin, frais_d_agence, Loyer, charges_fixes, Jour_Paiement, solod_TC, id_batiment, id_logement) values (3, TO_DATE('2023-01-25', 'YYYY-MM-DD'), TO_DATE('2023-07-24', 'YYYY-MM-DD'), 300.0, 600.0, 70.0, 15, 1, 1, 13);
insert into Contrat_bail (id_bail, date_debut, date_fin, frais_d_agence, Loyer, charges_fixes, Jour_Paiement, solod_TC, id_batiment, id_logement) values (4, TO_DATE('2023-01-10', 'YYYY-MM-DD'), TO_DATE('2024-04-09', 'YYYY-MM-DD'), 600.0, 900.0, 40.0, 20, 0, 2, 21);
insert into Contrat_bail (id_bail, date_debut, date_fin, frais_d_agence, Loyer, charges_fixes, Jour_Paiement, solod_TC, id_batiment, id_logement) values (5, TO_DATE('2023-01-15', 'YYYY-MM-DD'), TO_DATE('2023-11-14', 'YYYY-MM-DD'), 550.0, 850.0, 35.0, 5, 0, 2, 22);
insert into Contrat_bail (id_bail, date_debut, date_fin, frais_d_agence, Loyer, charges_fixes, Jour_Paiement, solod_TC, id_batiment, id_logement) values (6, TO_DATE('2023-01-20', 'YYYY-MM-DD'), TO_DATE('2024-06-19', 'YYYY-MM-DD'), 700.0, 950.0, 25.0, 1, 0, 2, 23);
insert into Contrat_bail (id_bail, date_debut, date_fin, frais_d_agence, Loyer, charges_fixes, Jour_Paiement, solod_TC, id_batiment, id_logement) values (7, TO_DATE('2023-01-10', 'YYYY-MM-DD'), TO_DATE('2024-07-09', 'YYYY-MM-DD'), 750.0, 1050.0, 30.0, 10, 0, 3, 31);
insert into Contrat_bail (id_bail, date_debut, date_fin, frais_d_agence, Loyer, charges_fixes, Jour_Paiement, solod_TC, id_batiment, id_logement) values (8, TO_DATE('2023-01-15', 'YYYY-MM-DD'), TO_DATE('2024-08-14', 'YYYY-MM-DD'), 450.0, 650.0, 70.0, 5, 0, 3, 32);
insert into Contrat_bail (id_bail, date_debut, date_fin, frais_d_agence, Loyer, charges_fixes, Jour_Paiement, solod_TC, id_batiment, id_logement) values (9, TO_DATE('2023-01-20', 'YYYY-MM-DD'), TO_DATE('2024-09-19', 'YYYY-MM-DD'), 550.0, 750.0, 60.0, 15, 0, 3, 33);
insert into Contrat_bail (id_bail, date_debut, date_fin, frais_d_agence, Loyer, charges_fixes, Jour_Paiement, solod_TC, id_batiment, id_logement) values (10, TO_DATE('2023-01-10', 'YYYY-MM-DD'), TO_DATE('2024-10-09', 'YYYY-MM-DD'), 650.0, 950.0, 40.0, 20, 0, 4, 41);
Commit;


insert into Signer (id_bail, id_locataire) values (1, 1);
insert into Signer (id_bail, id_locataire) values (2, 2);
insert into Signer (id_bail, id_locataire) values (3, 3);
insert into Signer (id_bail, id_locataire) values (4, 4);
insert into Signer (id_bail, id_locataire) values (5, 5);
insert into Signer (id_bail, id_locataire) values (6, 6);
insert into Signer (id_bail, id_locataire) values (7, 7);
insert into Signer (id_bail, id_locataire) values (8, 8);
insert into Signer (id_bail, id_locataire) values (9, 9);
insert into Signer (id_bail, id_locataire) values (10, 10);
Commit;


insert into fact_batiment (id_facture, id_batiment, date_facture, reference_du_paiement, paiement, type_Paiment, Date_de_paiement) values (101, 1, TO_DATE('2023-01-15', 'YYYY-MM-DD'), 'PKC1234123123', 150.0, 'Chèque', TO_DATE('2023-01-20', 'YYYY-MM-DD'));
insert into fact_batiment (id_facture, id_batiment, date_facture, reference_du_paiement, paiement, type_Paiment, Date_de_paiement) values (108, 3, TO_DATE('2023-08-15', 'YYYY-MM-DD'), 'PKC1275432123', 156.0, 'Chèque', TO_DATE('2023-08-20', 'YYYY-MM-DD'));
insert into fact_batiment (id_facture, id_batiment, date_facture, reference_du_paiement, paiement, type_Paiment, Date_de_paiement) values (109, 4, TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'PKC1288888423', 38.5, 'Chèque', TO_DATE('2023-09-20', 'YYYY-MM-DD'));
insert into fact_batiment (id_facture, id_batiment, date_facture, reference_du_paiement, paiement, type_Paiment, Date_de_paiement) values (111, 2, TO_DATE('2023-01-01', 'YYYY-MM-DD'), 'PKC1286548423', 225.8, 'Chèque', TO_DATE('2023-01-05', 'YYYY-MM-DD'));
insert into fact_batiment (id_facture, id_batiment, date_facture, reference_du_paiement, paiement, type_Paiment, Date_de_paiement) values (112, 2, TO_DATE('2023-02-01', 'YYYY-MM-DD'), 'PKC1286668423', 270.05, 'Chèque', TO_DATE('2023-02-05', 'YYYY-MM-DD'));
insert into fact_batiment (id_facture, id_batiment, date_facture, reference_du_paiement, paiement, type_Paiment, Date_de_paiement) values (113, 2, TO_DATE('2023-03-01', 'YYYY-MM-DD'), 'PKC1286693223', 98.45, 'Chèque', TO_DATE('2023-03-05', 'YYYY-MM-DD'));
insert into fact_batiment (id_facture, id_batiment, date_facture, reference_du_paiement, paiement, type_Paiment, Date_de_paiement) values (114, 2, TO_DATE('2023-04-01', 'YYYY-MM-DD'), 'PKC1286993223', 268.4, 'Chèque', TO_DATE('2023-04-05', 'YYYY-MM-DD'));
Commit;


insert into bat_charge (id_batiment, id_charges, date_charges, id_Type_Charges) values ( 2, 11, TO_DATE('2022-12-28', 'YYYY-MM-DD'), 2);
insert into bat_charge (id_batiment, id_charges, date_charges, id_Type_Charges) values ( 2, 12, TO_DATE('2023-01-28', 'YYYY-MM-DD'), 2);
insert into bat_charge (id_batiment, id_charges, date_charges, id_Type_Charges) values ( 2, 13, TO_DATE('2023-02-28', 'YYYY-MM-DD'), 2);
insert into bat_charge (id_batiment, id_charges, date_charges, id_Type_Charges) values ( 2, 14, TO_DATE('2023-03-28', 'YYYY-MM-DD'), 2);
Commit;
                                       

insert into fact_logement (id_facture, id_batiment, id_logement, date_facture, id_locataire, reference_du_paiement, paiement, type_Paiment, Date_de_paiement) values (102,2, 21, TO_DATE('2023-02-15', 'YYYY-MM-DD'), 4, 'CP9777273', 317.2, 'Carte de crédit', TO_DATE('2023-02-15', 'YYYY-MM-DD'));
insert into fact_logement (id_facture, id_batiment, id_logement, date_facture, id_locataire, reference_du_paiement, paiement, type_Paiment, Date_de_paiement) values (103,1, 13, TO_DATE('2023-03-25', 'YYYY-MM-DD'), 3, 'NoN', 120.75, 'Espèces', TO_DATE('2023-03-15', 'YYYY-MM-DD'));
insert into fact_logement (id_facture, id_batiment, id_logement, date_facture, id_locataire, reference_du_paiement, paiement, type_Paiment, Date_de_paiement) values (104,1, 13, TO_DATE('2023-04-15', 'YYYY-MM-DD'), 3, 'CP9756273', 374.5, 'Carte de crédit', TO_DATE('2023-04-15', 'YYYY-MM-DD'));
insert into fact_logement (id_facture, id_batiment, id_logement, date_facture, id_locataire, reference_du_paiement, paiement, type_Paiment, Date_de_paiement) values (105,2, 22, TO_DATE('2023-05-16', 'YYYY-MM-DD'), 5, 'PA7813883', 354, 'Prélèvement automatique', TO_DATE('2023-05-16', 'YYYY-MM-DD'));
insert into fact_logement (id_facture, id_batiment, id_logement, date_facture, id_locataire, reference_du_paiement, paiement, type_Paiment, Date_de_paiement) values (106,2, 22, TO_DATE('2023-06-15', 'YYYY-MM-DD'), 5, 'CP3154683', 141.6, 'Carte de crédit', TO_DATE('2023-06-15', 'YYYY-MM-DD'));
insert into fact_logement (id_facture, id_batiment, id_logement, date_facture, id_locataire, reference_du_paiement, paiement, type_Paiment, Date_de_paiement) values (107,3, 31, TO_DATE('2023-07-15', 'YYYY-MM-DD'), 7, 'NoN', 399.8, 'Espèces', TO_DATE('2023-07-15', 'YYYY-MM-DD'));
insert into fact_logement (id_facture, id_batiment, id_logement, date_facture, id_locataire, reference_du_paiement, paiement, type_Paiment, Date_de_paiement) values (110,4, 41, TO_DATE('2023-10-15', 'YYYY-MM-DD'), 10, 'VP6542317', 124, 'Virement bancaire', TO_DATE('2023-10-15', 'YYYY-MM-DD'));
Commit;


insert into log_charge (id_batiment, id_logement, id_charges, date_charges, id_Type_Charges) values (2, 21, 1, TO_DATE('2023-02-05', 'YYYY-MM-DD'), 3);
insert into log_charge (id_batiment, id_logement, id_charges, date_charges, id_Type_Charges) values (2, 21, 2, TO_DATE('2023-02-10', 'YYYY-MM-DD'), 1);
insert into log_charge (id_batiment, id_logement, id_charges, date_charges, id_Type_Charges) values (1, 13, 3, TO_DATE('2023-04-10', 'YYYY-MM-DD'), 1);
insert into log_charge (id_batiment, id_logement, id_charges, date_charges, id_Type_Charges) values (2, 22, 4, TO_DATE('2023-05-10', 'YYYY-MM-DD'), 1);
insert into log_charge (id_batiment, id_logement, id_charges, date_charges, id_Type_Charges) values (3, 31, 5, TO_DATE('2023-07-10', 'YYYY-MM-DD'), 1);
insert into log_charge (id_batiment, id_logement, id_charges, date_charges, id_Type_Charges) values (4, 41, 6, TO_DATE('2023-10-10', 'YYYY-MM-DD'), 1);
Commit;


insert into correspondre (id_facture, date_facture, id_charges, date_charges, charges_dues, charges_regularises, id_Type_Charges) values (102, TO_DATE('2023-02-15', 'YYYY-MM-DD'), 2, TO_DATE('2023-02-10', 'YYYY-MM-DD'), 80.0, 10.0, 1);
insert into correspondre (id_facture, date_facture, id_charges, date_charges, charges_dues, charges_regularises, id_Type_Charges) values (102, TO_DATE('2023-02-15', 'YYYY-MM-DD'), 1, TO_DATE('2023-02-05', 'YYYY-MM-DD'), 80.0, 10.0, 3);
insert into correspondre (id_facture, date_facture, id_charges, date_charges, charges_dues, charges_regularises, id_Type_Charges) values (104, TO_DATE('2023-04-15', 'YYYY-MM-DD'), 3, TO_DATE('2023-04-10', 'YYYY-MM-DD'), 75.0, 20.0, 1);
insert into correspondre (id_facture, date_facture, id_charges, date_charges, charges_dues, charges_regularises, id_Type_Charges) values (105, TO_DATE('2023-05-16', 'YYYY-MM-DD'), 4, TO_DATE('2023-05-10', 'YYYY-MM-DD'), 110.0, 10.0, 1);
insert into correspondre (id_facture, date_facture, id_charges, date_charges, charges_dues, charges_regularises, id_Type_Charges) values (107, TO_DATE('2023-07-15', 'YYYY-MM-DD'), 5, TO_DATE('2023-07-10', 'YYYY-MM-DD'), 85.0, 10.0, 1);
insert into correspondre (id_facture, date_facture, id_charges, date_charges, charges_dues, charges_regularises, id_Type_Charges) values (110, TO_DATE('2023-10-15', 'YYYY-MM-DD'), 6, TO_DATE('2023-10-10', 'YYYY-MM-DD'), 65.0, 5.0, 1);
insert into correspondre (id_facture, date_facture, id_charges, date_charges, charges_dues, charges_regularises, id_Type_Charges) values (111, TO_DATE('2023-01-01', 'YYYY-MM-DD'), 11, TO_DATE('2022-12-28', 'YYYY-MM-DD'), 80.0, 10.0, 2);
insert into correspondre (id_facture, date_facture, id_charges, date_charges, charges_dues, charges_regularises, id_Type_Charges) values (112, TO_DATE('2023-02-01', 'YYYY-MM-DD'), 12, TO_DATE('2023-01-28', 'YYYY-MM-DD'), 80.0, 10.0, 2);
insert into correspondre (id_facture, date_facture, id_charges, date_charges, charges_dues, charges_regularises, id_Type_Charges) values (113, TO_DATE('2023-03-01', 'YYYY-MM-DD'), 13, TO_DATE('2023-02-28', 'YYYY-MM-DD'), 80.0, 10.0, 2);
insert into correspondre (id_facture, date_facture, id_charges, date_charges, charges_dues, charges_regularises, id_Type_Charges) values (114, TO_DATE('2023-04-01', 'YYYY-MM-DD'), 14, TO_DATE('2023-03-28', 'YYYY-MM-DD'), 80.0, 10.0, 2);
Commit;


insert into EDL (id_bail, id_EDL, Statut_entree, Statut_sortie) values (1, 1 ,'Bien' , 'NoN');
insert into EDL (id_bail, id_EDL, Statut_entree, Statut_sortie) values (2, 2 ,'Bien' , 'NoN');
insert into EDL (id_bail, id_EDL, Statut_entree, Statut_sortie) values (3, 3 ,'Bien' , 'Etat moyen');
insert into EDL (id_bail, id_EDL, Statut_entree, Statut_sortie) values (4, 4 ,'Bien' , 'NoN');
insert into EDL (id_bail, id_EDL, Statut_entree, Statut_sortie) values (5, 5 ,'Bien' , 'NoN');
insert into EDL (id_bail, id_EDL, Statut_entree, Statut_sortie) values (6, 6 ,'Bien' , 'NoN');
insert into EDL (id_bail, id_EDL, Statut_entree, Statut_sortie) values (7, 7 ,'Bien' , 'NoN');
insert into EDL (id_bail, id_EDL, Statut_entree, Statut_sortie) values (8, 8 ,'Bien' , 'NoN');
insert into EDL (id_bail, id_EDL, Statut_entree, Statut_sortie) values (9, 9 ,'Bien' , 'NoN');
insert into EDL (id_bail, id_EDL, Statut_entree, Statut_sortie) values (10, 10 ,'Bien' , 'NoN');
Commit;


insert into Garantie (id_locataire, id_garant) values (1, 1);
insert into Garantie (id_locataire, id_garant) values (2, 2);
insert into Garantie (id_locataire, id_garant) values (3, 3);
insert into Garantie (id_locataire, id_garant) values (4, 4);
insert into Garantie (id_locataire, id_garant) values (5, 5);
insert into Garantie (id_locataire, id_garant) values (6, 1);
insert into Garantie (id_locataire, id_garant) values (7, 2);
insert into Garantie (id_locataire, id_garant) values (8, 3);
insert into Garantie (id_locataire, id_garant) values (9, 4);
insert into Garantie (id_locataire, id_garant) values (10, 5);
Commit;

