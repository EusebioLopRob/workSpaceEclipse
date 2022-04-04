package DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T>{
	
	//Se usa esta interface generica para que todos los progrmadores empleen los mismos nombres
	//declaro los metodos que se van a usar para acceder a la base de datos
	//CRUD 
	
	
	//Inserta un nuveo registro c de tipo generico T
	public boolean create(T c) throws SQLException;
	
	//Borra un registro por su clave
	public boolean delete(Object key) throws SQLException;
	
	//Modifica un registro a c
	public boolean update(T c) throws SQLException;
	
	//obtiene un registro por su clave
	public T read(Object key) throws SQLException;
	
	//obtiene todos los registros
	public List<T> readAll() throws SQLException;
 
}
