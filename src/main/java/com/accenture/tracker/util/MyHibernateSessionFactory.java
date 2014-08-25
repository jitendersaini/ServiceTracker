/**
 * 
 */
package com.accenture.tracker.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author j.saini
 * 
 */
public class MyHibernateSessionFactory {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		/*try {
			System.out.println("The URL is: "
					+ ((SessionFactoryImpl) sessionFactory)
							.getConnectionProvider().getConnection()
							.getMetaData().getURL());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return sessionFactory.getCurrentSession();
	}

}
