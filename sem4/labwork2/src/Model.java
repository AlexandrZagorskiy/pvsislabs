

import java.util.ArrayList;
import java.util.List;

import labwork2.model.*;

public class Model {

	private List<Student> studentsInTable;
	
	public Model(List<Student> studentsInTable) {
		this.studentsInTable = studentsInTable;
	}
	
	public void addStudentInTable(Student student) {
		this.studentsInTable.add(student);
	}
	
	public List<Student> findStudentInTable(Student student) {
		
		List<Student> foundStudents = new ArrayList<Student>();
		
		if (student.getName() == null &&
		student.getSurname() == null &&
		student.getPatronymic() == null &&
		student.getCourse()	== null &&
		student.getGroup() == null &&
		student.getWorks() == null &&
		student.getProgLanguage() == null) {
			for (int i = 0; i < this.studentsInTable.size(); i++) {
				foundStudents.add(this.studentsInTable.get(i));
			}			
		} else {
			for (int i = 0; i < this.studentsInTable.size(); i++) {
				Student studentFromTable = this.studentsInTable.get(i);
				
				if(student.getName() != null) {
					if (studentFromTable.getName().equals(student.getName())) {
						foundStudents.add(this.studentsInTable.get(i));
					}
				} else if (student.getCourse() != null) {
					if (studentFromTable.getCourse().getCourseNumber() == student.getCourse().getCourseNumber()) {
						foundStudents.add(this.studentsInTable.get(i));
					}				
				} else if (student.getGroup() != null) {
					if (studentFromTable.getGroup().getGroupNumber().equals(student.getGroup().getGroupNumber())) {
						foundStudents.add(this.studentsInTable.get(i));
					}					
				} else if (student.getWorks() != null ) {
					if (studentFromTable.getWorks().getWorksMax() == student.getWorks().getWorksMax()) {	
						foundStudents.add(this.studentsInTable.get(i));
					}
					if (studentFromTable.getWorks().getWorksMade() == student.getWorks().getWorksMade()) {	
						foundStudents.add(this.studentsInTable.get(i));
					}
				} else if (student.getProgLanguage() != null) {
					if (studentFromTable.getProgLanguage().equals(student.getProgLanguage())) {
						foundStudents.add(this.studentsInTable.get(i));
					}				
				}				
			}
		}		
		return foundStudents;
	}
	
	public List<Student> deleteStudentFromTable(Student student) {
		List<Student> delStudents = new ArrayList<Student>();
		delStudents = findStudentInTable(student);
		
		for (int i = 0; i < this.studentsInTable.size(); i++) {
			for(int x = 0; x < delStudents.size(); x++) {
				if(this.studentsInTable.get(i).equals(delStudents.get(x))) {
					this.studentsInTable.remove(i);
				}				
			}			
		}
		return delStudents;
	}

	
	public List<Student> getStudentsInTable() {
		return studentsInTable;
	}

	public void setStudentsInTable(List<Student> studentsInTable) {
		this.studentsInTable = studentsInTable;
	}
	
}
