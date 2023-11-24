package modele;

import java.util.Objects;

public class Diagnostic {
	
	private String ref;
	private boolean amiante;
	private String dateAmiante;
	private boolean plomb;
	private String datePlomb;
	private String dateDebERP;
	private String dateFinERP;
	private String dateDebDPE;
	private String dateFinDPE;
	
	public Diagnostic(String ref, boolean amiante, String dateAmiante, boolean plomb, String datePlomb,
			String dateDebERP, String dateFinERP, String dateDebDPE, String dateFinDPE) {
		super();
		this.ref = ref;
		this.amiante = amiante;
		this.dateAmiante = dateAmiante;
		this.plomb = plomb;
		this.datePlomb = datePlomb;
		this.dateDebERP = dateDebERP;
		this.dateFinERP = dateFinERP;
		this.dateDebDPE = dateDebDPE;
		this.dateFinDPE = dateFinDPE;
	}
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
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
	public String getDateDebERP() {
		return dateDebERP;
	}
	public void setDateDebERP(String dateDebERP) {
		this.dateDebERP = dateDebERP;
	}
	public String getDateFinERP() {
		return dateFinERP;
	}
	public void setDateFinERP(String dateFinERP) {
		this.dateFinERP = dateFinERP;
	}
	public String getDateDebDPE() {
		return dateDebDPE;
	}
	public void setDateDebDPE(String dateDebDPE) {
		this.dateDebDPE = dateDebDPE;
	}
	public String getDateFinDPE() {
		return dateFinDPE;
	}
	public void setDateFinDPE(String dateFinDPE) {
		this.dateFinDPE = dateFinDPE;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(amiante, dateAmiante, dateDebDPE, dateDebERP, dateFinDPE, dateFinERP, datePlomb, plomb,
				ref);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Diagnostic)) {
			return false;
		}
		Diagnostic other = (Diagnostic) obj;
		return amiante == other.amiante && Objects.equals(dateAmiante, other.dateAmiante)
				&& Objects.equals(dateDebDPE, other.dateDebDPE) && Objects.equals(dateDebERP, other.dateDebERP)
				&& Objects.equals(dateFinDPE, other.dateFinDPE) && Objects.equals(dateFinERP, other.dateFinERP)
				&& Objects.equals(datePlomb, other.datePlomb) && plomb == other.plomb && Objects.equals(ref, other.ref);
	}


	@Override
	public String toString() {
		return "Diagnostic [ref=" + ref + ", amiante=" + amiante + ", dateAmiante=" + dateAmiante + ", plomb=" + plomb
				+ ", datePlomb=" + datePlomb + ", dateDebERP=" + dateDebERP + ", dateFinERP=" + dateFinERP
				+ ", dateDebDPE=" + dateDebDPE + ", dateFinDPE=" + dateFinDPE + "]";
	}


}
