package co.grandcircus.david.hibernate1.model;

public class Person {
	
	private Integer id;
	private String name;
	private boolean isInstructor;
	private Integer courseId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isInstructor() {
		return isInstructor;
	}
	public void setInstructor(boolean isInstructor) {
		this.isInstructor = isInstructor;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	

}
