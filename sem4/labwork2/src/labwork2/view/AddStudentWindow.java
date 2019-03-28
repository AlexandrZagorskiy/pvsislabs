package labwork2.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import labwork2.controller.*;
import labwork2.model.*;

public class AddStudentWindow {

	public void showWindow(Display display, Shell shell, Labwork labwork, MainWindow mainWindow) {

		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    
		Shell addStudentWindow = new Shell(shell);
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
		Button cancelButton = new Button(addStudentWindow, SWT.PUSH);
		addStudentButton.setLayoutData(gridDataButton);
		addStudentButton.setText("Add student");
		cancelButton.setLayoutData(gridDataButton);
		cancelButton.setText("Cancel");
				
		addStudentButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				
				String name = nameText.getText();
				String surname = surnameText.getText();
				String patronymic = patronymicText.getText();
				Course course = new Course(Integer.parseInt(courseText.getText()));
				Group group = new Group(groupText.getText());
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
				labwork.getAddStudentController().addStudentInTable(student, labwork);
				mainWindow.showTable(labwork.getStudentsInTable());
			}
		});
		
		addStudentWindow.open();
	}
}
