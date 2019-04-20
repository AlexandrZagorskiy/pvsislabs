package labwork2.model;

public class Course {
	
	int courseNumber;
	
	public Course(int courseNumber) {
		this.courseNumber = courseNumber;
	}
	
	public Course() {
		this.courseNumber = 0;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}
}
