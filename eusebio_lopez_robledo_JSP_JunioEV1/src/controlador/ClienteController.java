package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.ClienteDAO;
import modelo.Cliente;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/junio22")
	private DataSource miPool;
	
	
	private ClienteDAO clienteDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String instruccion = request.getParameter("instruccion");
		if(instruccion!=null) {
			
		switch (instruccion) {
			case "Login":
				login(request, response);
				break;
				
			case "listar":
				listarClientes(request, response);
				break;
			case "Guardar":
				nuevoCliente(request, response);
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Declaraciones
		boolean sinErrores = true;
		
		//Limpiamos errores
		request.setAttribute("errorNombre", "");
		request.setAttribute("errorContrasena", "");
		request.setAttribute("errorBackend", "");
		
		//Instanciamos clienteDAO
		clienteDAO = new ClienteDAO(miPool);
		
		//Obtenemos los parámetros de la petición
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		
		//Comprobamos que los parámetros vienen llenos
		if(nombre == null || nombre == "") {
			request.setAttribute("errorNombre", "Introduzca un nombre");
			sinErrores = false;
		}
		if(contrasena== null || contrasena=="") {
			request.setAttribute("errorContrasena", "Introduzca una contraseña");
			sinErrores = false;
		}
		
		if(sinErrores) {
			//Obtenemos el cliente
			Cliente cliente = clienteDAO.login(nombre, contrasena);
			if(cliente != null) {
				//Si encontramos el cliente establecemos párámetros de éxito
				request.setAttribute("exito", "Login exitoso");
			}else {
				request.setAttribute("errorBackend", "Datos incorrectos");
			}
		}
		//Declaramos un RequestDispatcher 
		RequestDispatcher miDispatcher = request.getRequestDispatcher("paginas/login.jsp");
				
		//Ejecutamos un forward para pasar a la vista
		miDispatcher.forward(request, response);
	}
	private void listarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Instanciamos clienteDAO
		clienteDAO = new ClienteDAO(miPool);
		
		//Obtenemos la lista de clients llamando al método readall de ClienteDAO
		List<Cliente> clientes = clienteDAO.readall();
		
		//Establecemos el valor del atributo clientes como nuestra lista obtenida
		request.setAttribute("clientes", clientes);
		
		//Declaramos un RequestDispatcher 
		RequestDispatcher miDispatcher = request.getRequestDispatcher("paginas/clientes.jsp");
						
		//Ejecutamos un forward para pasar a la vista
		miDispatcher.forward(request, response);
	}
	private void nuevoCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Instanciamos clienteDAO
		clienteDAO = new ClienteDAO(miPool);
		//Booleano para saber si hay errores de datos del formulario
		boolean sinErrores = true;
		//Clientes para saber si hay duplicados
		Cliente duplicadoCodigo = null;
		Cliente duplicadoNombre = null;
		
		//Obtenemos los parámetros de la petición
		String codCliente = request.getParameter("codClienteAdd");
		String nombre = request.getParameter("nombreAdd");
		String contrasena = request.getParameter("contrasenaAdd");
		String direccion = request.getParameter("direccionAdd");
		
		//Comprobamos que los parámetros vienen llenos
		if(codCliente== null || codCliente=="") {
			request.setAttribute("errorCodCliente", "Introduzca un código de cliente");
			sinErrores = false;
		}else {
			//Comprobamos duplicados
			duplicadoCodigo = clienteDAO.read(codCliente);
		}
		if(nombre == null || nombre == "") {
			request.setAttribute("errorNombre", "Introduzca un nombre");
			sinErrores = false;
		}else {
			//Comprobamos duplicados
			duplicadoNombre = clienteDAO.readbyName(nombre);
		}
		if(contrasena== null || contrasena=="") {
			request.setAttribute("errorContrasena", "Introduzca una contraseña");
			sinErrores = false;
		}
		if(direccion== null || direccion=="") {
			request.setAttribute("errorDireccion", "Introduzca una dirección");
			sinErrores = false;
		}
		
		//Si existen duplicados mandamos respuesta del back, NO ESPECÍFICA.
		if(duplicadoCodigo!=null || duplicadoNombre!=null) {
			request.setAttribute("errorBackend", "El cliente ya existe");
			sinErrores = false;
		}
		
		//Si no hay errores procedemos a la inserción
		if(sinErrores) {
			//Creamos la instancia de Cliente
			Cliente clienteNuevo = new Cliente(codCliente,nombre,contrasena,direccion);
			//Guardamos el cliente en la base de datos
			clienteDAO.create(clienteNuevo);
			//Listamos los clientes otra vez
			listarClientes(request, response);
		}else {
			//Declaramos un RequestDispatcher 
			RequestDispatcher miDispatcher = request.getRequestDispatcher("paginas/error.jsp");
							
			//Ejecutamos un forward para pasar a la vista
			miDispatcher.forward(request, response);
		}
	}
}
