package modele;
import java.util.Collection;
import java.util.Objects;


public class Pièces {

	private int id_pieces;
	private String nom;
	
	public Pièces(int id_pieces, String nom) {
		this.id_pieces = id_pieces;
		this.nom = nom;
	}

	public int getId_pieces() {
		return id_pieces;
	}

	public void setId_pieces(int id_pieces) {
		this.id_pieces = id_pieces;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_pieces, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pièces other = (Pièces) obj;
		return id_pieces == other.id_pieces && Objects.equals(nom, other.nom);
	}

	@Override
	public String toString() {
		return "Pi�ces [id_pieces=" + id_pieces + ", nom=" + nom + "]";
	}
	
	
	
}