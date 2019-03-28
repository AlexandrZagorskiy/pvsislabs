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

public class DeleteStudentWindow {

	public void showWindow(Display display, Shell shell, Labwork labwork, MainWindow mainWindow) {
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    
		Shell deleteStudentWindow = new Shell(shell);
		deleteStudentWindow.setLayout(gridLayout);
		deleteStudentWindow.setSize(240, 224);
	    
	    GridData gridDataButton = new GridData();
	    gridDataButton.horizontalAlignment = GridData.FILL;
		
		Label surnameLabel = new Label(deleteStudentWindow, SWT.NONE);
        Text surnameText = new Text(deleteStudentWindow, SWT.FILL);
        surnameLabel.setText("Фамилия: ");
        surnameText.setText("-");
        
        Label nameLabel = new Label(deleteStudentWindow, SWT.NONE);
        Text nameText = new Text(deleteStudentWindow, SWT.NONE);
        nameLabel.setText("Имя: ");
        nameText.setText("-");
        
		Label patronymicLabel = new Label(deleteStudentWindow, SWT.NONE);
        Text patronymicText = new Text(deleteStudentWindow, SWT.NONE);
		patronymicLabel.setText("Отчество: ");
		patronymicText.setText("-");
		
		Label courseLabel = new Label(deleteStudentWindow, SWT.NONE);
        Text courseText = new Text(deleteStudentWindow, SWT.NONE);
		courseLabel.setText("Курс: ");
		courseText.setText("-");
		
		Label groupLabel = new Label(deleteStudentWindow, SWT.NONE);
        Text groupText = new Text(deleteStudentWindow, SWT.NONE);
		groupLabel.setText("Группа: ");
		groupText.setText("-");
		
		Label worksMaxLabel = new Label(deleteStudentWindow, SWT.NONE);
        Text worksMaxText = new Text(deleteStudentWindow, SWT.NONE);
		worksMaxLabel.setText("Работ всего: ");
		worksMaxText.setText("-");
		
		Label worksMadeLabel = new Label(deleteStudentWindow, SWT.NONE);
        Text worksMadeText = new Text(deleteStudentWindow, SWT.NONE);
		worksMadeLabel.setText("Работ сделано: ");
		worksMadeText.setText("-");
		
		Label progLanguageLabel = new Label(deleteStudentWindow, SWT.NONE);
        Text progLanguageText = new Text(deleteStudentWindow, SWT.NONE);
		progLanguageLabel.setText("Язык программирования: ");
		progLanguageText.setText("-");
		
		Button deleteStudentButton = new Button(deleteStudentWindow, SWT.PUSH);
		Button cancelButton = new Button(deleteStudentWindow, SWT.PUSH);
		deleteStudentButton.setLayoutData(gridDataButton);
		deleteStudentButton.setText("Delete student");
		cancelButton.setLayoutData(gridDataButton);
		cancelButton.setText("Cancel");
				
		deleteStudentButton.addSelectionListener (new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				String surname = null;
				String name = null;
				String patronymic = null;
				Course course = null;
				Group group = null;
				Works works = null;
				ProgLanguage progLanguage = null;
				
				if (!surnameText.getText().equals("-") &&
					!nameText.getText().equals("-") &&
					!patronymicText.getText().equals("-")) {	
					
					surname = surnameText.getText();	
					name = nameText.getText();	
					patronymic = patronymicText.getText();							
				} 
				
				if (!courseText.getText().equals("-")) {
					course = new Course(
						Integer.parseInt(courseText.getText())
						);
				}
				
				if (!groupText.getText().equals("-")) {
					group = new Group(groupText.getText());
				}
				
				if (!worksMaxText.getText().equals("-") || !worksMadeText.getText().equals("-")) {
					works = new Works(
						Integer.parseInt(worksMaxText.getText()),
						Integer.parseInt(worksMadeText.getText())
						);
				}
				
				if (!progLanguageText.getText().equals("-")) {
				   progLanguage = new ProgLanguage(progLanguageText.getText());
				}			
				
				Student student = new Student(
						surname,
						name,
						patronymic,
						course,
						group,
						works,
						progLanguage
						);
				labwork.getDeleteStudentController().deleteStudentFromTable(student, labwork);
				mainWindow.showTable(labwork.getStudentsInTable());
			}
		});
		
		deleteStudentWindow.open();
	}
}
