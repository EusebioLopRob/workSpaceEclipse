package controlador.control_Usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.UsuarioDAO;
import modelo.Usuario;

/**
 * Servlet implementation class Controlador_BuscaUsuario
 */
@WebServlet("/Controlador_BuscaUsuariosTodos")
public class Controlador_BuscaUsuariosTodos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/MVC_JSP")
	private DataSource miPool;

	private UsuarioDAO usuarioDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador_BuscaUsuariosTodos() {
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
		
		// busco todos los ID

				request.setCharacterEncoding("UTF-8");

				ArrayList<Usuario> userList = new ArrayList<>(); 
				try {					
					userList=(ArrayList<Usuario>) usuarioDAO.readAll();
					
					if (userList != null) {						

						
						request.setAttribute("usuarios", userList);
						
						request.getRequestDispatcher("vistasUsuario/mostrarTodos.jsp").forward(request, response);
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
