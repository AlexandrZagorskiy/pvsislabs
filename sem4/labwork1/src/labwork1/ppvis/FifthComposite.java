package labwork1.ppvis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class FifthComposite {

	public void createComposite(Shell shell) {
		Composite composite = null;
		GridLayout gridlayout = new GridLayout();
		gridlayout.numColumns = 4;
		composite = new Composite(shell, SWT.BORDER);
		composite.setLayout(gridlayout);
	
		GridData gridDataTextButtonA = new GridData();
		gridDataTextButtonA.horizontalAlignment = GridData.FILL;
		gridDataTextButtonA.horizontalSpan = 2;
		
		GridData gridDataTable = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);	  
		gridDataTable.horizontalAlignment = GridData.FILL;
		gridDataTable.horizontalSpan = 2;
		gridDataTable.verticalSpan = 3;	  
	
		Text text = new Text(composite, SWT.BORDER);
		text.setLayoutData(gridDataTextButtonA);
		
		Table table = new Table(composite, SWT.BORDER | SWT.V_SCROLL);
		table.setLayoutData(gridDataTable);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);	  
		
		Button buttonA = new Button(composite, SWT.PUSH);
		buttonA.setText("Add text in table");
		buttonA.setLayoutData(gridDataTextButtonA);
		
		Button buttonB = new Button(composite, SWT.PUSH);
		buttonB.setText("to second column");
		
		Button buttonC = new Button(composite, SWT.PUSH);
		buttonC.setText("to first column");
		
		TableColumn columnFirst = new TableColumn(table, SWT.LEFT);
		columnFirst.setText("First column");
		columnFirst.pack();
		
		TableColumn columnSecond = new TableColumn(table, SWT.LEFT);
		columnSecond.setText("Second column");
		columnSecond.pack();
	
		buttonA.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TableItem item = new TableItem(table, SWT.NONE);
				item.setText(0, text.getText());
				item.setText(1, "");
			}
		});
		
		buttonB.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TableItem[] selected = table.getSelection();
				if (!selected[0].getText().equals("")) {
					String text = selected[0].getText();
					selected[0].setText(1, text);
					selected[0].setText(0, "");
				}			
			}
		});
		
		buttonC.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TableItem[] selected = table.getSelection();
				if (selected[0].getText().equals("")) {
					String text = selected[0].getText(1);
					selected[0].setText(0, text);
					selected[0].setText(1, "");
				}			
			}
		});
	}	 

}
