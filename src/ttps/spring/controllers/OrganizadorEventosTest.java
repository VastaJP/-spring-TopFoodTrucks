package ttps.spring.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttps.spring.clasesDAO.DAOFactory;
import ttps.spring.clasesDAO.OrganizadorEventosDAOHibernateJPA;
import ttps.spring.model.Evento;
import ttps.spring.model.OrganizadorEventos;

/**
 * Servlet implementation class OrganizadorEventosTest
 */
@WebServlet("/OrganizadorEventosTest")
public class OrganizadorEventosTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrganizadorEventosTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrganizadorEventosDAOHibernateJPA oeDAO= (OrganizadorEventosDAOHibernateJPA)DAOFactory.getOrganizadorEventosDAO();
		List<OrganizadorEventos> todos = oeDAO.recuperarTodos("idUsuario");
		for (OrganizadorEventos organizadorEventos : todos) {
			System.out.println(organizadorEventos.getEmail());
		}
		System.out.println("Se obtuvieron todos los emails de la tabla Organizadores");
		
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
		OrganizadorEventos org1 = new OrganizadorEventos(null, email, pass, nombre, apellido, null);
		
		oeDAO.persistir(org1);
		System.out.println("Se ha registrado un organizador satisfactoriamente. Los datos son los siguientes:");
		System.out.println("Email: "+org1.getEmail());
		System.out.println("Contraseña: "+org1.getContrasenia());
		System.out.println("Nombre: "+org1.getNombre());
		System.out.println("Apellido: "+org1.getApellido());		
		
		System.out.println("MODIFICACION");
		System.out.println("Ingrese un nuevo nombre para el organizador recien registrado:");
		String nuevoNombre = teclado.nextLine();
		org1.setNombre(nuevoNombre);
		oeDAO.actualizar(org1);
		
		System.out.println("Se ha actualizado exitosamente. Los nuevos datos son");
		System.out.println("Email: "+org1.getEmail());
		System.out.println("Contraseña: "+org1.getContrasenia());
		System.out.println("Nombre: "+org1.getNombre());
		System.out.println("Apellido: "+org1.getApellido());
		
		
		System.out.println("Eventos de los organizadore:s");
		for(OrganizadorEventos organizador: todos) {
			if(organizador.getEventos().isEmpty()) {
				System.out.println("No tiene eventos");
			}else {
				for(Evento evento: (List<Evento>)organizador.getEventos())
					System.out.println(evento.getNombreEvento());
			}
		}
		
		System.out.println("mail de organizador // Identificador");
		for (OrganizadorEventos organizadorEventos : todos) {
			System.out.print(organizadorEventos.getEmail()+" // ");
			System.out.println(organizadorEventos.getIdUsuario());
		}
		System.out.println("Elija el Id del usuario a dar de baja");
		oeDAO.borrar(Integer.parseInt(teclado.nextLine().trim()));
		System.out.println("Usuario dado de baja");
		
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
