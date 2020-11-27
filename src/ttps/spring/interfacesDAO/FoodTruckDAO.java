package ttps.spring.interfacesDAO;

import ttps.spring.model.FoodTruck;

public interface FoodTruckDAO extends GenericDAO<FoodTruck> {
	public FoodTruck getFoodTruck(int id);
}
