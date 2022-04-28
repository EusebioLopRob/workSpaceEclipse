package DAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import modelo.Barco;
import modelo.Clase;
import modelo.Tipo;


public class BarcoDAO {
	/**
	 * Clase BarcoDAO:
	 * Esta clase contiene la l�gica necesaria para tratar con una base de datos MySQL espec�fica.
	 * La base de datos a tratar ser� barcos
	 * Trataremos con las tablas barco, clase y tipo
	 * Las fechas en base de datos est�n dadas en date
	 */
	
	//ATRIBUTOS
	private static final String SQL_READALL =
			"SELECT b.id_barco, b.nombre, b.id_tipo, b.id_clase, b.fecha_botado, t.nombre_tipo, c.nombre_clase "
			+ "FROM barco b "
			+ "LEFT JOIN tipo t ON b.id_tipo=t.id_tipo "
			+ "LEFT JOIN clase c ON b.id_clase=c.id_clase";

	private static final String SQL_READONE =
			"SELECT b.id_barco, b.nombre, b.id_tipo, b.id_clase, b.fecha_botado, t.nombre_tipo, c.nombre_clase "
			+ "FROM barco b "
			+ "LEFT JOIN tipo t ON b.id_tipo=t.id_tipo "
			+ "LEFT JOIN clase c ON b.id_clase=c.id_clase"
			+ "WHERE b.id_barco=?";
	private static final String SQL_DELETE = "DELETE FROM barco WHERE id_barco=?";
	private static final String SQL_ID_ORDERED = "SELECT id_barco FROM barco ORDER BY id_barco";
	private static final String SQL_INSERT = "INSERT INTO barco VALUES(?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE barco SET id_tipo=?,id_clase=?,fecha_botado=?,nombre=? WHERE id_barco=?";
	
	//Origen de datos
	private DataSource origenDatos;
		
	//Constructos de la clase, recibe el origen de datos
	public BarcoDAO(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}
	
	public Barco read(int key) {
		/*******DECLARACIONES*******/
		//Declaramos un objeto PreparedStatement que nos servir� para ejecutar sentencias SQL
		PreparedStatement ps = null;
		//Declaramos un objeto ResultSet que nos servir� para recoger el resultado de una consulta SQL
		ResultSet rs = null;
		//Declaramos un objeto Connection que nos servir� para iniciar la conexi�n con la base de datos
		Connection con= null;
		//Declaramos un objeto Barco que nos servir� para introducir los datos llegados del ResulSet
		Barco barco=null;
		/*****************************/
		
		//La operaciones con m�todos de la liber�a java.sql arrojan excepciones de tipo SQLException que deben ser capturadas
		try {
			/*******INSTANCIACIONES*******/
			//Instanciamos la conexi�n desde el origen de datos
			con = origenDatos.getConnection();
			//Premaramos la sentencia desde la conexi�n pas�ndole la string y un par�metro para que nos devuelva las keys generadas
			ps = con.prepareStatement(SQL_READONE,Statement.RETURN_GENERATED_KEYS);
			//Establecemos el valor del par�metro de la sentencia SQL, el c�digo del hotel en la posici�n 1 (primer y único interrogante)
			ps.setInt(1, key);
			/*****************************/
			
			//Ejecutamos la sentencia SQL
			rs = ps.executeQuery();
			
			//El resultado se obtiene como un iterable, en este caso solo esperamos 1 resultado
			//Para obtener resultados de un ResulSet ejecutamos el m�todo next
			if(rs.next()) {
				//System.out.println("Barco obtenido");
				//Tras ejecutar el m�todo next se cargar�n los datos en el formato de vuelta de la base de datos
				//Para obtener cada resultado ejecutamos los m�todos get asociados. Cada resultado aparece en el orden
				//En que SQL devuelve los resultados, empezando por el 1
				//Instanciamos el objeto Barco con los resultados de la consulta.
			    barco = new Barco(rs.getInt(1),rs.getString(2),rs.getDate(5).toLocalDate(),new Tipo(rs.getInt(3),rs.getString(6)), new Clase(rs.getInt(4),rs.getString(7)));	
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
		//Devolvemos el barco encontrado
		return barco;
	}
	
	public List<Barco> readAll() {
		/*******DECLARACIONES*******/
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con= null;
		//Lista de barcos para recoger el resultado
		List<Barco> barcos = new ArrayList<>();
		/*****************************/
		
		//La operaciones con métodos de la liber�a java.sql arrojan excepciones de tipo SQLException que deben ser capturadas
		try {
			/*******INSTANCIACIONES*******/
			//Instanciamos la conexi�n desde el origen de datos
			con = origenDatos.getConnection();
			//Premaramos la sentencia desde la conexi�n pas�ndole la string y un par�metro para que nos devuelva las keys generadas
			ps = con.prepareStatement(SQL_READALL,Statement.RETURN_GENERATED_KEYS);
			/*****************************/
			
			//Ejecutamos la sentencia SQL
			rs = ps.executeQuery();
			
			//En este caso tenemos varios resultados, iteramos el ResuSet y obtenemos los resultados uno a uno
			while(rs.next()) {
				//System.out.println("Barco obtenido");
				//A�adimos a nuestra lista de barcos una instancia de Barco con los datos del ResulSet de cada iteraci�n
				barcos.add(new Barco(rs.getInt(1),rs.getString(2),rs.getDate(5).toLocalDate(),new Tipo(rs.getInt(3),rs.getString(6)), new Clase(rs.getInt(4),rs.getString(7))));	
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
		return barcos;
	}
	public boolean delete(int key) {
		/*******DECLARACIONES*******/
		boolean borrado = false;
		//Declaramos un objeto PreparedStatement que nos servir� para ejecutar sentencias SQL
		PreparedStatement ps = null;
		//Declaramos un objeto Connection que nos servir� para iniciar la conexión con la base de datos
		Connection con= null;
		
		//La operaciones con m�todos de la liber�a java.sql arrojan excepciones de tipo SQLException que deben ser capturadas
		try {
			/*******INSTANCIACIONES*******/
			//Instanciamos la conexión desde el origen de datos
			con = origenDatos.getConnection();
			//Premaramos la sentencia desde la conexi�n pas�ndole la string y un par�metro para que nos devuelva las keys generadas
			ps = con.prepareStatement(SQL_DELETE,Statement.RETURN_GENERATED_KEYS);
			//Establecemos el valor del par�metro de la sentencia SQL, el c�digo del hotel en la posición 1 (primer y único interrogante)
			ps.setInt(1, key);
			/*****************************/
			
			//Ejecutamos la sentencia SQL
			//Esta senetencia de tipo DELETE se ejecuta con el m�todo executeUpdate y devuelve el n�mero de registros borrados
			//Si el n�mero de registros borrados es mayor que 0 es que ha borrado un dato
			borrado = ps.executeUpdate()>0;
			
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
		return borrado;
	}
	public List<Integer> listaIdBarcos(){
		/*******DECLARACIONES*******/
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con= null;
		//Lista de Integer para recoger el resultado
		List<Integer> ides = new ArrayList<>();
		/*****************************/
		
		//La operaciones con m�todos de la liber�a java.sql arrojan excepciones de tipo SQLException que deben ser capturadas
		try {
			/*******INSTANCIACIONES*******/
			//Instanciamos la conexi�n desde el origen de datos
			con = origenDatos.getConnection();
			//Premaramos la sentencia desde la conexi�n pas�ndole la string y un par�metro para que nos devuelva las keys generadas
			ps = con.prepareStatement(SQL_ID_ORDERED,Statement.RETURN_GENERATED_KEYS);
			/*****************************/
			
			//Ejecutamos la sentencia SQL
			rs = ps.executeQuery();
			
			//En este caso tenemos varios resultados, iteramos el ResuSet y obtenemos los resultados uno a uno
			while(rs.next()) {
				//A�adimos a nuestra lista de Integer con los datos del ResulSet de cada iteraci�n
				ides.add(rs.getInt(1));	
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
		return ides;
	}
	public boolean create(Barco barco) {
		/*******DECLARACIONES*******/
		//Declaramos un objeto PreparedStatement que nos servir� para ejecutar sentencias SQL
		PreparedStatement ps = null;
		//Declaramos un objeto Connection que nos servir� para iniciar la conexi�n con la base de datos
		Connection con= null;
		//Declaramos un booleano para devolver el resultado de la inserci�n de datos
		boolean insertado = false;
		//La operaciones con m�todos de la liber�a java.sql arrojan excepciones de tipo SQLException que deben ser capturadas
		try {
			/*******INSTANCIACIONES*******/
			//Instanciamos la conexi�n desde el origen de datos
			con = origenDatos.getConnection();
			//Premaramos la sentencia desde la conexi�n pas�ndole la string y un par�metro para que nos devuelva las keys generadas
			ps = con.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
			//Establecemos el valor de los par�metros de la sentencia SQL
			ps.setInt(1, barco.getIdBarco());
			ps.setInt(2, barco.getTipo().getIdTipo());
			ps.setInt(3, barco.getClase().getIdClase());
			ps.setDate(4, Date.valueOf(barco.getFechaBotado()));
			ps.setString(5, barco.getNombre());
			/*****************************/
			
			//Si el m�todo executeUpdate devuelve un n�mero mayor que 0 es que se ha insertado con �xito el registro
			insertado = ps.executeUpdate()>0;
			
			
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
		return insertado;
	}
	public boolean update(Barco barco) {
		/*******DECLARACIONES*******/
		//Declaramos un objeto PreparedStatement que nos servir� para ejecutar sentencias SQL
		PreparedStatement ps = null;
		//Declaramos un objeto Connection que nos servir� para iniciar la conexi�n con la base de datos
		Connection con= null;
		//Declaramos un booleano para devolver el resultado de la inserci�n de datos
		boolean actualizado = false;
		try {
			/*******INSTANCIACIONES*******/
			//Instanciamos la conexi�n desde el origen de datos
			con = origenDatos.getConnection();
			//Premaramos la sentencia desde la conexi�n pas�ndole la string y un par�metro para que nos devuelva las keys generadas
			ps = con.prepareStatement(SQL_UPDATE,Statement.RETURN_GENERATED_KEYS);
			//Establecemos el valor de los par�metros de la sentencia SQL
			ps.setInt(1, barco.getTipo().getIdTipo());
			ps.setInt(2, barco.getClase().getIdClase());
			ps.setDate(3, Date.valueOf(barco.getFechaBotado()));
			ps.setString(4, barco.getNombre());
			ps.setInt(5, barco.getIdBarco());
			/*****************************/
			
			//Si el m�todo executeUpdate devuelve un n�mero mayor que 0 es que se ha actualizado con �xito el registro
			actualizado = ps.executeUpdate()>0;
			
			
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
		
		return actualizado;
	}
}















