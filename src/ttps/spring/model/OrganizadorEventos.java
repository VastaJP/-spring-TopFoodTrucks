package ttps.spring.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name= "organizadores")
public class OrganizadorEventos extends Usuario{
	
	public OrganizadorEventos() {
	}
	
	@OneToMany(mappedBy = "organizador")
	@JsonManagedReference(value = "organizadorE")
	private List<Evento> eventos;
	
	public OrganizadorEventos(Integer idUsuario, String email, String contrasenia, String nombre, String apellido,
			List<Evento> eventos) {
		super(idUsuario, email, contrasenia, nombre, apellido);
		this.eventos = eventos;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
}
