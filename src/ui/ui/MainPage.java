package ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;

public class MainPage {

	protected Shell shell;
	
	
	Composite[] layouts;
	int crtActive;
	StackLayout stack;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainPage window = MainPage.getInstance();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		stack = new StackLayout();
		shell.setLayout(stack);
		
		layouts = new Composite[3];
		
		layouts[0] = new MainMenu(shell, SWT.NONE);
		
		layouts[1] = new SqrtPage(shell, SWT.NONE);
		
		layouts[2] = new PowerPage(shell, SWT.NONE);
		
		changeLayout(0);

	}
	
	public void changeLayout(int winNumber) {
		layouts[crtActive].setVisible(!layouts[crtActive].isVisible());
		stack.topControl = layouts[winNumber];
		crtActive = winNumber;
		shell.layout();
	}
	
	private static MainPage _instance;
	
	public static MainPage getInstance() {
		if(_instance == null)
			_instance = new MainPage();
		return _instance;
	}
}
