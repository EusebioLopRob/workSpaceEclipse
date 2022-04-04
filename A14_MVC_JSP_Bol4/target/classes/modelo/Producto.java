package modelo;

import java.time.LocalDate;


public class Producto {
	
	private String codprod;
	private String seccion;
	private String nombreprod;
	private Double precio;
	private LocalDate fecha;
	private Boolean importado;
	private String paisorigen;
	
	public Producto(String codprod, String seccion, String nombreprod, Double precio, LocalDate fecha,
			Boolean importado, String paisorigen) {
		super();
		this.codprod = codprod;
		this.seccion = seccion;
		this.nombreprod = nombreprod;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisorigen = paisorigen;
	}

	public String getCodprod() {
		return codprod;
	}

	public void setCodprod(String codprod) {
		this.codprod = codprod;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getNombreprod() {
		return nombreprod;
	}

	public void setNombreprod(String nombreprod) {
		this.nombreprod = nombreprod;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Boolean getImportado() {
		return importado;
	}

	public void setImportado(Boolean importado) {
		this.importado = importado;
	}

	public String getPaisorigen() {
		return paisorigen;
	}

	public void setPaisorigen(String paisorigen) {
		this.paisorigen = paisorigen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codprod == null) ? 0 : codprod.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((importado == null) ? 0 : importado.hashCode());
		result = prime * result + ((nombreprod == null) ? 0 : nombreprod.hashCode());
		result = prime * result + ((paisorigen == null) ? 0 : paisorigen.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((seccion == null) ? 0 : seccion.hashCode());
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
		Producto other = (Producto) obj;
		if (codprod == null) {
			if (other.codprod != null)
				return false;
		} else if (!codprod.equals(other.codprod))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (importado == null) {
			if (other.importado != null)
				return false;
		} else if (!importado.equals(other.importado))
			return false;
		if (nombreprod == null) {
			if (other.nombreprod != null)
				return false;
		} else if (!nombreprod.equals(other.nombreprod))
			return false;
		if (paisorigen == null) {
			if (other.paisorigen != null)
				return false;
		} else if (!paisorigen.equals(other.paisorigen))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (seccion == null) {
			if (other.seccion != null)
				return false;
		} else if (!seccion.equals(other.seccion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [codprod=" + codprod + ", seccion=" + seccion + ", nombreprod=" + nombreprod + ", precio="
				+ precio + ", fecha=" + fecha + ", importado=" + importado + ", paisorigen=" + paisorigen + "]";
	}
	
	
	

}
