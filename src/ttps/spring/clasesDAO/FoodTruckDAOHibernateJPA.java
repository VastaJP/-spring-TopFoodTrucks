package ttps.spring.clasesDAO;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ttps.spring.interfacesDAO.FoodTruckDAO;
import ttps.spring.model.FoodTruck;

@Repository
public class FoodTruckDAOHibernateJPA extends GenericDAOHibernateJPA<FoodTruck> implements FoodTruckDAO {

	public FoodTruckDAOHibernateJPA() {
		super(FoodTruck.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean existe(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FoodTruck recuperar(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}


}
