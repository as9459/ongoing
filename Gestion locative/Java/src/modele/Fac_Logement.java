package modele;

import java.util.Objects;

public class Fac_Logement {
    private int id_facture;
    private int id_batiment;
    private int id_logement;
    private String date_facture;
    private int id_locataire;
    private String reference_du_paiement;
    private double paiement;
    private String type_Paiment;
    private String Date_de_paiement;

    public Fac_Logement(int id_facture, int id_batiment, int id_logement, String date_facture, int id_locataire,
                        String reference_du_paiement, double paiement, String type_Paiment, String Date_de_paiement) {
        this.id_facture = id_facture;
        this.id_batiment = id_batiment;
        this.id_logement = id_logement;
        this.date_facture = date_facture;
        this.id_locataire = id_locataire;
        this.reference_du_paiement = reference_du_paiement;
        this.paiement = paiement;
        this.type_Paiment = type_Paiment;
        this.Date_de_paiement = Date_de_paiement;
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public int getId_batiment() {
        return id_batiment;
    }

    public void setId_batiment(int id_batiment) {
        this.id_batiment = id_batiment;
    }

    public int getId_logement() {
        return id_logement;
    }

    public void setId_logement(int id_logement) {
        this.id_logement = id_logement;
    }

    public String getDate_facture() {
        return date_facture;
    }

    public void setDate_facture(String date_facture) {
        this.date_facture = date_facture;
    }

    public int getId_locataire() {
        return id_locataire;
    }

    public void setId_locataire(int id_locataire) {
        this.id_locataire = id_locataire;
    }

    public String getReference_du_paiement() {
        return reference_du_paiement;
    }

    public void setReference_du_paiement(String reference_du_paiement) {
        this.reference_du_paiement = reference_du_paiement;
    }

    public double getPaiement() {
        return paiement;
    }

    public void setPaiement(double paiement) {
        this.paiement = paiement;
    }

    public String getType_Paiment() {
        return type_Paiment;
    }

    public void setType_Paiment(String type_Paiment) {
        this.type_Paiment = type_Paiment;
    }

    public String getDate_de_paiement() {
        return Date_de_paiement;
    }

    public void setDate_de_paiement(String Date_de_paiement) {
        this.Date_de_paiement = Date_de_paiement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fac_Logement that = (Fac_Logement) o;
        return id_facture == that.id_facture &&
                id_batiment == that.id_batiment &&
                id_logement == that.id_logement &&
                id_locataire == that.id_locataire &&
                Double.compare(that.paiement, paiement) == 0 &&
                Objects.equals(date_facture, that.date_facture) &&
                Objects.equals(reference_du_paiement, that.reference_du_paiement) &&
                Objects.equals(type_Paiment, that.type_Paiment) &&
                Objects.equals(Date_de_paiement, that.Date_de_paiement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_facture, id_batiment, id_logement, date_facture, id_locataire,
                reference_du_paiement, paiement, type_Paiment, Date_de_paiement);
    }

    @Override
    public String toString() {
        return "Fac_Logement [id_facture=" + id_facture + ", id_batiment=" + id_batiment + ", id_logement=" + id_logement +
                ", date_facture=" + date_facture + ", id_locataire=" + id_locataire +
                ", reference_du_paiement=" + reference_du_paiement + ", paiement=" + paiement +
                ", type_Paiment=" + type_Paiment + ", Date_de_paiement=" + Date_de_paiement + "]";
    }
}
