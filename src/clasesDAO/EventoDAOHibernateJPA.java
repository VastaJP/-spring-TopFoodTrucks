package clasesDAO;

import java.io.Serializable;

import interfacesDAO.EventoDAO;
import modelo.Evento;

public class EventoDAOHibernateJPA extends GenericDAOHibernateJPA<Evento> implements EventoDAO {

	public EventoDAOHibernateJPA() {
		super(Evento.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean existe(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Evento recuperar(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}


}
