package co.grandcircus.david.hibernate1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.david.hibernate1.dao.CourseDao;
import co.grandcircus.david.hibernate1.dao.DaoRegistry;
import co.grandcircus.david.hibernate1.dao.PersonDao;
import co.grandcircus.david.hibernate1.model.Course;

@Controller
public class CourseController {
	
	private CourseDao courseDao = DaoRegistry.getCourseDao();
	private PersonDao personDao = DaoRegistry.getPersonDao();

	@RequestMapping("/courses.html")
	public String listCourses(ModelMap model) {
		model.put("courses", courseDao.getAllCourses());
		return "course-list";
	}
	
	@RequestMapping(path = "/course.html", method = RequestMethod.GET)
	public String viewCourse(@RequestParam Integer courseId, ModelMap model) {
		Course course = courseDao.getById(courseId);
		model.put("course", course);
		model.put("instructor", personDao.getInstructorForCourse(courseId));
		model.put("students", personDao.getStudentsForCourse(courseId));
		return "course";
	}
}
