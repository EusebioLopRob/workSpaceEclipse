package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import modelo.Reserva;

public class ReservaDAO implements DAO<Reserva> {
	
	//atributos
	
	private static final String SQL_SELECT = 
			"SELECT COD_HOTEL FROM RESERVAS WHERE FECHAENTRADA = ?";
	private static final String SQL_SELECT_ALL = 
			"SELECT * FROM RESERVAS";
	
	private DataSource origenDatos;
	
	

	public ReservaDAO(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}
	
	

	@Override
	public boolean create(Reserva c) throws SQLException {
		return false;
	}
	

	@Override
	public boolean delete(Object key){
		return false;
	}

	@Override
	public boolean update(Reserva c){
		return false;
	}
	

	@Override
	public List<Reserva> readAll(){ 
		PreparedStatement ps=null;												
		ResultSet rs =null;														
		Connection con=null;	
		List<Reserva> lisres = new ArrayList<Reserva>();
		Reserva res = null;
		//con es mi conexión
		
		try {
			con=origenDatos.getConnection();
			ps=con.prepareStatement(SQL_SELECT_ALL);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				res= new Reserva(rs.getString(2), rs.getDate(3).toLocalDate());
				lisres.add(res);
			}
			return lisres;
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

	@Override
	public Reserva read(Object key){ 
		PreparedStatement ps=null;												
		ResultSet rs =null;														
		Connection con=null;	
		Reserva res = null;
		//con es mi conexión
		
		try {
			con=origenDatos.getConnection();
			ps=con.prepareStatement(SQL_SELECT);
			
			ps.setDate(1, java.sql.Date.valueOf((LocalDate)key));
			
			rs=ps.executeQuery();
			while(rs.next()) {
				res= new Reserva(rs.getString(1),(LocalDate)key);
			}
			return res;
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
