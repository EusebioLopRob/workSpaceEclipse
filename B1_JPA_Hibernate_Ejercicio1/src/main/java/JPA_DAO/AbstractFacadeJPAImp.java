package JPA_DAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.UtilJPA;

public abstract class AbstractFacadeJPAImp<T> implements AbstactFacadeJPA<T> {
	private Class<T> entityClass;
	protected EntityManager em;
	
	public AbstractFacadeJPAImp(Class<T> entityClass){
		this.entityClass=entityClass;
		em=UtilJPA.getEntityManager();
	}
	
	@Override
	public Boolean create(T entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ha ocurrido un error al GUARDAR, clave duplicada");
			return false;
		}	
	}
	@Override
	public Boolean update(T entity) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {		
			em.merge(entity);
			tx.commit();
			System.out.println(entity+" Actualización exitosa");
			return true;
		}catch (Exception e) {
			tx.rollback();
			System.out.println("Ha ocurrido un error al ACTUALIZAR");
			e.printStackTrace();
			return false;
		}	
	}
	
	@Override
	public void remove(T entity) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(entity));
		tx.commit();
		System.out.println(entity+" Eliminación exitosa");		
	}
	
	@Override
	public T find(Object id) {
		return em.find(entityClass, id);
	}
	@Override
	public EntityManager getEm() {
		return em;
	}
	
}
