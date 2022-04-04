package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.sql.Statement;
//import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import modelo.Hotel;

public class HotelDAO implements DAO<Hotel> {
	
	//atributos
	
	private static final String SQL_SELECT = 
			"SELECT * FROM HOTELES WHERE COD_HOTEL = ?";
	private static final String SQL_SELECT_BUSCA = 
			"SELECT * FROM HOTELES WHERE NOMBRE LIKE ? OR PROVINCIA LIKE ? AND COD_HOTEL NOT IN ?";
	
	private DataSource origenDatos;
	
	

	public HotelDAO(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}
	
	

	@Override
	public boolean create(Hotel c) throws SQLException {
		return false;
	}
	

	@Override
	public boolean delete(Object key){
		return false;
	}

	@Override
	public boolean update(Hotel c){
		return false;
	}
	

	@Override
	public List<Hotel> readAll(){  
		return null;
	}

	@Override
	public Hotel read(Object key){ 
		PreparedStatement ps=null;												
		ResultSet rs =null;														
		Connection con=null;	
		Hotel res = null;
		//con es mi conexión
		
		try {
			con=origenDatos.getConnection();
			ps=con.prepareStatement(SQL_SELECT);
			
			ps.setString(1, (String)key);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				res= new Hotel(rs.getString(1), rs.getString(2), rs.getInt(4), rs.getString(3), rs.getString(6));
				return res;
			}
			
			}catch(SQLException e) {
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
	
	public List<Hotel> buscarPorClave(Object key, Object fecha){ 
		PreparedStatement ps=null;												
		ResultSet rs =null;														
		Connection con=null;
		List<Hotel> hoteles = new ArrayList<Hotel>();
		Hotel res = null;
		//con es mi conexión
		
		try {
			con=origenDatos.getConnection();
			ps=con.prepareStatement(SQL_SELECT_BUSCA);
			
			ps.setString(1, (String)key);
			ps.setString(2, (String)key);
			ps.setString(3, (String)key);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				res= new Hotel(rs.getString(1), rs.getString(2), rs.getInt(4), rs.getString(3), rs.getString(6));
				hoteles.add(res);
				return hoteles;
			}
			
			}catch(SQLException e) {
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
