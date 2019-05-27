

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import labwork2.model.*;
import view.View;

public class Labwork {	
	
	public static void main(String[] args) {
		
		List<Student> studentsInTable = new ArrayList<Student>();

		Model model = new Model(studentsInTable);
		Controller controller = new Controller(model);
		View view = new View(controller);
	    view.run();
	}
}

/*
 * ������� ������ � ��������:
 * - �� ��� �������� ��� ������;
 * - �� ����� ��� ����� ����������������;
 * - �� ���������� ����������� ����� ��� ������ ����� �����;
 */
