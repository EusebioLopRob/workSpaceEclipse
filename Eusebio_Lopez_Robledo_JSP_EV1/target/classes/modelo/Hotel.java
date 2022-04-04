package modelo;

public class Hotel {
	private String codigo;
	private String nombre;
	private int categoria;
	private String direccion;
	private String provincia;
	
	
	public Hotel() {
		this.codigo = "";
		this.nombre = "";
		this.categoria = 0;
		this.direccion = "";
		this.provincia = "";
	}
	public Hotel(String codigo) {
		this.codigo = codigo;
		this.nombre = "";
		this.categoria = 0;
		this.direccion = "";
		this.provincia = "";
	}
	public Hotel(String codigo, String nombre, int categoria, String direccion, String provincia) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoria = categoria;
		this.direccion = direccion;
		this.provincia = provincia;
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	@Override
	public String toString() {
		return "--------\nHotel:\n"+"Código de hotel: "+this.codigo+
				"\nNombre del hotel: "+this.nombre+
				"\nCategoría: "+this.categoria+
				"\nDirección: "+this.direccion+
				"\nProvincia: "+this.provincia+
				"\n--------";
	}
}
