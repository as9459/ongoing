package modele;
import java.util.Collection;
import java.util.Objects;

public class Logement {

	
	private int id_logement;
	private String type;
	private String etage;
	private int icc;
	private boolean garage;
	private boolean jardin;
	private boolean balcon;
	
	
	public Logement(int id_logement, String type, String etage, int icc, boolean garage, boolean jardin, boolean balcon){
		this.id_logement = id_logement;
		this.type = type;
		this.etage = etage;
		this.icc = icc;
		this.garage = garage;
		this.jardin = jardin;
		this.balcon = balcon;
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
	public int getIcc() {
		return icc;
	}
	public void setIcc(int icc) {
		this.icc = icc;
	}
	public boolean isGarage() {
		return garage;
	}
	public void setGarage(boolean garage) {
		this.garage = garage;
	}
	public boolean isJardin() {
		return jardin;
	}
	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}
	public boolean isBalcon() {
		return balcon;
	}
	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}

	@Override
	public String toString() {
		return "Logement [id_logement=" + id_logement + ", type=" + type + ", etage=" + etage + ", icc=" + icc
				+ ", garage=" + garage + ", jardin=" + jardin + ", balcon=" + balcon + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(balcon, etage, garage, icc, id_logement, jardin, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logement other = (Logement) obj;
		return balcon == other.balcon && Objects.equals(etage, other.etage) && garage == other.garage
				&& icc == other.icc && id_logement == other.id_logement && jardin == other.jardin
				&& Objects.equals(type, other.type);
	}
	
	
}