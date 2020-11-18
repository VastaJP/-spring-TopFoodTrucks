package ttps.spring.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name= "organizadores")
public class OrganizadorEventos{
	
	public OrganizadorEventos() {
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
	
	@OneToMany(mappedBy = "organizador")
	private List<Evento> eventos;

	public OrganizadorEventos(Integer idUsuario, String email, String contrasenia, String nombre, String apellido,
			List<Evento> eventos) {
		this.idUsuario = idUsuario;
		this.email = email;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.eventos = eventos;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
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
