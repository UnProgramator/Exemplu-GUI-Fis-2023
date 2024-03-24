package ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class PageMain extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public PageMain(Composite parent, int style) {
		super(parent, style);
		
		Button btnComputeSqareRoot = new Button(this, SWT.NONE);
		btnComputeSqareRoot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				PageManager.getInstance().changeLayout(1);
			}
		});
		btnComputeSqareRoot.setBounds(10, 26, 131, 25);
		btnComputeSqareRoot.setText("Compute Sqare Root");
		
		Button btnComputePower = new Button(this, SWT.NONE);
		btnComputePower.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				PageManager.getInstance().changeLayout(2);
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
