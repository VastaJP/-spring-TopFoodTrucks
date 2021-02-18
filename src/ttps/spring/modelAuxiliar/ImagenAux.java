package ttps.spring.modelAuxiliar;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "imagenes")
public class ImagenAux {
	
	public ImagenAux() {
	}

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idImagen")
	private Integer idImagen;
	
	@Column(name = "path")
	private String path;
	
	@JsonBackReference(value = "foodTruckI")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idFoodTruck")
	private FoodTruckAux foodTruckAux;

	public ImagenAux(Integer idImagen, String path, FoodTruckAux foodTruckAux) {
		super();
		this.idImagen = idImagen;
		this.path = path;
		this.foodTruckAux = foodTruckAux;
	}

	
	
	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public FoodTruckAux getFoodTruck() {
		return foodTruckAux;
	}



	public void setFoodTruck(FoodTruckAux foodTruckAux) {
		this.foodTruckAux = foodTruckAux;
	}



	public Integer getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
	}
	
}
