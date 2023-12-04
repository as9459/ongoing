package modele.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import modele.*;

public class DaoTest {
    private static final Collection<Batiment> BATIMENT = new ArrayList<>();
    private static final Collection<Charges> CHARGES = new ArrayList<>();
    private static final Collection<Contrat_Bail> CONTRATBAIL = new ArrayList<>();
    private static final Collection<Correspondre> CORRESPONDRE = new ArrayList<>();
    private static final Collection<Diagnostic> DIAGNOSTIC = new ArrayList<>();
    private static final Collection<Entreprise> ENTREPRISE = new ArrayList<>();
    private static final Collection<Fac_Batiment> FACBATIMENT = new ArrayList<>();
    private static final Collection<Fac_Logement> FACLOGEMENT = new ArrayList<>();
    private static final Collection<Facture> FACTURE = new ArrayList<>();
    private static final Collection<Garant> GARANT = new ArrayList<>();
    private static final Collection<Locataire> LOCATAIRE = new ArrayList<>();
    private static final Collection<Logement> LOGEMENT = new ArrayList<>();
    private static final Collection<Type_charges> TYPECHARGES = new ArrayList<>();
    
    
    static {
        // Initialize your collections here...
    }
    
    //------------------------- Batiment ----------------------------------------------
    
    public static List<Batiment> selectBatiment(int id) {
        List<Batiment> liste = DaoTest.BATIMENT.stream().filter(b -> b.getIdBatiment() == id)
                .collect(Collectors.toList());
        return liste;
    }

    public static void insertBatiment(Batiment b) {
        DaoTest.BATIMENT.add(b);
    }

    public static void updateBatiment(Batiment b) {
        List<Batiment> liste = DaoTest.selectBatiment(b.getIdBatiment());
        Batiment d = liste.get(0);
        // Update fields of Batiment
    }

    public static void deleteBatiment(Batiment b) {
        DaoTest.BATIMENT.remove(b);
    }

    // -------------------------- Charges --------------------------------------------

    public static List<Charges> selectCharges(int id) {
        List<Charges> liste = DaoTest.CHARGES.stream().filter(c -> c.getIdCharges() == id)
                .collect(Collectors.toList());
        return liste;
    }

    public static void insertCharges(Charges c) {
        DaoTest.CHARGES.add(c);
    }

    public static void updateCharges(Charges c) {
        List<Charges> liste = DaoTest.selectCharges(c.getIdCharges());
        Charges d = liste.get(0);
        // Update fields of Charges
    }

    public static void deleteCharges(Charges c) {
        DaoTest.CHARGES.remove(c);
    }

    // -------------------------- Contrat_Bail ---------------------------------------

    public static List<Contrat_Bail> selectContratBail(int id) {
        List<Contrat_Bail> liste = DaoTest.CONTRATBAIL.stream().filter(cb -> cb.getIdBail() == id)
                .collect(Collectors.toList());
        return liste;
    }

    public static void insertContratBail(Contrat_Bail cb) {
        DaoTest.CONTRATBAIL.add(cb);
    }

    public static void updateContratBail(Contrat_Bail cb) {
        List<Contrat_Bail> liste = DaoTest.selectContratBail(cb.getIdBail());
        Contrat_Bail d = liste.get(0);
        // Update fields of Contrat_Bail
    }

    public static void deleteContratBail(Contrat_Bail cb) {
        DaoTest.CONTRATBAIL.remove(cb);
    }
    
    //------------------------- Correspondre ----------------------------------------------

    public static List<Correspondre> selectCorrespondre(int id) {
        List<Correspondre> liste = DaoTest.CORRESPONDRE.stream().filter(corresp -> corresp.getIdFacture() == id)
                .collect(Collectors.toList());
        return liste;
    }

    public static void insertCorrespondre(Correspondre corresp) {
        DaoTest.CORRESPONDRE.add(corresp);
    }

    public static void updateCorrespondre(Correspondre corresp) {
        List<Correspondre> liste = DaoTest.selectCorrespondre(corresp.getIdFacture());
        Correspondre c = liste.get(0);
        // Update fields of Correspondre
    }

    public static void deleteCorrespondre(Correspondre corresp) {
        DaoTest.CORRESPONDRE.remove(corresp);
    }

    // -------------------------- Diagnostic --------------------------------------------

    public static List<Diagnostic> selectDiagnostic(String... id) {
        List<Diagnostic> liste = DaoTest.DIAGNOSTIC.stream().filter(diag -> diag.getRef().equals(id[0]))
                .collect(Collectors.toList());
        return liste;
    }

    public static void insertDiagnostic(Diagnostic diag) {
        DaoTest.DIAGNOSTIC.add(diag);
    }

    public static void updateDiagnostic(Diagnostic diag) {
        List<Diagnostic> liste = DaoTest.selectDiagnostic(diag.getRef());
        Diagnostic d = liste.get(0);
        // Update fields of Diagnostic
    }

    public static void deleteDiagnostic(Diagnostic diag) {
        DaoTest.DIAGNOSTIC.remove(diag);
    }

    // -------------------------- Entreprise --------------------------------------------

    public static List<Entreprise> selectEntreprise(String... id) {
        List<Entreprise> liste = DaoTest.ENTREPRISE.stream().filter(entr -> entr.getSiren().equals(id[0]))
                .collect(Collectors.toList());
        return liste;
    }

    public static void insertEntreprise(Entreprise entr) {
        DaoTest.ENTREPRISE.add(entr);
    }

    public static void updateEntreprise(Entreprise entr) {
        List<Entreprise> liste = DaoTest.selectEntreprise(entr.getSiren());
        Entreprise e = liste.get(0);
        // Update fields of Entreprise
    }

    public static void deleteEntreprise(Entreprise entr) {
        DaoTest.ENTREPRISE.remove(entr);
    }
    
    //------------------------- Fac_Batiment ----------------------------------------------

    public static List<Fac_Batiment> selectFacBatiment(int id) {
        List<Fac_Batiment> liste = DaoTest.FACBATIMENT.stream().filter(facBat -> facBat.getId_batiment() == id)
                .collect(Collectors.toList());
        return liste;
    }

    public static void insertFacBatiment(Fac_Batiment facBat) {
        DaoTest.FACBATIMENT.add(facBat);
    }

    public static void updateFacBatiment(Fac_Batiment facBat) {
        List<Fac_Batiment> liste = DaoTest.selectFacBatiment(facBat.getId_batiment());
        Fac_Batiment f = liste.get(0);
        // Update fields of Fac_Batiment
    }

    public static void deleteFacBatiment(Fac_Batiment facBat) {
        DaoTest.FACBATIMENT.remove(facBat);
    }

    // -------------------------- Fac_Logement --------------------------------------------

    public static List<Fac_Logement> selectFacLogement(int id) {
        List<Fac_Logement> liste = DaoTest.FACLOGEMENT.stream().filter(facLog -> facLog.getId_logement() == id)
                .collect(Collectors.toList());
        return liste;
    }

    public static void insertFacLogement(Fac_Logement facLog) {
        DaoTest.FACLOGEMENT.add(facLog);
    }

    public static void updateFacLogement(Fac_Logement facLog) {
        List<Fac_Logement> liste = DaoTest.selectFacLogement(facLog.getId_logement());
        Fac_Logement f = liste.get(0);
        // Update fields of Fac_Logement
    }

    public static void deleteFacLogement(Fac_Logement facLog) {
        DaoTest.FACLOGEMENT.remove(facLog);
    }

    // -------------------------- Facture --------------------------------------------

    public static List<Facture> selectFacture(int id) {
        List<Facture> liste = DaoTest.FACTURE.stream().filter(fact -> fact.getId_facture() == id)
                .collect(Collectors.toList());
        return liste;
    }

    public static void insertFacture(Facture fact) {
        DaoTest.FACTURE.add(fact);
    }

    public static void updateFacture(Facture fact) {
        List<Facture> liste = DaoTest.selectFacture(fact.getId_facture());
        Facture f = liste.get(0);
        // Update fields of Facture
    }

    public static void deleteFacture(Facture fact) {
        DaoTest.FACTURE.remove(fact);
    }
        //------------------------- Garant ----------------------------------------------

    public static List<Garant> selectGarant(int id) {
        List<Garant> liste = DaoTest.GARANT.stream().filter(g -> g.getId_garant() == id)
                .collect(Collectors.toList());
        return liste;
    }

    public static void insertGarant(Garant garant) {
        DaoTest.GARANT.add(garant);
    }

    public static void updateGarant(Garant garant) {
        List<Garant> liste = DaoTest.selectGarant(garant.getId_garant());
        Garant g = liste.get(0);
        // Update fields of Garant
    }

    public static void deleteGarant(Garant garant) {
        DaoTest.GARANT.remove(garant);
    }

    // -------------------------- Locataire --------------------------------------------

    public static List<Locataire> selectLocataire(int id) {
        List<Locataire> liste = DaoTest.LOCATAIRE.stream().filter(l -> l.getIdLocataire() == id)
                .collect(Collectors.toList());
        return liste;
    }

    public static void insertLocataire(Locataire locataire) {
        DaoTest.LOCATAIRE.add(locataire);
    }

    public static void updateLocataire(Locataire locataire) {
        List<Locataire> liste = DaoTest.selectLocataire(locataire.getIdLocataire());
        Locataire l = liste.get(0);
        // Update fields of Locataire
    }

    public static void deleteLocataire(Locataire locataire) {
        DaoTest.LOCATAIRE.remove(locataire);
    }
    
  //------------------------- Logement ----------------------------------------------

    public static List<Logement> selectLogement(int id) {
        List<Logement> liste = DaoTest.LOGEMENT.stream().filter(l -> l.getId_logement() == id)
                .collect(Collectors.toList());
        return liste;
    }

    public static void insertLogement(Logement logement) {
        DaoTest.LOGEMENT.add(logement);
    }

    public static void updateLogement(Logement logement) {
        List<Logement> liste = DaoTest.selectLogement(logement.getId_logement());
        Logement l = liste.get(0);
        // Update fields of Logement
    }

    public static void deleteLogement(Logement logement) {
        DaoTest.LOGEMENT.remove(logement);
    }
    
    // -------------------------- Type_Charges ----------------------------------------

    public static List<Type_charges> selectTypeCharges(int id) {
        List<Type_charges> liste = DaoTest.TYPECHARGES.stream().filter(tc -> tc.getId_Type_charges() == id)
                .collect(Collectors.toList());
        return liste;
    }

    public static void insertTypeCharges(Type_charges typeCharges) {
        DaoTest.TYPECHARGES.add(typeCharges);
    }

    public static void updateTypeCharges(Type_charges typeCharges) {
        List<Type_charges> liste = DaoTest.selectTypeCharges(typeCharges.getId_Type_charges());
        Type_charges tc = liste.get(0);
        // Update fields of Type_Charges
    }

    public static void deleteTypeCharges(Type_charges typeCharges) {
        DaoTest.TYPECHARGES.remove(typeCharges);
    }
}

    
    
