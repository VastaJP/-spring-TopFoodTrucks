package ttps.spring.clasesDAO;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ttps.spring.interfacesDAO.ReservaDAO;
import ttps.spring.model.Reserva;


@Repository
public class ReservaDAOHibernateJPA extends GenericDAOHibernateJPA<Reserva> implements ReservaDAO {

	public ReservaDAOHibernateJPA() {
		super(Reserva.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean existe(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Reserva recuperar(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
