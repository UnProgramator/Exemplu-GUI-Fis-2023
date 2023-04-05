package ui.utilities;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import ui.MainMenu;
import ui.PowerPage;
import ui.SqrtPage;

public class LayoutStack {
	int crtActive;
	StackLayout stack;
	Composite[] layouts;
	Shell shell;
	
	public LayoutStack(Shell shell) {
		this.shell = shell;
		stack = new StackLayout();
		shell.setLayout(stack);
		
		layouts = new Composite[3];
		
		layouts[0] = new MainMenu(shell, SWT.NONE);
		
		layouts[1] = new SqrtPage(shell, SWT.NONE);
		
		layouts[2] = new PowerPage(shell, SWT.NONE);
	}
	
	public void changeLayout(int winNumber) {
		layouts[crtActive].setVisible(!layouts[crtActive].isVisible());
		stack.topControl = layouts[winNumber];
		crtActive = winNumber;
		shell.layout();
	}
	
	private static LayoutStack _instance;
	
	public static void createInstance(Shell shell) {
		_instance = new LayoutStack(shell);
	}
	
	public static LayoutStack getInstance() {
		if(_instance == null)
			throw new RuntimeException("Stack not instanciated but used");
		return _instance;
	}
}
