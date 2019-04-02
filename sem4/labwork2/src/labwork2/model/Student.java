package labwork2.model;

public class Student {
	
	String surname;
	String name;	
	String patronymic;
	Course course;
	StudGroup group;
	Works works;
	ProgLanguage progLanguage;
	
	public Student (String surname, String name, String patronymic, Course course, StudGroup group, Works works, ProgLanguage progLanguage) {
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.course = course;
		this.group = group;
		this.works = works;
		this.progLanguage = progLanguage;
	}



	public void setFullName(String surname, String name, String patronymic) {
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public StudGroup getGroup() {
		return group;
	}

	public void setGroup(StudGroup group) {
		this.group = group;
	}

	public Works getWorks() {
		return works;
	}

	public void setWorks(Works works) {
		this.works = works;
	}

	public ProgLanguage getProgLanguage() {
		return progLanguage;
	}

	public void setProgLanguage(ProgLanguage progLanguage) {
		this.progLanguage = progLanguage;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPatronymic() {
		return patronymic;
	}



	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
}
