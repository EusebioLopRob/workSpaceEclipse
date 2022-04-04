package controlador.control_Producto;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.ProductoDAO;
import modelo.Producto;


/**
 * Servlet implementation class Controlador_TodosProductos
 */
@WebServlet("/Controlador_TodosProductos")
public class Controlador_TodosProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;      
	@Resource(name="jdbc/MVC_JSP")
	private DataSource miPool;
	private ProductoDAO productoDAO;	
    public Controlador_TodosProductos() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controlador Producto");
		try {
			productoDAO=new ProductoDAO(miPool);
		} catch (Exception e) {
			throw new ServletException();
		}
		request.setCharacterEncoding("UTF-8");
		//Lee el parámetro del formulario
		String comando = request.getParameter("instruccion");
		//Si no envía el parámetro, listar productos
		if (comando == null)
			comando = "listar";
		System.out.println("Comando: "+comando);
		//Redirigimos el flujo de ejecución al método adecuado
		switch(comando) {
		case "listar":
			System.out.println("Nos redirigimos a la función listarProductos");
			this.listarProductos(request, response);
			break;
		case "insertar":
			System.out.println("Nos redirigimos a la función insertarProducto");
			this.insertarProducto(request, response);
		case "cargaActualiza":
			System.out.println("Nos redirigimos a la función cargaActualiza");
			this.cargaActualiza(request, response);
		case "eliminar":
			System.out.println("Nos redirigimos a la función eliminarProducto");
			this.eliminarProducto(request, response);
		case "carrito":
			System.out.println("Nos redirigimos a la función addToCart");
			this.addToCart(request, response);
		case "compra":
			System.out.println("Nos redirigimos a la función compra");
			this.compra(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void listarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Listar todos los productos");
		try {
			productoDAO=new ProductoDAO(miPool);
		} catch (Exception e) {
			throw new ServletException();
		}
		System.out.println("Origen de datos enlazado a DAO");
		//No recibo ningún parámetro
		List<Producto> productos = new ArrayList<>();
		System.out.println("Lista de productos declarada");
		productos = productoDAO.readAll();
		System.out.println("Lista de productos instanciada");
		request.setAttribute("datos_productos", productos);
		System.out.println("Lista de productos enviada");
		request.getRequestDispatcher("vistasProducto/todosProductos.jsp").forward(request, response);
		System.out.println("Redireccionado a vista");		
	}
	private void insertarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Insertar un producto");
		Producto prod = null;
		try {
			productoDAO=new ProductoDAO(miPool);
		} catch (Exception e) {
			throw new ServletException();
		}
		System.out.println("Origen de datos enlazado a DAO");
		request.setCharacterEncoding("UTF-8");
		try {
			String codigo = request.getParameter("insCodProd");
			String seccion = request.getParameter("insSeccion");
			String nombre = request.getParameter("insNombre");
			Double precio = Double.parseDouble(request.getParameter("insPrecio"));
			LocalDate fecha = LocalDate.parse(request.getParameter("insFecha"));
			Boolean importado = Boolean.parseBoolean(request.getParameter("insImportado"));
			String paisOrigen = request.getParameter("insPais");
			prod = new Producto(codigo,seccion,nombre,precio,fecha,importado,paisOrigen);
			if(productoDAO.create(prod)) {
				System.out.println("Producto insertado con éxito");
				System.out.println("Nos redirigimos a la función listarProductos");
				this.listarProductos(request, response);
			}
		}catch(NumberFormatException e) {
			System.out.println("El precio no es un número");
			request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
		}catch(DateTimeParseException e) {
			System.out.println("La fecha no tiene el formato adecuado");
			request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
		}catch(SQLException e) {
			System.out.println("Error al insertar producto");
			e.printStackTrace();
			request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
		}catch(ServletException e) {
			System.out.println("Error al listar productos");
			e.printStackTrace();
			request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
		}catch(IOException e) {
			System.out.println("Error al listar productos");
			e.printStackTrace();
			request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
		}		
	}
	private void cargaActualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Actualizar producto");
		try {
			productoDAO=new ProductoDAO(miPool);
		} catch (Exception e) {
			throw new ServletException();
		}
		System.out.println("Origen de datos enlazado a DAO");
		//AÑADIR CÓDIGO AQUÍ
	}
	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Eliminar producto");
		try {
			productoDAO=new ProductoDAO(miPool);
		} catch (Exception e) {
			throw new ServletException();
		}
		System.out.println("Origen de datos enlazado a DAO");
		//AÑADIR CÓDIGO AQUÍ
	}
	private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Eliminar producto");
		try {
			productoDAO=new ProductoDAO(miPool);
		} catch (Exception e) {
			throw new ServletException();
		}
		System.out.println("Origen de datos enlazado a DAO");
		//AÑADIR CÓDIGO AQUÍ
		request.setCharacterEncoding("UTF-8");
		String codigo=request.getParameter("hidCodProd");
		Producto prod = productoDAO.read(codigo);
		request.setAttribute("producto", prod);
		request.getRequestDispatcher("vistasProducto/addCarrito.jsp").forward(request, response);	
	}
	private void compra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Eliminar producto");
		try {
			productoDAO=new ProductoDAO(miPool);
		} catch (Exception e) {
			throw new ServletException();
		}
		System.out.println("Origen de datos enlazado a DAO");
		//AÑADIR CÓDIGO AQUÍ
		request.setCharacterEncoding("UTF-8");
	}
}
