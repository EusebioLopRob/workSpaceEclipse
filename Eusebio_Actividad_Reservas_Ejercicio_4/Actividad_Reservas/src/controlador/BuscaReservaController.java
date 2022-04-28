package controlador;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import DAO.HotelDAO;
import modelo.Hotel;

//Con la anotación @WebSetvlet estamos indicando que esta clase es un controlador servlet
//Al hacer que herede de HttpServlet este obtiene todos los métodos y funcionalidades de un servlet
@WebServlet("/BuscaReservaController")
public class BuscaReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Origen de los datos: base de datos reservas de MySQL se indica con la anotación @Resource
	@Resource(name="jdbc/reservas")
	private DataSource miPool;
	
	//Declaramos un objeto de la clase HotelDAO para acceder a los métodos de obtención de datos
	private HotelDAO hotelDAO;
	
	//Constructor del controlador
    public BuscaReservaController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*	Este controlador se encarga de ejecutar dos tareas
		 * 	Para saber qué tarea tenemos que ejecutar leeremos un
		 * 	parámetro que hemos establecido desde la vista llamado "instruccion"
		 * 	Si instruccion tiene el valor "Buscar" ejecutaremos el método BuscarHoteles
		 * 	Si instruccion tiene el valor de "VermasDatos" ejecutaremos el método DatosHotel
		*/
		
		//Obtenemos el parámetro instruccion de la petición utilizando el método getParameter
		String instruccion = request.getParameter("instruccion");
		
		//Ejecutamos los métodos adecuados según el valor de instruccion en caso de que este exista
		if(instruccion!=null) {
			switch (instruccion) {
				case "Buscar":
					BuscarHoteles(request, response);
					break;
				case "VermasDatos":
					DatosHotel(request, response);
					break;		
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//El método doPost llama al método doGet
		doGet(request, response);
	}
	
	private void BuscarHoteles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		/*
		 * Este método se encarga de realizar la búsqueda de los hoteles.
		 * Para ello obtendremos los parámetros de búsqueda de la petición
		 * Si los parámetros son erroneos enviaremos de vuelta cadenas de texto de error que se visualizarán en los input indicados
		 * Si los parámetros son válidos realizaremos la búsqueda llamando a los métodos del DAO y devolveremos los resultados
		 */
		
		//Instanciamos hotelDAO pasándole el origen de datos
		hotelDAO = new HotelDAO(miPool);
		
		/******PARÁMETROS INTERNOS******/
		//Declaramos una string para el error del nombre instanciando su valor a cadena vacía
		String ErrorNombre="";
		//Declaramos una string para el error de la fecha instanciando su valor a cadena vacía
		String ErrorFecha="";
		//NOTA: de esta manera conseguimos limpiar los errores cada vez que se ejecute el controlador
		
		//Declaramos un obteto Timestamp para parsear la fecha introducida por el usuario
		Timestamp fecha = null;
		
		/******PARÁMETROS EXTERNOS******/
		//Parámetro fecha asignado a variable fechaCadena que contiene la fecha en formato string a partir de la cual el usuario desea buscar hotel
		String fechaCadena = request.getParameter("fecha");
		//Parámetro nombre asignado a variable valor que contiene el nombre de la provincia donde el usuario desea buscar hotel
		String valor = request.getParameter("nombre");
		
		//Si no recibimos nombre, mostramos error
		if(valor.isEmpty()) {
			ErrorNombre= "* Elija Destino";
		}
		//Si no recibimos fecha, mostrammos error
		if(fechaCadena.isEmpty()) {
			ErrorFecha="* Rellene Fecha";
		}else {
			//Si recibimos la fecha
			//System.out.println(fechaCadena);
			
			//Declaramos un objeto LocalDateTime con la fecha actual
			LocalDateTime fechaActual = LocalDateTime.now();
			
			//Declaramos un objeto LocalDateTime con la fecha introducida por el usuario 
			//El método parse transforma una fecha tipo string en formato "DD/MM/AAAA" en un objeto LocalDateTime
			//El método atStartOfDay lo que hace es poner las horas, minutos, y segundos a las 0:00:00
			LocalDateTime fechaLocal = LocalDate.parse(fechaCadena).atStartOfDay();
			
			//Comparamos la fecha introducida por el usuario con la fecha actual
			if(fechaLocal.isBefore(fechaActual)) {
				//Si la fecha introducida es anterior a la actual no se puede realizar la reserva, mostramos mensaje de error
				ErrorFecha="* La fecha no puede ser anterior a la actual";
			}else {
				//En otro caso instanciamos nuestra variable fecha con el Timestamp de la fecha actual
				//Para ello utilizamos el método valueOf que acepta un LocalDateTime para transformarlo en Timestamp
				fecha = Timestamp.valueOf(fechaLocal);
			}
		}
		
		//Si los errores no estan vacíos quiere decir que nos ha llegado un dato incorrecto
		if(ErrorFecha!="" || ErrorNombre!="") {
			//Establecemos dos parámetros ErrorFecha y ErrorNombre, con el valor de la string de los errores
			request.setAttribute("ErrorFecha", ErrorFecha);
			request.setAttribute("ErrorNombre", ErrorNombre);
			//System.out.println("Vacio");
		}else {
			//En caso de que no haya errores obtenemos la lista de objetos Hotel 
			//Para ello ejecutamos el método readAll con los parámetros fecha y valor
			List<Hotel> lista = hotelDAO.readAll(fecha, valor);
			//System.out.println("lista");
			
			/*
			for(Hotel h: lista) {
				System.out.println(h);
			}
			*/
			
			//Establecemos el parámetro hoteles que contiene la lista de hoteles obtenida
			request.setAttribute("hoteles", lista);
		}
		
		//Declaramos un RequestDispatcher al que le asignamos el requestDispatcher de la petición con parámetro la ruta de la vista
		RequestDispatcher miDispatcher = request.getRequestDispatcher("paginas/buscaReserva.jsp");
		//Ejecutamos un forward para pasar a la vista
		miDispatcher.forward(request, response);
	}
	
	private void DatosHotel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		/**
		 * Este método se encanga de obtener un objero Hotel con los datos de la base de datos
		 * Para ello le pasamos un código de hotel por los parámetros de la petición
		 * Este método sólo se ejecuta con valores correctos por lo que no es necesario comprobar el parámetro
		 */
		
		//Instanciamos hotelDAO pasándole el origen de datos
		hotelDAO=new HotelDAO(miPool);
		
		//Obtenemos el código de hotel de los parámetros de la petición
		String cod_hotel = request.getParameter("cod_hotel");
		
		//Obtenemos el objeto Hotel ejecutando el método read de hotelDAO
		Hotel hot = hotelDAO.read(cod_hotel);
		
		//Establecemos un parámetro hotel en el que metemos el resultado de la búsqueda
		request.setAttribute("hotel", hot);
		
		//Declaramos un RequestDispatcher al que le asignamos el requestDispatcher de la petición con parámetro la ruta de la vista
		RequestDispatcher miDispatcher= request.getRequestDispatcher("paginas/ver.jsp");
		//Ejecutamos un forward para pasar a la vista
		miDispatcher.forward(request, response);
	}
}
