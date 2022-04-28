package modelo;

public class Tipo {
	private int idTipo;
	private String nombreTipo;
	
	//Constructores
	public Tipo() {}
	public Tipo(int idTipo, String nombreTipo) {
		this.idTipo = idTipo;
		this.nombreTipo = nombreTipo;
	}
	
	//Getters y setters
	public int getIdTipo() {
		return this.idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getNombreTipo() {
		return this.nombreTipo;
	}
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	
	@Override
	public String toString() {
		return "Tipo [idTipo=" + this.idTipo + ", nombreTipo=" + this.nombreTipo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.idTipo;
		result = prime * result + ((this.nombreTipo == null) ? 0 : this.nombreTipo.hashCode());
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
		Tipo other = (Tipo) obj;
		if (this.idTipo != other.idTipo)
			return false;
		if (this.nombreTipo == null) {
			if (other.nombreTipo != null)
				return false;
		} else if (!this.nombreTipo.equals(other.nombreTipo))
			return false;
		return true;
	}
}
