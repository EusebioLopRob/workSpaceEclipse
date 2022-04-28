package DAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import modelo.Tipo;


public class TipoDAO {
	/**
	 * Clase TipoDAO:
	 * Esta clase contiene la l�gica necesaria para tratar con una base de datos MySQL espec�fica.
	 * La base de datos a tratar será barcos
	 * Trataremos con las tablas barco, clase y tipo
	 * Las fechas en base de datos están dadas en date
	 */
	
	//ATRIBUTOS
	private static final String SQL_READALL = "SELECT * FROM tipo";
	private static final String SQL_READONE = "SELECT * FROM tipo WHERE id_tipo=?";
	private static final String SQL_INSERT = "INSERT INTO tipo VALUES(?,?)";
	private static final String SQL_ID_ORDERED = "SELECT id_tipo FROM tipo ORDER BY id_tipo";
	
	//Origen de datos
	private DataSource origenDatos;
		
	//Constructos de la clase, recibe el origen de datos
	public TipoDAO(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}
	
	public Tipo readOne(int key) {
		/*******DECLARACIONES*******/
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con= null;
		//Tipo para recoger el resultado
		Tipo tipo = null;
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
				//Tras ejecutar el m�todo next se cargar�n los datos en el formato de vuelta de la base de datos
				//Para obtener cada resultado ejecutamos los m�todos get asociados. Cada resultado aparece en el orden
				//En que SQL devuelve los resultados, empezando por el 1
				//Instanciamos el objeto Clase con los resultados de la consulta.
			    tipo = new Tipo(rs.getInt(1),rs.getString(2));	
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
		//Devolvemos el clase encontrado		
		return tipo;
	}
	
	
	public List<Tipo> readAll() {
		/*******DECLARACIONES*******/
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con= null;
		//Lista de barcos para recoger el resultado
		List<Tipo> tipos = new ArrayList<>();
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
				//A�adimos a nuestra lista de tipos una instancia de Tipo con los datos del ResulSet de cada iteraci�n
				tipos.add(new Tipo(rs.getInt(1),rs.getString(2)));	
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
		return tipos;
	}
	public boolean create(Tipo tipo) {
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
			ps.setInt(1, tipo.getIdTipo());
			ps.setString(2, tipo.getNombreTipo());
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
	public List<Integer> listaIdTipos(){
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
}















