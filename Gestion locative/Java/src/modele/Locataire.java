package modele;
import java.util.Objects;

public class Locataire {

	private int id_locataire;

    private String nom;

    private String prenom;

    private int tel;
    
    private String dateNaissance;
    
    private String email;


    public Locataire(int id_locataire, String nom, String prenom, int tel, String statut, String dateNaissance, String email, int id_Statut) {
        super();
        this.id_locataire = id_locataire;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.dateNaissance = dateNaissance;
        this.email = email;
    }
    
    public int getId_locataire() {
		return id_locataire;
	}


	public void setId_locataire(int id_locataire) {
		this.id_locataire = id_locataire;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public int getTel() {
		return tel;
	}


	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int hashCode() {
		return Objects.hash(dateNaissance, email, id_locataire, nom, prenom, tel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Locataire)) {
			return false;
		}
		Locataire other = (Locataire) obj;
		return Objects.equals(dateNaissance, other.dateNaissance) && Objects.equals(email, other.email)
				&& id_locataire == other.id_locataire && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom) && tel == other.tel;
	}


	@Override
	public String toString() {
		return "Locataire [id_locataire=" + id_locataire + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel
				 + ", dateNaissance=" + dateNaissance + ", email=" + email + "]";
	}

}