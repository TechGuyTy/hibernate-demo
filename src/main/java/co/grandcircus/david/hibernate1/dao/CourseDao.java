package co.grandcircus.david.hibernate1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.grandcircus.david.hibernate1.config.HibernateConfigurer;
import co.grandcircus.david.hibernate1.model.Course;

public class CourseDao {

	private SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();

	public Course getByTitle(String title) {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("from Course where title = :title", Course.class)
					.setParameter("title", title)
					.getSingleResult();
		}
	}
	
}
