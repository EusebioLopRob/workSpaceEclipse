package clase.com.negocio;

public class Empleado {

	private String nombre;
	private String apellidos;
	private String puesto;
	private Integer salario;
	
	public Empleado(String nombre, String apellidos, String puesto, Integer salario) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.puesto = puesto;
		this.salario = salario;
	}

	public Empleado() {
		super();
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

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}
	
	
	
	
	
}

