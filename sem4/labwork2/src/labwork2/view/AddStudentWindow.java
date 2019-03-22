package labwork2.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class AddStudentWindow {

	public void showWindow(Display display, Shell shell) {
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	  //  gridLayout.makeColumnsEqualWidth = true;
	    
	    GridData gridDataButton = new GridData();
	    gridDataButton.horizontalAlignment = GridData.FILL;
	    
	    Composite composite = new Composite(shell, SWT.NONE);
	    composite.setLayout(gridLayout);
		
		Label surnameLabel = new Label(composite, SWT.NONE);
        Text surnameText = new Text(composite, SWT.FILL);
        surnameLabel.setText("Фамилия: ");
        
        Label nameLabel = new Label(composite, SWT.NONE);
        Text nameText = new Text(composite, SWT.NONE);
        nameLabel.setText("Имя: ");
        
		Label patronymicLabel = new Label(composite, SWT.NONE);
        Text patronymicText = new Text(composite, SWT.NONE);
		patronymicLabel.setText("Отчество: ");

		Label courseLabel = new Label(composite, SWT.NONE);
        Text courseText = new Text(composite, SWT.NONE);
		courseLabel.setText("Курс: ");

		Label groupLabel = new Label(composite, SWT.NONE);
        Text groupText = new Text(composite, SWT.NONE);
		groupLabel.setText("Группа: ");

		Label worksMaxLabel = new Label(composite, SWT.NONE);
        Text worksMaxText = new Text(composite, SWT.NONE);
		worksMaxLabel.setText("Работ всего: ");

		Label worksMadeLabel = new Label(composite, SWT.NONE);
        Text worksMadeText = new Text(composite, SWT.NONE);
		worksMadeLabel.setText("Работ сделано: ");

		Label progLanguageLabel = new Label(composite, SWT.NONE);
        Text progLanguageText = new Text(composite, SWT.NONE);
		progLanguageLabel.setText("Язык программирования: ");
		
		Button addStudentButton = new Button(composite, SWT.PUSH);
		Button cancelButton = new Button(composite, SWT.PUSH);
		addStudentButton.setLayoutData(gridDataButton);
		cancelButton.setLayoutData(gridDataButton);
	}
}
