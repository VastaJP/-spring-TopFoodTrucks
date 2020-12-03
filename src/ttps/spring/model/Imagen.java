package ttps.spring.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "imagenes")
public class Imagen {
	
	public Imagen() {
	}

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idImagen")
	private Integer idImagen;
	
	@Column(name = "path")
	private String path;
	
	@JsonBackReference(value = "foodTruckI")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idFoodTruck")
	private FoodTruck foodTruck;

	public Imagen(Integer idImagen, String path, FoodTruck foodTruck) {
		super();
		this.idImagen = idImagen;
		this.path = path;
		this.foodTruck = foodTruck;
	}

	
	
	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public FoodTruck getFoodTruck() {
		return foodTruck;
	}



	public void setFoodTruck(FoodTruck foodTruck) {
		this.foodTruck = foodTruck;
	}



	public Integer getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
	}
	
}
