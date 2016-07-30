package co.grandcircus.david.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import co.grandcircus.david.hibernate1.config.HibernateConfigurer;
import co.grandcircus.david.hibernate1.model.Course;
import co.grandcircus.david.hibernate1.model.Person;

public class FillDatabaseTest {
	
	private SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();
	
	@Test
	public void fillDatabase() {
		try (Session session = sessionFactory.openSession()) {
			Course javaCourse = new Course();
			javaCourse.setTitle("Java Bootcamp");
			Course jsCourse = new Course();
			jsCourse.setTitle("JavaScript Bootcamp");
			session.save(javaCourse);
			session.save(jsCourse);
			
			session.save(buildInstructor("Aisha", jsCourse));
			session.save(buildInstructor("David", javaCourse));
			
			session.save(buildStudent("Picasso", jsCourse));
			session.save(buildStudent("Van Gogh", jsCourse));
			session.save(buildStudent("Andy Warhol", jsCourse));
			session.save(buildStudent("Monet", jsCourse));
			session.save(buildStudent("Ansel Adams", jsCourse));
			
			session.save(buildStudent("Elisha Otis", javaCourse));
			session.save(buildStudent("Archimedes", javaCourse));
			session.save(buildStudent("Da Vinci", javaCourse));
			session.save(buildStudent("Gustave Eiffel", javaCourse));
			session.save(buildStudent("James Watt", javaCourse));
			session.save(buildStudent("Thomas Edison", javaCourse));
			session.save(buildStudent("Henry Ford", javaCourse));
		}
	}
	
	@Test
	public void clearDatabase() {
		try (Session session = sessionFactory.openSession()) {
			session.createQuery("delete from Person").executeUpdate();
			session.createQuery("delete from Course").executeUpdate();
		}
	}
	
	private Person buildStudent(String name, Course course) {
		Person person = new Person();
		person.setName(name);
		person.setInstructor(false);
		person.setCourseId(course.getId());
		return person;
	}
	
	private Person buildInstructor(String name, Course course) {
		Person person = new Person();
		person.setName(name);
		person.setInstructor(true);
		person.setCourseId(course.getId());
		return person;
	}

}
