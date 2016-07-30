package co.grandcircus.david.hibernate1.dao;

import java.util.List;

import co.grandcircus.david.hibernate1.model.Person;

public interface PersonDao {

	Person getById(int id);
	
	Person getPersonByName(String name);
	
	List<Person> getInstructors();
	
	List<Person> getStudents();
	
	List<Person> getAllPeople();
	
	Person getInstructorForCourse(int courseId);
	
	List<Person> getStudentsForCourse(int courseId);
	
	void addPerson(Person person);
	
	void updatePerson(Person person);
	
	void deletePerson(int id);
}
