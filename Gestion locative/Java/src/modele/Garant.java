package modele;

import java.util.Objects;

public class Garant {

	private String nom;
	private String adresse;
	private int telephone;
	private String id_garant;
	private String email;
	
	public Garant(String email, String nom, String adresse, int telephone, String id_garant) {
		super();
		this.email = email;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
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

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getId_garant() {
		return id_garant;
	}

	public void setId_garant(String id_garant) {
		this.id_garant = id_garant;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(adresse, email, id_garant, nom, telephone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Garant)) {
			return false;
		}
		Garant other = (Garant) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(email, other.email)
				&& Objects.equals(id_garant, other.id_garant) && Objects.equals(nom, other.nom)
				&& telephone == other.telephone;
	}

	@Override
	public String toString() {
		return "Garant [nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + ", id_garant=" + id_garant
				+ ", email=" + email + "]";
	}

}
