package ttps.spring.modelAuxiliar;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name= "organizadores")
public class OrganizadorEventosAux{
	
	public OrganizadorEventosAux() {
	}
	
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
	
	@OneToMany(mappedBy = "organizador")
	private List<EventoAux> eventoAuxs;

	public OrganizadorEventosAux(Integer idUsuario, String email, String contrasenia, String nombre, String apellido,
			List<EventoAux> eventoAuxs) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.eventoAuxs = eventoAuxs;
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

	public List<EventoAux> getEventos() {
		return eventoAuxs;
	}

	public void setEventos(List<EventoAux> eventoAuxs) {
		this.eventoAuxs = eventoAuxs;
	}
	
}
