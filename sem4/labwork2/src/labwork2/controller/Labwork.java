package labwork2.controller;

import java.util.ArrayList;

import labwork2.model.Course;
import labwork2.model.Group;
import labwork2.model.ProgLanguage;
import labwork2.model.Student;
import labwork2.model.Works;
import labwork2.view.MainWindow;

public class Labwork {

	private DeleteStudentController deleteStudentController = new DeleteStudentController();
	private AddStudentController addStudentController = new AddStudentController();
	private ArrayList<Student> studentsInTable = new ArrayList<Student>();
	
	
	public static void main(String[] args) {
		Labwork labwork = new Labwork();
	    labwork.getStudentsInTable().add(new Student(
	    		"Шамрук",
	    		"Евгений",
	    		"Валерьевич",
	    		new Course(2),
	    		new Group("721703"), 
	    		new Works(12, 4), 
	    		new ProgLanguage("Java")
	    		));
	    
	    
		new MainWindow().run(labwork);
	}


	public DeleteStudentController getDeleteStudentController() {
		return deleteStudentController;
	}


	public AddStudentController getAddStudentController() {
		return addStudentController;
	}


	public ArrayList<Student> getStudentsInTable() {
		return studentsInTable;
	}


	public void setStudentsInTable(ArrayList<Student> studentsInTable) {
		this.studentsInTable = studentsInTable;
	}

}

/*
 * Условия поиска и удаления:
 * - по ФИО студента или группе;
 * - по курсу или языку программирования;
 * - по количеству выполненных работ или общему числу работ;
 */
