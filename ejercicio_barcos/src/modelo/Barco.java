package modelo;

import java.time.LocalDate;

public class Barco {
	private int idBarco;
	private String nombre;
	private LocalDate fechaBotado;
	private Tipo tipo;
	private Clase clase;
	
	//Constructores
	public Barco() {
	}
	public Barco(int idBarco, String nombre, LocalDate fechaBotado, Tipo tipo, Clase clase) {
		this.idBarco = idBarco;
		this.nombre = nombre;
		this.fechaBotado = fechaBotado;
		this.tipo = tipo;
		this.clase = clase;
	}
	public int getIdBarco() {
		return this.idBarco;
	}
	public void setIdBarco(int idBarco) {
		this.idBarco = idBarco;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaBotado() {
		return this.fechaBotado;
	}
	public void setFechaBotado(LocalDate fechaBotado) {
		this.fechaBotado = fechaBotado;
	}
	public Tipo getTipo() {
		return this.tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Clase getClase() {
		return this.clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	@Override
	public String toString() {
		return "{'id':" + this.idBarco + ",'nombre':'" + this.nombre +"', 'fechaBotado':'" + this.fechaBotado 
				+ "', 'tipo':{'id':"+this.tipo.getIdTipo()+", 'nombre':'" + this.tipo.getNombreTipo()
				+ "'}, 'clase':{'id':"+this.clase.getIdClase()+", 'nombre':'" + this.clase.getNombreClase() + "'}}";
	}
	
}
