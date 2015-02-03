package com.inbadevs.swimmingpoolserviceexample.dao;

import java.io.Serializable;
import org.hibernate.HibernateException;



import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @deprecated
 * 
 * Clase Abstracta para la construcción de DAOs
 *
 * @param <E> Tipo de dato esperado en el retorno de una query
 */
public abstract class BaseAbstractDAO<E, I extends Serializable> {
	private Class<E> entityClass;

	private SessionFactory sessionFactory;

//	protected BaseAbstractDAO(Class<E> entityClass, SessionFactory sessionFactory, Map<String, String> q) {
//		this.entityClass = entityClass;
//		this.sessionFactory = sessionFactory;
//		//getQueries().putAll(q);
//	}
//        
        public BaseAbstractDAO(Class<E> entityClass, SessionFactory sessionFactory) {
		this.entityClass = entityClass;
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * Constructor por defecto
	 */
	protected BaseAbstractDAO() {
	}

	/**
	 * Obtiene la session actual
	 * 
	 * @return retorna una instancia de Session
	 */
    public Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

	/**
	 * Obtiene quieries sql
	 * 
	 * @return Un mapa donde la una llave esta asociada a una query sql
	 */
//	protected Map<String, String> getQueries() {
//		//if (this.queries == null) {
//			this.queries = new HashMap<String, String>();
//                        queries.put ("example", "SELECT id_user, user_name, password FROM test.user limit 1");
//		//}
//
//		return this.queries;
//	}

	/**
	 * Find the methodName query in the list of queries defined in the
	 * constructor
	 * 
	 * @param methodName
	 *            name of the query to find
	 * @return SQLQuery with an instance of the sql query defined in the bean
	 *         file
	 * @throws QueryNotFoundException
	 *             Cuando no encuentra la query en el mapeo xml
	 */
	public SQLQuery createSqlQuery(String methodName)
			throws Exception {
		//String sql = getQueries().get(methodName);
                String sql = methodName;
		if (sql == null) {
			throw new Exception("La query [" + methodName
					+ "] no ha sido encontrada");
		}

		return getCurrentSession().createSQLQuery(sql);
	}

}
