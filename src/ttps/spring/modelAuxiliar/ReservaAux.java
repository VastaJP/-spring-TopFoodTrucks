package ttps.spring.modelAuxiliar;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name= "reservas")
public class ReservaAux {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idReserva")
	private Integer idReserva;
	
	@Column(name = "estado")
	private String estado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEvento")
	private EventoAux eventoAux;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idFoodTruck")
	private FoodTruckAux foodTruckAux;
	
	@JsonBackReference(value = "valoracionR")
	@OneToOne(fetch = FetchType.EAGER,optional = true)
	@JoinColumn(name = "idValoracion")
	private ValoracionAux valoracionAux;
	
	public ReservaAux() {
	}
	
	public ReservaAux(Integer idReserva, String estado, EventoAux eventoAux, FoodTruckAux foodTruckAux, ValoracionAux valoracionAux) {
		this.idReserva = idReserva;
		this.estado = estado;
		this.eventoAux = eventoAux;
		this.foodTruckAux = foodTruckAux;
		this.valoracionAux = valoracionAux;
	}

	public EventoAux getEvento() {
		return eventoAux;
	}

	public void setEvento(EventoAux eventoAux) {
		this.eventoAux = eventoAux;
	}

	public FoodTruckAux getFoodTruck() {
		return foodTruckAux;
	}

	public void setFoodTruck(FoodTruckAux foodTruckAux) {
		this.foodTruckAux = foodTruckAux;
	}

	public ValoracionAux getValoracion() {
		return valoracionAux;
	}

	public void setValoracion(ValoracionAux valoracionAux) {
		this.valoracionAux = valoracionAux;
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