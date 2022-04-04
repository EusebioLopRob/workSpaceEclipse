package DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T>{
	//CRUD create-read-update-delete
	//inserta un nuveo registro c de tipo generico T
	public boolean create(T c) throws SQLException;
	//borra un registro por su clave
	public boolean delete(Object key);
	//modifica un registro a c
	public boolean update(T c);
	//obtiene un registro por su clave
	public T read(Object key);
	//obtiene todos los registros
	public List<T> readAll();
}
