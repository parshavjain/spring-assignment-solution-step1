package com.stackroute.activitystream.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author PARSAV
 *
 */
@SuppressWarnings("deprecation")
public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return HibernateUtil.configureSessionFactory();
	}

	/**
	 * build the sessionFactory object based on the parameters from
	 * hibernate.cfg.xml file. Also, handle exception if the session factory object
	 * can't be created
	 */
	private static SessionFactory configureSessionFactory() {
		return sessionFactory;
	}

}
