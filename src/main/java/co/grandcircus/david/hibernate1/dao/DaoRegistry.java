package co.grandcircus.david.hibernate1.dao;

public class DaoRegistry {
	
	private static PersonDao personDaoSingleton;
	private static CourseDao courseDaoSingleton;
	
	public static PersonDao getPersonDao() {
		if (personDaoSingleton == null) {
			personDaoSingleton = new PersonDaoImpl();
		}
		return personDaoSingleton;
	}

	public static CourseDao getCourseDao() {
		if (courseDaoSingleton == null) {
			courseDaoSingleton = new CourseDao();
		}
		return courseDaoSingleton;
	}
}
