package co.grandcircus.david.hibernate1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.grandcircus.david.hibernate1.config.HibernateConfigurer;
import co.grandcircus.david.hibernate1.model.Course;

public class CourseDao {

	private SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();

	public Course getById(Integer courseId) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(Course.class, courseId);
		}
	}
	
	public List<Course> getAllCourses() {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("from Course order by title", Course.class)
					.getResultList();
		}
	}
	
	public Course getByTitle(String title) {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("from Course where title = :title", Course.class)
					.setParameter("title", title)
					.getSingleResult();
		}
	}
	
}
