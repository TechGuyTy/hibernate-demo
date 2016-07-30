package co.grandcircus.david.hibernate1.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

public class HibernateConfigurer {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}
	
	private static SessionFactory buildSessionFactory() {
		return new Configuration()
				.configure() // configures settings from hibernate.cfg.xml
				.buildSessionFactory();
	}

}
