package ttps.spring.clasesDAO;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.interfacesDAO.FoodTruckerDAO;
import ttps.spring.model.FoodTrucker;


@Repository
public class FoodTruckerDAOHibernateJPA extends GenericDAOHibernateJPA<FoodTrucker> implements FoodTruckerDAO {

	public FoodTruckerDAOHibernateJPA() {
		super(FoodTrucker.class);
		// TODO Auto-generated constructor stub
	}

	public FoodTrucker ConEmail(String email) {
		String tabla = getPersistentClass().getSimpleName();
		Query consulta =
			this.getEntityManager().createQuery("SELECT u FROM "+tabla+" u WHERE u.email= '"+email+"'");
		
		FoodTrucker resultado = null;
		
		try 
		{
			resultado = (FoodTrucker)consulta.getSingleResult();
		}
		catch (NoResultException e) {
			//no hace nada
		}
		return resultado;
	 }

	public FoodTrucker autenticar(String email, String contrasenia) {
		String tabla = getPersistentClass().getSimpleName();
		Query consulta =
			this.getEntityManager().createQuery("SELECT u FROM "+tabla+" u WHERE u.email= '"+email+"' AND u.contrasenia= '"+contrasenia+"'");
		FoodTrucker resultado = null;

		try 
		{
			resultado = (FoodTrucker)consulta.getSingleResult();
		}
		catch (NoResultException e) {
			//no hace nada
		}
		return resultado;
	}

}
