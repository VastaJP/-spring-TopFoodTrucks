package ttps.spring.clasesDAO;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import ttps.spring.interfacesDAO.ImagenDAO;
import ttps.spring.model.Imagen;


@Repository
public class ImagenDAOHibernateJPA extends GenericDAOHibernateJPA<Imagen> implements ImagenDAO {

	public ImagenDAOHibernateJPA() {
		super(Imagen.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean existe(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Imagen recuperar(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}


}
