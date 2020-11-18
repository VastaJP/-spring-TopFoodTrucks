package ttps.spring.clasesDAO;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ttps.spring.interfacesDAO.FoodTruckerDAO;
import ttps.spring.model.FoodTrucker;


@Repository
public class FoodTruckerDAOHibernateJPA extends GenericDAOHibernateJPA<FoodTrucker> implements FoodTruckerDAO {

	public FoodTruckerDAOHibernateJPA() {
		super(FoodTrucker.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean existe(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public FoodTrucker recuperar(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}



}
