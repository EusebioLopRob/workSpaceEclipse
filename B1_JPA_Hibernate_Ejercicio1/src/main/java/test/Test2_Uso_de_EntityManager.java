package test;


//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

import entidades.Libro;

import java.util.List;

import JPA_DAO.LibroFacaceImp;


public class Test2_Uso_de_EntityManager {

	public static void main(String[] args) {
		
		//El nombre de la unidad de persistencia no está puesto al azar
		//Es el nombre de la unidad del persistencia del fichero xml
		
		//This is no longer necessary when using Facade interfaces
		//EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Persistencia");
		//EntityManager emanager = emFactory.createEntityManager();
		
		//Insertar filas y comprobar si están manejadas
		//Creamos los objetos a insertar en la BBDD
		Libro l1 = new Libro("100", "autor1", "titulo1", (byte)0);
		Libro l2 = new Libro("200", "autor2", "titulo2", (byte)0);
		Libro l3 = new Libro("300", "autor3", "titulo3", (byte)0);
		Libro l4 = new Libro("400", "autor4", "titulo4", (byte)0);
		
		//Con esto creamos entradas en la tabla libros de la base de datos
		LibroFacaceImp lf = new LibroFacaceImp();
		lf.create(l1);
		lf.create(l2);
		lf.create(l3);
		lf.create(l4);
		
		//Buscamos y mostramos todos los libros
		List<Libro> listaLibros = lf.mostrarTodos();
		for(Libro libro:listaLibros) {
			System.out.println(libro);
		}
		
		//Buscamos y mostramos un libro por su autor
		Libro libroBuscadoLibro = lf.buscarPorAutor("autor2");
		System.out.println("Libro buscado");
		System.out.println(libroBuscadoLibro);
	}

}