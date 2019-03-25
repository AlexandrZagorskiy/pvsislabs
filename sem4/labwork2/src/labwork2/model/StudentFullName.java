package labwork2.model;

public class StudentFullName {
	
	String surname;
	String name;	
	String patronymic;
	

	public StudentFullName(String surname, String name, String patronymic) {
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;  
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
