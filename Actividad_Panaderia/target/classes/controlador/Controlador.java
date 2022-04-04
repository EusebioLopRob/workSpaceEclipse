package controlador;

import java.io.IOException;
import java.sql.SQLException;
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


import DAO.RecetaDAO;
import modelo.Receta;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/recetario")
	private DataSource miPool;
	
	private RecetaDAO RecetaDAO;
	
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String instruccion = request.getParameter("instruccion");
		if(instruccion!=null) {
			
		switch (instruccion) {
			case "Crear":
				mostrarReceta(request, response);
				break;
				
			case "Guardar Receta":
				guardarReceta(request, response);
				//break;
				
			case "verTitulosSesion":
				verTitulosSesion(request, response);
				break;
				
			case "verTitulosBd":
				verTitulosBd(request, response);
				break;
		
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void mostrarReceta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String titulo = request.getParameter("titulo");
		String harina = request.getParameter("harinagramos")+" gramos de "+request.getParameter("harina");
		ArrayList<String> liquidos = new ArrayList<>();
		String[] nombreLiquidos = request.getParameterValues("liquidos");
		if(nombreLiquidos!=null) {
		for(String i: nombreLiquidos) {
			liquidos.add(request.getParameter(i.toLowerCase()+"ml")+" ml de "+i);
		}
		}
		String levadura = request.getParameter("levaduragramos")+" gramos de levadura";
		String azucar = request.getParameter("azucargramos")+" gramos de azucar";
		String sal = request.getParameter("salgramos")+" gramos de sal";
		String preparacion = request.getParameter("preparacion");
		
		Receta recetaNueva = new Receta(titulo,harina,liquidos,levadura,azucar,sal,preparacion);
		ArrayList<String> recetasSesion = (ArrayList<String>)request.getSession().getAttribute("recetasSesion");
		if(recetasSesion==null) {
			recetasSesion = new ArrayList<>();
			recetasSesion.add(recetaNueva.getTitulo());
			request.getSession().setAttribute("recetasSesion", recetasSesion);
		}else {
			recetasSesion.add(recetaNueva.getTitulo());
			request.getSession().setAttribute("recetasSesion", recetasSesion);
		}

		
		
		
		request.getSession().setAttribute("receta", recetaNueva);
		
		RequestDispatcher miDispatcher= request.getRequestDispatcher("paginas/verReceta.jsp");
		
		miDispatcher.forward(request, response);
	}
	
	private void guardarReceta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RecetaDAO=new RecetaDAO(miPool);
		String estado = "";
		Receta recetaSeccion = (Receta)request.getSession().getAttribute("receta");
		if(RecetaDAO.readAll().contains(recetaSeccion)) {
			estado = "Esta receta ya existe.";
		}else {
			try {
				RecetaDAO.create(recetaSeccion);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			estado = "La receta ha sido insertada";
		}
		
		request.setAttribute("estado", estado);
		
		RequestDispatcher miDispatcher= request.getRequestDispatcher("paginas/verReceta.jsp");
		
		miDispatcher.forward(request, response);
		
	}
	
	private void verTitulosSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher miDispatcher= request.getRequestDispatcher("paginas/verTitulosSesion.jsp");
		
		miDispatcher.forward(request, response);
	}
	
	private void verTitulosBd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RecetaDAO=new RecetaDAO(miPool);
		List<Receta> listareceta = RecetaDAO.readAll();
		
		request.setAttribute("listareceta", listareceta);
		
		RequestDispatcher miDispatcher= request.getRequestDispatcher("paginas/verTitulosBd.jsp");
		
		miDispatcher.forward(request, response);
	}

}
