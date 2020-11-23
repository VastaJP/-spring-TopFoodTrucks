package ttps.spring.interfacesDAO;

import ttps.spring.model.FoodTrucker;

public interface FoodTruckerDAO extends GenericDAO<FoodTrucker> {
	
	public FoodTrucker ConEmail(String email);
	public FoodTrucker autenticar(String email, String contrasenia);
}
