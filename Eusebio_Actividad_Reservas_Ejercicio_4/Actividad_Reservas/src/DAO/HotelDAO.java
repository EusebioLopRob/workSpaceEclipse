package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import modelo.Hotel;

public class HotelDAO {
	/**
	 * Clase HotelDAO:
	 * Esta clase contiene la lógica necesaria para tratar con una base de datos MySQL específica.
	 * La base de datos a tratar será reservas
	 * Trataremos con las tablas HOTELES y RESERVAS
	 * Las fechas en base de datos están dadas en Timestamp
	 * El Timestamp de SQL es compatible con el objeto Timestamp de java
	 * Para este ejercicio no necesitamos modelo ni DAO para las RESERVAS
	 */
	
	//ATRIBUTOS
	
	/** String estática
	 * Sentencia SQL para obtener todos los campos de hoteles que cumplan con los siguientes requisitos:
	 * 1) El nombre del hotel o la provincia debe ser igual a una cadena de texto dada
	 * 2) El hotel no puede tener ninguna reserva cuyas fechas de entrada y salida comprendan una fecha dada
	 */
	private static final String SQL_READALL =
			"SELECT * FROM HOTELES hot where hot.COD_HOTEL not in " + 
			"(SELECT r.COD_HOTEL FROM RESERVAS r where ? BETWEEN r.FECHAENTRADA AND r.FECHASALIDA)" + 
			"AND (hot.NOMBRE=? OR hot.PROVINCIA=?);";
	
	/** String estátca
	 * Sentencia SQL simple que obtene los datos de un hotel dado su código
	 */
	private static final String SQL_SEARCH =
			"SELECT * FROM HOTELES WHERE COD_HOTEL=?";
    
	//Origen de datos
	private DataSource origenDatos;
	
	//Constructos de la clase, recibe el origen de datos
	public HotelDAO(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}

	//Método para introducir un nuevo Hotel en la base de datos
	public boolean create(Hotel r) throws SQLException {
		//No se pide
		return false;
	}
	
	public Hotel login() {
		//No se pide
		return null;
	}

	//Método para eliminar un hotel de la base de datos
	public boolean delete(Object key) {
		//No se pide
		return false;
	}

	//Método para actualizar un hotel de la base de datos
	public boolean update(Object c) {
		//No se pide
		return false;
	}

	//Método para obtener un hotel de la base de datos dado su código
	public Hotel read(String key){
		
		/*******DECLARACIONES*******/
		//Declaramos un objeto PreparedStatement que nos servirá para ejecutar sentencias SQL
		PreparedStatement ps = null;
		//Declaramos un objeto ResultSet que nos servirá para recoger el resultado de una consulta SQL
		ResultSet rs = null;
		//Declaramos un objeto Connection que nos servirá para iniciar la conexión con la base de datos
		Connection con= null;
		//Declaramos un objeto Hotel que nos servirá para introducir los datos llegados del ResulSet
		Hotel hot=null;
		/*****************************/
		
		//La operaciones con métodos de la libería java.sql arrojan excepciones de tipo SQLException que deben ser capturadas
		try {
			
			/*******INSTANCIACIONES*******/
			//Instanciamos la conexión desde el origen de datos
			con = origenDatos.getConnection();
			//Premaramos la sentencia desde la conexión pasandole la string y un parámetro para que nos devuelva las keys generadas
			ps = con.prepareStatement(SQL_SEARCH,Statement.RETURN_GENERATED_KEYS);
			//Establecemos el valor del parámetro de la sentencia SQL, el código del hotel en la posición 1 (primer y único interrogante)
			ps.setString(1, key);
			/*****************************/
			
			//Ejecutamos la sentencia SQL
			rs = ps.executeQuery();
			
			//El resultado se obtiene como un iterable, en este caso solo esperamos 1 resultado
			//Para obtener resultados de un ResulSet ejecutámos el método next
			if(rs.next()) {
				//Tras ejecutar el método next se cargarán los datos en el formato de vuelta de la base de datos
				//Para obtener cada resultado ejecutamos los metodos get asociados. Cada resultado aparece en el orden
				//En que SQL devuelve los resultados, empezando por el 1
				//Instanciamos el objeto Hotel con los resultados de la consulta.
			    hot= new Hotel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));	
			}
		//Tratamiento de excepciones
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
		//Devolvemos el hotel encontrado
		return hot;
	}

	
	public List<Hotel> readAll(java.sql.Timestamp fecha, String valor) {
		
		/*******DECLARACIONES*******/
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con= null;
		//Lista de Hoteles para recoger el resultado
		List<Hotel> lista = new ArrayList<>();
		/*****************************/
		
		try {
			/*******INSTANCIACIONES*******/
			con = origenDatos.getConnection();
			ps = con.prepareStatement(SQL_READALL);
			//Establecemos la fecha en el parámetro de la sentencia SQL posición 1
			ps.setTimestamp(1, fecha);
			//Establecemos el valor (Nombre hotel) en el parámetro de la sentencia SQL posición 2
			ps.setNString(2, valor);
			//Establecemos el valor (Nombre provincia) en el parámetro de la sentencia SQL posición 3
			ps.setNString(3, valor);
			/*****************************/
			
			//Ejecutamos la sentencia
			rs = ps.executeQuery();
			
			//En este caso tenemos varios resultados, iteramos el ResuSet y obtenemos los resultados uno a uno
			while(rs.next()) {
				//Añadimos a nuestra lista de hoteles una instancia de Hotel con los datos del ResulSet de cada iteración
				lista.add(new Hotel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6)));	
			}
		//Tratamiento de excepciones	
		}catch (SQLException e1) {
			System.out.println("Se ha producido un error en la sentencia SQL");
			e1.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e2) {
				System.out.println("Se ha producido un error al cerrar la conexión con la base de datos");
				e2.printStackTrace();
			}
		}
		//Devolvemos la lista
		return lista;
	}
}
