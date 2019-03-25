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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import labwork2.controller.DeleteStudentController;
import labwork2.model.*;

public class DeleteStudentWindow {

	public void showWindow(Display display, Shell shell, Table table) {
		
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
        surnameText.setText(null);
        
        Label nameLabel = new Label(addStudentWindow, SWT.NONE);
        Text nameText = new Text(addStudentWindow, SWT.NONE);
        nameLabel.setText("Имя: ");
        nameText.setText(null);
        
		Label patronymicLabel = new Label(addStudentWindow, SWT.NONE);
        Text patronymicText = new Text(addStudentWindow, SWT.NONE);
		patronymicLabel.setText("Отчество: ");
		patronymicText.setText(null);
		
		Label courseLabel = new Label(addStudentWindow, SWT.NONE);
        Text courseText = new Text(addStudentWindow, SWT.NONE);
		courseLabel.setText("Курс: ");
		courseText.setText(null);
		
		Label groupLabel = new Label(addStudentWindow, SWT.NONE);
        Text groupText = new Text(addStudentWindow, SWT.NONE);
		groupLabel.setText("Группа: ");
		groupText.setText(null);
		
		Label worksMaxLabel = new Label(addStudentWindow, SWT.NONE);
        Text worksMaxText = new Text(addStudentWindow, SWT.NONE);
		worksMaxLabel.setText("Работ всего: ");
		worksMaxText.setText(null);
		
		Label worksMadeLabel = new Label(addStudentWindow, SWT.NONE);
        Text worksMadeText = new Text(addStudentWindow, SWT.NONE);
		worksMadeLabel.setText("Работ сделано: ");
		worksMadeText.setText(null);
		
		Label progLanguageLabel = new Label(addStudentWindow, SWT.NONE);
        Text progLanguageText = new Text(addStudentWindow, SWT.NONE);
		progLanguageLabel.setText("Язык программирования: ");
		progLanguageText.setText(null);
		
		Button deleteStudentButton = new Button(addStudentWindow, SWT.PUSH);
		Button cancelButton = new Button(addStudentWindow, SWT.PUSH);
		deleteStudentButton.setLayoutData(gridDataButton);
		deleteStudentButton.setText("Add student");
		cancelButton.setLayoutData(gridDataButton);
		cancelButton.setText("Cancel");
				
		deleteStudentButton.addSelectionListener (new SelectionAdapter() {
			
			StudentFullName studentFullName = null;
			StudentCourse studentCourse = null;
			StudentGroup studentGroup = null;
			StudentWorks studentWorks = null;
			ProgLanguage progLanguage = null;
			
			public void widgetSelected(SelectionEvent e) {
				
				if (surnameText.getText() != null &&
					nameText.getText() != null &&
					patronymicText.getText() != null) {					
					studentFullName = new StudentFullName(
						surnameText.getText(),
						nameText.getText(),
						patronymicText.getText()
						);
				} 
				
				if (courseText != null) {
					studentCourse = new StudentCourse(
						Integer.parseInt(courseText.getText())
						);
				}
				
				if (groupText != null) {
					studentGroup = new StudentGroup(groupText.getText());
				}
				
				if (worksMadeText != null || worksMaxText != null) {
					studentWorks = new StudentWorks(
						Integer.parseInt(worksMaxText.getText()),
						Integer.parseInt(worksMadeText.getText())
						);
				}
				
				if (progLanguageText != null) {
				   progLanguage = new ProgLanguage(progLanguageText.getText());
				}			
				
				Student student = new Student(
						studentFullName,
						studentCourse,
						studentGroup,
						studentWorks,
						progLanguage
						);
				new DeleteStudentController().deleteStudentFromTable(student, table);
			}
		});
		
		addStudentWindow.open();
	}
}
