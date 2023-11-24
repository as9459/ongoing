package modele;
import java.util.Collection;
import java.util.Objects;

public class Type_charges {

	private int Id_Type_Charges;
	private float prix_unitaire;
	private String nom;
	
	public Type_charges(int id_Type_Charges, float prix_unitaire, String nom) {
		this.Id_Type_Charges = id_Type_Charges;
		this.prix_unitaire = prix_unitaire;
		this.nom = nom;
	}

	public int getId_Type_Charges() {
		return Id_Type_Charges;
	}

	public void setId_Type_Charges(int id_Type_Charges) {
		Id_Type_Charges = id_Type_Charges;
	}

	public float getPrix_unitaire() {
		return prix_unitaire;
	}

	public void setPrix_unitaire(float prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "type_charges [Id_Type_Charges=" + Id_Type_Charges + ", prix_unitaire=" + prix_unitaire + ", nom=" + nom
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id_Type_Charges, nom, prix_unitaire);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type_charges other = (Type_charges) obj;
		return Id_Type_Charges == other.Id_Type_Charges && Objects.equals(nom, other.nom)
				&& Float.floatToIntBits(prix_unitaire) == Float.floatToIntBits(other.prix_unitaire);
	}
	
	
	
}
