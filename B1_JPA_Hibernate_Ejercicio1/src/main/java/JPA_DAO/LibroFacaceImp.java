package JPA_DAO;


import java.util.List;

import javax.persistence.TypedQuery;

import javax.persistence.Query;

import entidades.Libro;

public class LibroFacaceImp extends AbstractFacadeJPAImp<Libro> implements LibroFacade {

	public LibroFacaceImp() {
		super(Libro.class);
	}

	@Override
	public List<Libro> mostrarTodos() {
		TypedQuery<Libro> query = em.createQuery("SELECT p FROM Libro AS p", Libro.class);
		return query.getResultList();
	}

	@Override
	public Libro buscarPorAutor(String autorBuscar) {
		//ESTO NO FUNCIONA ARREGLAR
		TypedQuery<Libro> query = em.createQuery("SELECT p FROM Libro AS p WHERE p.autor = :autorB", Libro.class);
		
		return query.getSingleResult();
	}

	@Override
	public Object contador() {
		try {
			Query query = em.createQuery("SELECT COUNT(p) FROM Libro AS p");
			Object result = query.getSingleResult();
			return result;
		}catch(Exception e) {
			System.out.println("Error en sentencia jsql");
		}
		return -1;
	}
	
	
		
}
