package modele;
import java.util.Collection;
import java.util.Objects;


public class Equipement {

	private int id_equipement;
	private String nom;
	
	public Equipement(int id_equipement, String nom) {
		this.id_equipement = id_equipement;
		this.nom = nom;
	}

	public int getId_equipement() {
		return id_equipement;
	}

	public void setId_equipement(int id_equipement) {
		this.id_equipement = id_equipement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Equipement [id_equipement=" + id_equipement + ", nom=" + nom + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_equipement, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipement other = (Equipement) obj;
		return id_equipement == other.id_equipement && Objects.equals(nom, other.nom);
	}
	
	
	
	
}