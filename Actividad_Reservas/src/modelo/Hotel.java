package modelo;

import java.util.ArrayList;

public class Hotel {
    private String cod_hotel;
    private String nombre;
    private String direccion;
    private int categoria;
    private String cod_cadena;
    private String provincia;
    
	public Hotel(String cod_hotel) {
		this.cod_hotel = cod_hotel;
	}
	public Hotel(String cod_hotel, String nombre, String direccion, int categoria, String cod_cadena,
			String provincia) {
		this.cod_hotel = cod_hotel;
		this.nombre = nombre;
		this.direccion = direccion;
		this.categoria = categoria;
		this.cod_cadena = cod_cadena;
		this.provincia = provincia;
	}
	public String getCod_hotel() {
		return cod_hotel;
	}
	public void setCod_hotel(String cod_hotel) {
		this.cod_hotel = cod_hotel;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getCod_cadena() {
		return cod_cadena;
	}
	public void setCod_cadena(String cod_cadena) {
		this.cod_cadena = cod_cadena;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_hotel == null) ? 0 : cod_hotel.hashCode());
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
		Hotel other = (Hotel) obj;
		if (cod_hotel == null) {
			if (other.cod_hotel != null)
				return false;
		} else if (!cod_hotel.equals(other.cod_hotel))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Hotel [cod_hotel=" + cod_hotel + ", nombre=" + nombre + ", direccion=" + direccion + ", categoria="
				+ categoria + ", cod_cadena=" + cod_cadena + ", provincia=" + provincia + "]";
	}
	
	
	
	
    
    

	
	
	
	
	
	
    
    
}
