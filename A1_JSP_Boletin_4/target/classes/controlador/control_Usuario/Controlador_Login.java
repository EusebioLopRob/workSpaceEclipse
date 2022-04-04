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
import modelo.Usuario;

/**
 * Servlet implementation class Controlador_Login
 */
@WebServlet("/Controlador_Login")
public class Controlador_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/MVC_JSP")
	private DataSource miPool;

	private UsuarioDAO usuarioDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador_Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			usuarioDAO = new UsuarioDAO(miPool);
		} catch (Exception e) {
			throw new ServletException();
		}

		// recibo los parametros del formulario

		request.setCharacterEncoding("UTF-8");

		String usuario = request.getParameter("txtUsuario");
		String contrasena = request.getParameter("txtContrasena");
		Usuario us = null;

		if (usuario != "" && contrasena != "") {

			try {
				us=usuarioDAO.login(usuario, contrasena);
				if (us != null) {
					request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("vistasUsuario/error_login.jsp").forward(request, response);
				}
		} catch (SQLException e) {
				System.out.println("Error sql");
				request.getRequestDispatcher("vistasUsuario/error_login.jsp").forward(request, response);
				
			}
		}else {
			System.out.println("cadenas vacías");
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);			
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
