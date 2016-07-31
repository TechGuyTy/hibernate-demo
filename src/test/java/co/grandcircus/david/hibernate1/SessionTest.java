package co.grandcircus.david.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import co.grandcircus.david.hibernate1.config.HibernateConfigurer;
import co.grandcircus.david.hibernate1.model.Course;
import co.grandcircus.david.hibernate1.model.Person;

public class SessionTest {
	
	private SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();

	@Test
	public void testRollbackTransaction() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Course newCourse = new Course();
		newCourse.setTitle("Virtual Reality");
		session.save(newCourse);
		
		Person person = new Person();
		person.setName("Anonymous");
		person.setInstructor(true);
		person.setCourseId(newCourse.getId());
		session.save(newCourse);
		
		session.flush();
		
		transaction.rollback();
		session.close();
	}
}
