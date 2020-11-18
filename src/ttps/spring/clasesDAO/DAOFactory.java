package ttps.spring.clasesDAO;

import ttps.spring.interfacesDAO.*;
import ttps.spring.clasesDAO.*;

public class DAOFactory {
	
	public static EventoDAO getEventoDAO() {     
		return new EventoDAOHibernateJPA();  
	}
	
	public static FoodTruckDAO getFoodTruckDAO() {
		return new FoodTruckDAOHibernateJPA();
	}
	
	public static FoodTruckerDAO getFoodTruckerDAO() {
		return new FoodTruckerDAOHibernateJPA();
	}
	
	public static ImagenDAO getImagenDAO() {
		return new ImagenDAOHibernateJPA();
	}
	
	public static OrganizadorEventosDAO getOrganizadorEventosDAO() {
		return new OrganizadorEventosDAOHibernateJPA();
	}
	
	public static ReservaDAO getReservaDAO() {
		return new ReservaDAOHibernateJPA();
	}
	
	public static ValoracionDAO getValoracionDAO() {
		return new ValoracionDAOHibernateJPA();
	}
}
