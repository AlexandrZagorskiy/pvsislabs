

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import controller.GenerateRandomStudent;
import labwork2.model.*;

public class View {
	
	private Display display;
	private Shell mainWindowShell;
	private Menu menuBar;
	
	private Label tableInfo;
	private Table table;
	private Button toStart;
	private Button toEnd;
	private Button next;
	private Button prev;
	private int currPage;
	private int maxPage;
	private int rowsCount;
	
	
	private Controller controller;	
	
	public View(Controller controller) {
		this.display = new Display();		
		this.mainWindowShell = new Shell(this.display);		
		this.menuBar = new Menu(mainWindowShell, SWT.BAR);
		this.table = new Table(mainWindowShell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		this.controller = controller;
		this.currPage = 1;
		this.rowsCount = 20;
		this.tableInfo = new Label(mainWindowShell, SWT.NONE);
	}
	
	public void run(Model model) {
		
	    GridData gridDataTable = new GridData();
	    gridDataTable.horizontalSpan = 5;

		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 5;
	    
		this.mainWindowShell.setText("таблица");
		this.mainWindowShell.setLayout(gridLayout);
		
		MenuItem addStudent = new MenuItem(this.menuBar, SWT.CASCADE);
		addStudent.setText("Добавить студента");		
		MenuItem deleteStudent = new MenuItem(this.menuBar, SWT.CASCADE);
		deleteStudent.setText("Удалить студента");	
		MenuItem findStudent = new MenuItem(this.menuBar, SWT.CASCADE);
		findStudent.setText("Найти студента");	
		MenuItem saveFile = new MenuItem(this.menuBar, SWT.CASCADE);
		saveFile.setText("Сохранить");	
		MenuItem loadFile = new MenuItem(this.menuBar, SWT.CASCADE);
		loadFile.setText("Загрузить");
		MenuItem randomStudents = new MenuItem(this.menuBar, SWT.CASCADE);
		randomStudents.setText("Заполнить таблицу");
		MenuItem clearTable = new MenuItem(this.menuBar, SWT.CASCADE);
		clearTable.setText("Очистить таблицу");
		this.mainWindowShell.setMenuBar(this.menuBar);
		
		this.table.setHeaderVisible(true);
		this.table.setLinesVisible(true);
		
		table.setLayoutData(gridDataTable);
		showTable(model.getStudentsInTable(), this.table);
		
	    toStart = new Button(mainWindowShell, SWT.PUSH);
	    toStart.setText(" <<< ");
	    prev = new Button(mainWindowShell, SWT.PUSH);
	    prev.setText("   <   ");
	    next = new Button(mainWindowShell, SWT.PUSH);
	    next.setText("   >   ");
	    toEnd = new Button(mainWindowShell, SWT.PUSH);
	    toEnd.setText(" >>> ");
	    
		maxPage = 1;		
		
		toStart.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				currPage = 1;
				showTable(model.getStudentsInTable(), table);
			}
		});
		
		prev.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (currPage != 1) {
					currPage--;
				}
				showTable(model.getStudentsInTable(), table);
			}
		});
		
		next.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (currPage != maxPage) {
					currPage++;
				}
				showTable(model.getStudentsInTable(), table);
			}
		});
		
		toEnd.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				currPage = maxPage;
				showTable(model.getStudentsInTable(), table);
			}
		});
		
	    addStudent.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				addWindow(model);
			}
		});

	    deleteStudent.addSelectionListener (new SelectionAdapter() {
	    	public void widgetSelected(SelectionEvent e) {
				deleteWindow(model);
			}
		});	  
	    
	    findStudent.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				searchWindow(model);
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
				controller.save(model.getStudentsInTable(), dialog.getFileName());
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
				model.setStudentsInTable(controller.load(dialog.getFileName()));
				showTable(model.getStudentsInTable(), getTable());
			}
		});
	    
	    clearTable.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				model.setStudentsInTable(new ArrayList<>());
				showTable(model.getStudentsInTable(), getTable());
				MessageBox messagebox = new MessageBox(mainWindowShell);
				messagebox.setMessage("Таблица очищена");
				messagebox.open();
			}
		}); 
	    
	    randomStudents.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				addRandomStudent(model);
			}
		});
	    	
		mainWindowShell.open();
		while (!mainWindowShell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
	private void addRandomStudent(Model model) {
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
				
				new GenerateRandomStudent(Integer.parseInt(studentsCountText.getText()), model.getStudentsInTable());
				showTable(model.getStudentsInTable(), getTable());
			}
		});
		
		addRandomStudentWindow.open();
	}
	
	private void addWindow(Model model) {

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
				
				model.addStudentInTable(student);
				showTable(model.getStudentsInTable(), getTable());
			}
		});
		
		addStudentWindow.open();
	}
	
	private void deleteWindow(Model model) {
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    gridLayout.makeColumnsEqualWidth = true;
	    
		Shell deleteStudentWindow = new Shell(this.mainWindowShell);
		deleteStudentWindow.setText("удалить студента");
		deleteStudentWindow.setLayout(gridLayout);
		deleteStudentWindow.setSize(270, 215);
		
		GridData gridDataLabel = new GridData();
		gridDataLabel.horizontalAlignment = GridData.FILL;
		gridDataLabel.horizontalSpan = 2;
	    
	    GridData gridDataButton = new GridData();
	    gridDataButton.horizontalAlignment = GridData.FILL;

		Label label = new Label(deleteStudentWindow, SWT.NONE);
		label.setLayoutData(gridDataLabel);
		label.setText("                         Условия удаления:                         ");
		Button nameButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);
		nameButton.setLayoutData(gridDataButton);		
		nameButton.setText("ФИО");
		Button courseButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		courseButton.setLayoutData(gridDataButton);	
		courseButton.setText("Курс");
		Button groupButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		groupButton.setLayoutData(gridDataButton);	
		groupButton.setText("Группа");
		Button worksMaxButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		worksMaxButton.setLayoutData(gridDataButton);	
		worksMaxButton.setText("Работ всего");
		Button worksMadeButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		worksMadeButton.setLayoutData(gridDataButton);	
		worksMadeButton.setText("Работ выполнено");
		Button langButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		langButton.setLayoutData(gridDataButton);	
		langButton.setText("ЯП");
				
		Label inputLabel = new Label(deleteStudentWindow, SWT.NONE);
		inputLabel.setLayoutData(gridDataLabel);
		inputLabel.setText("Выберите условие                     ");
		Text inputText = new Text(deleteStudentWindow, SWT.NONE);
		inputText.setLayoutData(gridDataLabel);
		
		Button deleteStudentButton = new Button(deleteStudentWindow, SWT.PUSH);
		Button cancelButton = new Button(deleteStudentWindow, SWT.PUSH);
		deleteStudentButton.setLayoutData(gridDataButton);
		deleteStudentButton.setText("Удалить студентов");
		cancelButton.setLayoutData(gridDataButton);
		cancelButton.setText("Отмена");
		
		nameButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("Введите ФИО студента:");	
				inputLabel.redraw();				
			}			
		});
		courseButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("Введите курс студента:");		
				inputLabel.redraw();			
			}
		});
		groupButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("Введите номер группы студента:");	
				inputLabel.redraw();				
			}
		});
		worksMaxButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("Введите кол-во всех работ студента:");		
				inputLabel.redraw();			
			}
		});
		worksMadeButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("Введите кол-во выполненных работ студента:");	
				inputLabel.redraw();				
			}
		});
		langButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("Введите ЯП студента:");		
				inputLabel.redraw();			
			}
		});
				
		deleteStudentButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String text = inputText.getText();
				List<String> temp = new ArrayList<String>();
				String name = null;
				String surname = null;
				String patronymic = null;
				Course course = null;
				StudGroup group = null;
				Works works = null;
				ProgLanguage progLang = null;
				
				if(inputLabel.getText() == "Введите ФИО студента:") {					
					for(String retval : text.split(" ", 3)) {
						temp.add(retval);
					}					
					name = temp.get(0);
					surname = temp.get(1);
					patronymic = temp.get(2);					
				} else if (inputLabel.getText() == "Введите курс студента:") {
					course = new Course(Integer.parseInt(text));
				} else if (inputLabel.getText() == "Введите номер группы студента:") {
					group = new StudGroup(text);
				} else if (inputLabel.getText() == "Введите кол-во всех работ студента:") {
					works = new Works(Integer.parseInt(text), 0);
				} else if (inputLabel.getText() == "Введите кол-во выполненных работ студента:") {
					works = new Works(0, Integer.parseInt(text));
				} else if (inputLabel.getText() == "Введите ЯП студента:") {
					progLang = new ProgLanguage(text);
				}
				
				Student student = new Student(
						surname,
						name,
						patronymic,
						course,
						group,
						works,
						progLang						
						);				
				
				resultWindow(model.deleteStudentFromTable(student));
				showTable(model.getStudentsInTable(), getTable());			
			}
		});
		
		deleteStudentWindow.open();
	}

	private void searchWindow(Model model) {
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    gridLayout.makeColumnsEqualWidth = true;
	    
		Shell deleteStudentWindow = new Shell(this.mainWindowShell);
		deleteStudentWindow.setText("поиск студента");
		deleteStudentWindow.setLayout(gridLayout);
		deleteStudentWindow.setSize(270, 215);
		
		GridData gridDataLabel = new GridData();
		gridDataLabel.horizontalAlignment = GridData.FILL;
		gridDataLabel.horizontalSpan = 2;
	    
	    GridData gridDataButton = new GridData();
	    gridDataButton.horizontalAlignment = GridData.FILL;

		Label label = new Label(deleteStudentWindow, SWT.NONE);
		label.setLayoutData(gridDataLabel);
		label.setText("                          Условия поиска:                          ");
		Button nameButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);
		nameButton.setLayoutData(gridDataButton);		
		nameButton.setText("ФИО");
		Button courseButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		courseButton.setLayoutData(gridDataButton);	
		courseButton.setText("Курс");
		Button groupButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		groupButton.setLayoutData(gridDataButton);	
		groupButton.setText("Группа");
		Button worksMaxButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		worksMaxButton.setLayoutData(gridDataButton);	
		worksMaxButton.setText("Работ всего");
		Button worksMadeButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		worksMadeButton.setLayoutData(gridDataButton);	
		worksMadeButton.setText("Работ выполнено");
		Button langButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		langButton.setLayoutData(gridDataButton);	
		langButton.setText("ЯП");
				
		Label inputLabel = new Label(deleteStudentWindow, SWT.NONE);
		inputLabel.setLayoutData(gridDataLabel);
		inputLabel.setText("Выберите условие                     ");
		Text inputText = new Text(deleteStudentWindow, SWT.NONE);
		inputText.setLayoutData(gridDataLabel);
		
		Button searchStudentButton = new Button(deleteStudentWindow, SWT.PUSH);
		Button cancelButton = new Button(deleteStudentWindow, SWT.PUSH);
		searchStudentButton.setLayoutData(gridDataButton);
		searchStudentButton.setText("Найти студентов");
		cancelButton.setLayoutData(gridDataButton);
		cancelButton.setText("Отмена");
		
		nameButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("Введите ФИО студента:");	
				inputLabel.redraw();				
			}			
		});
		courseButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("Введите курс студента:");		
				inputLabel.redraw();			
			}
		});
		groupButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("Введите номер группы студента:");	
				inputLabel.redraw();				
			}
		});
		worksMaxButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("Введите кол-во всех работ студента:");		
				inputLabel.redraw();			
			}
		});
		worksMadeButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("Введите кол-во выполненных работ студента:");	
				inputLabel.redraw();				
			}
		});
		langButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("Введите ЯП студента:");		
				inputLabel.redraw();			
			}
		});
				
		searchStudentButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String text = inputText.getText();
				ArrayList<String> temp = new ArrayList<String>();
				String name = null;
				String surname = null;
				String patronymic = null;
				Course course = null;
				StudGroup group = null;
				Works works = null;
				ProgLanguage progLang = null;
				
				if(inputLabel.getText() == "Введите ФИО студента:") {					
					for(String retval : text.split(" ", 3)) {
						temp.add(retval);
					}					
					name = temp.get(0);
					surname = temp.get(1);
					patronymic = temp.get(2);					
				} else if (inputLabel.getText() == "Введите курс студента:") {
					course = new Course(Integer.parseInt(text));
				} else if (inputLabel.getText() == "Введите номер группы студента:") {
					group = new StudGroup(text);
				} else if (inputLabel.getText() == "Введите кол-во всех работ студента:") {
					works = new Works(Integer.parseInt(text), 0);
				} else if (inputLabel.getText() == "Введите кол-во выполненных работ студента:") {
					works = new Works(0, Integer.parseInt(text));
				} else if (inputLabel.getText() == "Введите ЯП студента:") {
					progLang = new ProgLanguage(text);
				}
				
				Student student = new Student(
						surname,
						name,
						patronymic,
						course,
						group,
						works,
						progLang						
						);
				
				resultWindow(model.findStudentInTable(student));
				showTable(model.getStudentsInTable(), getTable());			
			}
		});
		
		deleteStudentWindow.open();
	}
	
	private void showTable(List<Student> studentsInTable, Table table) {		
		table.clearAll();
		table.setItemCount(0);
		maxPage = (studentsInTable.size() / rowsCount) + 1;
		
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
		mainWindowShell.redraw();
		mainWindowShell.layout();
	}
	
	private void resultWindow(List<Student> students) {
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    gridLayout.makeColumnsEqualWidth = true;

		Shell resultWindowShell = new Shell(this.mainWindowShell);
	    resultWindowShell.setText("Результат");
	    resultWindowShell.setLayout(gridLayout);
	    resultWindowShell.setSize(270, 215);	
		
		Table resultTable = new Table(resultWindowShell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
		showTable(students, resultTable);
		resultWindowShell.open();
		
		MessageBox messagebox = new MessageBox(resultWindowShell);
		messagebox.setMessage("Было найдено " + students.size() + " студентов");
		messagebox.open();	
	}

	private Table getTable() {
		return table;
	}
	
}
