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
 * Servlet implementation class Controlador_InsertaUsuario
 */
@WebServlet("/Controlador_InsertaUsuario")
public class Controlador_InsertaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/MVC_JSP")
	private DataSource miPool;
	
	private UsuarioDAO usuarioDAO;
	
    public Controlador_InsertaUsuario() {

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
		String nombre=request.getParameter("txtNombre");
		String apellidos=request.getParameter("txtApellidos");
		String usuario=request.getParameter("txtUsuario");
		String contrasena=request.getParameter("txtContrasena");
		String pais=request.getParameter("txtPais");
		String tecnologia=request.getParameter("txtTecnologia");
		
		if(nombre!="" && apellidos!="" && usuario!="" && contrasena!="" && pais!="" && tecnologia!="") {
			Usuario u=new Usuario(nombre, apellidos, usuario, contrasena, pais, tecnologia);
			
			try {
				if(usuarioDAO.create(u)) {
					request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
				}
			} catch(SQLException e) {
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
