package clasesDAO;

import java.io.Serializable;

import interfacesDAO.ReservaDAO;
import modelo.Reserva;

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
