package co.grandcircus.david.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import co.grandcircus.david.hibernate1.config.HibernateConfigurer;
import co.grandcircus.david.hibernate1.dao.DaoRegistry;
import co.grandcircus.david.hibernate1.dao.PersonDao;
import co.grandcircus.david.hibernate1.model.Course;
import co.grandcircus.david.hibernate1.model.Person;

public class SessionTest {
	
	private SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();
	private PersonDao personDao = DaoRegistry.getPersonDao();

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
		session.save(person);
		
		session.flush();
		
		System.out.println(session.get(Person.class, person.getId()));
		System.out.println(session.get(Course.class, newCourse.getId()));
		
		System.out.println("Rollback.");
		transaction.rollback();
		
		System.out.println(session.get(Person.class, person.getId()));
		System.out.println(session.get(Course.class, newCourse.getId()));
		
		session.close();
	}
	
	@Test
	public void sessionAttachment() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Person person = new Person();
		person.setName("Anonymous");
		person.setInstructor(false);
		person.setCourseId(1);
		session.save(person);
		System.out.println(session.get(Person.class, person.getId()));
		
		person.setName("New Name");
		
		transaction.commit();
		
		System.out.println(session.get(Person.class, person.getId()));
		session.close();
		
		person.setName("Yet another name.");
		
		System.out.println(personDao.getById(person.getId()));
		
		System.out.println(person);
	}
}
