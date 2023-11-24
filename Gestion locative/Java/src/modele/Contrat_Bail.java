package modele;
import java.util.Collection;
import java.util.Objects;


public class Contrat_Bail {

	private int id_bail;
	private long date_debut;
	private long date_fin;
	private int frais_agence;
	private int loyer;
	private int charges_fixes;
	private int Jour_paiement;
	
	
	public Contrat_Bail(int id_bail, long date_debut, long date_fin, int frais_agence, int loyer, int charges_fixes,
			int jour_paiement) {
		this.id_bail = id_bail;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.frais_agence = frais_agence;
		this.loyer = loyer;
		this.charges_fixes = charges_fixes;
		Jour_paiement = jour_paiement;
	}


	public int getId_bail() {
		return id_bail;
	}


	public void setId_bail(int id_bail) {
		this.id_bail = id_bail;
	}


	public long getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(long date_debut) {
		this.date_debut = date_debut;
	}


	public long getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(long date_fin) {
		this.date_fin = date_fin;
	}


	public int getFrais_agence() {
		return frais_agence;
	}


	public void setFrais_agence(int frais_agence) {
		this.frais_agence = frais_agence;
	}


	public int getLoyer() {
		return loyer;
	}


	public void setLoyer(int loyer) {
		this.loyer = loyer;
	}


	public int getCharges_fixes() {
		return charges_fixes;
	}


	public void setCharges_fixes(int charges_fixes) {
		this.charges_fixes = charges_fixes;
	}


	public int getJour_paiement() {
		return Jour_paiement;
	}


	public void setJour_paiement(int jour_paiement) {
		Jour_paiement = jour_paiement;
	}


	@Override
	public String toString() {
		return "Contrat_Bail [id_bail=" + id_bail + ", date_debut=" + date_debut + ", date_fin=" + date_fin
				+ ", frais_agence=" + frais_agence + ", loyer=" + loyer + ", charges_fixes=" + charges_fixes
				+ ", Jour_paiement=" + Jour_paiement + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(Jour_paiement, charges_fixes, date_debut, date_fin, frais_agence, id_bail, loyer);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrat_Bail other = (Contrat_Bail) obj;
		return Jour_paiement == other.Jour_paiement && charges_fixes == other.charges_fixes
				&& date_debut == other.date_debut && date_fin == other.date_fin && frais_agence == other.frais_agence
				&& id_bail == other.id_bail && loyer == other.loyer;
	}
	
	
}