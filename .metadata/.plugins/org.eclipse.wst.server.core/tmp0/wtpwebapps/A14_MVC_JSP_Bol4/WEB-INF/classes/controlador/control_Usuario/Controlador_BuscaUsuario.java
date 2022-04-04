package controlador.control_Usuario;

import java.io.IOException;
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
@WebServlet("/Controlador_BuscaUsuario")
public class Controlador_BuscaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/MVC_JSP")
	private DataSource miPool;
	
	private UsuarioDAO usuarioDAO;
	
    public Controlador_BuscaUsuario() {

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
			//Si no fuese in input tipo number tendríamos que comprobar que la string
			//que nos viene es de verdad un número para que la aplicación no explote
				if(usuarioDAO.read(key)!=null) {
					Usuario u = usuarioDAO.read(key);
					ArrayList<String> usuario = new ArrayList<String>();
					usuario.add(u.getId_usuario().toString());
					usuario.add(u.getNombre());
					usuario.add(u.getApellidos());
					usuario.add(u.getUsuario());
					usuario.add(u.getContrasena());
					usuario.add(u.getPais());
					usuario.add(u.getTecnologia());
					request.setAttribute("datos_usuario", usuario);
					request.getRequestDispatcher("vistasUsuario/datosUsuario.jsp").forward(request, response);
				}else {
					System.out.println("La clave no existe en la base de datos");
					request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
				}
			
		}
		else {
			System.out.println("No ha introducido clave");
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);				
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
