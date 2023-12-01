package modele;

import java.util.Objects;

public class Garant {
    private int id_garant;
    private String nom;
    private String adresse;
    private String e_mail;
    private String telephone;

    public Garant() {
    }

    public Garant(int id_garant, String nom, String adresse, String e_mail, String telephone) {
        this.id_garant = id_garant;
        this.nom = nom;
        this.adresse = adresse;
        this.e_mail = e_mail;
        this.telephone = telephone;
    }

    public int getId_garant() {
        return id_garant;
    }

    public void setId_garant(int id_garant) {
        this.id_garant = id_garant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garant garant = (Garant) o;
        return id_garant == garant.id_garant &&
                Objects.equals(nom, garant.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_garant, nom);
    }

	@Override
	public String toString() {
		return "Garant [id_garant=" + id_garant + ", nom=" + nom + ", adresse=" + adresse + ", e_mail=" + e_mail
				+ ", telephone=" + telephone + "]";
	}
    
    
}