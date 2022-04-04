package clase.com.negocio;

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
		String productos[]= {"Destornillador","Serrucho","Tornillo","Taladro"};
		
		//hereda de la interface ServletRequest
		//almacena un atributo en el request. Se usa junto a RequesteDispatcher
		//almacenamos en request la informacion que viene de la BD (en este caso es invent)
		request.setAttribute("lista_productos", productos);
		
		//comunicamos con el JSP (esto es la vista en este caso)
		RequestDispatcher miDispatcher=request.getRequestDispatcher("/VistaJSP.jsp");
		
		//enviamos la ind al jsp
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
