package modele;

import java.util.Objects;

public class Equipement {
    private String reference;
    private int id_batiment;
    private int id_logement;
    private String type;
    private String etat;

    public Equipement(String reference, int id_batiment, int id_logement, String type, String etat) {
        this.reference = reference;
        this.id_batiment = id_batiment;
        this.id_logement = id_logement;
        this.type = type;
        this.etat = etat;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, id_batiment, id_logement, type, etat);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Equipement that = (Equipement) obj;
        return id_batiment == that.id_batiment &&
                id_logement == that.id_logement &&
                Objects.equals(reference, that.reference) &&
                Objects.equals(type, that.type) &&
                Objects.equals(etat, that.etat);
    }

	@Override
	public String toString() {
		return "Equipement [reference=" + reference + ", id_batiment=" + id_batiment + ", id_logement=" + id_logement
				+ ", type=" + type + ", etat=" + etat + "]";
	}
    
    
    
}
