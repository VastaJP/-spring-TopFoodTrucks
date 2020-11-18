package ttps.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "foodtruckers")
public class FoodTrucker{
	
	public FoodTrucker() {
	}

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@OneToOne(mappedBy = "foodtrucker")
	private FoodTruck foodTruck;
	
	public FoodTrucker(Integer idUsuario, String email, String contrasenia, String nombre, String apellido,
			FoodTruck foodTruck) {
		this.idUsuario = idUsuario;
		this.email = email;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.foodTruck = foodTruck;
	}

	public FoodTruck getFoodTruck() {
		return foodTruck;
	}
	
	public void setFoodTruck(FoodTruck foodTruck) {
		this.foodTruck = foodTruck;
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
	
}
