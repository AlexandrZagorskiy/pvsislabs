package view;
import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import controller.Controller;
import controller.GenerateRandomStudent;

public class View {
	 
	private Display display;
	private Shell mainWindowShell;
	private Menu menuBar;
	private TableComposite tableComposite;
	
	private Controller controller;	
	
	public View(Controller controller) {
		this.display = new Display();		
		this.mainWindowShell = new Shell(this.display);		
		this.menuBar = new Menu(mainWindowShell, SWT.BAR);
		this.controller = controller;
	}
	
	public void run() {
		
		this.mainWindowShell.setText("таблица");
		
		Menu fileSubmenu = new Menu(mainWindowShell, SWT.DROP_DOWN);
		MenuItem fileItem = new MenuItem(this.menuBar, SWT.CASCADE);
		fileItem.setText("Файл");				
		fileItem.setMenu(fileSubmenu);
		MenuItem saveFile = new MenuItem(fileSubmenu, SWT.CASCADE);
		saveFile.setText("Сохранить");	
		MenuItem loadFile = new MenuItem(fileSubmenu, SWT.CASCADE);
		loadFile.setText("Загрузить");
		
		Menu studentSubmenu = new Menu(mainWindowShell, SWT.DROP_DOWN);
		MenuItem studentItem = new MenuItem(this.menuBar, SWT.CASCADE);
		studentItem.setText("Студент");	
		studentItem.setMenu(studentSubmenu);
		MenuItem addStudent = new MenuItem(studentSubmenu, SWT.CASCADE);
		addStudent.setText("Добавить студента");
		
		Menu searchSubmenu = new Menu(mainWindowShell, SWT.DROP_DOWN);
		MenuItem findStudent = new MenuItem(studentSubmenu, SWT.CASCADE);
		findStudent.setText("Найти студента");
		findStudent.setMenu(searchSubmenu);
		MenuItem nameOrGroupSearch = new MenuItem(searchSubmenu, SWT.CASCADE);
		nameOrGroupSearch.setText("По ФИО или группе");
		MenuItem courseOrLangSearch = new MenuItem(searchSubmenu, SWT.CASCADE);
		courseOrLangSearch.setText("По курсу или языку программирования");
		MenuItem maxWorksOrMadeWorksSearch = new MenuItem(searchSubmenu, SWT.CASCADE);
		maxWorksOrMadeWorksSearch.setText("По количеству выполненных работ или общему числу работ");
		MenuItem undoWorksSearch = new MenuItem(searchSubmenu, SWT.CASCADE);
		undoWorksSearch.setText("По количеству не выполненных работ");
		
		Menu deleteSubmenu = new Menu(mainWindowShell, SWT.DROP_DOWN);
		MenuItem deleteStudent = new MenuItem(studentSubmenu, SWT.CASCADE);
		deleteStudent.setText("Удалить студента");	
		deleteStudent.setMenu(deleteSubmenu);
		MenuItem nameOrGroupDelete = new MenuItem(deleteSubmenu, SWT.CASCADE);
		nameOrGroupDelete.setText("По ФИО или группе");
		MenuItem courseOrLangDelete = new MenuItem(deleteSubmenu, SWT.CASCADE);
		courseOrLangDelete.setText("По курсу или языку программирования");
		MenuItem maxWorksOrMadeWorksDelete = new MenuItem(deleteSubmenu, SWT.CASCADE);
		maxWorksOrMadeWorksDelete.setText("По количеству выполненных работ или общему числу работ");
		MenuItem undoWorksDelete = new MenuItem(deleteSubmenu, SWT.CASCADE);
		undoWorksDelete.setText("По количеству не выполненных работ");
		
		Button button = new Button(this.mainWindowShell, SWT.PUSH);
		button.setText("hwerkghl");
		
		Menu tableSubmenu = new Menu(mainWindowShell, SWT.DROP_DOWN);
		MenuItem tableItem = new MenuItem(this.menuBar, SWT.CASCADE);
		tableItem.setText("Таблица");
		tableItem.setMenu(tableSubmenu);
		MenuItem fillTable = new MenuItem(tableSubmenu, SWT.CASCADE);
		fillTable.setText("Заполнить таблицу");
		MenuItem clearTable = new MenuItem(tableSubmenu, SWT.CASCADE);
		clearTable.setText("Очистить таблицу");
		
		this.mainWindowShell.setMenuBar(this.menuBar);	

		tableComposite = new TableComposite(this.mainWindowShell, this.controller.getModel().getStudentsInTable());
		
	    addStudent.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new AdditionDialog(mainWindowShell, controller, tableComposite);
			}
		});
	    
	    nameOrGroupSearch.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new SearchDialog(mainWindowShell).nameOrGroupSearchDialog(controller.getModel().getStudentsInTable());
			}
		}); 
	    
	    courseOrLangSearch.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new SearchDialog(mainWindowShell).courseOrLangSearchDialog(controller.getModel().getStudentsInTable());
			}
		}); 
	    
	    maxWorksOrMadeWorksSearch.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new SearchDialog(mainWindowShell).maxWorksOrMadeWorksSearchDialog(controller.getModel().getStudentsInTable());
			}
		}); 
	    
	    undoWorksSearch.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new SearchDialog(mainWindowShell).undoWorksSearchDialog(controller.getModel().getStudentsInTable());
			}
		}); 
	    
	    nameOrGroupDelete.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new DeleteDialog(mainWindowShell, controller, tableComposite).nameOrGroupDeleteDialog(controller.getModel().getStudentsInTable());
			}
		}); 
	    
	    courseOrLangDelete.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new DeleteDialog(mainWindowShell, controller, tableComposite).courseOrLangDeleteDialog(controller.getModel().getStudentsInTable());
			}
		}); 
	    
	    maxWorksOrMadeWorksDelete.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new DeleteDialog(mainWindowShell, controller, tableComposite).maxWorksOrMadeWorksDeleteDialog(controller.getModel().getStudentsInTable());
			}
		}); 
	    
	    undoWorksDelete.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new DeleteDialog(mainWindowShell, controller, tableComposite).undoWorksDeleteDialog(controller.getModel().getStudentsInTable());
			}
		}); 
	    
	    saveFile.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(mainWindowShell, SWT.SAVE);
			    dialog.setFilterNames(new String[] {"XML Files"});
			    dialog.setFilterExtensions(new String[] {"*.xml"});
			    dialog.setFilterPath("D:\\projects on Java\\LabPpvis\\sem4\\labwork2\\");
			    dialog.setFileName("students.xml");
			    dialog.open();			    
				controller.save(controller.getModel().getStudentsInTable(), dialog.getFileName());
			}
		});
	    
	    loadFile.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(mainWindowShell, SWT.OPEN);
			    dialog.setFilterNames(new String[] {"XML Files"});
			    dialog.setFilterExtensions(new String[] {"*.xml"});
			    dialog.setFilterPath("D:\\projects on Java\\LabPpvis\\sem4\\labwork2\\");
			    dialog.setFileName("students.xml");
			    dialog.open();
			    controller.getModel().setStudentsInTable(controller.load(dialog.getFileName()));
			    tableComposite.showTable(controller.getModel().getStudentsInTable());
			}
		});
	    
	    clearTable.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				controller.getModel().setStudentsInTable(new ArrayList<>());
				tableComposite.showTable(controller.getModel().getStudentsInTable());
				MessageBox messagebox = new MessageBox(mainWindowShell);
				messagebox.setMessage("Таблица очищена");
				messagebox.open();
			}
		}); 
	    
	    fillTable.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				addRandomStudentDialog();
			}
		});
		this.mainWindowShell.redraw();
		this.mainWindowShell.layout();
		
		this.mainWindowShell.open();

		while (!mainWindowShell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		display.dispose();
	}
	
	private void addRandomStudentDialog() {
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 1;
	    
		Shell addRandomStudentWindow = new Shell(this.mainWindowShell);
		addRandomStudentWindow.setLayout(gridLayout);
		addRandomStudentWindow.setText("добавить студента");
		addRandomStudentWindow.setSize(240, 224);
		
		Label studentsCountLabel = new Label(addRandomStudentWindow, SWT.NONE);
        Text studentsCountText = new Text(addRandomStudentWindow, SWT.NONE);
        studentsCountLabel.setText("Введите количество студентов, которых хотите добавить: ");
        
        Button addRandomStudentButton = new Button(addRandomStudentWindow, SWT.PUSH);
        addRandomStudentButton.setText("Добавить студента");
        
        Button cancelButton = new Button(addRandomStudentWindow, SWT.PUSH);
		cancelButton.setText("Отмена");
		
		addRandomStudentButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				
				new GenerateRandomStudent(Integer.parseInt(studentsCountText.getText()), controller.getModel().getStudentsInTable());
				tableComposite.showTable(controller.getModel().getStudentsInTable());
			}
		});
		
		addRandomStudentWindow.open();
	}
}