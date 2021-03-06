package test;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidades.Libro;


public class Test1_Uso_de_EntityManager {

	public static void main(String[] args) {
		
		//El nombre de la unidad de persistencia no está puesto al azar
		//Es el nombre de la unidad del persistencia del fichero xml
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Persistencia");
		EntityManager emanager = emFactory.createEntityManager();
		
		//Insertar filas y comprobar si están manejadas
		//Creamos los objetos a insertar en la BBDD
		Libro l1 = new Libro("100", "autor1", "titulo1", (byte)0);
		Libro l2 = new Libro("200", "autor2", "titulo2", (byte)0);
		Libro l3 = new Libro("300", "autor3", "titulo3", (byte)0);
		Libro l4 = new Libro("400", "autor4", "titulo4", (byte)0);
		
		//Comenzamos una transacción con esta instrucción
		emanager.getTransaction().begin();
		//Persistimos los objetos en la base de datos 
		emanager.persist(l1);
		emanager.persist(l2);
		emanager.persist(l3);
		emanager.persist(l4);
		//Una vez que hemos persistido un objeto pasa a ser de tipo Managed
		//Los objetos de tipo managed se sincronizan automáticamente con la BBDD
		
		//Antes de realizar el commit vamos a modificar uno de los objetos
		l1.setTitulo("JPA e Hibernate");
		
		//Finalizamos la transacción con un commit en el que confirmamos los cambios
		emanager.getTransaction().commit();
		
		//Comprobamos si uno de los objetos introducidos está o no dentro de 
		//la unidad de persistencia
		boolean gestionado = emanager.contains(l1);
		System.out.println("l1 gestionado: "+gestionado);
		
		//Compruebo creando otra transacción si l1 sigue o no gestionado
		emanager.getTransaction().begin();
		l1.setTitulo("nuevo cambio");
		gestionado = emanager.contains(l1);
		System.out.println("l1 sigue gestionado: "+gestionado);
		//Finalizamos transacción
		emanager.getTransaction().commit();
		
		
		
		//Buscar un libro
		emanager.getTransaction().begin();
		//Utilizo el método find, que busca entradas en la base de datos por su clave
		//Devuelve el objeto POR REFERENCIA, osea, es el mismo objeto 
		//aunque lo llamemos de forma diferente, y por tanto su estado es MANAGED
		Libro libroBuscado = emanager.find(Libro.class, "200");
		System.out.println("libroBuscado: "+libroBuscado.toString());
		//Si modificamos el objeto buscado
		libroBuscado.setTitulo("Cosas de casa");
		System.out.println("libroBuscado: "+libroBuscado.toString());
		//y finalizamos la transacción
		emanager.getTransaction().commit();
		//SE MODIFICA LA BASE DE DATOS, ya que el objeto que hemos modificado
		//es exactamente el mismo que está persistido en la BBDD
		
		
		
		//Realizar una consulta
		TypedQuery<Libro>query = emanager.createQuery("Select e from Libro e",Libro.class);
		List<Libro> list = query.getResultList();
		for(Libro libro:list) {
			System.out.println(libro);
		}
		
		
		//Recuperar el estado de una entidad
		boolean geationaNew = emanager.contains(libroBuscado);
		System.out.println("libroBuscado gestionado: "+geationaNew);
		emanager.getTransaction().begin();
		//Realizamos una modificación de una entidad manejada por la BBDD
		libroBuscado.setTitulo("Hoy es juernes");
		//El refresh es como un ROLLBACK pero solo para un objeto
		emanager.refresh(libroBuscado);
		//Al terminar la transacción el objero no debe tener si título modificado
		System.out.println("libroBuscado: "+libroBuscado.toString());
		emanager.getTransaction().commit();
		
		
		//Insertar una entidad con merge
		emanager.getTransaction().begin();
		Libro l5 = new Libro("500", "autor5", "titulo5", (byte)0);
		emanager.merge(l5);
		emanager.getTransaction().commit();
		
		//Modificar una entidad desvinculada de la bbdd
		emanager.getTransaction().begin();
		emanager.detach(l4);
		l4.setAutor("Juanito");
		list = query.getResultList();
		for(Libro libro:list) {
			System.out.println(libro);
		}
		//Se comprueba que la actualización no se ha persistido en la bbdd
		emanager.getTransaction().commit();
		
		//revinculamos y visualizar
		emanager.getTransaction().begin();
		emanager.merge(l4);
		list = query.getResultList();
		for(Libro libro:list) {
			System.out.println(libro);
		}
		emanager.getTransaction().commit();
		
		emanager.close();
		emFactory.close();
	}

}