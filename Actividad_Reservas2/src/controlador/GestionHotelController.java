package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import DAO.CadenaDAO;
import modelo.Hotel;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/GestionHotelController")
public class GestionHotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/reservas")
	private DataSource miPool;
	
	private HotelDAO HotelDAO;
	private CadenaDAO CadenaDAO;
	
    public GestionHotelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String instruccion = request.getParameter("instruccion");
		System.out.println("instruccion= "+instruccion);
		if(instruccion==null) {
			instruccion = "listar";
		}
			
		switch (instruccion) {
			case "listar":
				listarHoteles(request,response);
				break;
				
			case "anadir":
				anadirHotel(request,response);
				break;
				
			case "insertarHotel":
				insertarHotel(request, response);
				break;
			
			case "eliminarHotel":
				eliminarHotel(request,response);
				break;
		    default:
		    	listarHoteles(request,response);
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void anadirHotel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("anadir", "anadir");
		listarHoteles(request, response);
	}
	
	private void listarHoteles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HotelDAO = new HotelDAO(miPool);
		CadenaDAO = new CadenaDAO(miPool);
		
		List<Hotel> lista = HotelDAO.readAll();
		List<String> listaNombreCadenas = CadenaDAO.readAllNombreCategoria();
		String nombreCadena = "";
		for(Hotel h: lista) {
			nombreCadena =CadenaDAO.read_NOMBRECADENA(h.getCod_cadena());
			h.setNombreCadena(nombreCadena);
		}
		request.setAttribute("hoteles", lista);
		request.setAttribute("nombreCadenas", listaNombreCadenas);
		
		
		RequestDispatcher miDispatcher= request.getRequestDispatcher("paginas/gestionHoteles.jsp");
		
		miDispatcher.forward(request, response);
	}
	
	private void insertarHotel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HotelDAO=new HotelDAO(miPool);
		CadenaDAO = new CadenaDAO(miPool);
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String provincia = request.getParameter("provincia");
		String Codcadena = CadenaDAO.read_CODIGOCADENA(request.getParameter("nombreCadena"));
		String categoriaCad = request.getParameter("categoria");
		System.out.println("Codigo: "+codigo+" Nombre: "+nombre+" direccion: "+direccion+" provincia: "+provincia+" Codcadena: "+Codcadena+" categoriaCad: "+categoriaCad);
		if(codigo.isEmpty() || nombre.isEmpty() || direccion.isEmpty() || provincia.isEmpty() || Codcadena.isEmpty() || categoriaCad.isEmpty()) {
			request.setAttribute("error", "- No puede haber campos vacios");
			listarHoteles(request, response);
		}
		else {
		int categoria = Integer.parseInt(categoriaCad);
		Hotel hot = new Hotel(codigo, nombre, direccion, categoria, Codcadena, provincia);
		try {
			if(HotelDAO.create(hot)) {
				request.setAttribute("exito", "- Hotel insertado correctamente");
			}else {
				request.setAttribute("error", "- Hotel no insertado. El hotel ya existe");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listarHoteles(request, response);
		}
		
	}
	
	private void eliminarHotel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HotelDAO = new HotelDAO(miPool);
		
		String codigohotel = request.getParameter("cod_hotel");
		System.out.println("Codigo eliminar: "+codigohotel);
		if(HotelDAO.delete(codigohotel)) {
			request.setAttribute("exito", "- Hotel eliminado correctamente");
			listarHoteles(request, response);
		}else {
			request.setAttribute("error", "- Error, El hotel no sido eliminado");
			listarHoteles(request, response);
		}
		
	}
	

}
