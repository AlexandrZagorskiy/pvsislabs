package labwork2.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private List<Student> studentsInTable;
	
	public Model(List<Student> studentsInTable) {
		this.studentsInTable = studentsInTable;
	}
	
	public void addStudentInTable(Student student) {
		this.studentsInTable.add(student);
	}
	
	public List<Student> findStudentInTable(Student student) {
		
		List<Student> findStudents = new ArrayList<Student>();
		
		if (student.getName() 		== null &&
		student.getSurname() 		== null &&
		student.getPatronymic() 	== null &&
		student.getCourse()			== null &&
		student.getGroup() 			== null &&
		student.getWorks() 			== null &&
		student.getProgLanguage()	== null) {
			for (int i = 0; i < this.studentsInTable.size(); i++) {
				findStudents.add(this.studentsInTable.get(i));
			}			
		} else {
			for (int i = 0; i < this.studentsInTable.size(); i++) {
				Student studentFromTable = this.studentsInTable.get(i);
				
				if(student.getName() != null) {
					if (studentFromTable.getName().equals(student.getName())) {
						findStudents.add(this.studentsInTable.get(i));
					}
				} else if (student.getCourse() != null) {
					if (studentFromTable.getCourse().getCourseNumber() == student.getCourse().getCourseNumber()) {
						findStudents.add(this.studentsInTable.get(i));
					}				
				} else if (student.getGroup() != null) {
					if (studentFromTable.getGroup().getGroupNumber().equals(student.getGroup().getGroupNumber())) {
						findStudents.add(this.studentsInTable.get(i));
					}					
				} else if (student.getWorks() != null ) {
					if (studentFromTable.getWorks().getWorksMax() == student.getWorks().getWorksMax()) {	
						findStudents.add(this.studentsInTable.get(i));
					}
					if (studentFromTable.getWorks().getWorksMade() == student.getWorks().getWorksMade()) {	
						findStudents.add(this.studentsInTable.get(i));
					}
				} else if (student.getProgLanguage() != null) {
					if (studentFromTable.getProgLanguage().equals(student.getProgLanguage())) {
						findStudents.add(this.studentsInTable.get(i));
					}				
				}				
			}
		}
		
		return findStudents;
	}
	
	public void deleteStudentFromTable(Student student) {
		
	}
	
	
	

	
	
	public List<Student> getStudentsInTable() {
		return studentsInTable;
	}

	public void setStudentsInTable(ArrayList<Student> studentsInTable) {
		this.studentsInTable = studentsInTable;
	}
}
