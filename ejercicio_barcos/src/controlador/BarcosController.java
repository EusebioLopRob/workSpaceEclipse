package controlador;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;


import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.BarcoDAO;
import DAO.ClaseDAO;
import DAO.TipoDAO;
import modelo.Barco;
import modelo.Clase;
import modelo.Tipo;

//Con la anotación @WebSetvlet estamos indicando que esta clase es un controlador servlet
//Al hacer que herede de HttpServlet este obtiene todos los métodos y funcionalidades de un servlet
@WebServlet("/BarcosController")
public class BarcosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Origen de los datos: base de datos barcos de MySQL se indica con la anotación @Resource
	@Resource(name="jdbc/barcos")
	private DataSource miPool;
	
	//Declaramos un objeto de la clase BarcoDAO para acceder a los m�todos de obtenci�n de datos
	private BarcoDAO barcoDAO;
	//Declaramos un objeto de la clase TipoDAO para acceder a los m�todos de obtenci�n de datos
	private TipoDAO tipoDAO;
	//Declaramos un objeto de la clase TipoDAO para acceder a los m�todos de obtenci�n de datos
	private ClaseDAO claseDAO;

	//Constructor
	public BarcosController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*	Este controlador se encarga de ejecutar dos tareas
		 * 	Para saber qu� tarea tenemos que ejecutar leeremos un
		 * 	par�metro que hemos establecido desde la vista llamado "instruccion"
		 * 	Si instruccion tiene el valor "BuscarUno" ejecutaremos el m�todo BuscarBarco
		 * 	Si instruccion tiene el valor "BuscarTodos" ejecutaremos el m�todo BuscarTodosBarcos
		 *  Si instruccion tiene el valor "Guardar" ejecutamos el m�todo AnadirBarco
		 *  Si instruccion tiene el valor "eliminarBarco" ejecutamos el m�todo EliminarBarco
		 *  Si instruccion tiene el valor "Guardar Tipo" ejecutamos el m�todo AnadirTipo
		 *  Si instruccion tiene el valor "Guardar Clase" ejecutamos el m�todo AnadirClase
		 *  Si instruccion tiene el valor "Actualizar" ejecutamos el m�todo ActualizarBarco
		*/
		//Obtenemos el par�metro instruccion de la petici�n utilizando el m�todo getParameter
		String instruccion = request.getParameter("instruccion");
				
		//Ejecutamos los m�todos adecuados seg�n el valor de instruccion en caso de que este exista
		if(instruccion!=null) {
			switch (instruccion) {
				case "BuscarUno":
					BuscarBarco(request, response);
					break;
				case "BuscarTodos":
					BuscarTodosBarcos(request, response);
					break;	
				case "Guardar":
					AnadirBarco(request,response);
				case "eliminarBarco":
					EliminarBarco(request,response);
					break;
				case "Guardar Tipo":
					AnadirTipo(request,response);
					break;
				case "Guardar Clase":
					AnadirClase(request,response);
					break;
				case "Actualizar":
					ActualizarBarco(request,response);
					break;
			}
		}else {
			BuscarTodosBarcos(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//El m�todo doPost llama al m�todo doGet
		doGet(request, response);
	}
	private void BuscarBarco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	private void BuscarTodosBarcos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//Instanciamos barcoDAO pas�ndole el origen de datos
		barcoDAO = new BarcoDAO(miPool);
		//Instanciamos tipoDAO pas�ndole el origen de datos
		tipoDAO = new TipoDAO(miPool);
		//Instanciamos claseDAO pas�ndole el origen de datos
		claseDAO = new ClaseDAO(miPool);	
		
		//Obtenemos la lista de todos los barcos
		List<Barco> barcos = barcoDAO.readAll();
		
		//Obtenemos la lista de todos los tipos
		List<Tipo> tipos = tipoDAO.readAll();
		
		//Obtenemos la lista de todas las clases
		List<Clase> clases = claseDAO.readAll();
		
		//Establecemos el par�metro barcos que contiene la lista de barcos obtenida
		request.setAttribute("barcos", barcos);
		//Establecemos el par�metro tipos que contiene la lista de tipos obtenida
		request.setAttribute("tipos", tipos);
		//Establecemos el par�metro tipos que contiene la lista de clases obtenida
		request.setAttribute("clases", clases);
		
		//Declaramos un RequestDispatcher al que le asignamos el requestDispatcher de la petici�n con parámetro la ruta de la vista
		RequestDispatcher miDispatcher = request.getRequestDispatcher("paginas/index.jsp");
		
		//Ejecutamos un forward para pasar a la vista
		miDispatcher.forward(request, response);
	}
	private void AnadirBarco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Instanciamos barcoDAO pas�ndole el origen de datos
		barcoDAO = new BarcoDAO(miPool);
		
		//Obtenemos los par�metros de la petici�n para instanciar el nuevo barco
		String nombre = request.getParameter("nombre");
		Integer idTipo = Integer.parseInt(request.getParameter("tipo"));
		Integer idClase = Integer.parseInt(request.getParameter("clase"));
		LocalDate fechaBotado = LocalDate.parse(request.getParameter("fechaBotado"));
			
		//Obtenemos los objetos del Tipo y Clase del barco mediante los DAO
		Tipo tipoInsertar = tipoDAO.readOne(idTipo);
		Clase claseInsertar = claseDAO.readOne(idClase);
		
		//Obtenemos la lista de id de barcos ordenada de menos a m�s
		List<Integer> ides = barcoDAO.listaIdBarcos();
		//Declaramos un int para insertar inicialmente a 1
		int idInsertar = 1;
		//Declaramos un boolean para continuar dentro del while o salir
		boolean continuar = true;
		//Declaramos un iterador para iterar por la lista de id
		Iterator<Integer> it = ides.iterator();
		//Mientras que tengamos cosas en la lista o el booleano sea true
		while(it.hasNext() && continuar) {
			//Obtenemos el id de la iteraci�n
			Integer id = it.next();
			//Si los id son distintos
			if(id != idInsertar) {
				//No contimuamos m�s
				continuar = false;
			}else {
				//Aumentamos el contador de id
				idInsertar++;
			}
		}
		//Creamos la instancia de objeto Barco
		Barco barco = new Barco(idInsertar,nombre,fechaBotado,tipoInsertar,claseInsertar);
		//Insertamos el barco
		barcoDAO.create(barco);
		//Volvemos a cargar la lista
		BuscarTodosBarcos(request,response);		
	}
	public void EliminarBarco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Instanciamos barcoDAO pas�ndole el origen de datos
		barcoDAO = new BarcoDAO(miPool);
		//Obtenemos el id del barco a eliminar de los par�metros de la petici�n
		Integer idBarco = Integer.parseInt(request.getParameter("id_barco"));
		//Eliminamos el barco
		barcoDAO.delete(idBarco);
		//Volvemos a cargar la lista
		BuscarTodosBarcos(request,response);
	}
	public void AnadirTipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Instanciamos tipoDAO pas�ndole el origen de datos
		tipoDAO = new TipoDAO(miPool);
		
		//Obtenemos los par�metros de la petici�n para instanciar el nuevo tipo
		String nombreTipo = request.getParameter("nombre_tipo");
		
		//Obtenemos la lista de id de tipos ordenada de menos a m�s
		List<Integer> ides = tipoDAO.listaIdTipos();
		//Declaramos un int para insertar inicialmente a 1
		int idInsertar = 1;
		//Declaramos un boolean para continuar dentro del while o salir
		boolean continuar = true;
		//Declaramos un iterador para iterar por la lista de id
		Iterator<Integer> it = ides.iterator();
		//Mientras que tengamos cosas en la lista o el booleano sea true
		while(it.hasNext() && continuar) {
			//Obtenemos el id de la iteraci�n
			Integer id = it.next();
			//Si los id son distintos
			if(id != idInsertar) {
				//No contimuamos m�s
				continuar = false;
			}else {
				//Aumentamos el contador de id
				idInsertar++;
			}
		}
		//Creamos la instancia de objeto Tipo
		Tipo tipo = new Tipo(idInsertar, nombreTipo);
		//Insertamos el tipo
		tipoDAO.create(tipo);
		//Volvemos a cargar la lista
		BuscarTodosBarcos(request,response);
	}
	public void AnadirClase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Instanciamos claseDAO pas�ndole el origen de datos
		claseDAO = new ClaseDAO(miPool);
		//Obtenemos los par�metros de la petici�n para instanciar la nueva clase
		String nombreClase = request.getParameter("nombre_clase");
		
		//Obtenemos la lista de id de tipos ordenada de menos a m�s
		List<Integer> ides = claseDAO.listaIdClases();
		//Declaramos un int para insertar inicialmente a 1
		int idInsertar = 1;
		//Declaramos un boolean para continuar dentro del while o salir
		boolean continuar = true;
		//Declaramos un iterador para iterar por la lista de id
		Iterator<Integer> it = ides.iterator();
		//Mientras que tengamos cosas en la lista o el booleano sea true
		while(it.hasNext() && continuar) {
			//Obtenemos el id de la iteraci�n
			Integer id = it.next();
			//Si los id son distintos
			if(id != idInsertar) {
				//No contimuamos m�s
				continuar = false;
			}else {
				//Aumentamos el contador de id
				idInsertar++;
			}
		}
		//Creamos la instancia de objeto Clase
		Clase clase = new Clase(idInsertar, nombreClase);
		//Insertamos la clase
		claseDAO.create(clase);
		//Volvemos a cargar la lista
		BuscarTodosBarcos(request,response);
	}
	
	public void ActualizarBarco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Instanciamos barcoDAO pas�ndole el origen de datos
		barcoDAO = new BarcoDAO(miPool);
		
		//Obtenemos los par�metros de la petici�n para instanciar el nuevo barco
		Integer id = Integer.parseInt(request.getParameter("id_editar"));
		String nombre = request.getParameter("nombre_editar");
		Integer idTipo = Integer.parseInt(request.getParameter("tipo_editar"));
		Integer idClase = Integer.parseInt(request.getParameter("clase_editar"));
		LocalDate fechaBotado = LocalDate.parse(request.getParameter("fechaBotado_editar"));
			
		//Obtenemos los objetos del Tipo y Clase del barco mediante los DAO
		Tipo tipoInsertar = tipoDAO.readOne(idTipo);
		Clase claseInsertar = claseDAO.readOne(idClase);	
		//Creamos la instancia de objeto Barco
		Barco barco = new Barco(id,nombre,fechaBotado,tipoInsertar,claseInsertar);
		//Actualizamos el barco
		barcoDAO.update(barco);
		BuscarTodosBarcos(request,response);
	}
}









