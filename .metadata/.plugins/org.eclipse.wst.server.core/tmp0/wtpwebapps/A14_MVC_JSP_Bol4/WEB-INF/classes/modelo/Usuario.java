package modelo;

public class Usuario {

	private Long id_usuario;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String contrasena;
	private String pais;
	private String tecnologia;
	
	
	public Usuario() {

	}
	
	public Usuario(String nombre, String apellidos, String usuario, String contrasena, String pais,
			String tecnologia) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.pais = pais;
		this.tecnologia = tecnologia;
	}

	public Usuario(Long id_usuario, String nombre, String apellidos, String usuario, String contrasena, String pais,
			String tecnologia) {
		
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.pais = pais;
		this.tecnologia = tecnologia;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", usuario="
				+ usuario + ", contrasena=" + contrasena + ", pais=" + pais + ", tecnologia=" + tecnologia + "]";
	}
	
	
	
	
	
	
}
