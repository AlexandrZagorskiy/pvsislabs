package labwork2.controller;

import labwork2.model.Student;

public class AddStudentController {

	public void addStudentInTable(Student student, Labwork labwork) {
		labwork.getStudentsInTable().add(student);
	}
}