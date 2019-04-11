package labwork2.view;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import labwork2.model.*;

public class View {
	
	private Table table;
	private Display display;
	private Shell mainWindowShell;
	private Menu menuBar;
	
	
	public View() {
		this.display = new Display();		
		this.mainWindowShell = new Shell(this.display);		
		this.menuBar = new Menu(mainWindowShell, SWT.BAR);
		this.table = new Table(mainWindowShell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
	}
	
	public void run(Model model) {

		this.mainWindowShell.setText("�������");
		this.mainWindowShell.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		MenuItem addStudent = new MenuItem(this.menuBar, SWT.CASCADE);
		addStudent.setText("�������� ��������");		
		MenuItem deleteStudent = new MenuItem(this.menuBar, SWT.CASCADE);
		deleteStudent.setText("������� ��������");	
		MenuItem findStudent = new MenuItem(this.menuBar, SWT.CASCADE);
		findStudent.setText("����� ��������");	
		this.mainWindowShell.setMenuBar(this.menuBar);
		
		this.table.setHeaderVisible(true);
		this.table.setLinesVisible(true);
		
//		mainWindow.setTable(table);		
//	    mainWindow.showTable(labwork.getStudentsInTable());
	    
	    addStudent.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				showAddWindow(model);
			}
		});

	    deleteStudent.addSelectionListener (new SelectionAdapter() {
	    	public void widgetSelected(SelectionEvent e) {
				showDeleteWindow(model);
			}
		});	  
	    
	    findStudent.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				showSearchWindow(model);
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
	
	public void showAddWindow(Model model) {

		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    
		Shell addStudentWindow = new Shell(this.mainWindowShell);
		addStudentWindow.setText("�������� ��������");
		addStudentWindow.setLayout(gridLayout);
		addStudentWindow.setSize(240, 224);
	    
	    GridData gridDataButton = new GridData();
	    gridDataButton.horizontalAlignment = GridData.FILL;
		
		Label surnameLabel = new Label(addStudentWindow, SWT.NONE);
        Text surnameText = new Text(addStudentWindow, SWT.FILL);
        surnameLabel.setText("�������: ");
        
        Label nameLabel = new Label(addStudentWindow, SWT.NONE);
        Text nameText = new Text(addStudentWindow, SWT.NONE);
        nameLabel.setText("���: ");
        
		Label patronymicLabel = new Label(addStudentWindow, SWT.NONE);
        Text patronymicText = new Text(addStudentWindow, SWT.NONE);
		patronymicLabel.setText("��������: ");

		Label courseLabel = new Label(addStudentWindow, SWT.NONE);
        Text courseText = new Text(addStudentWindow, SWT.NONE);
		courseLabel.setText("����: ");

		Label groupLabel = new Label(addStudentWindow, SWT.NONE);
        Text groupText = new Text(addStudentWindow, SWT.NONE);
		groupLabel.setText("������: ");

		Label worksMaxLabel = new Label(addStudentWindow, SWT.NONE);
        Text worksMaxText = new Text(addStudentWindow, SWT.NONE);
		worksMaxLabel.setText("����� �����: ");

		Label worksMadeLabel = new Label(addStudentWindow, SWT.NONE);
        Text worksMadeText = new Text(addStudentWindow, SWT.NONE);
		worksMadeLabel.setText("����� �������: ");

		Label progLanguageLabel = new Label(addStudentWindow, SWT.NONE);
        Text progLanguageText = new Text(addStudentWindow, SWT.NONE);
		progLanguageLabel.setText("���� ����������������: ");
		
		Button addStudentButton = new Button(addStudentWindow, SWT.PUSH);
		Button cancelButton = new Button(addStudentWindow, SWT.PUSH);
		addStudentButton.setLayoutData(gridDataButton);
		addStudentButton.setText("�������� ��������");
		cancelButton.setLayoutData(gridDataButton);
		cancelButton.setText("������");
				
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
				showTable(model.getStudentsInTable());
			}
		});
		
		addStudentWindow.open();
	}
	
	public void showDeleteWindow(Model model) {
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    gridLayout.makeColumnsEqualWidth = true;
	    
		Shell deleteStudentWindow = new Shell(this.mainWindowShell);
		deleteStudentWindow.setText("������� ��������");
		deleteStudentWindow.setLayout(gridLayout);
		deleteStudentWindow.setSize(270, 215);
		
		GridData gridDataLabel = new GridData();
		gridDataLabel.horizontalAlignment = GridData.FILL;
		gridDataLabel.horizontalSpan = 2;
	    
	    GridData gridDataButton = new GridData();
	    gridDataButton.horizontalAlignment = GridData.FILL;

		Label label = new Label(deleteStudentWindow, SWT.NONE);
		label.setLayoutData(gridDataLabel);
		label.setText("                         ������� ��������:                         ");
		Button nameButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);
		nameButton.setLayoutData(gridDataButton);		
		nameButton.setText("���");
		Button courseButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		courseButton.setLayoutData(gridDataButton);	
		courseButton.setText("����");
		Button groupButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		groupButton.setLayoutData(gridDataButton);	
		groupButton.setText("������");
		Button worksMaxButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		worksMaxButton.setLayoutData(gridDataButton);	
		worksMaxButton.setText("����� �����");
		Button worksMadeButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		worksMadeButton.setLayoutData(gridDataButton);	
		worksMadeButton.setText("����� ���������");
		Button langButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		langButton.setLayoutData(gridDataButton);	
		langButton.setText("��");
				
		Label inputLabel = new Label(deleteStudentWindow, SWT.NONE);
		inputLabel.setLayoutData(gridDataLabel);
		inputLabel.setText("�������� �������                     ");
		Text inputText = new Text(deleteStudentWindow, SWT.NONE);
		inputText.setLayoutData(gridDataLabel);
		
		Button deleteStudentButton = new Button(deleteStudentWindow, SWT.PUSH);
		Button cancelButton = new Button(deleteStudentWindow, SWT.PUSH);
		deleteStudentButton.setLayoutData(gridDataButton);
		deleteStudentButton.setText("������� ���������");
		cancelButton.setLayoutData(gridDataButton);
		cancelButton.setText("������");
		
		nameButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("������� ��� ��������:");	
				inputLabel.redraw();				
			}			
		});
		courseButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("������� ���� ��������:");		
				inputLabel.redraw();			
			}
		});
		groupButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("������� ����� ������ ��������:");	
				inputLabel.redraw();				
			}
		});
		worksMaxButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("������� ���-�� ���� ����� ��������:");		
				inputLabel.redraw();			
			}
		});
		worksMadeButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("������� ���-�� ����������� ����� ��������:");	
				inputLabel.redraw();				
			}
		});
		langButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("������� �� ��������:");		
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
				
				if(inputLabel.getText() == "������� ��� ��������:") {					
					for(String retval : text.split(" ", 3)) {
						temp.add(retval);
					}					
					name = temp.get(0);
					surname = temp.get(1);
					patronymic = temp.get(2);					
				} else if (inputLabel.getText() == "������� ���� ��������:") {
					course = new Course(Integer.parseInt(text));
				} else if (inputLabel.getText() == "������� ����� ������ ��������:") {
					group = new StudGroup(text);
				} else if (inputLabel.getText() == "������� ���-�� ���� ����� ��������:") {
					works = new Works(Integer.parseInt(text), 0);
				} else if (inputLabel.getText() == "������� ���-�� ����������� ����� ��������:") {
					works = new Works(0, Integer.parseInt(text));
				} else if (inputLabel.getText() == "������� �� ��������:") {
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
				
				model.deleteStudentFromTable(student);
				showTable(model.getStudentsInTable());			
			}
		});
		
		deleteStudentWindow.open();
	}

	public void showSearchWindow(Model model) {
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    gridLayout.makeColumnsEqualWidth = true;
	    
		Shell deleteStudentWindow = new Shell(this.mainWindowShell);
		deleteStudentWindow.setText("����� ��������");
		deleteStudentWindow.setLayout(gridLayout);
		deleteStudentWindow.setSize(270, 215);
		
		GridData gridDataLabel = new GridData();
		gridDataLabel.horizontalAlignment = GridData.FILL;
		gridDataLabel.horizontalSpan = 2;
	    
	    GridData gridDataButton = new GridData();
	    gridDataButton.horizontalAlignment = GridData.FILL;

		Label label = new Label(deleteStudentWindow, SWT.NONE);
		label.setLayoutData(gridDataLabel);
		label.setText("                          ������� ������:                          ");
		Button nameButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);
		nameButton.setLayoutData(gridDataButton);		
		nameButton.setText("���");
		Button courseButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		courseButton.setLayoutData(gridDataButton);	
		courseButton.setText("����");
		Button groupButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		groupButton.setLayoutData(gridDataButton);	
		groupButton.setText("������");
		Button worksMaxButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		worksMaxButton.setLayoutData(gridDataButton);	
		worksMaxButton.setText("����� �����");
		Button worksMadeButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		worksMadeButton.setLayoutData(gridDataButton);	
		worksMadeButton.setText("����� ���������");
		Button langButton = new Button(deleteStudentWindow, SWT.PUSH | SWT.CENTER);	
		langButton.setLayoutData(gridDataButton);	
		langButton.setText("��");
				
		Label inputLabel = new Label(deleteStudentWindow, SWT.NONE);
		inputLabel.setLayoutData(gridDataLabel);
		inputLabel.setText("�������� �������                     ");
		Text inputText = new Text(deleteStudentWindow, SWT.NONE);
		inputText.setLayoutData(gridDataLabel);
		
		Button searchStudentButton = new Button(deleteStudentWindow, SWT.PUSH);
		Button cancelButton = new Button(deleteStudentWindow, SWT.PUSH);
		searchStudentButton.setLayoutData(gridDataButton);
		searchStudentButton.setText("����� ���������");
		cancelButton.setLayoutData(gridDataButton);
		cancelButton.setText("������");
		
		nameButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("������� ��� ��������:");	
				inputLabel.redraw();				
			}			
		});
		courseButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("������� ���� ��������:");		
				inputLabel.redraw();			
			}
		});
		groupButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("������� ����� ������ ��������:");	
				inputLabel.redraw();				
			}
		});
		worksMaxButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("������� ���-�� ���� ����� ��������:");		
				inputLabel.redraw();			
			}
		});
		worksMadeButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("������� ���-�� ����������� ����� ��������:");	
				inputLabel.redraw();				
			}
		});
		langButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				inputLabel.setText("������� �� ��������:");		
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
				
				if(inputLabel.getText() == "������� ��� ��������:") {					
					for(String retval : text.split(" ", 3)) {
						temp.add(retval);
					}					
					name = temp.get(0);
					surname = temp.get(1);
					patronymic = temp.get(2);					
				} else if (inputLabel.getText() == "������� ���� ��������:") {
					course = new Course(Integer.parseInt(text));
				} else if (inputLabel.getText() == "������� ����� ������ ��������:") {
					group = new StudGroup(text);
				} else if (inputLabel.getText() == "������� ���-�� ���� ����� ��������:") {
					works = new Works(Integer.parseInt(text), 0);
				} else if (inputLabel.getText() == "������� ���-�� ����������� ����� ��������:") {
					works = new Works(0, Integer.parseInt(text));
				} else if (inputLabel.getText() == "������� �� ��������:") {
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
				
				model.findStudentInTable(student);
				showTable(model.getStudentsInTable());			
			}
		});
		
		deleteStudentWindow.open();
	}
	
	public void showTable(List<Student> studentsInTable) {		
		this.table.clearAll();
		this.table.setItemCount(0);
		
		String[] titles = {
				" ��� ",
				" ���� ",
				" ������ ",
				" ����� ����� ����� ",
				" ���������� ����������� ����� ",
				" ���� ���������������� "
				};
		
	    for (int currColumn = 0; currColumn < titles.length; currColumn++) {
	        TableColumn column = new TableColumn(this.table, SWT.NONE);
	        column.setText(titles[currColumn]);
	    }
		
		for (int currStud = 0;
		currStud < studentsInTable.size();
		currStud++) {			
			TableItem item = new TableItem(this.table, SWT.NONE);
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
			this.table.getColumn(currColumn).pack();
		    }
		
		this.table.setSize(this.table.computeSize(SWT.DEFAULT, 200));
	}
	
	
}
