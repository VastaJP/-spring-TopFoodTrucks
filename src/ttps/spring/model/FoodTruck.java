package ttps.spring.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "foodtrucks")
public class FoodTruck {

	@Id@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "idFoodTruck")
	private Integer idFoodTruck;
	
	@Column(name = "whatsapp", nullable = true)
	private Integer whatsapp;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "servicio")
	private String servicio;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "website", nullable = true)
	private String website;
	
	@Column(name = "instagram", nullable = true)
	private String instagram;
	
	@Column(name = "twitter", nullable = true)
	private String twitter;
	
	//Back->owner / Managed->no owner
	//@JsonBackReference(value = "foodTruckFT")
	@JsonIgnore
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	//@JoinColumn(name = "foodtrucker_idUsuario")
	private FoodTrucker foodtrucker;
	
	@JsonBackReference(value = "reservasFT")
	@OneToMany(mappedBy = "foodTruck")
	private List<Reserva> reservas;
	
	@JsonManagedReference(value = "foodTruckI")
	@OneToMany(mappedBy = "foodTruck", fetch = FetchType.EAGER)
	private List<Imagen> imagenes;
	
	public FoodTruck() {
	}
	
	public FoodTruck(Integer idFoodTruck, Integer idUsuario, Integer whatsapp, String nombre, String servicio,
			String descripcion, String website, String instagram, String twitter, FoodTrucker foodtrucker,
			List<Reserva> reservas, List<Imagen> imagen) {
		this.idFoodTruck = idFoodTruck;
		this.whatsapp = whatsapp;
		this.nombre = nombre;
		this.servicio = servicio;
		this.descripcion = descripcion;
		this.website = website;
		this.instagram = instagram;
		this.twitter = twitter;
		this.foodtrucker = foodtrucker;
		this.reservas = reservas;
		this.imagenes = imagen;
	}
	
	public Integer getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(Integer whatsapp) {
		this.whatsapp = whatsapp;
	}

	public FoodTrucker getFoodtrucker() {
		return foodtrucker;
	}

	public void setFoodtrucker(FoodTrucker foodtrucker) {
		this.foodtrucker = foodtrucker;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<Imagen> getImagen() {
		return imagenes;
	}

	public void setImagen(List<Imagen> imagen) {
		this.imagenes = imagen;
	}

	public Integer getIdFoodTruck() {
		return idFoodTruck;
	}

	public void setIdFoodTruck(Integer idFoodTruck) {
		this.idFoodTruck = idFoodTruck;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
}
