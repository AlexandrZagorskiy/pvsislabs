package labwork1.ppvis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SecondComposite {
	
	public void createComposite(Shell shell) {
		Composite composite = null;
		GridLayout gridlayout = new GridLayout();	
		gridlayout.numColumns = 2;
		composite = new Composite(shell, SWT.BORDER);
		composite.setLayout(gridlayout);	
		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		
		Text text = new Text(composite, SWT.BORDER);
		text.setLayoutData(gridData);
		
		Button buttonA = new Button(composite, SWT.PUSH);		
		buttonA.setText("Add name");
	    
	    Button buttonB = new Button(composite, SWT.PUSH);		
		buttonB.setText("Swap names");
		
		buttonA.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				buttonB.setText(text.getText());
			}
        });
		
		buttonB.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String buttonAtext = buttonA.getText();
				buttonA.setText(buttonB.getText());
				buttonB.setText(buttonAtext);
			}
        });
	}
	
}
