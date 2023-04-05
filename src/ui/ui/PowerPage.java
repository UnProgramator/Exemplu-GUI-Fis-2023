package ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import logic.Mathematics;
import ui.utilities.LayoutStack;

public class PowerPage extends Composite {
	
	private Text InputBase;
	private Text Output;
	private Text txtRezultat;
	private Text InputPower;
	private Button btnBack;
	
	public PowerPage(Shell parent, int style) {
		super(parent, style);
		
		Button btnCompute = new Button(this, SWT.NONE);
		btnCompute.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				var base = InputBase.getText();
				var power = InputPower.getText();
				try {
				var output = Mathematics.getInstance().gerPow(base, power);	
								
				Output.setText(output);
				}
				catch(NumberFormatException er) {
					new ErrorNotification(parent, SWT.NONE, "The input text is not a number. Failed with error:\n" + er.getMessage()).open();
				}
			}
		});
		btnCompute.setBounds(10, 10, 75, 25);
		btnCompute.setText("Compute");
		
		InputBase = new Text(this, SWT.BORDER);
		InputBase.setBounds(91, 10, 76, 21);
		
		InputPower = new Text(this, SWT.BORDER);
		InputPower.setBounds(173, 10, 76, 21);
		
		Output = new Text(this, SWT.BORDER);
		Output.setBounds(91, 51, 76, 21);
		
		txtRezultat = new Text(this, SWT.BORDER);
		txtRezultat.setEnabled(false);
		txtRezultat.setEditable(false);
		txtRezultat.setText("Rezultat");
		txtRezultat.setBounds(10, 51, 76, 21);
		
		btnBack = new Button(this, SWT.NONE);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				InputBase.setText("");
				InputPower.setText("");
				Output.setText("");
				LayoutStack.getInstance().changeLayout(0);
			}
		});
		btnBack.setBounds(10, 78, 75, 25);
		btnBack.setText("Back");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
