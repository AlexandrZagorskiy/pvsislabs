package view;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import controller.Controller;
import labwork2.model.Student;

public class TableComposite {
	
	List<Student> students;
	private Composite composite;
	private Table table;
	private Label tableInfo;
	private Button toStart;
	private Button toEnd;
	private Button next;
	private Button prev;
	private Button delRow;
	private Button addRow;
	private int currPage;
	private int maxPage;
	
	private int rowsCount;
	private int rowsMax;
	private int rowsMin;
	
	public TableComposite(Shell shell, List<Student> students) {
		this.students = students;
		this.composite = new Composite(shell, SWT.BORDER);	
		this.composite.setSize(shell.getSize());
		this.currPage = 1;
		this.rowsCount = 20;
		this.rowsMax = 25;
		this.rowsMin = 10;
		this.createTableComposite();
	}
	
	public TableComposite(Shell shell, Controller controller) {
		this.students = controller.getModel().getStudentsInTable();
		this.composite = new Composite(shell, SWT.BORDER);	
		this.composite.setSize(shell.getSize());
		this.currPage = 1;
		this.rowsCount = 20;
		this.rowsMax = 25;
		this.rowsMin = 10;
		this.createTableComposite();
	}
	
	public void createTableComposite() {
		GridData gridDataComposite = new GridData();
		gridDataComposite.horizontalSpan = 2;		
		GridData gridDataTable = new GridData();
		gridDataTable.horizontalSpan = 8;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 8;
		this.composite.setLayout(gridLayout);
		this.composite.setLayoutData(gridDataComposite);
		
		this.table = new Table(this.composite, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		this.table.setHeaderVisible(true);
		this.table.setLinesVisible(true);		
		this.table.setLayoutData(gridDataTable);
		
		this.toStart = new Button(this.composite, SWT.PUSH);
		this.toStart.setText(" <<< ");
		this.prev = new Button(this.composite, SWT.PUSH);
		this.prev.setText("   <   ");
		this.next = new Button(this.composite, SWT.PUSH);
		this.next.setText("   >   ");
		this.toEnd = new Button(this.composite, SWT.PUSH);
		this.toEnd.setText(" >>> ");
		Label emptySpace = new Label(this.composite, SWT.NONE);
	    emptySpace.setText("                         ");
	    this.addRow = new Button(this.composite, SWT.PUSH);
	    this.addRow.setText(" add row ");
	    this.delRow = new Button(this.composite, SWT.PUSH);
	    this.delRow.setText(" del row ");
	    this.tableInfo = new Label(this.composite, SWT.NONE);
	    
	    this.maxPage = 1;		
		
	    this.toStart.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				currPage = 1;
				showTable(students);
			}
		});
		
		prev.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (currPage != 1) {
					currPage--;
				}
				showTable(students);
			}
		});
		
		next.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (currPage != maxPage) {
					currPage++;
				}
				showTable(students);
			}
		});
		
		toEnd.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				currPage = maxPage;
				showTable(students);
			}
		});
				
		addRow.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (rowsCount != rowsMax) {
					rowsCount++;
				}
				showTable(students);
			}
		});
		
		delRow.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (rowsCount != rowsMin) {
					rowsCount--;
				}
				showTable(students);
			}
		});
		
		this.showTable(students);
	}
	
	public void showTable(List<Student> studentsInTable) {		
		table.clearAll();
		table.setItemCount(0);		
		maxPage = ((studentsInTable.size() - 1)/ rowsCount) + 1;
		
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
	    
	    int currStudMax = rowsCount*currPage;
	    int currStudMin = rowsCount*(currPage-1);
	    if (currStudMax > studentsInTable.size()) {
	    	currStudMax = studentsInTable.size();
	    }
	    
		for (int currStud = currStudMin; currStud < currStudMax; currStud++) {			
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
		table.setItemCount(rowsCount);
		
		for (int currColumn = 0; currColumn < titles.length; currColumn++) {
			table.getColumn(currColumn).pack();
		    }
		
		table.setSize(table.computeSize(SWT.DEFAULT, rowsCount*20));	
		tableInfo.setText("страница " + currPage +
				" из " + maxPage +
				" || студентов всего: " + studentsInTable.size());
		
		this.composite.pack();
		this.composite.layout();
		this.composite.redraw();
	}
	
	public void showFirstPage(List<Student> studentsInTable) {
		currPage = 1;
		showTable(studentsInTable);
	}
	
	public Composite getComposite() {
		return this.composite;
	}
}
