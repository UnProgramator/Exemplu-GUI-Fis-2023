package ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import ui.utilities.LayoutStack;

public class MainPage {

	protected Shell shell;
	
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
		
		LayoutStack.createInstance(shell);
		
		LayoutStack.getInstance().changeLayout(0);

	}
	
	private MainPage() {}
	
	private static MainPage _instance;
	
	public static MainPage getInstance() {
		if(_instance == null)
			_instance = new MainPage();
		return _instance;
	}
}
