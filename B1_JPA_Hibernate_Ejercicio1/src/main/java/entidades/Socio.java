package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="SOCIOS", catalog="ejercicio2", uniqueConstraints= {
		@UniqueConstraint(columnNames="ID_SOCIO")
})
public class Socio implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Esta es la clave primaria de la clase
	@Id
	@Column(name="ID_SOCIO", unique=true, nullable=false)
	private String idSocio;
	//Otros atributos
	@Column(name="APELLIDOS")
	private String apellidos;
	@Column(name="NOMBRE")
	private String nombre;
	
	
	//Constructores
	public Socio() {
	}
	public Socio(String idSocio, String apellidos, String nombre) {
		super();
		this.idSocio = idSocio;
		this.apellidos = apellidos;
		this.nombre = nombre;	
	}
	
	//Getters y Setters
	public String getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}