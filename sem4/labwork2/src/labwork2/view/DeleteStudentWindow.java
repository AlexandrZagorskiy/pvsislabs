package labwork2.view;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import labwork2.controller.*;
import labwork2.model.*;

public class DeleteStudentWindow {

	public void showWindow(Shell shell, Labwork labwork, MainWindow mainWindow) {
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    gridLayout.makeColumnsEqualWidth = true;
	    
		Shell deleteStudentWindow = new Shell(shell);
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
		deleteStudentButton.setText("Delete student");
		cancelButton.setLayoutData(gridDataButton);
		cancelButton.setText("Cancel");
		
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
				ArrayList<String> snp = new ArrayList<String>();
				String name = null;
				String surname = null;
				String patronymic = null;
				Course course = null;
				StudGroup group = null;
				Works works = null;
				ProgLanguage progLang = null;
				
				if(inputLabel.getText() == "������� ��� ��������:") {					
					for(String retval : text.split(" ", 3)) {
						snp.add(retval);
					}					
					name = snp.get(0);
					surname = snp.get(1);
					patronymic = snp.get(2);					
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
				
				Student stud = new Student(
						surname,
						name,
						patronymic,
						course,
						group,
						works,
						progLang						
						);
				int countDelStudents = labwork.getDeleteStudentController().deleteStudentFromTable(stud, labwork);
				showResult(deleteStudentWindow, countDelStudents);
				mainWindow.showTable(labwork.getStudentsInTable());				
			}
		});
		
		deleteStudentWindow.open();
	}
	
	public void showResult(Shell shell, int countDelStudents) {
		MessageBox messagebox = new MessageBox(shell);
		if (countDelStudents == 0) {
			messagebox.setMessage("�� ������ �������� �� ������� ���������");
			
		}
		messagebox.setMessage("���� ������� " + countDelStudents + " ���������");
		messagebox.open();
	}
}
