package modele;

import java.util.Objects;

public class Charges {
    private int idCharges;
    private String dateCharges;
    private int consommation;
    private int idTypeCharges;

    public Charges(int idCharges, String dateCharges, int consommation, int idTypeCharges) {
        this.idCharges = idCharges;
        this.dateCharges = dateCharges;
        this.consommation = consommation;
        this.idTypeCharges = idTypeCharges;
    }

    public int getIdCharges() {
        return idCharges;
    }

    public void setIdCharges(int idCharges) {
        this.idCharges = idCharges;
    }

    public String getDateCharges() {
        return dateCharges;
    }

    public void setDateCharges(String dateCharges) {
        this.dateCharges = dateCharges;
    }

    public int getConsommation() {
        return consommation;
    }

    public void setConsommation(int consommation) {
        this.consommation = consommation;
    }

    public int getIdTypeCharges() {
        return idTypeCharges;
    }

    public void setIdTypeCharges(int idTypeCharges) {
        this.idTypeCharges = idTypeCharges;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCharges, dateCharges, consommation, idTypeCharges);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Charges charges = (Charges) obj;
        return idCharges == charges.idCharges &&
                consommation == charges.consommation &&
                idTypeCharges == charges.idTypeCharges &&
                Objects.equals(dateCharges, charges.dateCharges);
    }

	@Override
	public String toString() {
		return "Charges [idCharges=" + idCharges + ", dateCharges=" + dateCharges + ", consommation=" + consommation
				+ ", idTypeCharges=" + idTypeCharges + "]";
	}
    
    
}
