package view;

import java.util.List;

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

import controller.Controller;
import controller.Delete;
import labwork2.model.Student;

public class DeleteDialog {


	Controller controller;
	Shell mainWindowShell;
	TableComposite tableComposite;	
	GridLayout gridLayout;
	GridData gridDataLabel;
	GridData gridDataButton;

	public DeleteDialog(Shell mainWindowShell, Controller controller, TableComposite tableComposite) {
		this.controller = controller;
		this.mainWindowShell = mainWindowShell;
		this.tableComposite = tableComposite;
		this.gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    gridLayout.makeColumnsEqualWidth = true;		
		this.gridDataLabel = new GridData();
		gridDataLabel.horizontalAlignment = GridData.FILL;
		this.gridDataButton = new GridData();
		gridDataButton.horizontalAlignment = GridData.FILL;
		gridDataButton.horizontalSpan = 2;
	}

	public void nameOrGroupDeleteDialog(List<Student> students) {
		Shell nameOrGroupDeleteShell = new Shell(this.mainWindowShell);
		nameOrGroupDeleteShell.setText("�������� �� ��� �������� ��� ������");
		nameOrGroupDeleteShell.setLayout(gridLayout);
		
		Label surnameLabel = new Label(nameOrGroupDeleteShell, SWT.NONE);
		surnameLabel.setLayoutData(gridDataLabel);		
		surnameLabel.setText("�������:		");
		Text surnameText = new Text(nameOrGroupDeleteShell, SWT.NONE);
		surnameText.setLayoutData(gridDataLabel);
		
		Label nameLabel = new Label(nameOrGroupDeleteShell, SWT.NONE);
		nameLabel.setLayoutData(gridDataLabel);		
		nameLabel.setText("���:");
		Text nameText = new Text(nameOrGroupDeleteShell, SWT.NONE);
		nameText.setLayoutData(gridDataLabel);
		
		Label patronymicLabel = new Label(nameOrGroupDeleteShell, SWT.NONE);
		patronymicLabel.setLayoutData(gridDataLabel);		
		patronymicLabel.setText("��������:");
		Text patronymicText = new Text(nameOrGroupDeleteShell, SWT.NONE);
		patronymicText.setLayoutData(gridDataLabel);
		
		Label groupLabel = new Label(nameOrGroupDeleteShell, SWT.NONE);
		groupLabel.setLayoutData(gridDataLabel);	
		groupLabel.setText("������:");
		Text groupText = new Text(nameOrGroupDeleteShell, SWT.NONE);
		groupText.setLayoutData(gridDataLabel);
		
		Button searchButton = new Button(nameOrGroupDeleteShell, SWT.PUSH);
		searchButton.setLayoutData(gridDataButton);
		searchButton.setText("������� ���������");	
		
		searchButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String name = nameText.getText();
				String surname = surnameText.getText();
				String patronymic = patronymicText.getText();
				String group = groupText.getText();
				int studentsSizeBefore = students.size();
				new Delete(students).nameOrGroupDelete(name, surname, patronymic, group);
				tableComposite.showTable(students);
				resultDialog(studentsSizeBefore, students.size());
			}
		});

		nameOrGroupDeleteShell.pack();
		nameOrGroupDeleteShell.open();
	}

	public void courseOrLangDeleteDialog(List<Student> students) {
		Shell courseOrLangDeleteShell = new Shell(this.mainWindowShell);
		courseOrLangDeleteShell.setText("�������� �� ��� �������� ��� ������");
		courseOrLangDeleteShell.setLayout(gridLayout);
		
		Label courseLabel = new Label(courseOrLangDeleteShell, SWT.NONE);
		courseLabel.setLayoutData(gridDataLabel);		
		courseLabel.setText("����:");
		Text courseText = new Text(courseOrLangDeleteShell, SWT.NONE);
		courseText.setLayoutData(gridDataLabel);
		
		Label progLangLabel = new Label(courseOrLangDeleteShell, SWT.NONE);
		progLangLabel.setLayoutData(gridDataLabel);	
		progLangLabel.setText("���� ����������������:");
		Text progLangText = new Text(courseOrLangDeleteShell, SWT.NONE);
		progLangText.setLayoutData(gridDataLabel);
		
		Button searchButton = new Button(courseOrLangDeleteShell, SWT.PUSH);
		searchButton.setLayoutData(gridDataButton);
		searchButton.setText("����� ���������");
		
		searchButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String course = courseText.getText();
				String progLang = progLangText.getText();

				int studentsSizeBefore = students.size();
				new Delete(students).courseOrLangDelete(course, progLang);
				tableComposite.showTable(students);
				resultDialog(studentsSizeBefore, students.size());
			}
		});

		courseOrLangDeleteShell.pack();
		courseOrLangDeleteShell.open();
		
	}

	public void maxWorksOrMadeWorksDeleteDialog(List<Student> students) {
		Shell maxWorksOrMadeWorksDeleteShell = new Shell(this.mainWindowShell);
		maxWorksOrMadeWorksDeleteShell.setText("����� �� ���������� ����������� ����� ��� ������ ����� �����");
		maxWorksOrMadeWorksDeleteShell.setLayout(gridLayout);
		
		Label maxWorksLabel = new Label(maxWorksOrMadeWorksDeleteShell, SWT.NONE);
		maxWorksLabel.setLayoutData(gridDataLabel);		
		maxWorksLabel.setText("����� �����:");
		Text maxWorksText = new Text(maxWorksOrMadeWorksDeleteShell, SWT.NONE);
		maxWorksText.setLayoutData(gridDataLabel);
		
		Label madeWorksLabel = new Label(maxWorksOrMadeWorksDeleteShell, SWT.NONE);
		madeWorksLabel.setLayoutData(gridDataLabel);	
		madeWorksLabel.setText("����� ���������:");
		Text madeWorksText = new Text(maxWorksOrMadeWorksDeleteShell, SWT.NONE);
		madeWorksText.setLayoutData(gridDataLabel);
		
		Button searchButton = new Button(maxWorksOrMadeWorksDeleteShell, SWT.PUSH);
		searchButton.setLayoutData(gridDataButton);
		searchButton.setText("����� ���������");
		
		searchButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String maxWorks = maxWorksText.getText();
				String madeWorks = madeWorksText.getText();

				int studentsSizeBefore = students.size();
				new Delete(students).maxWorksOrMadeWorksDelete(maxWorks, madeWorks);
				tableComposite.showTable(students);
				resultDialog(studentsSizeBefore, students.size());
			}
		});
		
		maxWorksOrMadeWorksDeleteShell.pack();
		maxWorksOrMadeWorksDeleteShell.open();
	}

	public void undoWorksDeleteDialog(List<Student> students) {

		Shell undoWorksDeleteShell = new Shell(this.mainWindowShell);
		undoWorksDeleteShell.setText("����� �� ���������� �� ����������� �����");
		undoWorksDeleteShell.setLayout(gridLayout);
		
		Label undoWorksLabel = new Label(undoWorksDeleteShell, SWT.NONE);
		undoWorksLabel.setLayoutData(gridDataLabel);		
		undoWorksLabel.setText("����� �� ���������:		");
		Text undoWorksText = new Text(undoWorksDeleteShell, SWT.NONE);
		undoWorksText.setLayoutData(gridDataLabel);
		
		Button searchButton = new Button(undoWorksDeleteShell, SWT.PUSH);
		searchButton.setLayoutData(gridDataButton);
		searchButton.setText("����� ���������");
		
		searchButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				
				String undoWorks = undoWorksText.getText();

				int studentsSizeBefore = students.size();
				new Delete(students).undoWorksDelete(undoWorks);
				tableComposite.showTable(students);
				resultDialog(studentsSizeBefore, students.size());
			}
		});
		
		undoWorksDeleteShell.pack();
		undoWorksDeleteShell.open();
	}

	public void resultDialog(int wasStudentsSize, int nowStudentsSize) {
		int studentsRemoved = wasStudentsSize - nowStudentsSize;
		if (studentsRemoved != 0) {
			MessageBox messagebox = new MessageBox(mainWindowShell);
			messagebox.setMessage("���� ������� " + studentsRemoved + " ���������");
			messagebox.open();	
		} else {
			MessageBox messagebox = new MessageBox(mainWindowShell);
			messagebox.setMessage("�� ���� ������� ���������");
			messagebox.open();			
		}
	}
}
