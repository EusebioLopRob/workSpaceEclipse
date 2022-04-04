package DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T>{
	//Se usa esta interface genérica para que todos los programadores empleen los mismo nombre de méotodos
	//declaro lo smétodos que se van a usar para acceder a la bnased de datos 
	//CRUD create-red-update-delete

	
	//Inserta un nuevo registro c de tipo genético T
	public boolean create(T c) throws SQLException;
	
	//Borra un registro por su clave
	public boolean delete(Object key);
	
	//modifica un registro a c
	public boolean update(T c);
	
	//obtiene un registro por su clave
	public T read(Object key);
	
	//obtiene todos los registros
	public List<T> readAll();

}
