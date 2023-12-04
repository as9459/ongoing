package modele;

import java.util.Objects;

public class Facture {
    private int id_facture;
    private String date_facture;
    private String description;
    private int aide;
    private double montant_HT;
    private double TVA;
    private String type;
    private String SIREN;

    public Facture(int id_facture, String date_facture, String description, int aide,
                   double montant_HT, double TVA, String type, String SIREN) {
        this.id_facture = id_facture;
        this.date_facture = date_facture;
        this.description = description;
        this.aide = aide;
        this.montant_HT = montant_HT;
        this.TVA = TVA;
        this.type = type;
        this.SIREN = SIREN;
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public String getDate_facture() {
        return date_facture;
    }

    public void setDate_facture(String date_facture) {
        this.date_facture = date_facture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAide() {
        return aide;
    }

    public void setAide(int aide) {
        this.aide = aide;
    }

    public double getMontant_HT() {
        return montant_HT;
    }

    public void setMontant_HT(double montant_HT) {
        this.montant_HT = montant_HT;
    }

    public double getTVA() {
        return TVA;
    }

    public void setTVA(double TVA) {
        this.TVA = TVA;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSIREN() {
        return SIREN;
    }

    public void setSIREN(String SIREN) {
        this.SIREN = SIREN;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_facture, date_facture, description, aide, montant_HT, TVA, type, SIREN);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Facture facture = (Facture) obj;
        return id_facture == facture.id_facture &&
                aide == facture.aide &&
                Double.compare(facture.montant_HT, montant_HT) == 0 &&
                Double.compare(facture.TVA, TVA) == 0 &&
                Objects.equals(date_facture, facture.date_facture) &&
                Objects.equals(description, facture.description) &&
                Objects.equals(type, facture.type) &&
                Objects.equals(SIREN, facture.SIREN);
    }
}
