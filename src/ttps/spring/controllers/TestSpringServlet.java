package ttps.spring.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ttps.spring.config.PersistenceConfig;
import ttps.spring.interfacesDAO.OrganizadorEventosDAO;

/**
 * Servlet implementation class TestSpringServlet
 */
@WebServlet("/LoginServlet")
public class TestSpringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSpringServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		//registra una o más componentes que serán procesadas
		ctx.register(PersistenceConfig.class);
		//Busca clases anotadas en el paquete base pasado por parámetro
		ctx.scan("ttps.spring.clasesDAO");
		ctx.refresh();

		OrganizadorEventosDAO orgDAO = ctx.getBean(OrganizadorEventosDAO.class);
		response.getWriter().append("En total hay "+String.valueOf(orgDAO.recuperarTodos("email").size())+" organizadores");
		ctx.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
