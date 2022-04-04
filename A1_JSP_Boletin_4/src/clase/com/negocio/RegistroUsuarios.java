package clase.com.negocio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistroUsuarios
 */
@WebServlet("/RegistroUsuarios")
public class RegistroUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter salida =response.getWriter();
			
			salida.println("<html>");
			salida.println("<head>");
			salida.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
			salida.println("<title>Test SERVLET 1</title>");
			salida.println("</head>");
			salida.println("<body>");
			salida.println("<p>Nombre introducido: "+request.getParameter("nombre")+"</p>");
			salida.println("<p>Apellidos introducidos: "+request.getParameter("apellido")+"</p>");
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
