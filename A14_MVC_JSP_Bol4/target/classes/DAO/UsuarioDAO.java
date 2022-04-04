package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import modelo.Usuario;

public class UsuarioDAO implements DAO<Usuario>{
	
	//atributos
	private static final String SQL_INSERT = 
			"INSERT INTO USUARIOS (nombre,apellidos,usuario,contrasena,pais,tecnologia)"
			+"VALUES (?,?,?,?,?,?)";
	private static final String SQL_LOGIN = 
			"SELECT USUARIO, CONTRASENA FROM USUARIOS WHERE USUARIO=? AND CONTRASENA=?";
	
	private static final String SQL_SELECT =
			"SELECT * FROM USUARIOS WHERE ID_USUARIO=?";
	
	private static final String SQL_DELETE =
			"DELETE FROM USUARIOS WHERE ID_USUARIO=?";
	
	private static final String SQL_UPDATE = 
			"UPDATE USUARIOS SET NOMBRE=?, APELLIDOS=?, USUARIO=?, CONTRASENA=?, PAIS=?, TECNOLOGIA=? WHERE ID_USUARIO=?";
	
	private static final String SQL_GETID =
			"SELECT ID_USUARIO FROM USUARIOS WHERE USUARIO=? AND CONTRASENA=?";
	
	private DataSource origenDatos;
	
	
	public UsuarioDAO(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}

	@Override
	public boolean create(Usuario c) throws SQLException {
		boolean success = false;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection con=null;
		//con es mi conexión
		
		try {
			con=origenDatos.getConnection();			  
			//RETURN_GENERATED_KEYS Devuelve la clave a la consulta para reutilizarla luego
			ps=con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			
			//Le paso los valores (Métodos gets de la clase usuario)
			ps.setNString(1, c.getNombre());
			ps.setNString(2, c.getApellidos());
			ps.setNString(3, c.getUsuario());
			ps.setNString(4, c.getContrasena());
			ps.setNString(5, c.getPais());
			ps.setNString(6, c.getTecnologia());
			
			if(ps.executeUpdate() >0) {
				//Si lo ha insertado entra en el if
				rs=ps.getGeneratedKeys();
				if(rs.next()) {
					c.setId_usuario(rs.getLong(1));
				}
				success = true;
			}
			
		} finally {
			try {
				con.close();
			} 
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return success;
	}
	public boolean login(String usuario, String contrasena) throws SQLException {
		boolean success = false;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection con=null;
		//con es mi conexión
		
		try {
			con=origenDatos.getConnection();
			ps=con.prepareStatement(SQL_LOGIN, Statement.RETURN_GENERATED_KEYS);
			ps.setNString(1, usuario);
			ps.setNString(2, contrasena);
			rs=ps.executeQuery();
			if(rs.next()) {	
				success = true;
			}
		} finally {
			try {
				con.close();
			} 
			catch(SQLException e){
				
				e.printStackTrace();
			}
		}
		return success;
	}
	
	@Override
	public boolean delete(Object key) {
		boolean success = false;
		PreparedStatement ps=null;
		int resultado = 0;
		Connection con=null;
		//con es mi conexión
		try {
			con=origenDatos.getConnection();
			//RETURN_GENERATED_KEYS Devuelve la clave a la consulta para reutilizarla luego
			ps=con.prepareStatement(SQL_DELETE, Statement.RETURN_GENERATED_KEYS);
			
			//Le paso los valores (Métodos gets de la clase usuario)
			ps.setLong(1, Long.parseLong(key.toString())); 
			resultado=ps.executeUpdate();
			if(resultado != 0) {	
				success = true;
			}
			
		}catch(SQLException e) {
			System.out.println("Error al eliminar datos de usuario");
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} 
			catch(SQLException e){
				
				e.printStackTrace();
			}
		}
		return success;
	}

	@Override
	public boolean update(Usuario c) {
		boolean success=false;
		PreparedStatement ps=null;
		int resultado = 0;
		Connection con=null;
		//con es mi conexión
		try {
			con=origenDatos.getConnection();
			//RETURN_GENERATED_KEYS Devuelve la clave a la consulta para reutilizarla luego
			ps=con.prepareStatement(SQL_UPDATE, Statement.RETURN_GENERATED_KEYS);
			
			//Le paso los valores (Métodos gets de la clase usuario)		
			ps.setNString(1, c.getNombre());
			ps.setNString(2, c.getApellidos());
			ps.setNString(3, c.getUsuario());
			ps.setNString(4, c.getContrasena());
			ps.setNString(5, c.getPais());
			ps.setNString(6, c.getTecnologia());
			ps.setLong(7, c.getId_usuario());
			
			resultado=ps.executeUpdate();
			if(resultado != 0) {	
				success = true;
			}
			
		}catch(SQLException e) {
			System.out.println("Error al actualizar datos de usuario");
			e.printStackTrace();
			
		}finally {
			try {
				con.close();
			} 
			catch(SQLException e){
				
				e.printStackTrace();
			}
		}	
		return success;
	}

	@Override
	public Usuario read(Object key) {
		Usuario us = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection con=null;
		//con es mi conexión
		try {
			con=origenDatos.getConnection();
			//RETURN_GENERATED_KEYS Devuelve la clave a la consulta para reutilizarla luego
			ps=con.prepareStatement(SQL_SELECT, Statement.RETURN_GENERATED_KEYS);
			
			//Le paso los valores (Métodos gets de la clase usuario)
			ps.setLong(1, Long.parseLong(key.toString())); 
			rs=ps.executeQuery();
			if(rs.next()) {	
				us = new Usuario(rs.getLong(1),rs.getNString(2),rs.getNString(3),rs.getNString(4),rs.getNString(5),rs.getNString(6),rs.getNString(7));
			}
			
		}catch(SQLException e) {
			System.out.println("Error al buscar datos de usuario");
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} 
			catch(SQLException e){
				
				e.printStackTrace();
			}
		}
		return us;
	}

	@Override
	public List<Usuario> readAll() {
		return null;
	}
	
	public Long getId(String usuario, String contrasena) {
		Long longo = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection con=null;
		//con es mi conexión
		try {
			con=origenDatos.getConnection();
			//RETURN_GENERATED_KEYS Devuelve la clave a la consulta para reutilizarla luego
			ps=con.prepareStatement(SQL_GETID, Statement.RETURN_GENERATED_KEYS);
			ps.setNString(1, usuario);
			ps.setNString(2, contrasena);
			rs=ps.executeQuery();
			if(rs.next()) {	
				longo = rs.getLong(1);
			}
		}catch(SQLException e) {
			System.out.println("Error al buscar datos de usuario");
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} 
			catch(SQLException e){
				
				e.printStackTrace();
			}
		}
		return longo;
	}
}
