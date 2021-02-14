package ttps.spring.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "foodtruckers")
public class FoodTrucker{

	@JsonManagedReference(value = "foodTruckFT")
	@OneToOne(mappedBy = "foodtrucker", optional = true)
	private FoodTruck foodTruck;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idUsuario")
	private Integer idUsuario;
	
	@Column(name = "email")
	private String email; 
	
	@Column(name = "contrasenia")
	private String contrasenia;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	public FoodTrucker() {
	}

	public FoodTrucker(FoodTruck foodTruck, Integer idUsuario, String email, String contrasenia, String nombre,
			String apellido) {
		super();
		this.foodTruck = foodTruck;
		this.idUsuario = idUsuario;
		this.email = email;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
	}



	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public FoodTruck getFoodTruck() {
		return foodTruck;
	}
	
	public void setFoodTruck(FoodTruck foodTruck) {
		this.foodTruck = foodTruck;
	}
	
}
