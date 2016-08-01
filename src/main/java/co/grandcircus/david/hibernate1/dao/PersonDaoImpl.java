package co.grandcircus.david.hibernate1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.grandcircus.david.hibernate1.config.HibernateConfigurer;
import co.grandcircus.david.hibernate1.model.Person;

public class PersonDaoImpl implements PersonDao {
	
	private SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();

	@Override
	public Person getById(int id) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(Person.class, id);
		}
	}

	@Override
	public Person getPersonByName(String name) {
		Session session = sessionFactory.openSession();
		try {
			return session.createQuery("from Person where name = :name", Person.class)
				.setParameter("name", name)
				.getSingleResult();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Person> getInstructors() {
		Session session = sessionFactory.openSession();
		try {
			return session.createQuery("from Person where instructor = true order by name", Person.class)
				.getResultList();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Person> getStudents() {
		Session session = sessionFactory.openSession();
		try {
			return session.createQuery("from Person where instructor = false order by name", Person.class)
				.getResultList();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Person> getAllPeople() {
		Session session = sessionFactory.openSession();
		try {
			return session.createQuery("from Person", Person.class)
				.getResultList();
		} finally {
			session.close();
		}
	}

	@Override
	public Person getInstructorForCourse(int courseId) {
		Session session = sessionFactory.openSession();
		try {
			return session.createQuery("from Person where courseId = :courseId and instructor = true", Person.class)
				.setParameter("courseId", courseId)
				.getSingleResult();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Person> getStudentsForCourse(int courseId) {
		Session session = sessionFactory.openSession();
		try {
			return session.createQuery("from Person where courseId = :courseId and instructor = false", Person.class)
				.setParameter("courseId", courseId)
				.getResultList();
		} finally {
			session.close();
		}
	}

	@Override
	public void addPerson(Person person) {
		Session session = sessionFactory.openSession();
		Transaction transaction;
		try {
			transaction = session.beginTransaction();
			session.save(person);
			transaction.commit();
		} finally {
			session.close();
		}		
	}

	@Override
	public void updatePerson(Person person) {
		Session session = sessionFactory.openSession();
		Transaction transaction;
		try {
			transaction = session.beginTransaction();
			session.update(person);
			transaction.commit();
		} finally {
			session.close();
		}	
	}

	@Override
	public void deletePerson(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction;
		try {
			transaction = session.beginTransaction();
			Person person = session.get(Person.class, id);
			session.delete(person);
			session.flush();
			transaction.commit();
		} finally {
			session.close();
		}
	}
	

}
