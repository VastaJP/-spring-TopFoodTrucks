package testing;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clasesDAO.DAOFactory;
import clasesDAO.FoodTruckDAOHibernateJPA;
import modelo.FoodTruck;

/**
 * Servlet implementation class FoodTruckTest
 */
@WebServlet("/FoodTruckTest")
public class FoodTruckTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodTruckTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodTruckDAOHibernateJPA fdtDAO= (FoodTruckDAOHibernateJPA)DAOFactory.getFoodTruckDAO();
		List<FoodTruck> todos = fdtDAO.recuperarTodos("idFoodTruck");
		for (FoodTruck foodTruck : todos) {
			System.out.println(foodTruck.getIdFoodTruck());
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
