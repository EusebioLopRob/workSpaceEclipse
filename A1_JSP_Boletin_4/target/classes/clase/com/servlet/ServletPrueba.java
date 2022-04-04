package clase.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletPrueba
 * Permite la conexion a Bd mediante POOL de conexiones 
 * y muestra en formato texto los nombres de la tabla PRODUCTOS
 */
@WebServlet("/ServletPrueba")
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/MVC_JSP")
	private DataSource miPool;
	
    public ServletPrueba() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter salida = response.getWriter();
		response.setContentType("text/plain");
		
		Connection miConexion=null;
		ResultSet mir = null;
		
		try {
			miConexion=miPool.getConnection();
			mir=miConexion.createStatement().executeQuery("SELECT * FROM PRODUCTOS");
			while(mir.next()) {
				salida.println(mir.getString(3));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
