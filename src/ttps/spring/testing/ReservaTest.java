package testing;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clasesDAO.DAOFactory;
import clasesDAO.ReservaDAOHibernateJPA;
import modelo.Reserva;

/**
 * Servlet implementation class ReservaTest
 */
@WebServlet("/ReservaTest")
public class ReservaTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservaDAOHibernateJPA rDAO= (ReservaDAOHibernateJPA)DAOFactory.getReservaDAO();
		List<Reserva> todos = rDAO.recuperarTodos("idReserva");
		for (Reserva reserva : todos) {
			System.out.println(reserva.getEstado());
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
