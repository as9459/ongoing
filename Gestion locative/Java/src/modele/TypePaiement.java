package modele;

import java.util.Objects;

public class TypePaiement {
	

	private String type;
	private String idTypePaiment;
	
	public TypePaiement(String type, String idTypePaiment) {
		super();
		this.type = type;
		this.idTypePaiment = idTypePaiment;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIdTypePaiment() {
		return idTypePaiment;
	}
	public void setIdTypePaiment(String idTypePaiment) {
		this.idTypePaiment = idTypePaiment;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idTypePaiment, type);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TypePaiement)) {
			return false;
		}
		TypePaiement other = (TypePaiement) obj;
		return Objects.equals(idTypePaiment, other.idTypePaiment) && Objects.equals(type, other.type);
	}


	@Override
	public String toString() {
		return "TypePaiement [type=" + type + ", idTypePaiment=" + idTypePaiment + "]";
	}

}
