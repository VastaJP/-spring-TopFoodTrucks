package ttps.spring.clasesDAO;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ttps.spring.interfacesDAO.ValoracionDAO;
import ttps.spring.model.Valoracion;

@Repository
public class ValoracionDAOHibernateJPA extends GenericDAOHibernateJPA<Valoracion> implements ValoracionDAO {

	public ValoracionDAOHibernateJPA() {
		super(Valoracion.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean existe(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Valoracion recuperar(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}


}
