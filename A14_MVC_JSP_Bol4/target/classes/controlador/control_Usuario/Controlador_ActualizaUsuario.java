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
 * Servlet implementation class Controlador_ActualizaUsuario
 */
@WebServlet("/Controlador_ActualizaUsuario")
public class Controlador_ActualizaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/MVC_JSP")
	private DataSource miPool;
	
	private UsuarioDAO usuarioDAO;
	
    public Controlador_ActualizaUsuario() {

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
		request.setCharacterEncoding("UTF-8");
		Usuario u = null;
		if(request.getParameter("Consultar")!=null) {
			System.out.println("Boton consultar pulsado");
			//Recibo usuario y contraseña del formulario			
			String usuario=request.getParameter("conUsuario");
			String contrasena=request.getParameter("conContrasena");
			
			//Con el Usuario y contraseña consulto el ID en la base de datos
			Long key=usuarioDAO.getId(usuario, contrasena);
			//Con el ID consulto los datos del usuario
			if(key!=null) {	
				System.out.println("Usuario encontrado");
				//Si no fuese in input tipo number tendríamos que comprobar que la string
				//que nos viene es de verdad un número para que la aplicación no explote
					if(usuarioDAO.read(key)!=null) {
						u = usuarioDAO.read(key);
						System.out.println("Enviamos datos para rellenar formulario de actualización");
						request.setAttribute("datos_usuario", u);
						request.getRequestDispatcher("vistasUsuario/actualizaUsuario.jsp").forward(request, response);
					}else {
						System.out.println("La clave no existe en la base de datos");
						request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
					}
				
			}
			else {
				System.out.println("No ha introducido clave");
				request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);				
			}
		} else if(request.getParameter("Actualizar")!=null){
			System.out.println("Botón Actualizar");
			if(request.getParameter("txtIdUsuario")!=null) {
				Long idUsuarioUpdate=Long.parseLong(request.getParameter("txtIdUsuario"));
				String nombreUpdate=request.getParameter("txtNombre");
				String apellidoUpdate=request.getParameter("txtApellido");
				String usuarioUpdate=request.getParameter("txtUsuario");
				String contrasenaUpdate=request.getParameter("txtContrasena");
				String paisUpdate=request.getParameter("txtPais"); 
				String tecnologiaUpdate=request.getParameter("txtTecnologia"); 
				Usuario uUpdate = new Usuario(idUsuarioUpdate,nombreUpdate,apellidoUpdate,usuarioUpdate,contrasenaUpdate,paisUpdate,tecnologiaUpdate);
				if(usuarioDAO.update(uUpdate)) {
					System.out.println("Usuario actualizado correctamente");
					request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
				}
			}
						
		} else {
			System.out.println("Error de ruta");
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
