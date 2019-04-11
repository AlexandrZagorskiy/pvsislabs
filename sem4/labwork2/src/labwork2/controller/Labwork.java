package labwork2.controller;

import java.util.ArrayList;
import java.util.List;

import labwork2.model.*;
import labwork2.view.View;

public class Labwork {	
	
	public static void main(String[] args) {
		
		List<Student> studentsInTable = new ArrayList<Student>();
		
		Controller controller = new Controller();
		Model model = new Model(studentsInTable);
		View view = new View();
//	    labwork.getStudentsInTable().add(new Student(
//	    		"������",
//	    		"�������",
//	    		"����������",
//	    		new Course(2),
//	    		new StudGroup("721703"), 
//	    		new Works(12, 4), 
//	    		new ProgLanguage("Java")
//	    		));
	    view.run(model);
	}
}

/*
 * ������� ������ � ��������:
 * - �� ��� �������� ��� ������;
 * - �� ����� ��� ����� ����������������;
 * - �� ���������� ����������� ����� ��� ������ ����� �����;
 */
