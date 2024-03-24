package ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class PageManager {
	int crtActive;
	StackLayout stack;
	Composite[] layouts;
	Shell shell;
	
	public PageManager(Shell shell) {
		this.shell = shell;
		stack = new StackLayout();
		shell.setLayout(stack);
		
		layouts = new Composite[3];
		
		layouts[0] = new PageMain(shell, SWT.NONE);
		
		layouts[1] = new PageSqrt(shell, SWT.NONE);
		
		layouts[2] = new PagePower(shell, SWT.NONE);
	}
	
	public void changeLayout(int winNumber) {
		layouts[crtActive].setVisible(!layouts[crtActive].isVisible());
		stack.topControl = layouts[winNumber];
		crtActive = winNumber;
		shell.layout();
	}
	
	private static PageManager _instance;
	
	public static void createInstance(Shell shell) {
		if(_instance == null)
			_instance = new PageManager(shell);
		else
			throw new RuntimeException("PageManager already instantiated");
	}
	
	public static PageManager getInstance() {
		if(_instance == null)
			throw new RuntimeException("Stack not instanciated but used");
		return _instance;
	}
}
