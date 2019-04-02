package labwork2.view;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import labwork2.controller.*;
import labwork2.model.*;


public class MainWindow {
	
	private Table table;
	private Display display;
	private Shell mainWindowShell;
	private Menu menuBar;
	private MainWindow mainWindow;
	
	public void run(Labwork labwork) {

		display = new Display();
		
		mainWindowShell = new Shell(display);
		mainWindowShell.setText("таблица");
		mainWindowShell.setLayout(new RowLayout(SWT.HORIZONTAL)); 
		
		mainWindow = new MainWindow();
		
		menuBar = new Menu(mainWindowShell, SWT.BAR);
		MenuItem addStudent = new MenuItem(menuBar, SWT.CASCADE);
		addStudent.setText("Добавить студента");		
		MenuItem deleteStudent = new MenuItem(menuBar, SWT.CASCADE);
		deleteStudent.setText("Удалить студента");	
		mainWindowShell.setMenuBar(menuBar);
		
		table = new Table(mainWindowShell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		mainWindow.setTable(table);		
	    mainWindow.showTable(labwork.getStudentsInTable());
	    
	    addStudent.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new AddStudentWindow().showWindow(mainWindowShell, labwork, mainWindow);
			}
		});

	    deleteStudent.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			    new DeleteStudentWindow().showWindow(mainWindowShell, labwork, mainWindow);
			}
		});	    
	    
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
		table.clearAll();
		table.setItemCount(0);
		
		String[] titles = {
				" ФИО ",
				" Курс ",
				" Группа ",
				" Общее число работ ",
				" Количество выполненных работ ",
				" Язык программирования "
				};
		
	    for (int currColumn = 0; currColumn < titles.length; currColumn++) {
	        TableColumn column = new TableColumn(table, SWT.NONE);
	        column.setText(titles[currColumn]);
	    }
		
		for (int currStud = 0;
		currStud < studentsInTable.size();
		currStud++) {			
			TableItem item = new TableItem(table, SWT.NONE);
		    Student student = studentsInTable.get(currStud);
		    item.setText(0,
				student.getSurname() + " " +
				student.getName() + " " +
				student.getPatronymic()
				);
			item.setText(1,
				Integer.toString(student.getCourse().getCourseNumber())
				);
			item.setText(2,
				student.getGroup().getGroupNumber()
				);
			item.setText(3,
				Integer.toString(student.getWorks().getWorksMax())
				);
			item.setText(4,
				Integer.toString(student.getWorks().getWorksMade())
				);
			item.setText(5,
				student.getProgLanguage().getProgLanguage()
				);			
		}

		for (int currColumn = 0; currColumn < titles.length; currColumn++) {
			table.getColumn(currColumn).pack();
		    }
		
		table.setSize(table.computeSize(SWT.DEFAULT, 200));
	}
}



