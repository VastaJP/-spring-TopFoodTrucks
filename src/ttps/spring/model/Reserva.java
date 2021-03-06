package ttps.spring.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name= "reservas")
public class Reserva {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idReserva")
	private Integer idReserva;
	
	@Column(name = "estado")
	private String estado;
	
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "idEvento")
	private Evento evento;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idFoodTruck")
	private FoodTruck foodTruck;
	
	@JsonBackReference(value = "valoracionR")
	@OneToOne(fetch = FetchType.EAGER,optional = true)
	@JoinColumn(name = "idValoracion")
	private Valoracion valoracion;
	
	public Reserva() {
	}
	
	public Reserva(Integer idReserva, String estado, Evento evento, FoodTruck foodTruck, Valoracion valoracion) {
		this.idReserva = idReserva;
		this.estado = estado;
		this.evento = evento;
		this.foodTruck = foodTruck;
		this.valoracion = valoracion;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public FoodTruck getFoodTruck() {
		return foodTruck;
	}

	public void setFoodTruck(FoodTruck foodTruck) {
		this.foodTruck = foodTruck;
	}

	public Valoracion getValoracion() {
		return valoracion;
	}

	public void setValoracion(Valoracion valoracion) {
		this.valoracion = valoracion;
	}

	public Integer getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}