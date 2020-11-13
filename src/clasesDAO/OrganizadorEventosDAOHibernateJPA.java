package clasesDAO;

import interfacesDAO.OrganizadorEventosDAO;
import modelo.OrganizadorEventos;

public class OrganizadorEventosDAOHibernateJPA extends GenericDAOHibernateJPA<OrganizadorEventos> implements OrganizadorEventosDAO {

	public OrganizadorEventosDAOHibernateJPA() {
		super(OrganizadorEventos.class);
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public OrganizadorEventos actualizar(OrganizadorEventos entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void borrar(OrganizadorEventos entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public OrganizadorEventos borrar(Serializable id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean existe(Serializable id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public OrganizadorEventos persistir(OrganizadorEventos entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public OrganizadorEventos recuperar(Serializable id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<OrganizadorEventos> recuperarTodos(String columnOrder) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
