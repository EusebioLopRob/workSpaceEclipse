package DAO;
//Imports java.sql
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

//Imports javax.sql
import javax.sql.DataSource;

import java.util.ArrayList;
//Imports java.utils
import java.util.List;
//Imports modelos
import modelo.Producto;
import modelo.Usuario;


public class ProductoDAO implements DAO<Producto>{
	
	//Atributos
	private static final String SQL_SELECT_ALL =
			"SELECT * FROM PRODUCTOS";
	private static final String SQL_INSERT = 
			"INSERT INTO PRODUCTOS (CODPROD,SECCION,NOMBREPROD,PRECIO,FECHA,IMPORTADO,PAISORIGEN) "+
			"VALUES (?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE =
			"UPDATE PRODUCTOS SET SECCION=?, NOMBREPROD=?, PRECIO=?, FECHA=?, IMPORTADO=?, "
			+ "PAISORIGEN=? WHERE CODPROD=?";
	private static final String SQL_DELETE = 
			"DELETE FROM PRODUCTOS WHERE CODPROD=?";
	
	private static final String SQL_SELECT =
			"SELECT * FROM PRODUCTO WHERE CODPROD=?";
	
	private DataSource origenDatos;
	
	//Constructor
	public ProductoDAO(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}

	//Métodos
	@Override
	public boolean create(Producto c) throws SQLException {
		boolean resultado = false;
		System.out.println("Dentro de productoDAO, método create");
		PreparedStatement ps=null;
		Connection con=null;
		//con es mi conexión
		try {
			System.out.println("Iniciando conexión con base de datos...");
			con=origenDatos.getConnection();
			System.out.println("Conexión iniciada");
			ps=con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			System.out.println("Sentencia CRUD preparada");
			//Le paso los valores (Métodos getter de la clase producto)
			ps.setString(1, c.getCodprod());
			ps.setString(2, c.getSeccion());
			ps.setString(3, c.getNombreprod());
			ps.setDouble(4, c.getPrecio());
			ps.setDate(5, Date.valueOf(c.getFecha()));
			ps.setInt(6, c.getImportado()? 1:0);
			ps.setString(7, c.getPaisorigen());
			int res=ps.executeUpdate();
			System.out.println("Insertando datos...");
			if(res>0){
				resultado = true;
			}
			System.out.println("Datos insertados");
		}catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			try {
				con.close();
			} 
			catch(SQLException e){
				throw new SQLException(e);
			}
		}			
		return resultado;
	}

	@Override
	public boolean delete(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Producto c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Producto read(Object key) {
		Producto prod = null;
		System.out.println("Dentro de productoDAO, método read");
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection con=null;
		try {
			System.out.println("Iniciando conexión con base de datos...");
			con=origenDatos.getConnection();
			System.out.println("Conexión iniciada");
			ps=con.prepareStatement(SQL_SELECT, Statement.RETURN_GENERATED_KEYS);
			System.out.println("Sentencia CRUD preparada");
			ps.setString(1, (String)key);
			rs=ps.executeQuery();
			System.out.println("Extrayendo datos...");
			if(rs.next()) {
				LocalDate fecha = rs.getDate(5).toLocalDate();
				boolean importado = rs.getInt(6) == 1? true:false;
				prod = new Producto(rs.getNString(1),rs.getNString(2),rs.getNString(3),rs.getDouble(4),fecha,importado,rs.getNString(7));
				System.out.println("Producto extraído: ");
				System.out.println(prod);
			}
			System.out.println("Datos extraidos");
		}catch(SQLException e) {
			System.out.println("Error al buscar datos de productos");
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} 
			catch(SQLException e){
				
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Producto> readAll() {
		ArrayList<Producto> prods = new ArrayList<>();
		Producto prod = null;
		System.out.println("Dentro de productoDAO, método readAll");
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection con=null;
		//con es mi conexión
		try {
			System.out.println("Iniciando conexión con base de datos...");
			con=origenDatos.getConnection();
			System.out.println("Conexión iniciada");
			ps=con.prepareStatement(SQL_SELECT_ALL, Statement.RETURN_GENERATED_KEYS);
			System.out.println("Sentencia CRUD preparada");
			rs=ps.executeQuery();
			System.out.println("Extrayendo datos...");
			while(rs.next()) {
				LocalDate fecha = rs.getDate(5).toLocalDate();
				boolean importado = rs.getInt(6) == 1? true:false;
				prod = new Producto(rs.getNString(1),rs.getNString(2),rs.getNString(3),rs.getDouble(4),fecha,importado,rs.getNString(7));
				System.out.println("Producto extraído: ");
				System.out.println(prod);
				prods.add(prod);
			}
			System.out.println("Datos extraidos");
		}catch(SQLException e) {
			System.out.println("Error al buscar datos de productos");
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} 
			catch(SQLException e){
				
				e.printStackTrace();
			}
		}		
		return prods;
	}

}
