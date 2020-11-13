package testing;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clasesDAO.DAOFactory;
import clasesDAO.ValoracionDAOHibernateJPA;
import modelo.Valoracion;

/**
 * Servlet implementation class ValoracionTest
 */
@WebServlet("/ValoracionTest")
public class ValoracionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValoracionTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ValoracionDAOHibernateJPA vDAO= (ValoracionDAOHibernateJPA)DAOFactory.getValoracionDAO();
		List<Valoracion> todos = vDAO.recuperarTodos("idValoracion");
		for (Valoracion valoracion : todos) {
			System.out.println(valoracion.getCalidadPrecio());
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
