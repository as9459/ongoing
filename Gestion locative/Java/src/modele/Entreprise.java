package modele;

import java.util.Objects;

public class Entreprise {
	
	private String siren;
	private String nom;
	private String adresse;
	private String cp;
	private String iban;
	private String ville;
	private String mail;
	private int tel;
	
	public Entreprise(String siren, String nom, String adresse, String cp, String iban, String ville, String mail,
			int tel) {
		super();
		this.siren = siren;
		this.nom = nom;
		this.adresse = adresse;
		this.cp = cp;
		this.iban = iban;
		this.ville = ville;
		this.mail = mail;
		this.tel = tel;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}


	@Override
	public int hashCode() {
		return Objects.hash(adresse, cp, iban, mail, nom, siren, tel, ville);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Entreprise)) {
			return false;
		}
		Entreprise other = (Entreprise) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(cp, other.cp)
				&& Objects.equals(iban, other.iban) && Objects.equals(mail, other.mail)
				&& Objects.equals(nom, other.nom) && Objects.equals(siren, other.siren) && tel == other.tel
				&& Objects.equals(ville, other.ville);
	}


	@Override
	public String toString() {
		return "Entreprise [siren=" + siren + ", nom=" + nom + ", adresse=" + adresse + ", cp=" + cp + ", iban=" + iban
				+ ", ville=" + ville + ", mail=" + mail + ", tel=" + tel + "]";
	}

}
