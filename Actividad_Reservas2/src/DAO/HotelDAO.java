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

public class HotelDAO {
	
	private static final String SQL_READALL =
			"SELECT * FROM HOTELES";
	
	private static final String SQL_SEARCH =
			"SELECT * FROM HOTELES WHERE COD_HOTEL=?";
	
	private static final String SQL_INSERT =
			"INSERT INTO HOTELES VALUES(?,?,?,?,?,?)";
	
	/*private static final String SQL_DELETE =
			"DELETE res, hot "+
			"from RESERVAS as res "+
			"left join HOTELES as hot on res.COD_HOTEL = hot.COD_HOTEL "+
			"WHERE hot.COD_HOTEL=?";
	*/
	
	private static final String SQL_DELETE_RESERVAS =
			"DELETE FROM RESERVAS res WHERE res.COD_HOTEL=?";
	
	private static final String SQL_DELETE_HOTELES =
			"DELETE FROM HOTELES hot WHERE hot.COD_HOTEL=?";
    
	private DataSource origenDatos;
	
	
	public HotelDAO(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}

	
	public boolean create(Hotel h) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con= null;
		
		try {
			con = origenDatos.getConnection();
			ps = con.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
			
			
			
			
			
			ps.setString(1, h.getCod_hotel());
			ps.setString(2, h.getNombre());
			ps.setString(3, h.getDireccion());
			ps.setInt(4, h.getCategoria());
			ps.setString(5, h.getCod_cadena());
			ps.setString(6, h.getProvincia());
			
			if(ps.executeUpdate()>0) {
				rs = ps.getGeneratedKeys();
				
				return true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
	
		try {
			con.close();
		} catch (SQLException e) {
			
		}
	}
		
		return false;
	}
	
	public Hotel login() {
		
	   return null;
	}

	
	public boolean delete(String key) {
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		Connection con= null;
		boolean borrado=false;
		
		try {
			con = origenDatos.getConnection();
			ps = con.prepareStatement(SQL_DELETE_RESERVAS,Statement.RETURN_GENERATED_KEYS);
			ps1 = con.prepareStatement(SQL_DELETE_HOTELES,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, key);
			ps1.setString(1, key);
		    
			ps.executeUpdate();
			if(ps1.executeUpdate()>0) {
					borrado = true;
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}finally{
		
			try {
				con.close();
			} catch (SQLException e) {
				
			}
		}
		
		return borrado;
	
	
	}

	
	public boolean update(Object c) {
		
		return false;
	}

	
	public Hotel read(String key){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con= null;
		Hotel hot=null;
		try {
			con = origenDatos.getConnection();
			ps = con.prepareStatement(SQL_SEARCH,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, key);
			rs = ps.executeQuery();
			if(rs.next()) {
			
			    hot= new Hotel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
			    
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}finally{
		
			try {
				con.close();
			} catch (SQLException e) {
				
			}
		}
		
		return hot;
	
}

	
	public List<Hotel> readAll() {
		System.out.print("Metodo readAll");
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con= null;
		List<Hotel> lista = new ArrayList<>();
		
		try {
			con = origenDatos.getConnection();
			ps = con.prepareStatement(SQL_READALL);
			
			rs = ps.executeQuery();
			System.out.print("ExecuteQuery="+rs);
			while(rs.next()) {
					lista.add(new Hotel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6)));
					
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
