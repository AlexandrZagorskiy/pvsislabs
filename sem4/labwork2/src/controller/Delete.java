package controller;

import java.util.ArrayList;
import java.util.List;

import labwork2.model.Student;

public class Delete {

	List<Student> students;
	List<Student> foundStudents;
	
	public Delete(List<Student> students) {
		this.students = students;
		this.foundStudents = new ArrayList<Student>();
	}
	
	public void nameOrGroupDelete(String name,	String surname,	String patronymic, String group) {
		this.foundStudents = new Search(students).nameOrGroupSearch(name, surname, patronymic, group);

		for (Student foundStudent : this.foundStudents) {
			for (int studentNum = 0 ; studentNum < students.size(); studentNum++) {
				if(foundStudent.equals(students.get(studentNum))) {
					students.remove(studentNum);
					studentNum--;
				}				
			}			
		}		
	}
	
	public List<Student> courseOrLangDelete(String course, String progLang){		
		this.foundStudents = new Search(students).courseOrLangSearch(course, progLang);

		for (Student foundStudent : this.foundStudents) {
			for (int studentNum = 0 ; studentNum < students.size(); studentNum++) {
				if(foundStudent.equals(students.get(studentNum))) {
					students.remove(studentNum);
					studentNum--;
				}				
			}			
		}
		return this.students;
	}
	
	public List<Student> maxWorksOrMadeWorksDelete(String maxWorks, String madeWorks){
		this.foundStudents = new Search(students).maxWorksOrMadeWorksSearch(maxWorks, madeWorks);

		for (Student foundStudent : this.foundStudents) {
			for (int studentNum = 0 ; studentNum < students.size(); studentNum++) {
				if(foundStudent.equals(students.get(studentNum))) {
					students.remove(studentNum);
					studentNum--;
				}				
			}			
		}		
		return this.students;
	}
	
	public List<Student> undoWorksDelete(String undoWorks){
		this.foundStudents = new Search(students).undoWorksSearch(undoWorks);

		for (Student foundStudent : this.foundStudents) {
			for (int studentNum = 0 ; studentNum < students.size(); studentNum++) {
				if(foundStudent.equals(students.get(studentNum))) {
					students.remove(studentNum);
					studentNum--;
				}				
			}			
		}		
		return this.students;
	}
}
