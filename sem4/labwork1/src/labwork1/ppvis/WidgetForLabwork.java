package labwork1.ppvis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class WidgetForLabwork {

	static int counter = 1;
	static boolean isRun = false;

	public static void main(String[] args) {

		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setSize(640, 480);
		shell.setText("Widgets for labwork");
		shell.setLayout(new RowLayout(SWT.HORIZONTAL));

		WidgetForLabwork widget = new WidgetForLabwork();

		shell.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				if (e.character == 'c') {
					widget.clearComposites(shell);
					widget.createComposites(shell);
					shell.redraw();
				}

				if (e.character == 'z') {
					
					new Thread(new Runnable() {
					      public void run() {
					    	 isRun = true;
					         while (isRun) {
					            try { Thread.sleep(1000); } catch (Exception e) { }
					            Display.getDefault().asyncExec(new Runnable() {
					               public void run() {
					            	   widget.swapComposites(widget, shell);
					               }
					            });
					         }
					      }
					   }).start();					
					
				}
				
				if (e.character == 'x') {
					isRun = false;
				}
				
				shell.layout();
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		widget.showComposites(shell, display);
	}

	public void createComposites(Shell shell) {
		FirstComposite first = new FirstComposite();
		SecondComposite second = new SecondComposite();
		ThirdComposite third = new ThirdComposite();
		ForthComposite forth = new ForthComposite();
		FifthComposite fifth = new FifthComposite();

		first.createComposite(shell);
		second.createComposite(shell);
		third.createComposite(shell);
		forth.createComposite(shell);
		fifth.createComposite(shell);
	}
	
	public void createComposites(Shell shell, int counter) {
		if(counter == 1) {
			FirstComposite first = new FirstComposite();			
			first.createComposite(shell);			
		}
		if(counter == 2) {
			SecondComposite second = new SecondComposite();
			second.createComposite(shell);		
		}
		if(counter == 3) {
			ThirdComposite third = new ThirdComposite();
			third.createComposite(shell);	
		}
		if(counter == 4) {
			ForthComposite forth = new ForthComposite();
			forth.createComposite(shell);
		}
		if(counter == 5) {
			FifthComposite fifth = new FifthComposite();
			fifth.createComposite(shell);
		}
	}

	public void clearComposites(Shell shell) {
		for (Control kid : shell.getChildren()) {
			kid.dispose();
		}

	}

	public void showComposites(Shell shell, Display display) {
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	public void swapComposites(WidgetForLabwork widget, Shell shell) {
		widget.clearComposites(shell);
		widget.createComposites(shell, counter);
		counter++;
		if (counter == 6) {
			counter = 1;
		}
		shell.redraw();
		shell.layout();
	}
}
//почему статик ? философия джава
// 2 хоткея, первый поочерёдно показывает композиты, второй возвращает в исходное положение
