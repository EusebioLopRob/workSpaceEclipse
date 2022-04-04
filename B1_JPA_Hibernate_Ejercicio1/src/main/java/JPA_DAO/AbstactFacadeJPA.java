package JPA_DAO;

import javax.persistence.EntityManager;

public interface AbstactFacadeJPA<T> {
	public Boolean create(T entity);
	public Boolean update(T entity);
	public void remove(T entity);
	public T find(Object id);
	public EntityManager getEm();
}
