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
import modelo.Hotel;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/BuscaReservaController")
public class BuscaReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/reservas")
	private DataSource miPool;
	
	private HotelDAO HotelDAO;
	
    public BuscaReservaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String instruccion = request.getParameter("instruccion");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void BuscarHoteles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HotelDAO = new HotelDAO(miPool);
		String ErrorNombre="";
		String ErrorFecha="";
		Timestamp fecha = null;
		String fechaCadena = request.getParameter("fecha");
		String valor = request.getParameter("nombre");
		
		if(valor.isEmpty()) {
			ErrorNombre= "* Elija Destino";
		}
		if(fechaCadena.isEmpty()) {
			ErrorFecha="* Rellene Fecha";
		}else {
			System.out.println(fechaCadena);
			LocalDateTime fechaActual = LocalDateTime.now();
			LocalDateTime fechaLocal = LocalDate.parse(fechaCadena).atStartOfDay();
			if(fechaLocal.isBefore(fechaActual)) {
				ErrorFecha="* La fecha no puede ser anterior a la actual";
			}else {
				fecha = Timestamp.valueOf(fechaLocal);
			}
		}
		if(ErrorFecha!="" || ErrorNombre!="") {
			request.setAttribute("ErrorFecha", ErrorFecha);
			request.setAttribute("ErrorNombre", ErrorNombre);
			System.out.println("Vacio");
		}else {
		List<Hotel> lista = HotelDAO.readAll(fecha, valor);
		System.out.println("lista");
		for(Hotel h: lista) {
			System.out.println(h);
		}
		request.setAttribute("hoteles", lista);
		}
		
		RequestDispatcher miDispatcher= request.getRequestDispatcher("paginas/buscaReserva.jsp");
		
		miDispatcher.forward(request, response);
	}
	
	private void DatosHotel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HotelDAO=new HotelDAO(miPool);
		String cod_hotel = request.getParameter("cod_hotel");
		Hotel hot= HotelDAO.read(cod_hotel);
		request.setAttribute("hotel", hot);
		
		RequestDispatcher miDispatcher= request.getRequestDispatcher("paginas/ver.jsp");
		
		miDispatcher.forward(request, response);
		
	}
	

}
