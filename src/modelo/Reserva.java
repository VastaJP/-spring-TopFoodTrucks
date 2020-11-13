package modelo;

import javax.persistence.*;

@Entity
@Table(name= "reservas")
public class Reserva {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idReserva")
	private Integer idReserva;
	
	@Column(name = "estado")
	private String estado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEvento")
	private Evento evento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idFoodTruck")
	private FoodTruck foodTruck;
	
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