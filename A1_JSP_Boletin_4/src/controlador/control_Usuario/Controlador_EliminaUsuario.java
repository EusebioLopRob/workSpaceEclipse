package controlador.control_Usuario;

import java.io.IOException;
import java.sql.SQLException;

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
	
	@Resource(name = "jdbc/MVC_JSP")
	private DataSource miPool;

	private UsuarioDAO usuarioDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador_EliminaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			usuarioDAO = new UsuarioDAO(miPool);
		} catch (Exception e) {
			throw new ServletException();
		}
		
		// recibo los parametros del formulario

				request.setCharacterEncoding("UTF-8");

				String idUsuario = request.getParameter("txtIDUsuario");
				try {									
					
					if (usuarioDAO.delete(idUsuario)) {							
						
						request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
					}
					else {
						System.out.println("cadenas vacías");
						request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);					
					}
				} catch (SQLException e) {
					System.out.println("Error sql");
					request.getRequestDispatcher("vistasUsuario/error_login.jsp").forward(request, response);
					
				}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
