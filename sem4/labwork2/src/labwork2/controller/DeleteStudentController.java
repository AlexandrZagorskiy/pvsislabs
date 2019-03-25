package labwork2.controller;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import labwork2.model.Student;

public class DeleteStudentController {

	public void deleteStudentFromTable(Student student, Table table) {
		TableItem item;
		
		if (student.getFullName() == null &&
		student.getCourse()== null &&
		student.getGroup() == null &&
		student.getWorks() == null &&
		student.getProgLanguage() == null) {
					
			
			
		} else {
			for (int i = 1; i < table.getItemCount(); i++) {
				item = table.getItem(i);
			}
		}
			
		
	}
}
