package ttps.spring.clasesDAO;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ttps.spring.interfacesDAO.EventoDAO;
import ttps.spring.model.Evento;

@Repository
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
