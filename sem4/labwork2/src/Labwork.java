

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
 * Условия поиска и удаления:
 * - по ФИО студента или группе;
 * - по курсу или языку программирования;
 * - по количеству выполненных работ или общему числу работ;
 */
