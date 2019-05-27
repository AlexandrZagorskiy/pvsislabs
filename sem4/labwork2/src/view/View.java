package view;
import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
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
import labwork2.model.*;

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
				addWindow();
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
				new DeleteDialog(mainWindowShell, controller).nameOrGroupDeleteDialog(controller.getModel().getStudentsInTable());
				
			    tableComposite.showTable(controller.getModel().getStudentsInTable());
			}
		}); 
	    
	    courseOrLangDelete.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new DeleteDialog(mainWindowShell, controller).courseOrLangDeleteDialog(controller.getModel().getStudentsInTable());
			}
		}); 
	    
	    maxWorksOrMadeWorksDelete.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new DeleteDialog(mainWindowShell, controller).maxWorksOrMadeWorksDeleteDialog(controller.getModel().getStudentsInTable());
			}
		}); 
	    
	    undoWorksDelete.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new DeleteDialog(mainWindowShell, controller).undoWorksDeleteDialog(controller.getModel().getStudentsInTable());
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
				addRandomStudent();
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
	
	private void addRandomStudent() {
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
	
	private void addWindow() {

		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    
		Shell addStudentWindow = new Shell(this.mainWindowShell);
		addStudentWindow.setText("добавить студента");
		addStudentWindow.setLayout(gridLayout);
		addStudentWindow.setSize(240, 224);
	    
	    GridData gridDataButton = new GridData();
	    gridDataButton.horizontalAlignment = GridData.FILL;
		
		Label surnameLabel = new Label(addStudentWindow, SWT.NONE);
        Text surnameText = new Text(addStudentWindow, SWT.FILL);
        surnameLabel.setText("Фамилия: ");
        
        Label nameLabel = new Label(addStudentWindow, SWT.NONE);
        Text nameText = new Text(addStudentWindow, SWT.NONE);
        nameLabel.setText("Имя: ");
        
		Label patronymicLabel = new Label(addStudentWindow, SWT.NONE);
        Text patronymicText = new Text(addStudentWindow, SWT.NONE);
		patronymicLabel.setText("Отчество: ");

		Label courseLabel = new Label(addStudentWindow, SWT.NONE);
        Text courseText = new Text(addStudentWindow, SWT.NONE);
		courseLabel.setText("Курс: ");

		Label groupLabel = new Label(addStudentWindow, SWT.NONE);
        Text groupText = new Text(addStudentWindow, SWT.NONE);
		groupLabel.setText("Группа: ");

		Label worksMaxLabel = new Label(addStudentWindow, SWT.NONE);
        Text worksMaxText = new Text(addStudentWindow, SWT.NONE);
		worksMaxLabel.setText("Работ всего: ");

		Label worksMadeLabel = new Label(addStudentWindow, SWT.NONE);
        Text worksMadeText = new Text(addStudentWindow, SWT.NONE);
		worksMadeLabel.setText("Работ сделано: ");

		Label progLanguageLabel = new Label(addStudentWindow, SWT.NONE);
        Text progLanguageText = new Text(addStudentWindow, SWT.NONE);
		progLanguageLabel.setText("Язык программирования: ");
		
		Button addStudentButton = new Button(addStudentWindow, SWT.PUSH);
		addStudentButton.setLayoutData(gridDataButton);
		addStudentButton.setText("Добавить студента");
		
		Button cancelButton = new Button(addStudentWindow, SWT.PUSH);
		cancelButton.setLayoutData(gridDataButton);
		cancelButton.setText("Отмена");
				
		addStudentButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				
				String name = nameText.getText();
				String surname = surnameText.getText();
				String patronymic = patronymicText.getText();
				Course course = new Course(Integer.parseInt(courseText.getText()));
				StudGroup group = new StudGroup(groupText.getText());
				Works works = new Works(Integer.parseInt(worksMaxText.getText()), Integer.parseInt(worksMadeText.getText()));
				ProgLanguage progLanguage = new ProgLanguage(progLanguageText.getText());
				Student student = new Student(
						surname,
						name, 
						patronymic, 
						course, 
						group, 
						works, 
						progLanguage
						);
				
				controller.addStudentInTable(student);
				tableComposite.showTable(controller.getModel().getStudentsInTable());
			}
		});
		
		addStudentWindow.open();
	}
}