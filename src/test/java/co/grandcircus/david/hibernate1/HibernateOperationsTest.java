package co.grandcircus.david.hibernate1;

import org.junit.Test;

import co.grandcircus.david.hibernate1.dao.CourseDao;
import co.grandcircus.david.hibernate1.dao.DaoRegistry;
import co.grandcircus.david.hibernate1.dao.PersonDao;
import co.grandcircus.david.hibernate1.model.Course;
import co.grandcircus.david.hibernate1.model.Person;

public class HibernateOperationsTest {
	
	private PersonDao personDao = DaoRegistry.getPersonDao();
	private CourseDao courseDao = DaoRegistry.getCourseDao();
	
	@Test
	public void testAllTheOperations() {
		Course javaCourse = courseDao.getByTitle("Java Bootcamp");
		
		Person student = new Person();
		student.setName("Micky Mouse");
		student.setInstructor(false);
		student.setCourseId(javaCourse.getId());
		
		personDao.addPerson(student);
		System.out.println("Added: " + student);
		
		student.setName("Micky Mouse (TM)");
		personDao.updatePerson(student);
		System.out.println("Updated: " + student);
		
		student = personDao.getById(student.getId());
		System.out.println("Fetched: " + student);
		
		System.out.println("Students in course...");
		for (Person studentInClass : personDao.getStudentsForCourse(javaCourse.getId())) {
			System.out.println(studentInClass);
		}
		
		personDao.deletePerson(student.getId());
		System.out.println("Deleted: " + student);
		
	}

}
