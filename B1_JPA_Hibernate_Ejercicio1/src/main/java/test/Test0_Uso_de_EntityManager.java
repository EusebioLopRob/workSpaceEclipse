package test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Test0_Uso_de_EntityManager {

	public static void main(String[] args) {
		
		//El nombre de la unidad de persistencia no está puesto al azar
		//Es el nombre de la unidad del persistencia del fichero xml
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Persistencia");
		EntityManager emanager = emFactory.createEntityManager();
		
		emanager.close();
		emFactory.close();
	}

}