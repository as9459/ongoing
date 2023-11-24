package modele;

import java.util.Objects;

public class Facture {
	

	private String ref;
	private String desc;
	private String chargesDues;
	private float chargesRegularise;
	private boolean aide;
	private int montantAide;
	private float montantHT;
	private float tva;
	
	public Facture(String ref, String desc, String chargesDues, float chargesRegularise, boolean aide, int montantAide,
			float montantHT, float tva) {
		super();
		this.ref = ref;
		this.desc = desc;
		this.chargesDues = chargesDues;
		this.chargesRegularise = chargesRegularise;
		this.aide = aide;
		this.montantAide = montantAide;
		this.montantHT = montantHT;
		this.tva = tva;
	}
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getChargesDues() {
		return chargesDues;
	}
	public void setChargesDues(String chargesDues) {
		this.chargesDues = chargesDues;
	}
	public float getChargesRegularise() {
		return chargesRegularise;
	}
	public void setChargesRegularise(float chargesRegularise) {
		this.chargesRegularise = chargesRegularise;
	}
	public boolean isAide() {
		return aide;
	}
	public void setAide(boolean aide) {
		this.aide = aide;
	}
	public int getMontantAide() {
		return montantAide;
	}
	public void setMontantAide(int montantAide) {
		this.montantAide = montantAide;
	}
	public float getMontantHT() {
		return montantHT;
	}
	public void setMontantHT(float montantHT) {
		this.montantHT = montantHT;
	}
	public float getTva() {
		return tva;
	}
	public void setTva(float tva) {
		this.tva = tva;
	}


	@Override
	public int hashCode() {
		return Objects.hash(aide, chargesDues, chargesRegularise, desc, montantAide, montantHT, ref, tva);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Facture)) {
			return false;
		}
		Facture other = (Facture) obj;
		return aide == other.aide && Objects.equals(chargesDues, other.chargesDues)
				&& Float.floatToIntBits(chargesRegularise) == Float.floatToIntBits(other.chargesRegularise)
				&& Objects.equals(desc, other.desc) && montantAide == other.montantAide
				&& Float.floatToIntBits(montantHT) == Float.floatToIntBits(other.montantHT)
				&& Objects.equals(ref, other.ref) && Float.floatToIntBits(tva) == Float.floatToIntBits(other.tva);
	}


	@Override
	public String toString() {
		return "Facture [ref=" + ref + ", desc=" + desc + ", chargesDues=" + chargesDues + ", chargesRegularise="
				+ chargesRegularise + ", aide=" + aide + ", montantAide=" + montantAide + ", montantHT=" + montantHT
				+ ", tva=" + tva + "]";
	}

}
