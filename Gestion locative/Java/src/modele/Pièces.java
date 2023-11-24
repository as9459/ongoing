package modele;

import java.util.Objects;

public class Pièces {
    private int id_batiment;
    private int id_logement;
    private int id_piece;
    private String type;
    private double surface;
    private int nombre_fenetres;
    private int nombre_portes;

    public Pièces() {
    }

    public Pièces(int id_batiment, int id_logement, int id_piece, String type, double surface,
                 int nombre_fenetres, int nombre_portes) {
        this.id_batiment = id_batiment;
        this.id_logement = id_logement;
        this.id_piece = id_piece;
        this.type = type;
        this.surface = surface;
        this.nombre_fenetres = nombre_fenetres;
        this.nombre_portes = nombre_portes;
    }

    public int getId_batiment() {
        return id_batiment;
    }

    public void setId_batiment(int id_batiment) {
        this.id_batiment = id_batiment;
    }

    public int getId_logement() {
        return id_logement;
    }

    public void setId_logement(int id_logement) {
        this.id_logement = id_logement;
    }

    public int getId_piece() {
        return id_piece;
    }

    public void setId_piece(int id_piece) {
        this.id_piece = id_piece;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public int getNombre_fenetres() {
        return nombre_fenetres;
    }

    public void setNombre_fenetres(int nombre_fenetres) {
        this.nombre_fenetres = nombre_fenetres;
    }

    public int getNombre_portes() {
        return nombre_portes;
    }

    public void setNombre_portes(int nombre_portes) {
        this.nombre_portes = nombre_portes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pièces piece = (Pièces) o;
        return id_batiment == piece.id_batiment &&
                id_logement == piece.id_logement &&
                id_piece == piece.id_piece;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_batiment, id_logement, id_piece);
    }

    @Override
    public String toString() {
        return "Piece [id_batiment=" + id_batiment + ", id_logement=" + id_logement + ", id_piece=" + id_piece +
                ", type=" + type + ", surface=" + surface + ", nombre_fenetres=" + nombre_fenetres +
                ", nombre_portes=" + nombre_portes + "]";
    }
}
