package labwork2.controller;

import labwork2.model.Student;

public class DeleteStudentController {

	private int counter;
	
	public int deleteStudentFromTable(Student student, Labwork labwork) {
		counter = 0;
		if (student.getName() == null &&
		student.getSurname() == null &&
		student.getPatronymic() == null &&
		student.getCourse()== null &&
		student.getGroup() == null &&
		student.getWorks() == null &&
		student.getProgLanguage() == null) {
			for (int i = 0; i < labwork.getStudentsInTable().size(); i++) {
				labwork.getStudentsInTable().remove(i);
				counter++;
				i--;
			}
			
		} else {
			for (int i = 0; i < labwork.getStudentsInTable().size(); i++) {
				Student studentFromTable = labwork.getStudentsInTable().get(i);
				
				if(student.getName() != null) {
					if (studentFromTable.getName().equals(student.getName())) {
						labwork.getStudentsInTable().remove(i);
						counter++;
						i--;
					}
				} else if (student.getCourse() != null) {
					if (studentFromTable.getCourse().getCourseNumber() == student.getCourse().getCourseNumber()) {
						labwork.getStudentsInTable().remove(i);	
						counter++;
						i--;
					}				
				} else if (student.getGroup() != null) {
					if (studentFromTable.getGroup().getGroupNumber().equals(student.getGroup().getGroupNumber())) {
						labwork.getStudentsInTable().remove(i);
						counter++;
						i--;
					}					
				} else if (student.getWorks() != null ) {
					if (studentFromTable.getWorks().getWorksMax() == student.getWorks().getWorksMax()) {	
						labwork.getStudentsInTable().remove(i);	
						counter++;
						i--;
					}
					if (studentFromTable.getWorks().getWorksMade() == student.getWorks().getWorksMade()) {	
						labwork.getStudentsInTable().remove(i);
						counter++;
						i--;
					}
				} else if (student.getProgLanguage() != null) {
					if (studentFromTable.getProgLanguage().equals(student.getProgLanguage())) {
						labwork.getStudentsInTable().remove(i);	
						counter++;
						i--;
					}				
				}
				
			}
		}
		
		return counter;
	}
}
