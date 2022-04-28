package modelo;

public class Clase {
	private int idClase;
	private String nombreClase;
	
	//Contsructores
	public Clase() {
	}
	public Clase(int idClase, String nombreClase) {
		this.idClase = idClase;
		this.nombreClase = nombreClase;
	}
	
	//Getters y Setters
	public int getIdClase() {
		return this.idClase;
	}
	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}
	public String getNombreClase() {
		return this.nombreClase;
	}
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	@Override
	public String toString() {
		return "Clase [idClase=" + this.idClase + ", nombreClase=" + this.nombreClase + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.idClase;
		result = prime * result + ((this.nombreClase == null) ? 0 : this.nombreClase.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clase other = (Clase) obj;
		if (this.idClase != other.idClase)
			return false;
		if (this.nombreClase == null) {
			if (other.nombreClase != null)
				return false;
		} else if (!this.nombreClase.equals(other.nombreClase))
			return false;
		return true;
	}
	
}
