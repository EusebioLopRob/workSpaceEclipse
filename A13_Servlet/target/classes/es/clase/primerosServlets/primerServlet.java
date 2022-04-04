package es.clase.primerosServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class primerServlet
 */
@WebServlet("/primerServlet")
public class primerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public primerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Especificamos el formato de respuesta a través de getWriter()
		PrintWriter salida=response.getWriter();
		//Generamos la respuesta de la petición
		salida.println("<html lang=\"en\">");
		salida.println("<head>");
		salida.println("<meta charset=\"UTF-8\">");
		salida.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		salida.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		salida.println("<title>Página</title>");
		salida.println("</head>");
		salida.println("<body>");
		salida.println("<h3>Página generada</h3>");
		salida.println("<p style=\"font-size: 70%;\">Eusebio López Robledo</p>");
		salida.println("</body>");
		salida.println("</html>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
