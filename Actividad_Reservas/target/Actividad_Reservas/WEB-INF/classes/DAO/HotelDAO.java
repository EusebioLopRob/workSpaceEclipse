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
			"SELECT * FROM HOTELES hot where hot.COD_HOTEL not in " + 
			"(SELECT r.COD_HOTEL FROM RESERVAS r where ? BETWEEN r.FECHAENTRADA AND r.FECHASALIDA)" + 
			"AND (hot.NOMBRE=? OR hot.PROVINCIA=?);";
	
	private static final String SQL_SEARCH =
			"SELECT * FROM HOTELES WHERE COD_HOTEL=?";
    
	private DataSource origenDatos;
	
	
	public HotelDAO(DataSource origenDatos) {
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

	
	public List<Hotel> readAll(java.sql.Timestamp fecha, String valor) {
		System.out.print("Metodo readAll");
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con= null;
		List<Hotel> lista = new ArrayList<>();
		
		try {
			con = origenDatos.getConnection();
			ps = con.prepareStatement(SQL_READALL);
			ps.setTimestamp(1, fecha);
			ps.setNString(2, valor);
			ps.setNString(3, valor);
			
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
