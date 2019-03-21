package labwork1.ppvis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class FirstComposite {
	
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

		Button buttonAdd = new Button(composite, SWT.PUSH | SWT.CENTER);		
		buttonAdd.setText("Add");
		
		CCombo combo = new CCombo(composite, SWT.READ_ONLY | SWT.FLAT | SWT.BORDER);
		combo.setLayoutData(gridData);
		
		buttonAdd.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				combo.add(text.getText());
			}
		});	
	}

}
