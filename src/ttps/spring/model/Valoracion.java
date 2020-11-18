package ttps.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "Valoracion")
public class Valoracion {
	
	public Valoracion() {
	}

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idValoracion")
	private Integer idValoracion;
	
	@Column(name = "limpieza")
	private Integer limpieza;
	
	@Column(name = "simpatia")
	private Integer simpatia;
	
	@Column(name = "calidadPrecio")
	private Integer calidadPrecio;
	
	@Column(name = "sabor")
	private Integer sabor;
	
	@Column(name = "disenio")
	private Integer disenio;
	
	@OneToOne(mappedBy = "valoracion")
	private Reserva reserva;
	
	public Valoracion(Integer idValoracion, Integer limpieza, Integer simpatia, Integer calidadPrecio, Integer sabor,
			Integer disenio, Reserva reserva) {
		this.idValoracion = idValoracion;
		this.limpieza = limpieza;
		this.simpatia = simpatia;
		this.calidadPrecio = calidadPrecio;
		this.sabor = sabor;
		this.disenio = disenio;
		this.reserva = reserva;
	}

	public Integer getLimpieza() {
		return limpieza;
	}

	public void setLimpieza(Integer limpieza) {
		this.limpieza = limpieza;
	}

	public Integer getSimpatia() {
		return simpatia;
	}

	public void setSimpatia(Integer simpatia) {
		this.simpatia = simpatia;
	}

	public Integer getCalidadPrecio() {
		return calidadPrecio;
	}

	public void setCalidadPrecio(Integer calidadPrecio) {
		this.calidadPrecio = calidadPrecio;
	}

	public Integer getSabor() {
		return sabor;
	}

	public void setSabor(Integer sabor) {
		this.sabor = sabor;
	}

	public Integer getDisenio() {
		return disenio;
	}

	public void setDisenio(Integer disenio) {
		this.disenio = disenio;
	}
}
