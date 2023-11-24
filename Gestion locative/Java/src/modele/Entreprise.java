package modele;

import java.util.Objects;

public class Entreprise {
    private String siren;
    private String nom;
    private String serves;
    private String adresse;
    private String cp;
    private String iban;
    private String ville;
    private String email;
    private String telephone;

    public Entreprise(String siren, String nom, String serves, String adresse, String cp, String iban, String ville,
                      String email, String telephone) {
        this.siren = siren;
        this.nom = nom;
        this.serves = serves;
        this.adresse = adresse;
        this.cp = cp;
        this.iban = iban;
        this.ville = ville;
        this.email = email;
        this.telephone = telephone;
    }

    public String getSiren() {
        return siren;
    }

    public void setSiren(String siren) {
        this.siren = siren;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getServes() {
        return serves;
    }

    public void setServes(String serves) {
        this.serves = serves;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(siren, nom, serves, adresse, cp, iban, ville, email, telephone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Entreprise that = (Entreprise) obj;
        return Objects.equals(siren, that.siren) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(serves, that.serves) &&
                Objects.equals(adresse, that.adresse) &&
                Objects.equals(cp, that.cp) &&
                Objects.equals(iban, that.iban) &&
                Objects.equals(ville, that.ville) &&
                Objects.equals(email, that.email) &&
                Objects.equals(telephone, that.telephone);
    }

	@Override
	public String toString() {
		return "Entreprise [siren=" + siren + ", nom=" + nom + ", serves=" + serves + ", adresse=" + adresse + ", cp="
				+ cp + ", iban=" + iban + ", ville=" + ville + ", email=" + email + ", telephone=" + telephone + "]";
	}
    
    
}
