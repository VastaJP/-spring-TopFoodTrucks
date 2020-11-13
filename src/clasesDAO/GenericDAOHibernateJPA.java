package clasesDAO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import interfacesDAO.GenericDAO;

public class GenericDAOHibernateJPA<T> implements GenericDAO<T>{
	
	protected Class<T> persistentClass;
	
	public GenericDAOHibernateJPA(Class<T> clase) {
		persistentClass = clase;
	}
	 
	 
	 
	private Class<T> getPersistentClass() {
		return persistentClass;
	}



	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}



	@Override
	 public T persistir(T entity) {
		 EntityManager em = EMF.getEMF().createEntityManager();
		 EntityTransaction tx = null;
		 try {
			 tx = em.getTransaction();
			 tx.begin();
			 em.persist(entity);
			 tx.commit();
		 }
		 catch (RuntimeException e) {
			 if ( tx != null && tx.isActive() ) tx.rollback();
			 throw e; // escribir en un log o mostrar un mensaje
		 }
		 finally {
			 em.close();
		 }
		 return entity;
	 }
	 
	 public T actualizar(T entity) {
		 EntityManager em= EMF.getEMF().createEntityManager();
		 EntityTransaction etx= em.getTransaction();
		 etx.begin();
		 entity = em.merge(entity);
		 etx.commit();
		 em.close();
		 return entity;
	 }
	 
	 @Override
	 public void borrar(T entity) {
		 EntityManager em = EMF.getEMF().createEntityManager();
		 EntityTransaction tx = null;
		 try {
			 tx = em.getTransaction();
			 tx.begin();
			 em.remove(em.merge(entity));
			 tx.commit();
		 }
		 catch (RuntimeException e) {
			 if ( tx != null && tx.isActive() ) tx.rollback();
			 throw e; // escribir en un log o mostrar un mensaje
		 }
		 finally {
			 em.close();
		 }
	 }
	 
	 public T borrar(Serializable id) {
		 T entity =
				 EMF.getEMF().createEntityManager().find(this.getPersistentClass(),id);
		 if (entity != null) {
			 this.borrar(entity);
		 }
		 return entity;
	 }
	 
	 @Override
	 public List<T> recuperarTodos(String columnOrder) {
		 Query consulta=
				 EMF.getEMF().createEntityManager().createQuery(
						 "select e from "+ getPersistentClass().getSimpleName()+" e order by e."+columnOrder
				);
		 List<T> resultado = (List<T>)consulta.getResultList();
		 return resultado;
	 }



	@Override
	public boolean existe(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public T recuperar(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
