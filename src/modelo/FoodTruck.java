package modelo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "foodtrucks")
public class FoodTruck {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
	
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	private FoodTrucker foodtrucker;
	
	@OneToMany(mappedBy = "foodTruck")
	private List<Reserva> reservas;
	
	@OneToMany(mappedBy = "foodTruck")
	private List<Imagen> imagen;
	
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
		this.imagen = imagen;
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
		return imagen;
	}

	public void setImagen(List<Imagen> imagen) {
		this.imagen = imagen;
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
