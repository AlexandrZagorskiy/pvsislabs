package labwork2.controller;

import java.util.ArrayList;

import labwork2.model.Student;

public class SearchStudentController {
	//
	//��� �������� ���������� �� ������
	//
	public ArrayList<Student> findStudentInTable(Student student, Labwork labwork) {
		
		ArrayList<Student> findStudents = new ArrayList<Student>();
		
		if (student.getName() == null &&
		student.getSurname() == null &&
		student.getPatronymic() == null &&
		student.getCourse()== null &&
		student.getGroup() == null &&
		student.getWorks() == null &&
		student.getProgLanguage() == null) {
			for (int i = 0; i < labwork.getStudentsInTable().size(); i++) {
				findStudents.add(labwork.getStudentsInTable().get(i));
			}
			
		} else {
			for (int i = 0; i < labwork.getStudentsInTable().size(); i++) {
				Student studentFromTable = labwork.getStudentsInTable().get(i);
				
				if(student.getName() != null) {
					if (studentFromTable.getName().equals(student.getName())) {
						findStudents.add(labwork.getStudentsInTable().get(i));
					}
				} else if (student.getCourse() != null) {
					if (studentFromTable.getCourse().getCourseNumber() == student.getCourse().getCourseNumber()) {
						findStudents.add(labwork.getStudentsInTable().get(i));
					}				
				} else if (student.getGroup() != null) {
					if (studentFromTable.getGroup().getGroupNumber().equals(student.getGroup().getGroupNumber())) {
						findStudents.add(labwork.getStudentsInTable().get(i));
					}					
				} else if (student.getWorks() != null ) {
					if (studentFromTable.getWorks().getWorksMax() == student.getWorks().getWorksMax()) {	
						findStudents.add(labwork.getStudentsInTable().get(i));
					}
					if (studentFromTable.getWorks().getWorksMade() == student.getWorks().getWorksMade()) {	
						findStudents.add(labwork.getStudentsInTable().get(i));
					}
				} else if (student.getProgLanguage() != null) {
					if (studentFromTable.getProgLanguage().equals(student.getProgLanguage())) {
						findStudents.add(labwork.getStudentsInTable().get(i));
					}				
				}				
			}
		}
		
		return findStudents;
	}
}
