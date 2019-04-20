

import java.util.ArrayList;
import java.util.List;

import labwork2.model.*;

public class Labwork {	
	
	public static void main(String[] args) {
		
		List<Student> studentsInTable = new ArrayList<Student>();

		Model model = new Model(studentsInTable);
		Controller controller = new Controller();
		View view = new View(controller);
	    model.addStudentInTable(new Student(
	    		"������",
	    		"�������",
	    		"����������",
	    		new Course(2),
	    		new StudGroup("721703"), 
	    		new Works(12, 4), 
	    		new ProgLanguage("Java")
	    		));
	    view.run(model);
	}
}

/*
 * ������� ������ � ��������:
 * - �� ��� �������� ��� ������;
 * - �� ����� ��� ����� ����������������;
 * - �� ���������� ����������� ����� ��� ������ ����� �����;
 */
