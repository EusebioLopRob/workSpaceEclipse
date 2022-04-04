package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="LIBROS", catalog="ejercicio2", uniqueConstraints= {
		@UniqueConstraint(columnNames="ISBN")
})
public class Libro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Esta es la clave primaria de la clase
	@Id
	@Column(name="ISBN", unique=true, nullable=false)
	private String isbn;
	//Otros atributos
	@Column(name="AUTOR")
	private String autor;
	@Column(name="TITULO")
	private String titulo;
	@Column(name="PRESTADO")
	private byte prestado;
	
	//Constructores
	public Libro() {
	}
	public Libro(String isbn, String autor, String titulo, byte prestado) {
		super();
		this.isbn = isbn;
		this.autor = autor;
		this.titulo = titulo;
		this.prestado = prestado;
	}
	
	//Getters y Setters
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public byte getPrestado() {
		return prestado;
	}
	public void setPrestado(byte prestado) {
		this.prestado = prestado;
	}
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", autor=" + autor + ", titulo=" + titulo + ", prestado=" + prestado + "]";
	}	
}