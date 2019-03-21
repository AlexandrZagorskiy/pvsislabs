package labwork2.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class AddStudentWindow {

	public void showWindow(Display display) {
		//Display display = new Display();
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    
		Shell shell = new Shell(display);
		shell.setSize(640, 480);
		shell.setText("second labwork");
        shell.setLayout(gridLayout);
		
		Label surnameLabel = new Label(shell, SWT.NONE);
        Text surnameText = new Text(shell, SWT.NONE);
        surnameLabel.setText("Фамилия: ");
        
        Label nameLabel = new Label(shell, SWT.NONE);
        Text nameText = new Text(shell, SWT.NONE);
        nameLabel.setText("Имя: ");
        
		Label patronymicLabel = new Label(shell, SWT.NONE);
        Text patronymicText = new Text(shell, SWT.NONE);
		patronymicLabel.setText("Отчество: ");

		Label courseLabel = new Label(shell, SWT.NONE);
        Text courseText = new Text(shell, SWT.NONE);
		courseLabel.setText("Курс: ");

		Label groupLabel = new Label(shell, SWT.NONE);
        Text groupText = new Text(shell, SWT.NONE);
		groupLabel.setText("Группа: ");

		Label worksMaxLabel = new Label(shell, SWT.NONE);
        Text worksMaxText = new Text(shell, SWT.NONE);
		worksMaxLabel.setText("Работ всего: ");

		Label worksMadeLabel = new Label(shell, SWT.NONE);
        Text worksMadeText = new Text(shell, SWT.NONE);
		worksMadeLabel.setText("Работ сделано: ");

		Label progLanguageLabel = new Label(shell, SWT.NONE);
        Text progLanguageText = new Text(shell, SWT.NONE);
		progLanguageLabel.setText("Язык программирования: ");  
		
	}
}
