package ttps.spring.clasesDAO;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.interfacesDAO.OrganizadorEventosDAO;
import ttps.spring.model.OrganizadorEventos;

@Repository
public class OrganizadorEventosDAOHibernateJPA extends GenericDAOHibernateJPA<OrganizadorEventos> implements OrganizadorEventosDAO {

	public OrganizadorEventosDAOHibernateJPA() {
		super(OrganizadorEventos.class);
		// TODO Auto-generated constructor stub
	}
	
	public OrganizadorEventos ConEmail(String email) {
		String tabla = getPersistentClass().getSimpleName();
		Query consulta =
			this.getEntityManager().createQuery("SELECT u FROM "+tabla+" u WHERE u.email= '"+email+"'");
		
		OrganizadorEventos resultado = null;
		
		try 
		{
			resultado = (OrganizadorEventos)consulta.getSingleResult();
		}
		catch (NoResultException e) {
			//no hace nada
		}
		return resultado;
	 }

	public OrganizadorEventos autenticar(String email, String contrasenia) {
		String tabla = getPersistentClass().getSimpleName();
		Query consulta =
			this.getEntityManager().createQuery("SELECT u FROM "+tabla+" u WHERE u.email= '"+email+"' AND u.contrasenia= '"+contrasenia+"'");
		OrganizadorEventos resultado = null;

		try 
		{
			resultado = (OrganizadorEventos)consulta.getSingleResult();
		}
		catch (NoResultException e) {
			//no hace nada
		}
		return resultado;
	}

}
