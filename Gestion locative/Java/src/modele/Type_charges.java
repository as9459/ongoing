package modele;

import java.util.Objects;

public class Type_charges {
    private int id_Type_charges;
    private double prix_unitaire;
    private String nom;


    public Type_charges(int id_Type_charges, double prix_unitaire, String nom) {
        this.id_Type_charges = id_Type_charges;
        this.prix_unitaire = prix_unitaire;
        this.nom = nom;
    }

    public int getId_Type_charges() {
        return id_Type_charges;
    }

    public void setId_Type_charges(int id_Type_charges) {
        this.id_Type_charges = id_Type_charges;
    }

    public double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type_charges that = (Type_charges) o;
        return id_Type_charges == that.id_Type_charges &&
                Double.compare(that.prix_unitaire, prix_unitaire) == 0 &&
                Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Type_charges, prix_unitaire, nom);
    }

    @Override
    public String toString() {
        return "Type_charges [id_Type_charges=" + id_Type_charges + ", prix_unitaire=" + prix_unitaire +
                ", nom=" + nom + "]";
    }
}
