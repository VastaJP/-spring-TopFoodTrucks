package ttps.spring.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "eventos")
public class Evento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEvento")
	private Integer idEvento;
	
	@Column(name = "nombreEvento")
	private String nombreEvento;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "provincia")
	private String provincia;
	
	@Column(name = "pagaAsistente")
	private int pagaAsistente;
	
	@Column(name = "geolocalizacion")
	private String geolocalizacion;
	
	@Column(name = "tipoEvento")
	private String tipoEvento;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fechaYHora")
	private LocalDateTime fechaYHora;
	
	@Column(name = "codigoPostal")
	private Integer codigoPostal;
	
	@Column(name = "telefono")
	private String telefono;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idOrganizador")
	private OrganizadorEventos organizador;
	
	@OneToMany(mappedBy = "evento")
	private List<Reserva> reservas;
	
	public Evento() {
		super();
	}
	
	
	public Evento(Integer idEvento, String nombreEvento, String direccion, String provincia, int pagaAsistente,
			String geolocalizacion, String tipoEvento, String email, String descripcion, LocalDateTime fechaYHora,
			Integer codigoPostal, String telefono, OrganizadorEventos organizador, List<Reserva> reservas) {
		this.idEvento = idEvento;
		this.nombreEvento = nombreEvento;
		this.direccion = direccion;
		this.provincia = provincia;
		this.pagaAsistente = pagaAsistente;
		this.geolocalizacion = geolocalizacion;
		this.tipoEvento = tipoEvento;
		this.email = email;
		this.descripcion = descripcion;
		this.fechaYHora = fechaYHora;
		this.codigoPostal = codigoPostal;
		this.telefono = telefono;
		this.organizador = organizador;
		this.reservas = reservas;
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getGeolocalizacion() {
		return geolocalizacion;
	}
	public void setGeolocalizacion(String geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPagaAsistente() {
		return pagaAsistente;
	}
	public void setPagaAsistente(int pagaAsistente) {
		this.pagaAsistente = pagaAsistente;
	}
	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}
	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Integer getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}
	public OrganizadorEventos getOrganizador() {
		return organizador;
	}
	public void setOrganizador(OrganizadorEventos organizador) {
		this.organizador = organizador;
	}
	
}
