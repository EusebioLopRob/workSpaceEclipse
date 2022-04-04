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
 * Servlet implementation class Controlador_LoginUsuario
 */
@WebServlet("/Controlador_LoginUsuario")
public class Controlador_LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/MVC_JSP")
	private DataSource miPool;
	
	private UsuarioDAO usuarioDAO;
	
    public Controlador_LoginUsuario() {

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
		String usuario=request.getParameter("txtUsuario");
		String contrasena=request.getParameter("txtContrasena");

		
		if(usuario!="" && contrasena!="") {			
			try {
				if(usuarioDAO.login(usuario, contrasena)) {
					request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
				}else {
					System.out.println("Usuario o contraseña incorrectos");
					request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
				}
			} catch(SQLException e) {
				System.out.println("SQL exception");
				request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);				
			}
		}
		else {
			System.out.println("Cadenas vacías");
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);				
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
