package ttps.spring.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "foodtruckers")
public class FoodTrucker extends Usuario{

	@JsonIgnore
	@OneToOne(mappedBy = "foodtrucker", optional = true)
	private FoodTruck foodTruck;
	
	public FoodTrucker() {
	}
	
	public FoodTrucker(Integer idUsuario, String email, String contrasenia, String nombre, String apellido,
			FoodTruck foodTruck) {
		super(idUsuario, email, contrasenia, nombre, apellido);
		this.foodTruck = foodTruck;
	}

	public FoodTruck getFoodTruck() {
		return foodTruck;
	}
	
	public void setFoodTruck(FoodTruck foodTruck) {
		this.foodTruck = foodTruck;
	}
	
}
