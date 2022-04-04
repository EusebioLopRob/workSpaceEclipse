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
	
	public Producto() {
		this.codprod="";
		this.seccion="";
		this.nombreprod="";
		this.precio=null;
		this.fecha=null;
		this.importado= false;
		this.paisorigen="";
	}

	public Producto(String codprod, String seccion, String nombreprod, Double precio, LocalDate fecha,
			Boolean importado, String paisorigen) {
		
		this.codprod = codprod;
		this.seccion = seccion;
		this.nombreprod = nombreprod;
		this.precio = precio;
		this.fecha = fecha;
		this.importado=importado;	
		this.paisorigen = paisorigen;
	}
	
	public Producto(String codprod, String seccion, String nombreprod, Double precio, LocalDate fecha,
			int importado, String paisorigen) {
		
		this.codprod = codprod;
		this.seccion = seccion;
		this.nombreprod = nombreprod;
		this.precio = precio;
		this.fecha = fecha;
		if(importado==1) {
			this.importado= true;
		}
		else {
			this.importado= false;
		}			
		this.paisorigen = paisorigen;
	}
	
	public Producto(String codprod) {
		this.codprod=codprod;
		this.seccion="";
		this.nombreprod="";
		this.precio=0.0;
		this.fecha=null;
		this.importado= false;
		this.paisorigen="";
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
	
	
	
	
	
	
	

}
