package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ALQUILER database table.
 * 
 */
@Entity
@Table(name="ALQUILER")
@NamedQuery(name="Alquiler.findAll", query="SELECT a FROM Alquiler a")
public class Alquiler implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlquilerPK id;

	@Column(name="FECHAFIN")
	private Timestamp fechafin;

	@Lob
	@Column(name="PRECIODIA")
	private String preciodia;

	private int valoracion;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="COD_CLI")
	private Cliente2 cliente;

	//bi-directional many-to-one association to Jardineria
	@ManyToOne
	@JoinColumn(name="COD_PROD")
	private Jardineria jardineria;

	public Alquiler() {
	}

	public AlquilerPK getId() {
		return this.id;
	}

	public void setId(AlquilerPK id) {
		this.id = id;
	}

	public Timestamp getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}

	public String getPreciodia() {
		return this.preciodia;
	}

	public void setPreciodia(String preciodia) {
		this.preciodia = preciodia;
	}

	public int getValoracion() {
		return this.valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public Cliente2 getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente2 cliente) {
		this.cliente = cliente;
	}

	public Jardineria getJardineria() {
		return this.jardineria;
	}

	public void setJardineria(Jardineria jardineria) {
		this.jardineria = jardineria;
	}

}