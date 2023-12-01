package modele;
import java.util.Objects;

public class Locataire {
    private int idLocataire;
    private String nom;
    private String prenom;
    private String telephone;
    private String dateDeNaissance;
    private String statut;
    private String email;

    public Locataire(int idLocataire, String nom, String prenom, String telephone, String dateDeNaissance,
                     String statut, String email) {
        this.idLocataire = idLocataire;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.dateDeNaissance = dateDeNaissance;
        this.statut = statut;
        this.email = email;
    }

    public int getIdLocataire() {
        return idLocataire;
    }

    public void setIdLocataire(int idLocataire) {
        this.idLocataire = idLocataire;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLocataire, nom, prenom, telephone, dateDeNaissance, statut, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Locataire locataire = (Locataire) obj;
        return idLocataire == locataire.idLocataire &&
                Objects.equals(nom, locataire.nom) &&
                Objects.equals(prenom, locataire.prenom) &&
                Objects.equals(telephone, locataire.telephone) &&
                Objects.equals(dateDeNaissance, locataire.dateDeNaissance) &&
                Objects.equals(statut, locataire.statut) &&
                Objects.equals(email, locataire.email);
    }

	@Override
	public String toString() {
		return "Locataire [idLocataire=" + idLocataire + ", nom=" + nom + ", prenom=" + prenom + ", telephone="
				+ telephone + ", dateDeNaissance=" + dateDeNaissance + ", statut=" + statut + ", email=" + email + "]";
	}
    
    
}
