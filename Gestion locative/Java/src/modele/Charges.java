package modele;
import java.util.Collection;
import java.util.Objects;

public class Charges {

	private int id_charges;
	private long date;
	private int consommation;
	

	public Charges(int id_charges, long date, int consommation) {
		this.id_charges = id_charges;
		this.date = date;
		this.consommation = consommation;
	}


	public int getId_charges() {
		return id_charges;
	}


	public void setId_charges(int id_charges) {
		this.id_charges = id_charges;
	}


	public long getDate() {
		return date;
	}


	public void setDate(long date) {
		this.date = date;
	}


	public int getConsommation() {
		return consommation;
	}


	public void setConsommation(int consommation) {
		this.consommation = consommation;
	}


	@Override
	public String toString() {
		return "Charges [id_charges=" + id_charges + ", date=" + date + ", consommation=" + consommation + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(consommation, date, id_charges);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Charges other = (Charges) obj;
		return consommation == other.consommation && date == other.date && id_charges == other.id_charges;
	}
	
	
	
}