package modele;

import java.util.Objects;

public class Diagnostic {
    private String ref;
    private int idBatiment;
    private int idLogement;
    private boolean amiante;
    private String dateAmiante;
    private boolean plomb;
    private String datePlomb;
    private String dateDebutERP;
    private String dateFinERP;
    private String dateDebutDPE;
    private String dateFinDPE;

    public Diagnostic(String ref, int idBatiment, int idLogement, boolean amiante, String dateAmiante,
                        boolean plomb, String datePlomb, String dateDebutERP, String dateFinERP, String dateDebutDPE,
                        String dateFinDPE) {
        this.ref = ref;
        this.idBatiment = idBatiment;
        this.idLogement = idLogement;
        this.amiante = amiante;
        this.dateAmiante = dateAmiante;
        this.plomb = plomb;
        this.datePlomb = datePlomb;
        this.dateDebutERP = dateDebutERP;
        this.dateFinERP = dateFinERP;
        this.dateDebutDPE = dateDebutDPE;
        this.dateFinDPE = dateFinDPE;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getIdBatiment() {
        return idBatiment;
    }

    public void setIdBatiment(int idBatiment) {
        this.idBatiment = idBatiment;
    }

    public int getIdLogement() {
        return idLogement;
    }

    public void setIdLogement(int idLogement) {
        this.idLogement = idLogement;
    }

    public boolean isAmiante() {
        return amiante;
    }

    public void setAmiante(boolean amiante) {
        this.amiante = amiante;
    }

    public String getDateAmiante() {
        return dateAmiante;
    }

    public void setDateAmiante(String dateAmiante) {
        this.dateAmiante = dateAmiante;
    }

    public boolean isPlomb() {
        return plomb;
    }

    public void setPlomb(boolean plomb) {
        this.plomb = plomb;
    }

    public String getDatePlomb() {
        return datePlomb;
    }

    public void setDatePlomb(String datePlomb) {
        this.datePlomb = datePlomb;
    }

    public String getDateDebutERP() {
        return dateDebutERP;
    }

    public void setDateDebutERP(String dateDebutERP) {
        this.dateDebutERP = dateDebutERP;
    }

    public String getDateFinERP() {
        return dateFinERP;
    }

    public void setDateFinERP(String dateFinERP) {
        this.dateFinERP = dateFinERP;
    }

    public String getDateDebutDPE() {
        return dateDebutDPE;
    }

    public void setDateDebutDPE(String dateDebutDPE) {
        this.dateDebutDPE = dateDebutDPE;
    }

    public String getDateFinDPE() {
        return dateFinDPE;
    }

    public void setDateFinDPE(String dateFinDPE) {
        this.dateFinDPE = dateFinDPE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ref, idBatiment, idLogement, amiante, dateAmiante, plomb, datePlomb, dateDebutERP, dateFinERP, dateDebutDPE, dateFinDPE);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Diagnostic that = (Diagnostic) obj;
        return idBatiment == that.idBatiment &&
                idLogement == that.idLogement &&
                amiante == that.amiante &&
                plomb == that.plomb &&
                Objects.equals(ref, that.ref) &&
                Objects.equals(dateAmiante, that.dateAmiante) &&
                Objects.equals(datePlomb, that.datePlomb) &&
                Objects.equals(dateDebutERP, that.dateDebutERP) &&
                Objects.equals(dateFinERP, that.dateFinERP) &&
                Objects.equals(dateDebutDPE, that.dateDebutDPE) &&
                Objects.equals(dateFinDPE, that.dateFinDPE);
    }

	@Override
	public String toString() {
		return "Diagnostic [ref=" + ref + ", idBatiment=" + idBatiment + ", idLogement=" + idLogement + ", amiante="
				+ amiante + ", dateAmiante=" + dateAmiante + ", plomb=" + plomb + ", datePlomb=" + datePlomb
				+ ", dateDebutERP=" + dateDebutERP + ", dateFinERP=" + dateFinERP + ", dateDebutDPE=" + dateDebutDPE
				+ ", dateFinDPE=" + dateFinDPE + "]";
	}
    
    
}
