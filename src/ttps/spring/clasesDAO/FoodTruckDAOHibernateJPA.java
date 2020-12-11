package ttps.spring.clasesDAO;

import java.io.Serializable;

import javax.persistence.NoResultException;
import javax.persistence.Query;

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
	public FoodTruck getFoodTruck(int id) {
		Query consulta = this.getEntityManager().createQuery(""
				+ "SELECT ft FROM "+ getPersistentClass().getSimpleName()+" ft WHERE ft.idFoodTruck = '"+id+"'");
		FoodTruck foodtruck = null;
		try {
			foodtruck = (FoodTruck)consulta.getSingleResult();
		} catch (NoResultException e) {
			
		}
		return foodtruck;
	}


}
