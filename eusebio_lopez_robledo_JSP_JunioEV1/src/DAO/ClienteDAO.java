package DAO;

import javax.sql.DataSource;

import modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
	private static final String SQL_READALL = "SELECT * FROM CLIENTE";
	private static final String SQL_LOGIN = "SELECT * FROM CLIENTE WHERE NOMBRE=? AND CONTRASENA=?";
	private static final String SQL_READONE = "SELECT * FROM CLIENTE WHERE COD_CLI=?";
	private static final String SQL_INSERT = "INSERT INTO CLIENTE VALUES(?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE CLIENTE SET NOMBRE=?,CONTRASENA=?,DIRECCION=? WHERE COD_CLI=?";
	private static final String SQL_READ_NOMBRE = "SELECT * FROM CLIENTE WHERE NOMBRE=?";

	//Origen de datos
	private DataSource origenDatos;
			
	//Constructos de la clase, recibe el origen de datos
	public ClienteDAO(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}
	
	public Cliente read(String key) {
		/*******DECLARACIONES*******/
		//Declaramos un objeto PreparedStatement 
		PreparedStatement ps = null;
		//Declaramos un objeto ResultSet 
		ResultSet rs = null;
		//Declaramos un objeto Connection 
		Connection con= null;
		//Declaramos un objeto Cliente 
		Cliente cliente=null;
		/*****************************/
		
		try {
			/*******INSTANCIACIONES*******/
			//Instanciamos la conexión desde el origen de datos
			con = origenDatos.getConnection();
			//Premaramos la sentencia desde la conexión 
			ps = con.prepareStatement(SQL_READONE,Statement.RETURN_GENERATED_KEYS);
			//Establecemos el valor del parámetro de la sentencia SQL
			ps.setInt(1, Integer.parseInt(key));
			/*****************************/
			
			//Ejecutamos la sentencia SQL
			rs = ps.executeQuery();
			
			//El resultado se obtiene como un iterable, en este caso solo esperamos 1 resultado
			//Para obtener resultados de un ResulSet ejecutamos el método next
			if(rs.next()) {
				//System.out.println("Cliente obtenido");
			    cliente = new Cliente(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));	
			}
			
		}catch (SQLException e1) {
			System.out.println("Se ha producido un error en la sentencia SQL");
			e1.printStackTrace();
		}finally{
			try {
				con.close();
			}catch (SQLException e2) {
				System.out.println("Se ha producido un error al cerrar la conexi�n con la base de datos");
				e2.printStackTrace();
			}
		}
		//Devolvemos el cliente encontrado
		return cliente;
	}
	public List<Cliente> readall() {
		/*******DECLARACIONES*******/
		//Declaramos un objeto PreparedStatement 
		PreparedStatement ps = null;
		//Declaramos un objeto ResultSet 
		ResultSet rs = null;
		//Declaramos un objeto Connection 
		Connection con= null;
		//Declaramos un objeto Cliente 
		List<Cliente> clientes = new ArrayList<Cliente>();
		/*****************************/
		
		try {
			/*******INSTANCIACIONES*******/
			//Instanciamos la conexión desde el origen de datos
			con = origenDatos.getConnection();
			//Premaramos la sentencia desde la conexión 
			ps = con.prepareStatement(SQL_READALL,Statement.RETURN_GENERATED_KEYS);
			/*****************************/
			
			//Ejecutamos la sentencia SQL
			rs = ps.executeQuery();
			
			//El resultado se obtiene como un iterable, en este caso solo esperamos 1 resultado
			//Para obtener resultados de un ResulSet ejecutamos el método next
			while(rs.next()) {
				//System.out.println("Cliente obtenido");
			    clientes.add(new Cliente(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			
		}catch (SQLException e1) {
			System.out.println("Se ha producido un error en la sentencia SQL");
			e1.printStackTrace();
		}finally{
			try {
				con.close();
			}catch (SQLException e2) {
				System.out.println("Se ha producido un error al cerrar la conexi�n con la base de datos");
				e2.printStackTrace();
			}
		}
		//Devolvemos la lista de clientes
		return clientes;
	}
	public Cliente login(String nombre, String contrasena) {
		/*******DECLARACIONES*******/
		//Declaramos un objeto PreparedStatement 
		PreparedStatement ps = null;
		//Declaramos un objeto ResultSet 
		ResultSet rs = null;
		//Declaramos un objeto Connection 
		Connection con= null;
		//Declaramos un objeto Cliente 
		Cliente cliente=null;
		/*****************************/
		
		try {
			/*******INSTANCIACIONES*******/
			//Instanciamos la conexión desde el origen de datos
			con = origenDatos.getConnection();
			//Premaramos la sentencia desde la conexión 
			ps = con.prepareStatement(SQL_LOGIN,Statement.RETURN_GENERATED_KEYS);
			//Establecemos los valores de los parámetros de la sentencia SQL
			ps.setString(1, nombre);
			ps.setString(2, contrasena);
			/*****************************/
			
			//Ejecutamos la sentencia SQL
			rs = ps.executeQuery();
			
			//El resultado se obtiene como un iterable, en este caso solo esperamos 1 resultado
			//Para obtener resultados de un ResulSet ejecutamos el método next
			if(rs.next()) {
				//System.out.println("Cliente obtenido");
			    cliente = new Cliente(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));	
			}
			
		}catch (SQLException e1) {
			System.out.println("Se ha producido un error en la sentencia SQL");
			e1.printStackTrace();
		}finally{
			try {
				con.close();
			}catch (SQLException e2) {
				System.out.println("Se ha producido un error al cerrar la conexión con la base de datos");
				e2.printStackTrace();
			}
		}
		//Devolvemos el cliente encontrado
		return cliente;
	}
	public boolean create(Cliente cliente) {
		/*******DECLARACIONES*******/
		//Declaramos un objeto PreparedStatement 
		PreparedStatement ps = null;
		//Declaramos un objeto Connection 
		Connection con= null;
		//Declaramos un booleano para devolver el resultado
		boolean insertado = false;
		/*****************************/
		
		try {
			/*******INSTANCIACIONES*******/
			//Instanciamos la conexión desde el origen de datos
			con = origenDatos.getConnection();
			//Premaramos la sentencia desde la conexión 
			ps = con.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
			//Establecemos los valores de los parámetros de la sentencia SQL
			ps.setInt(1, Integer.parseInt(cliente.getCodCliente()));
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getContrasena());
			ps.setString(4, cliente.getDireccion());
			/*****************************/
			
			//Ejecutamos la sentencia SQL
			insertado = ps.executeUpdate()>0;
			
		}catch (SQLException e1) {
			System.out.println("Se ha producido un error en la sentencia SQL");
			e1.printStackTrace();
		}finally{
			try {
				con.close();
			}catch (SQLException e2) {
				System.out.println("Se ha producido un error al cerrar la conexión con la base de datos");
				e2.printStackTrace();
			}
		}
		//Devolvemos el resultado de la operación
		return insertado;
	}
	public Cliente readbyName(String key) {
		/*******DECLARACIONES*******/
		//Declaramos un objeto PreparedStatement 
		PreparedStatement ps = null;
		//Declaramos un objeto ResultSet 
		ResultSet rs = null;
		//Declaramos un objeto Connection 
		Connection con= null;
		//Declaramos un objeto Cliente 
		Cliente cliente=null;
		/*****************************/
		
		try {
			/*******INSTANCIACIONES*******/
			//Instanciamos la conexión desde el origen de datos
			con = origenDatos.getConnection();
			//Premaramos la sentencia desde la conexión 
			ps = con.prepareStatement(SQL_READ_NOMBRE,Statement.RETURN_GENERATED_KEYS);
			//Establecemos el valor del parámetro de la sentencia SQL
			ps.setString(1, key);
			/*****************************/
			
			//Ejecutamos la sentencia SQL
			rs = ps.executeQuery();
			
			//El resultado se obtiene como un iterable, en este caso solo esperamos 1 resultado
			//Para obtener resultados de un ResulSet ejecutamos el método next
			if(rs.next()) {
				//System.out.println("Cliente obtenido");
			    cliente = new Cliente(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));	
			}
			
		}catch (SQLException e1) {
			System.out.println("Se ha producido un error en la sentencia SQL");
			e1.printStackTrace();
		}finally{
			try {
				con.close();
			}catch (SQLException e2) {
				System.out.println("Se ha producido un error al cerrar la conexi�n con la base de datos");
				e2.printStackTrace();
			}
		}
		//Devolvemos el cliente encontrado
		return cliente;
	}
}
