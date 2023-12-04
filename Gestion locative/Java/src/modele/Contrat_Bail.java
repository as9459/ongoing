package modele;

import java.util.Date;
import java.util.Objects;

public class Contrat_Bail {
    private int idBail;
    private Date dateDebut;
    private Date dateFin;
    private double fraisDagence;
    private double loyer;
    private double chargesFixes;
    private double montant_aide;
    private int jourPaiement;
    private boolean solodTC;
    private int idBatiment;
    private int idLogement;

    public Contrat_Bail(int idBail, Date dateDebut, Date dateFin, double fraisDagence, double loyer, double chargesFixes, 
    					double montant_aide, int jourPaiement, boolean solodTC, int idBatiment, int idLogement) {
        this.idBail = idBail;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.fraisDagence = fraisDagence;
        this.loyer = loyer;
        this.chargesFixes = chargesFixes;
        this.montant_aide = montant_aide;
        this.jourPaiement = jourPaiement;
        this.solodTC = solodTC;
        this.idBatiment = idBatiment;
        this.idLogement = idLogement;
    }

    public int getIdBail() {
        return idBail;
    }

    public void setIdBail(int idBail) {
        this.idBail = idBail;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getFraisDagence() {
        return fraisDagence;
    }

    public void setFraisDagence(double fraisDagence) {
        this.fraisDagence = fraisDagence;
    }

    public double getLoyer() {
        return loyer;
    }

    public void setLoyer(double loyer) {
        this.loyer = loyer;
    }

    public double getChargesFixes() {
        return chargesFixes;
    }

    public void setChargesFixes(double chargesFixes) {
        this.chargesFixes = chargesFixes;
    }
    
    public double getMontant_aide() {
        return chargesFixes;
    }

    public void setMontant_aide(double montant_aide) {
        this.montant_aide = montant_aide;
    }

    public int getJourPaiement() {
        return jourPaiement;
    }

    public void setJourPaiement(int jourPaiement) {
        this.jourPaiement = jourPaiement;
    }

    public boolean isSolodTC() {
        return solodTC;
    }

    public void setSolodTC(boolean solodTC) {
        this.solodTC = solodTC;
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

    @Override
    public int hashCode() {
        return Objects.hash(idBail, dateDebut, dateFin, fraisDagence, loyer, chargesFixes, montant_aide, jourPaiement, solodTC, idBatiment, idLogement);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contrat_Bail that = (Contrat_Bail) obj;
        return idBail == that.idBail &&
                Double.compare(that.fraisDagence, fraisDagence) == 0 &&
                Double.compare(that.loyer, loyer) == 0 &&
                Double.compare(that.chargesFixes, chargesFixes) == 0 &&
                Double.compare(that.montant_aide, montant_aide) == 0 &&
                jourPaiement == that.jourPaiement &&
                solodTC == that.solodTC &&
                idBatiment == that.idBatiment &&
                idLogement == that.idLogement &&
                Objects.equals(dateDebut, that.dateDebut) &&
                Objects.equals(dateFin, that.dateFin);
    }

	@Override
	public String toString() {
		return "Contrat_Bail [idBail=" + idBail + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", fraisDagence=" + fraisDagence + ", loyer=" + loyer + ", chargesFixes=" + chargesFixes
				+ ", Montant Aide=" + montant_aide + ", jourPaiement=" + jourPaiement + ", solodTC=" + solodTC + ", idBatiment=" + idBatiment
				+ ", idLogement=" + idLogement + "]";
	}
    
    
}
