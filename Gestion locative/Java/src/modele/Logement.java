package modele;

import java.util.Objects;

public class Logement {
    private int id_batiment;
    private int id_logement;
    private String type;
    private String etage;
    private double surface;
    private int colocation;
    private Integer icc;
    private int garage;
    private int jardin;
    private int balcon;

    public Logement(int id_batiment, int id_logement, String type, String etage, double surface,
                    int colocation, Integer icc, int garage, int jardin, int balcon) {
        this.id_batiment = id_batiment;
        this.id_logement = id_logement;
        this.type = type;
        this.etage = etage;
        this.surface = surface;
        this.colocation = colocation;
        this.icc = icc;
        this.garage = garage;
        this.jardin = jardin;
        this.balcon = balcon;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtage() {
        return etage;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public int getColocation() {
        return colocation;
    }

    public void setColocation(int colocation) {
        this.colocation = colocation;
    }

    public Integer getIcc() {
        return icc;
    }

    public void setIcc(Integer icc) {
        this.icc = icc;
    }

    public int getGarage() {
        return garage;
    }

    public void setGarage(int garage) {
        this.garage = garage;
    }

    public int getJardin() {
        return jardin;
    }

    public void setJardin(int jardin) {
        this.jardin = jardin;
    }

    public int getBalcon() {
        return balcon;
    }

    public void setBalcon(int balcon) {
        this.balcon = balcon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logement logement = (Logement) o;
        return id_batiment == logement.id_batiment &&
                id_logement == logement.id_logement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_batiment, id_logement);
    }

    @Override
    public String toString() {
        return "Logement [id_batiment=" + id_batiment + ", id_logement=" + id_logement + ", type=" + type +
                ", etage=" + etage + ", surface=" + surface + ", colocation=" + colocation + ", icc=" + icc +
                ", garage=" + garage + ", jardin=" + jardin + ", balcon=" + balcon + "]";
    }
}
