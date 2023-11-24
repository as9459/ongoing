package modele;

import java.util.Objects;

public class Fac_Batiment {
    private int id_facture;
    private int id_batiment;
    private String date_facture;
    private String reference_du_paiement;
    private double paiement;
    private String type_Paiment;
    private String Date_de_paiement;
    
    public Fac_Batiment(int id_facture, int id_batiment, String date_facture, String reference_du_paiement,
                        double paiement, String type_Paiment, String Date_de_paiement) {
        this.id_facture = id_facture;
        this.id_batiment = id_batiment;
        this.date_facture = date_facture;
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

    public String getDate_facture() {
        return date_facture;
    }

    public void setDate_facture(String date_facture) {
        this.date_facture = date_facture;
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
        Fac_Batiment that = (Fac_Batiment) o;
        return id_facture == that.id_facture &&
                id_batiment == that.id_batiment &&
                Double.compare(that.paiement, paiement) == 0 &&
                Objects.equals(date_facture, that.date_facture) &&
                Objects.equals(reference_du_paiement, that.reference_du_paiement) &&
                Objects.equals(type_Paiment, that.type_Paiment) &&
                Objects.equals(Date_de_paiement, that.Date_de_paiement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_facture, id_batiment, date_facture, reference_du_paiement,
                paiement, type_Paiment, Date_de_paiement);
    }

    @Override
    public String toString() {
        return "Fac_Batiment [id_facture=" + id_facture + ", id_batiment=" + id_batiment +
                ", date_facture=" + date_facture + ", reference_du_paiement=" + reference_du_paiement +
                ", paiement=" + paiement + ", type_Paiment=" + type_Paiment +
                ", Date_de_paiement=" + Date_de_paiement + "]";
    }
}
