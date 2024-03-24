package ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class AplicationFrame {

	protected Shell shell;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AplicationFrame window = AplicationFrame.getInstance();
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
		
		PageManager.createInstance(shell);
		
		PageManager.getInstance().changeLayout(0);

	}
	
	private AplicationFrame() {}
	
	private static AplicationFrame _instance;
	
	public static AplicationFrame getInstance() {
		if(_instance == null)
			_instance = new AplicationFrame();
		return _instance;
	}
}
