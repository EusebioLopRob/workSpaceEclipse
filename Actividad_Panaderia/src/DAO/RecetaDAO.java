package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;

import com.mysql.cj.xdevapi.PreparableStatement;

import modelo.Receta;

public class RecetaDAO {
	
	private static final String SQL_INSERT =
			"INSERT INTO recetas(titulo)"
			+"VALUES (?)";
	
	private static final String SQL_READALL = 
			"SELECT * FROM recetas";
    
	private DataSource origenDatos;
	
	
	public RecetaDAO(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}

	
	public boolean create(Receta r) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con= null;
		
		try {
			con = origenDatos.getConnection();
			ps = con.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, r.getTitulo());
			System.out.println("Titulo receta Dao: "+r.getTitulo());
			if(ps.executeUpdate()>0) {
				
				return true;
			}
			
		}finally{
		
			try {
				con.close();
			} catch (SQLException e) {
				
			}
		}
		
		return false;
	}
	
	public Receta login() {
		
	   return null;
	}

	
	public boolean delete(Object key) {
		
		
		return false;
	
	}

	
	public boolean update(Object c) {
		
		return false;
	}

	
	public Receta read(Object key){
		
		return null;
	
}

	
	public List<Receta> readAll() {
		System.out.print("Metodo readAll");
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con= null;
		List<Receta> lista = new ArrayList<>();
		
		try {
			con = origenDatos.getConnection();
			ps = con.prepareStatement(SQL_READALL);
			
			rs = ps.executeQuery();
			System.out.print("ExecuteQuery="+rs);
			while(rs.next()) {
				    System.out.print("if");
					lista.add(new Receta(rs.getString(1)));
					
				
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
