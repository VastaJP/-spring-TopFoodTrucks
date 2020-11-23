package ttps.spring.interfacesDAO;

import ttps.spring.model.OrganizadorEventos;

public interface OrganizadorEventosDAO extends GenericDAO<OrganizadorEventos> {
	public OrganizadorEventos ConEmail(String email);
	public OrganizadorEventos autenticar(String email, String contrasenia);
}
