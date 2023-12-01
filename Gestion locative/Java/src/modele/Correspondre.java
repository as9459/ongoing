package modele;

import java.util.Objects;

public class Correspondre {

    private Long idFacture;
    private String dateFacture;
    private String idCharges;
    private Double chargesRegularises;
    private Double chargesDues;
    	
    public Correspondre(Long idFacture, String dateFacture, String idCharges, Double chargesRegularises, Double chargesDues) {
        this.idFacture = idFacture;
        this.dateFacture = dateFacture;
        this.idCharges = idCharges;
        this.chargesRegularises = chargesRegularises;
        this.chargesDues = chargesDues;
    }

    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public String getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(String dateFacture) {
        this.dateFacture = dateFacture;
    }

    public String getIdCharges() {
        return idCharges;
    }

    public void setIdCharges(String idCharges) {
        this.idCharges = idCharges;
    }

    public Double getChargesRegularises() {
        return chargesRegularises;
    }

    public void setChargesRegularises(Double chargesRegularises) {
        this.chargesRegularises = chargesRegularises;
    }

    public Double getChargesDues() {
        return chargesDues;
    }

    public void setChargesDues(Double chargesDues) {
        this.chargesDues = chargesDues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correspondre that = (Correspondre) o;
        return Objects.equals(idFacture, that.idFacture) &&
                Objects.equals(dateFacture, that.dateFacture) &&
                Objects.equals(idCharges, that.idCharges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacture, dateFacture, idCharges);
    }

    @Override
    public String toString() {
        return "Correspondre{" +
                "idFacture=" + idFacture +
                ", dateFacture='" + dateFacture + '\'' +
                ", idCharges='" + idCharges + '\'' +
                ", chargesRegularises=" + chargesRegularises +
                ", chargesDues=" + chargesDues +
                '}';
    }
}
