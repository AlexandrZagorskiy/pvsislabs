package controller;

import java.util.ArrayList;
import java.util.List;

import labwork2.model.*;

public class Search {

	List<Student> students;
	List<Student> foundStudents;
	
	public Search(List<Student> students) {
		this.students = students;
		this.foundStudents = new ArrayList<Student>();
	}
	
	public List<Student> nameOrGroupSearch(String name,	String surname,	String patronymic, String group) {

		if(name == "" || surname == "" || patronymic == "") {
			for(Student student : students) {
				if (student.getName().equals(name)) {
					this.foundStudents.add(student);				
				} else if (student.getSurname().equals(surname)) {
					this.foundStudents.add(student);				
				} else if (student.getPatronymic().equals(patronymic)) {
					this.foundStudents.add(student);				
				} else if (student.getGroup().getGroupNumber().equals(group)) {
					this.foundStudents.add(student);	
				}
			}
		} else {
			for(Student student : students) {
				if(student.getName().equals(name) && student.getSurname().equals(surname) && student.getPatronymic().equals(patronymic)) {
					this.foundStudents.add(student);
				} else if (student.getGroup().getGroupNumber().equals(group)) {
					this.foundStudents.add(student);	
				}					
			}
		}	
		
		return this.foundStudents;
	}
	
	public List<Student> courseOrLangSearch(String course, String progLang){		
		for(Student student : students) {
			if (student.getCourse().getCourseNumber() == Integer.parseInt(course)) {
				this.foundStudents.add(student);
				
			} else if (student.getProgLanguage().getProgLanguage().equals(progLang)) {
				this.foundStudents.add(student);
			}
		}
		return this.foundStudents;
	}
	
	public List<Student> maxWorksOrMadeWorksSearch(String maxWorks, String madeWorks){
		for(Student student : students) {
			if (student.getWorks().getWorksMax() == Integer.parseInt(maxWorks)) {
				this.foundStudents.add(student);
				
			} else if (student.getWorks().getWorksMade() == Integer.parseInt(madeWorks)) {
				this.foundStudents.add(student);
			}
		}
		return this.foundStudents;
	}
	
	public List<Student> undoWorksSearch(String undoWorks){
		for(Student student : students) {
			int temp = student.getWorks().getWorksMax() - student.getWorks().getWorksMade();
			if (temp == Integer.parseInt(undoWorks)) {
				this.foundStudents.add(student);
			}
		}
		return this.foundStudents;
	}
}
