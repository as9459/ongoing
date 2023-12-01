package modele;

import java.util.Objects;

public class Batiment {
    private int idBatiment;
    private String adresse;
    private String codePostal;
    private String ville;
    private String regimeJuridique;
    private String dateConstruction;

    public Batiment(int idBatiment, String adresse, String codePostal, String ville,
                    String regimeJuridique, String dateConstruction) {
        this.idBatiment = idBatiment;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.regimeJuridique = regimeJuridique;
        this.dateConstruction = dateConstruction;
    }

    public int getIdBatiment() {
        return idBatiment;
    }

    public void setIdBatiment(int idBatiment) {
        this.idBatiment = idBatiment;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRegimeJuridique() {
        return regimeJuridique;
    }

    public void setRegimeJuridique(String regimeJuridique) {
        this.regimeJuridique = regimeJuridique;
    }

    public String getDateConstruction() {
        return dateConstruction;
    }

    public void setDateConstruction(String dateConstruction) {
        this.dateConstruction = dateConstruction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBatiment, adresse, codePostal, ville, regimeJuridique, dateConstruction);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Batiment batiment = (Batiment) obj;
        return idBatiment == batiment.idBatiment &&
                Objects.equals(adresse, batiment.adresse) &&
                Objects.equals(codePostal, batiment.codePostal) &&
                Objects.equals(ville, batiment.ville) &&
                Objects.equals(regimeJuridique, batiment.regimeJuridique) &&
                Objects.equals(dateConstruction, batiment.dateConstruction);
    }

	@Override
	public String toString() {
		return "Batiment [idBatiment=" + idBatiment + ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville="
				+ ville + ", regimeJuridique=" + regimeJuridique + ", dateConstruction=" + dateConstruction + "]";
	}
    
    
    
}