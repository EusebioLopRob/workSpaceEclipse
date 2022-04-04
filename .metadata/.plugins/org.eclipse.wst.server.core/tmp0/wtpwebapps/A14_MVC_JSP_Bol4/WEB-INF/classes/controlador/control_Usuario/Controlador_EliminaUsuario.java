package controlador.control_Usuario;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import DAO.UsuarioDAO;

/**
 * Servlet implementation class Controlador_EliminaUsuario
 */
@WebServlet("/Controlador_EliminaUsuario")
public class Controlador_EliminaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/MVC_JSP")
	private DataSource miPool;
	
	private UsuarioDAO usuarioDAO;
	
    public Controlador_EliminaUsuario() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			usuarioDAO=new UsuarioDAO(miPool);
		} catch (Exception e) {
			throw new ServletException();
		}
		
		//Recibo los parámetros del formulario
		request.setCharacterEncoding("UTF-8");
		String key=request.getParameter("txtIdUsuario");
		
		if(key!="") {				
				if(usuarioDAO.delete(key)) {
					request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
				}else {
					System.out.println("La clave no existe en la base de datos");
					request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
				}
			
		} else {
			System.out.println("No ha introducido clave");
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);				
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
