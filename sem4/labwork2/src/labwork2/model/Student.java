package labwork2.model;

public class Student {
	
	StudentFullName fullName;
	StudentCourse course;
	StudentGroup group;
	StudentWorks works;
	ProgLanguage progLanguage;
	
	public Student (StudentFullName studentFullName, StudentCourse course, StudentGroup group, StudentWorks works, ProgLanguage progLanguage) {
		this.fullName = studentFullName;
		this.course = course;
		this.group = group;
		this.works = works;
		this.progLanguage = progLanguage;
	}

	public StudentFullName getFullName() {
		return fullName;
	}

	public void setFullName(StudentFullName fullName) {
		this.fullName = fullName;
	}

	public StudentCourse getCourse() {
		return course;
	}

	public void setCourse(StudentCourse course) {
		this.course = course;
	}

	public StudentGroup getGroup() {
		return group;
	}

	public void setGroup(StudentGroup group) {
		this.group = group;
	}

	public StudentWorks getWorks() {
		return works;
	}

	public void setWorks(StudentWorks works) {
		this.works = works;
	}

	public ProgLanguage getProgLanguage() {
		return progLanguage;
	}

	public void setProgLanguage(ProgLanguage progLanguage) {
		this.progLanguage = progLanguage;
	}
}
