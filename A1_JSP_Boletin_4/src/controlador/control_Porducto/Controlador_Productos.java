package controlador.control_Porducto;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
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
@WebServlet("/Controlador_Productos")
public class Controlador_Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/MVC_JSP")
	private DataSource miPool;

	private ProductoDAO productoDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador_Productos() {
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

		// Primero compruebo si estamos Insertando o Mostrando:

		if (request.getParameter("btnEnviar") != null) {
			
			String codProd=request.getParameter("txtCodProd");
			String seccion=request.getParameter("txtSeccion");
			String nombreArt=request.getParameter("txtNombreArticulo");
			String precio=request.getParameter("txtPrecio");
			String fecha=request.getParameter("txtFecha");
			String importado=request.getParameter("txtImportado");
			String pais=request.getParameter("txtPais");

			
			 if(codProd!="") {
				 Producto p = new Producto(codProd, seccion, nombreArt, Double.parseDouble(precio), LocalDate.parse(fecha),Boolean.parseBoolean(importado),pais);
				
			 	try {
			 		if(productoDAO.create(p)) {
			 			request.getRequestDispatcher("vistasProducto/exito.jsp").forward(request, response);
			 		}
			 	}catch (SQLException e) {
			 		System.out.println(e.getMessage());
			 		request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);;
			 	}
			 }
			 else {
				 System.out.println("cadenas vacías");
				 request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);;
			 }

		} else {

			ArrayList<Producto> prodList = new ArrayList<>();
			try {
				prodList = (ArrayList<Producto>) productoDAO.readAll();

				if (prodList != null) {

					request.setAttribute("productos", prodList);

					request.getRequestDispatcher("vistasProducto/mostrarTodos.jsp").forward(request, response);
				} else {
					System.out.println("cadenas vacías");
					request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				System.out.println("Error sql");
				request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);

			}
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
