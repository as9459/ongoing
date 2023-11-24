package modele;
import java.util.Collection;
import java.util.Objects;


public class Batiment {

	
	private int id_batiment;
	private String Adresse;
	private int code_postal;
	private String Ville;
	private String regime_juridique;
	private long date_construction;
	
	public Batiment(int id_batiment, String adresse, int code_postal, String ville, String regime_juridique,
			long date_construction) {
		super();
		this.id_batiment = id_batiment;
		Adresse = adresse;
		this.code_postal = code_postal;
		Ville = ville;
		this.regime_juridique = regime_juridique;
		this.date_construction = date_construction;
	}

	public int getId_batiment() {
		return id_batiment;
	}

	public void setId_batiment(int id_batiment) {
		this.id_batiment = id_batiment;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public int getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getRegime_juridique() {
		return regime_juridique;
	}

	public void setRegime_juridique(String regime_juridique) {
		this.regime_juridique = regime_juridique;
	}

	public long getDate_construction() {
		return date_construction;
	}

	public void setDate_construction(long date_construction) {
		this.date_construction = date_construction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Adresse, Ville, code_postal, date_construction, id_batiment, regime_juridique);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batiment other = (Batiment) obj;
		return Objects.equals(Adresse, other.Adresse) && Objects.equals(Ville, other.Ville)
				&& code_postal == other.code_postal && date_construction == other.date_construction
				&& id_batiment == other.id_batiment && Objects.equals(regime_juridique, other.regime_juridique);
	}

	@Override
	public String toString() {
		return "Batiment [id_batiment=" + id_batiment + ", Adresse=" + Adresse + ", code_postal=" + code_postal
				+ ", Ville=" + Ville + ", regime_juridique=" + regime_juridique + ", date_construction="
				+ date_construction + "]";
	}
	
	
}