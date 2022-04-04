package controlador.control_Porducto;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

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
 * Servlet implementation class Controlador_BuscaUsuario
 */
@WebServlet("/Controlador_ProductosSwitch")
public class Controlador_ProductosSwitch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/MVC_JSP")
	private DataSource miPool;

	private ProductoDAO productoDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador_ProductosSwitch() {
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
			productoDAO = new ProductoDAO(miPool);
		} catch (Exception e) {
			throw new ServletException();
		}

		request.setCharacterEncoding("UTF-8");

		// Recojo el input oculto para tener el nombre de la instrucción:

		String comando = request.getParameter("instruccion");

		// si no envía el parámetro, listar productos:
		if (comando == null) {
			comando = "listar";
		}

		// Redirijo el flujo de ejecución del método adecuado:

		switch (comando) {
		case "listar":
			listarProductos(request, response);
			break;

		case "insertar":
			insertarProducto(request, response);
			break;

		case "eliminar":
			eliminarProducto(request, response);
			break;

		case "cargaActualiza":
			cargaActualiza(request, response);
			break;
		case "actualizar":
			actualizarProducto(request, response);
			break;

		default:
			listarProductos(request, response);
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
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

	// MÉTODOS ESPECÍFICOS:

	private void insertarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codProd = request.getParameter("txtCodProd").trim();
		String seccion = request.getParameter("txtSeccion").trim();
		String nombreArt = request.getParameter("txtNombreArticulo").trim();
		String precio = request.getParameter("txtPrecio").trim();
		String fecha = request.getParameter("txtFecha").trim();
		String importado = request.getParameter("txtImportado");
		String pais = request.getParameter("txtPais").trim();

		if (codProd != "" && seccion != "" && nombreArt != "" && precio != "" && fecha != "" && importado != null
				&& pais != "") {
			System.out.println("Entro en if codprod != ''");
			Producto p = null;

			try {
				p = new Producto(codProd, seccion, nombreArt, Double.parseDouble(precio), LocalDate.parse(fecha),
						Boolean.parseBoolean(importado), pais);
				if (productoDAO.create(p)) {
					listarProductos(request, response);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
				request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
			} catch (DateTimeParseException e) {
				System.out.println(e.getMessage());
				request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
			}
		} else {
			System.out.println("cadenas vacías");
			request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
			;
		}

	}

	private void listarProductos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Producto> prodList = new ArrayList<>();
		try {
			prodList = (ArrayList<Producto>) productoDAO.readAll();

			if (prodList != null) {

				request.setAttribute("productos", prodList);

				request.getRequestDispatcher("vistasProducto/mostrarTodos.jsp").forward(request, response);
			} else {
				System.out.println("Error lista");
				request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("Error sql");
			request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);

		}
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String codProd = request.getParameter("hidCodProd");
		System.out.println(codProd);
		try {

			if (productoDAO.delete(codProd)) {

				listarProductos(request, response);
			} else {
				System.out.println("Error eliminar");
				request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("Error sql");
			request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);

		}
	}

	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entro en actualizar");
		request.setCharacterEncoding("UTF-8");
		String codProd = request.getParameter("txtCodProd").trim();
		String seccion = request.getParameter("txtSeccion").trim();
		String nombreArt = request.getParameter("txtNombreArticulo").trim();
		String precio = request.getParameter("txtPrecio").trim();
		String fecha = request.getParameter("txtFecha").trim();
		String importado = request.getParameter("txtImportado");
		String pais = request.getParameter("txtPais").trim();
		System.out.println(codProd);

		if (codProd != "" && seccion != "" && nombreArt != "" && precio != "" && fecha != "" && importado != null
				&& pais != "") {
			System.out.println("Entro en if codprod != ''");
			Producto p = null;

			try {
				p = new Producto(codProd, seccion, nombreArt, Double.parseDouble(precio), LocalDate.parse(fecha),
						Boolean.parseBoolean(importado), pais);
				if (productoDAO.update(p)) {
					listarProductos(request, response);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
				request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
			} catch (DateTimeParseException e) {
				System.out.println(e.getMessage());
				request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
			}
		} else {
			System.out.println("cadenas vacías");
			request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
		}
	}

	private void cargaActualiza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entro en cargaActualiza");
		request.setCharacterEncoding("UTF-8");
		String codProd = request.getParameter("hidCodProd");
		System.out.println(codProd);
		try {
			Producto prod = productoDAO.read(codProd);
			System.out.println("Read no lanza excepcion");
			if (prod != null) {
				System.out.println("Cargo producto en prod");
				request.setAttribute("producto", prod);
				System.out.println("Cargo el dispatcher y reenvio");
				request.getRequestDispatcher("vistasProducto/actualizaProducto.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("Error sql");
			request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);

		}

	}

}
