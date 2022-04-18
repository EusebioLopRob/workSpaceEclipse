package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;

import com.mysql.cj.xdevapi.PreparableStatement;

import modelo.Hotel;

public class CadenaDAO {
	
	private static final String SQL_READALL_NOMBRE_CATEGORIAS =
			"SELECT nombre_cadena FROM CADENAS";
	
	private static final String SQL_READ_NOMBRECADENA =
			"SELECT nombre_cadena FROM CADENAS WHERE COD_CADENA=?";
	
	private static final String SQL_READ_CODIGOCADENA =
			"SELECT COD_CADENA FROM CADENAS WHERE NOMBRE_CADENA=?";
	
    
	private DataSource origenDatos;
	
	
	public CadenaDAO(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}

	
	public boolean create(Hotel r) throws SQLException {
		
		
		return false;
	}
	
	public Hotel login() {
		
	   return null;
	}

	
	public boolean delete(Object key) {
		
		
		return false;
	
	}

	
	public boolean update(Object c) {
		
		return false;
	}

	
	public Hotel read(String key){
	
		return null;
	
}
	
	public String read_NOMBRECADENA(String key){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con= null;
		Hotel hot=null;
		String nombre = "";
		try {
			con = origenDatos.getConnection();
			ps = con.prepareStatement(SQL_READ_NOMBRECADENA,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, key);
			rs = ps.executeQuery();
			if(rs.next()) {
			
			   nombre = rs.getString(1);
			   return nombre;
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}finally{
		
			try {
				con.close();
			} catch (SQLException e) {
				
			}
		}
		
		
		return null;
	
}

	public String read_CODIGOCADENA(String key){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con= null;
		Hotel hot=null;
		String codigo = "";
		try {
			con = origenDatos.getConnection();
			ps = con.prepareStatement(SQL_READ_CODIGOCADENA,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, key);
			rs = ps.executeQuery();
			if(rs.next()) {
			
			   codigo = rs.getString(1);
			   return codigo;
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}finally{
		
			try {
				con.close();
			} catch (SQLException e) {
				
			}
		}
		
		
		return null;
	
}
	
	public List<String> readAll() {
		
		
		return null;
	}
	
	public List<String> readAllNombreCategoria() {
		System.out.print("Metodo readAllNombreCategorias");
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con= null;
		List<String> lista = new ArrayList<>();
		
		try {
			con = origenDatos.getConnection();
			ps = con.prepareStatement(SQL_READALL_NOMBRE_CATEGORIAS);
			
			rs = ps.executeQuery();
			System.out.print("ExecuteQuery="+rs);
			while(rs.next()) {
					lista.add(rs.getString(1));
					
			}
			
		}catch (SQLException e) {
				e.printStackTrace();
			}finally{
		
			try {
				con.close();
			} catch (SQLException e) {
				
			}
		}
		
		return lista;
	}

}
