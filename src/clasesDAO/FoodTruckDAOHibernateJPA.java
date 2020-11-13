package clasesDAO;

import java.io.Serializable;

import interfacesDAO.FoodTruckDAO;
import modelo.FoodTruck;

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
