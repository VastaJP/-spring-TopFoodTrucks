package testing;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clasesDAO.DAOFactory;
import clasesDAO.FoodTruckerDAOHibernateJPA;
import modelo.FoodTrucker;

/**
 * Servlet implementation class FoodTruckerTest
 */
@WebServlet("/FoodTruckerTest")
public class FoodTruckerTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodTruckerTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodTruckerDAOHibernateJPA fDAO= (FoodTruckerDAOHibernateJPA)DAOFactory.getFoodTruckerDAO();
		List<FoodTrucker> todos = fDAO.recuperarTodos("idUsuario");
		for (FoodTrucker foodTrucker : todos) {
			System.out.println(foodTrucker.getEmail());
		}
		System.out.println("Se obtuvieron todos los emails de la tabla Organizadores");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Ingrese los datos para registrar un organizador");
		System.out.println("Email:");
		Scanner teclado = new Scanner(System.in);
		String email = teclado.nextLine();
		System.out.println("Contraseña:");
		String pass = teclado.nextLine();
		System.out.println("Nombre:");
		String nombre = teclado.nextLine();
		System.out.println("Apellido:");
		String apellido = teclado.nextLine();



		FoodTrucker ft1 = new FoodTrucker(null, email, pass, nombre, apellido, null);
		fDAO.persistir(ft1);
		System.out.println("Se ha registrado un organizador satisfactoriamente");
		
		teclado.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
