package view;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import controller.Search;
import labwork2.model.Student;

public class SearchDialog {

	List<Student> foundStudents;

	Shell mainWindowShell;
	GridLayout gridLayout;
	GridData gridDataLabel;
	GridData gridDataButton;
	
	public SearchDialog(Shell mainWindowShell) {
		this.mainWindowShell = mainWindowShell;
		this.gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    gridLayout.makeColumnsEqualWidth = true;		
		this.gridDataLabel = new GridData();
		gridDataLabel.horizontalAlignment = GridData.FILL;
		this.gridDataButton = new GridData();
		gridDataButton.horizontalAlignment = GridData.FILL;
		gridDataButton.horizontalSpan = 2;
	}
	
	public void nameOrGroupSearchDialog(List<Student> students) {		
	    
		Shell nameOrGroupSearchShell = new Shell(this.mainWindowShell);
		nameOrGroupSearchShell.setText("поиск по ФИО студента или группе");
		nameOrGroupSearchShell.setLayout(gridLayout);
		
		Label surnameLabel = new Label(nameOrGroupSearchShell, SWT.NONE);
		surnameLabel.setLayoutData(gridDataLabel);		
		surnameLabel.setText("Фамилия:		");
		Text surnameText = new Text(nameOrGroupSearchShell, SWT.NONE);
		surnameText.setLayoutData(gridDataLabel);
		
		Label nameLabel = new Label(nameOrGroupSearchShell, SWT.NONE);
		nameLabel.setLayoutData(gridDataLabel);		
		nameLabel.setText("Имя:");
		Text nameText = new Text(nameOrGroupSearchShell, SWT.NONE);
		nameText.setLayoutData(gridDataLabel);
		
		Label patronymicLabel = new Label(nameOrGroupSearchShell, SWT.NONE);
		patronymicLabel.setLayoutData(gridDataLabel);		
		patronymicLabel.setText("Отчество:");
		Text patronymicText = new Text(nameOrGroupSearchShell, SWT.NONE);
		patronymicText.setLayoutData(gridDataLabel);
		
		Label groupLabel = new Label(nameOrGroupSearchShell, SWT.NONE);
		groupLabel.setLayoutData(gridDataLabel);	
		groupLabel.setText("Группа:");
		Text groupText = new Text(nameOrGroupSearchShell, SWT.NONE);
		groupText.setLayoutData(gridDataLabel);
		
		Button searchButton = new Button(nameOrGroupSearchShell, SWT.PUSH);
		searchButton.setLayoutData(gridDataButton);
		searchButton.setText("Найти студентов");	
		
		searchButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				searchButton.dispose();
				
				String name = nameText.getText();
				String surname = surnameText.getText();
				String patronymic = patronymicText.getText();
				String group = groupText.getText();
				
				foundStudents = new Search(students).nameOrGroupSearch(name, surname, patronymic, group);
				new TableComposite(nameOrGroupSearchShell, foundStudents);
				nameOrGroupSearchShell.pack();
			}
		});

		nameOrGroupSearchShell.pack();
		nameOrGroupSearchShell.open();
	}
	
	public void courseOrLangSearchDialog(List<Student> students) {
	    
		Shell courseOrLangSearchShell = new Shell(this.mainWindowShell);
		courseOrLangSearchShell.setText("поиск по курсу или языку программирования");
		courseOrLangSearchShell.setLayout(gridLayout);
		
		Label courseLabel = new Label(courseOrLangSearchShell, SWT.NONE);
		courseLabel.setLayoutData(gridDataLabel);		
		courseLabel.setText("Курс:");
		Text courseText = new Text(courseOrLangSearchShell, SWT.NONE);
		courseText.setLayoutData(gridDataLabel);
		
		Label progLangLabel = new Label(courseOrLangSearchShell, SWT.NONE);
		progLangLabel.setLayoutData(gridDataLabel);	
		progLangLabel.setText("Язык программирования:");
		Text progLangText = new Text(courseOrLangSearchShell, SWT.NONE);
		progLangText.setLayoutData(gridDataLabel);
		
		Button searchButton = new Button(courseOrLangSearchShell, SWT.PUSH);
		searchButton.setLayoutData(gridDataButton);
		searchButton.setText("Найти студентов");
		
		searchButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				searchButton.dispose();
				
				String course = courseText.getText();
				String progLang = progLangText.getText();
								
				foundStudents = new Search(students).courseOrLangSearch(course, progLang);
				new TableComposite(courseOrLangSearchShell, foundStudents);
				courseOrLangSearchShell.pack();
			}
		});
		
		courseOrLangSearchShell.pack();
		courseOrLangSearchShell.open();
		
	}
	
	public void maxWorksOrMadeWorksSearchDialog(List<Student> students) {
		Shell maxWorksOrMadeWorksSearchShell = new Shell(this.mainWindowShell);
		maxWorksOrMadeWorksSearchShell.setText("поиск по количеству выполненных работ или общему числу работ");
		maxWorksOrMadeWorksSearchShell.setLayout(gridLayout);
		
		Label maxWorksLabel = new Label(maxWorksOrMadeWorksSearchShell, SWT.NONE);
		maxWorksLabel.setLayoutData(gridDataLabel);		
		maxWorksLabel.setText("Работ всего:");
		Text maxWorksText = new Text(maxWorksOrMadeWorksSearchShell, SWT.NONE);
		maxWorksText.setLayoutData(gridDataLabel);
		
		Label madeWorksLabel = new Label(maxWorksOrMadeWorksSearchShell, SWT.NONE);
		madeWorksLabel.setLayoutData(gridDataLabel);	
		madeWorksLabel.setText("Работ выполнено:");
		Text madeWorksText = new Text(maxWorksOrMadeWorksSearchShell, SWT.NONE);
		madeWorksText.setLayoutData(gridDataLabel);
		
		Button searchButton = new Button(maxWorksOrMadeWorksSearchShell, SWT.PUSH);
		searchButton.setLayoutData(gridDataButton);
		searchButton.setText("Найти студентов");
		
		searchButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				searchButton.dispose();
				
				String maxWorks = maxWorksText.getText();
				String madeWorks = madeWorksText.getText();
				
				foundStudents = new Search(students).maxWorksOrMadeWorksSearch(maxWorks, madeWorks);
				new TableComposite(maxWorksOrMadeWorksSearchShell, foundStudents);
				maxWorksOrMadeWorksSearchShell.pack();
			}
		});
		
		maxWorksOrMadeWorksSearchShell.pack();
		maxWorksOrMadeWorksSearchShell.open();
	}
	
	public void undoWorksSearchDialog(List<Student> students) {
		Shell undoWorksSearchShell = new Shell(this.mainWindowShell);
		undoWorksSearchShell.setText("поиск по количеству не выполненных работ");
		undoWorksSearchShell.setLayout(gridLayout);
		
		Label undoWorksLabel = new Label(undoWorksSearchShell, SWT.NONE);
		undoWorksLabel.setLayoutData(gridDataLabel);		
		undoWorksLabel.setText("Работ не выполнено:		");
		Text undoWorksText = new Text(undoWorksSearchShell, SWT.NONE);
		undoWorksText.setLayoutData(gridDataLabel);
		
		Button searchButton = new Button(undoWorksSearchShell, SWT.PUSH);
		searchButton.setLayoutData(gridDataButton);
		searchButton.setText("Найти студентов");
		
		searchButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				searchButton.dispose();
				
				String undoWorks = undoWorksText.getText();
				
				foundStudents = new Search(students).undoWorksSearch(undoWorks);
				new TableComposite(undoWorksSearchShell, foundStudents);
				undoWorksSearchShell.pack();
			}
		});
		
		undoWorksSearchShell.pack();
		undoWorksSearchShell.open();
	}

}
