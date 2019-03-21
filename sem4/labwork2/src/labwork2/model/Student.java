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
}
