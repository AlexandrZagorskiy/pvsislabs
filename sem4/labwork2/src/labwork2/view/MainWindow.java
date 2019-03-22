package labwork2.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class MainWindow {

	
	public void run() {

		Display display = new Display();
		
		Shell shell = new Shell(display);
		shell.setSize(640, 480);
		shell.setText("second labwork");
		shell.setLayout(new RowLayout(SWT.HORIZONTAL)); 
		
		Table table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
	    String[] titles = { " ФИО ", " Курс ", " Группа ", " Количество выполненных работ ", " Общее число работ ", " Язык программирования "};
	    for (int i = 0; i < titles.length; i++) {
	        TableColumn column = new TableColumn(table, SWT.NONE);
	        column.setText(titles[i]);
	    }
	    int count = 10;
	    for (int i = 0; i < count; i++) {
	      TableItem item = new TableItem(table, SWT.NONE);
	      item.setText(0, "x");
	      item.setText(1, "y");
	      item.setText(2, "!");
	      item.setText(3, "this stuff behaves the way I expect");
	      item.setText(4, "almost everywhere");
	      item.setText(5, "some.folder");
	      item.setText(6, "line " + i + " in nowhere");
	    }
	    for (int i = 0; i < titles.length; i++) {
	      table.getColumn(i).pack();
	    }
	    table.setSize(table.computeSize(SWT.DEFAULT, 200));
	    

	    new AddStudentWindow().showWindow(display, shell);
	    
	    
	    
	    shell.pack();		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
}


