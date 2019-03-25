package labwork2.view;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import labwork2.model.Student;


public class MainWindow {
	
	Table table;
	Display display;
	Shell mainWindowShell;
	Menu menuBar;
	
	public void run() {

		display = new Display();
		
		mainWindowShell = new Shell(display);
		mainWindowShell.setText("second labwork");
		mainWindowShell.setLayout(new RowLayout(SWT.HORIZONTAL)); 
		
		menuBar = new Menu(mainWindowShell, SWT.BAR);
		MenuItem addStudent = new MenuItem(menuBar, SWT.CASCADE);
		addStudent.setText("Добавить студента");
		
		
		table = new Table(mainWindowShell,
				SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
	    
	    
	    ArrayList<Student> studentsInTable = new ArrayList<Student>();	
	    
	    
	    

	    new AddStudentWindow().showWindow(display, mainWindowShell, table);
	    
	    
	    mainWindowShell.setMenuBar(menuBar);
	    mainWindowShell.pack();		
		mainWindowShell.open();
		while (!mainWindowShell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
	public Table getTable() {
		return this.table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
	
	public void showTable(ArrayList<Student> studentsInTable) {
		String[] titles = {
				" ФИО ",
				" Курс ",
				" Группа ",
				" Количество выполненных работ ",
				" Общее число работ ",
				" Язык программирования "
				};
	    for (int currColumn = 0; currColumn < titles.length; currColumn++) {
	        TableColumn column = new TableColumn(table, SWT.NONE);
	        column.setText(titles[currColumn]);
	    }
		
		for (int currStud = 0; currStud < studentsInTable.size(); currStud++) {
			TableItem item = new TableItem(table, SWT.NONE);
		    Student student = studentsInTable.get(currStud);
		    item.setText(0,
				student.getFullName().getSurname() + " " +
				student.getFullName().getName() + " " +
				student.getFullName().getPatronymic()
				);
			item.setText(1,
				Integer.toString(student.getCourse().getCourse()));
			item.setText(2,
				student.getGroup().getGroup());
			item.setText(3,
				Integer.toString(student.getWorks().getWorksMax()));
			item.setText(4,
				Integer.toString(student.getWorks().getWorksMade()));
			item.setText(5,
				student.getProgLanguage().getProgLanguage());			
		}

		for (int currColumn = 0; currColumn < titles.length; currColumn++) {
		      table.getColumn(currColumn).pack();
		    }
		
		table.setSize(table.computeSize(SWT.DEFAULT, 200));
	}
}



