package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import modelo.Producto;

public class ProductoDAO implements DAO<Producto>{
	
	//ATRIBUTOS:
	
	private static final String SQL_SELECT_ALL = 
			"SELECT * FROM PRODUCTOS";
	
	private static final String SQL_SELECT = 
			"SELECT * FROM PRODUCTOS WHERE CODPROD = ?";
	
	private static final String SQL_INSERT=
			"INSERT INTO PRODUCTOS (codprod, seccion, nombreprod, precio, fecha, importado, paisorigen)"
			+" VALUES(?,?,?,?,?,?,?)";
	
	private static final String SQL_DELETE =
			"DELETE FROM PRODUCTOS WHERE CODPROD = ?";
	
	private static final String SQL_UPDATE=
			"UPDATE PRODUCTOS SET SECCION = ?, NOMBREPROD = ?, PRECIO =?, FECHA = ?, IMPORTADO = ?, PAISORIGEN = ? WHERE CODPROD = ?";
			
	
	private DataSource origenDatos;
	
	

	public ProductoDAO(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}
	
	//METODOS

	@Override
	public boolean create(Producto c) throws SQLException {
		PreparedStatement ps=null;
		Connection con=null;
		//con es mi conexión
		
			try {
				con=origenDatos.getConnection();
				ps=con.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
				
				ps.setString(1, c.getCodprod());
				ps.setString(2, c.getSeccion());
				ps.setString(3, c.getNombreprod());
				ps.setDouble(4, c.getPrecio());
				ps.setDate(5, java.sql.Date.valueOf(c.getFecha()));
				if(c.getImportado().booleanValue()) {
					ps.setInt(6, 1);
				}
				else {
					ps.setInt(6, 0);
				}				
				ps.setString(7, c.getPaisorigen());
				
				if (ps.executeUpdate()>0) {
					return true;				
				}
				
			}finally {
				try {
					ps.close();//No es imprescindible
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		return false;
	}

	@Override
	public boolean delete(Object key) throws SQLException {
		PreparedStatement ps=null;
		Connection con=null;
		//con es mi conexión
		
			try {
				con=origenDatos.getConnection();
				ps=con.prepareStatement(SQL_DELETE,Statement.RETURN_GENERATED_KEYS);				
				ps.setString(1, key.toString());
				
				
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
	public Producto read(Object key) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;												
		ResultSet rs =null;														
		Connection con=null;	
		Producto prod =null;
		//con es mi conexión
		
		try {
			con=origenDatos.getConnection();
			ps=con.prepareStatement(SQL_SELECT);	
			ps.setString(1, key.toString());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				prod = new Producto(rs.getString(1),rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6), rs.getString(7));
				return prod;
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
	public List<Producto> readAll() throws SQLException {
		PreparedStatement ps=null;												
		ResultSet rs =null;														
		Connection con=null;	
		Producto prod =null;
		List<Producto> prodList = new ArrayList<>();		
		
		try {
			con=origenDatos.getConnection();
			ps=con.prepareStatement(SQL_SELECT_ALL);			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				prod = new Producto(rs.getString(1),rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6), rs.getString(7));
				prodList.add(prod);
			}
			return prodList;
			
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
	public boolean update(Producto c) throws SQLException {
		PreparedStatement ps=null;
		Connection con=null;
		//con es mi conexión
		
			try {
				con=origenDatos.getConnection();
				ps=con.prepareStatement(SQL_UPDATE);
				/*private static final String SQL_UPDATE=
				"UPDATE PRODUCTOS SET ( seccion, nombreprod, precio, fecha, importado, paisorigen)" 
				+"VALUES(?,?,?,?,?,?) WHERE CODPROD = ?";*/
				ps.setString(1, c.getSeccion());
				ps.setString(2, c.getNombreprod());
				ps.setDouble(3, c.getPrecio());
				ps.setDate(4, java.sql.Date.valueOf(c.getFecha()));
				if(c.getImportado().booleanValue()) {
					ps.setInt(5, 1);
				}
				else {
					ps.setInt(5, 0);
				}
				ps.setString(6, c.getPaisorigen());
				ps.setString(7, c.getCodprod());
				
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

}
