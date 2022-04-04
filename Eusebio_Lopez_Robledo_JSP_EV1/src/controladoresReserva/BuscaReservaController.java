package controladoresReserva;

import java.io.IOException;
//import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
//import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.HotelDAO;
import DAO.ReservaDAO;

import modelo.*;


/**
 * Servlet implementation class BuscaReservaController
 */
@WebServlet("/BuscaReservaController")
public class BuscaReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/Reservas")
	private DataSource miPool;

	private ReservaDAO reservaDAO;
	private HotelDAO hotelDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscaReservaController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			reservaDAO = new ReservaDAO(miPool);
			hotelDAO = new HotelDAO(miPool);
		} catch (Exception e) {
			throw new ServletException();
		}

		request.setCharacterEncoding("UTF-8");

		// Recojo el nombre de la instrucción:

		String comando = request.getParameter("instruccion");

		// si no envía el parámetro, listar productos:
		if (comando == null) {
			comando = "buscar";
		}

		// Redirijo el flujo de ejecución del método adecuado:

		switch (comando) {
		case "buscar":
			buscarHoteles(request, response);
			break;

		case "ver":
			//verHotel(request, response);
			break;
			
		default:
			buscarHoteles(request, response);
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// MÉTODOS ESPECÍFICOS:

	private void buscarHoteles(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String claveHotel = request.getParameter("claveNomDes").trim();
		String fechaentrada = request.getParameter("fechaEntrada").trim();
		LocalDate fechaEntradaLocalDate = LocalDate.parse(fechaentrada);
			try {
				String codigos = "(";
				List<Reserva> reservas = reservaDAO.readAll();
				for(Reserva res:reservas) {
					if(fechaEntradaLocalDate == res.getFechaEntrada()) {
						codigos+="'"+res.getCodHotel()+"',";
					}
				}
				codigos+="'')";
				List<Hotel> hotelesList = hotelDAO.buscarPorClave(claveHotel,codigos);
				request.setAttribute("hoteles", hotelesList);
				request.getRequestDispatcher("buscaReserva/error.jsp").forward(request, response);
			}catch (DateTimeParseException e) {
				System.out.println(e.getMessage());
				request.setAttribute("error", "fechaNoValida");
				request.getRequestDispatcher("buscaReserva/error.jsp").forward(request, response);
			}catch (Exception e) {
				System.out.println(e.getMessage());
				request.setAttribute("error", "errorDesconocido");
				request.getRequestDispatcher("buscaReserva/error.jsp").forward(request, response);
			}

	}

}
