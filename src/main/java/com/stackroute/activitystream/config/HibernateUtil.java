package com.stackroute.activitystream.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.stackroute.activitystream.repository.MessageRepository;

import net.bytebuddy.asm.Advice.This;

@SuppressWarnings("deprecation")
public class HibernateUtil {

	public static SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return HibernateUtil.configureSessionFactory();
	}

	/*
	 * build the sessionFactory object based on the parameters from
	 * hibernate.cfg.xml file. Also, handle exception if the session factory object
	 * can't be created
	 */
	private static SessionFactory configureSessionFactory() {
		// Configuration configuration = new Configuration();
		// configuration.configure("/hiberante.cfg.xml");
		// SessionFactory sessionFactory = configuration.buildSessionFactory();
		// return sessionFactory;
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.stackroute.activitystream.model.Message.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		return configuration.buildSessionFactory(builder.build());
	}

}
