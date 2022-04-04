package JPA_DAO;

import java.util.List;

import entidades.Libro;
public interface LibroFacade extends AbstactFacadeJPA<Libro> {
	public List<Libro> mostrarTodos();
	public Libro buscarPorAutor(String autor);
	public Object contador();
}
