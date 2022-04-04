package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import modelo.Usuario;

public class UsuarioDAO implements DAO<Usuario> {
	
	//atributos
	private static final String SQL_INSERT=
			"INSERT INTO USUARIOS (nombre, apellidos, usuario, contrasena, pais, tecnologia)"
			+" VALUES(?,?,?,?,?,?)"; //ojo no tiene id pk es autonumerico en la BD y fallaria
	
	private static final String SQL_LOGIN=
			"SELECT * FROM USUARIOS WHERE USUARIO = ? AND CONTRASENA = ?";
	
	private static final String SQL_SELECT = 
			"SELECT * FROM USUARIOS WHERE ID_USUARIO = ?";
	
	private static final String SQL_DELETE =
			"DELETE FROM USUARIOS WHERE ID_USUARIO = ?";
	
	private static final String SQL_SELECT_ALL = 
			"SELECT * FROM USUARIOS";
	
	private static final String SQL_UPDATE=
			"UPDATE USUARIOS SET nombre=?, apellidos=?, usuario=?, contrasena=?, pais=?, tecnologia=? WHERE ID_USUARIO=?";
	
	
	private DataSource origenDatos;
	
	

	public UsuarioDAO(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}
	
	

	@Override
	public boolean create(Usuario c) throws SQLException {
		
		PreparedStatement ps=null;
		ResultSet rs =null;
		Connection con=null;
		//con es mi conexión
		
			try {
				con=origenDatos.getConnection();
				ps=con.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
				
				ps.setString(1, c.getNombre());
				ps.setString(2, c.getApellidos());
				ps.setString(3, c.getUsuario());
				ps.setString(4, c.getContrasena());
				ps.setString(5, c.getPais());
				ps.setString(6, c.getTecnologia());
				
				if (ps.executeUpdate()>0) {
					rs=ps.getGeneratedKeys();//Me devuelve todas las claves en un resulset
					if(rs.next()) {
						c.setId_usuario(rs.getLong(1));
					}
					return true;				
				}
				
			}finally {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		return false;
	}
	
	public Usuario login (String usuario, String contrasena) throws SQLException{//Es booleano en ESTE caso, 
		PreparedStatement ps=null;												//cuando estemos usando session
		ResultSet rs =null;														//necesitaremos devolver ALGO del
		Connection con=null;													//usuario.
		Usuario us = null;
		//con es mi conexión
		
		try {
			con=origenDatos.getConnection();
			ps=con.prepareStatement(SQL_LOGIN);
			
			ps.setNString(1, usuario);
			ps.setNString(2, contrasena);
			
			rs=ps.executeQuery();			
			if(rs.next()) {
				us = new Usuario(rs.getLong(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				return us;				
			}
			
		}finally {
			try {
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}				
		}
	return us;	
		
	}

	@Override
	public boolean delete(Object key) throws SQLException {
		PreparedStatement ps=null;
		Connection con=null;
		//con es mi conexión
		
			try {
				con=origenDatos.getConnection();
				ps=con.prepareStatement(SQL_DELETE,Statement.RETURN_GENERATED_KEYS);				
				ps.setLong(1, Long.parseLong(key.toString()));
				
				
				if (ps.executeUpdate()>0) {					
					return true;		
				}
				
			}finally {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		return false;
	}

	@Override
	public boolean update(Usuario c) throws SQLException {
		PreparedStatement ps=null;
		Connection con=null;
		//con es mi conexión
		
			try {
				con=origenDatos.getConnection();
				ps=con.prepareStatement(SQL_UPDATE);
				
				ps.setString(1, c.getNombre());
				ps.setString(2, c.getApellidos());
				ps.setString(3, c.getUsuario());
				ps.setString(4, c.getContrasena());
				ps.setString(5, c.getPais());
				ps.setString(6, c.getTecnologia());
				ps.setLong(7, c.getId_usuario());
				
				if (ps.executeUpdate()>0) {					
					return true;				
				}
				
			}finally {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		return false;
	}
	

	@Override
	public Usuario read(Object key) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement ps=null;												
		ResultSet rs =null;														
		Connection con=null;	
		Usuario us =null;
		//con es mi conexión
		
		try {
			con=origenDatos.getConnection();
			ps=con.prepareStatement(SQL_SELECT);
			
			ps.setLong(1, Long.parseLong(key.toString()));
			
			rs=ps.executeQuery();
			if(rs.next()) {
				us = new Usuario(rs.getLong(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				return us;
			}
			}catch(NumberFormatException e) {
				e.printStackTrace();
			
			}finally {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}				
			}	 
		return null;
	}

	@Override
	public List<Usuario> readAll() throws SQLException {
		PreparedStatement ps=null;												
		ResultSet rs =null;														
		Connection con=null;	
		Usuario us =null;
		List<Usuario> userList = new ArrayList<>();
		//con es mi conexión
		
		try {
			con=origenDatos.getConnection();
			ps=con.prepareStatement(SQL_SELECT_ALL);			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				us = new Usuario(rs.getLong(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				userList.add(us);
			}
			
			return userList;
			
			}catch(NumberFormatException e) {
				e.printStackTrace();
			
			}finally {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}				
			}	 
		return null;
	}	
}
