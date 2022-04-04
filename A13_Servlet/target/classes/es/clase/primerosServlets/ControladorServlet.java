package es.clase.primerosServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControladorServlet
 */
@WebServlet("/ControladorServlet")
public class ControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Imagina que hemos conectado a una BD
		String productos[] = {"destornillador", "serrucho", "tornillo", "taladro"};
		
		//hereda de la interface servletRequest
		//almacena un atributo en el request, se usea junto a requestDispather
		//almacenalos en request la info que viene de la BD
		request.setAttribute("lista_productos", productos);
		
		//Comunicamos con el JSP
		RequestDispatcher miDispatcher = request.getRequestDispatcher("/VistaJSP.jsp");
		//enviamos la info al JSP
		miDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
