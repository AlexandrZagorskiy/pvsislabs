package labwork2.controller;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import labwork2.model.Student;
import labwork2.view.*;

public class AddStudentController {

	public void addStudentInTable(Student student, Table table) {
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(0,
				student.getFullName().getSurname() + " " +
				student.getFullName().getName() + " " +
				student.getFullName().getPatronymic()
				);
	    item.setText(1, Integer.toString(student.getCourse().getCourse()));
	    item.setText(2, student.getGroup().getGroup());
	    item.setText(3, Integer.toString(student.getWorks().getWorksMax()));
	    item.setText(4, Integer.toString(student.getWorks().getWorksMade()));
	    item.setText(5, student.getProgLanguage().getProgLanguage());
	    for (int i = 0; i < table.getColumnCount(); i++) {
		      table.getColumn(i).pack();
		    }
	    table.setSize(table.computeSize(SWT.DEFAULT, 200));
	}
}