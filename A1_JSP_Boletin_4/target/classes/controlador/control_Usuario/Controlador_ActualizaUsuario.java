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
 * Servlet implementation class Controlador_ActualizaUsuario
 */
@WebServlet("/Controlador_ActualizaUsuario")
public class Controlador_ActualizaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/MVC_JSP")
	private DataSource miPool;

	private UsuarioDAO usuarioDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador_ActualizaUsuario() {
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
		
		if (request.getParameter("botonBusca") != null) {//Primera condición para elegir botón
			String usuario = request.getParameter("usUsuario");
			String contrasena = request.getParameter("usContrasena");
			Usuario us = null;

			if (usuario != "" && contrasena != "") {

				try {
					us=usuarioDAO.login(usuario, contrasena);
					if (us != null) {
						request.setAttribute("usuario", us);
						//aquí devolver los parámetros a la vistaActualiza con un indicador de login ok
						request.getRequestDispatcher("vistasUsuario/actualizaUsuario.jsp").forward(request, response);
					
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
			
		} else if (request.getParameter("botonActualiza") != null) {//Segunda condición para elegir botón
			String idUsuario = request.getParameter("txtidUsuario");
			String nombre = request.getParameter("txtNombre");
			String apellidos = request.getParameter("txtApellidos");
			String usuario = request.getParameter("txtUsuario");
			String contrasena = request.getParameter("txtContrasena");
			String pais = request.getParameter("txtPais");
			String tecnologia = request.getParameter("txtTecnologia");
			Usuario us =null;
			System.out.println(idUsuario);
			System.out.println(nombre);
			if (idUsuario != "" && nombre != "" && apellidos != "" && usuario != "" && contrasena != "") {
				try {
					us = new Usuario(Long.parseLong(idUsuario),nombre,apellidos,usuario,contrasena,pais,tecnologia);
					if(usuarioDAO.update(us)) {
						System.out.println("update exitoso");
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
