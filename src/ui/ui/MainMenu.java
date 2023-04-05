package ui;

import org.eclipse.swt.widgets.Composite;

import ui.utilities.LayoutStack;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class MainMenu extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MainMenu(Composite parent, int style) {
		super(parent, style);
		
		Button btnComputeSqareRoot = new Button(this, SWT.NONE);
		btnComputeSqareRoot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				LayoutStack.getInstance().changeLayout(1);
			}
		});
		btnComputeSqareRoot.setBounds(10, 26, 131, 25);
		btnComputeSqareRoot.setText("Compute Sqare Root");
		
		Button btnComputePower = new Button(this, SWT.NONE);
		btnComputePower.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				LayoutStack.getInstance().changeLayout(2);
			}
		});
		
		btnComputePower.setBounds(10, 70, 131, 25);
		btnComputePower.setText("Compute Power");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
