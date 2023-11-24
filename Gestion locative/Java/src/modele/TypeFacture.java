package modele;

import java.util.Objects;

public class TypeFacture {

	private String idTypeFacture;
	private String nom;
	
	public TypeFacture(String idTypeFacture, String nom) {
		super();
		this.idTypeFacture = idTypeFacture;
		this.nom = nom;
	}
	
	public String getIdTypeFacture() {
		return idTypeFacture;
	}
	public void setIdTypeFacture(String idTypeFacture) {
		this.idTypeFacture = idTypeFacture;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idTypeFacture, nom);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TypeFacture)) {
			return false;
		}
		TypeFacture other = (TypeFacture) obj;
		return Objects.equals(idTypeFacture, other.idTypeFacture) && Objects.equals(nom, other.nom);
	}


	@Override
	public String toString() {
		return "TypeFacture [idTypeFacture=" + idTypeFacture + ", nom=" + nom + "]";
	}

}
