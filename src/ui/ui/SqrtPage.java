package ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import logic.Mathematics;

public class SqrtPage extends Composite {
	
	private Text Input;
	private Text Output;
	private Text txtRezultat;
	private Button btnBack;
	
	public SqrtPage(Shell parent, int style) {
		super(parent, style);
		
		Button btnCompute = new Button(this, SWT.NONE);
		btnCompute.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				var input = Input.getText();
				try {
				var output = Mathematics.getInstance().getSqrt(input);	
								
				Output.setText(output);
				}
				catch(NumberFormatException er) {
					new ErrorNotification(parent, SWT.NONE, "The input text is not a number. Failed with error:\n" + er.getMessage()).open();
				}
			}
		});
		btnCompute.setBounds(10, 10, 75, 25);
		btnCompute.setText("Compute");
		
		Input = new Text(this, SWT.BORDER);
		Input.setBounds(91, 10, 76, 21);
		
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
				Input.setText("");
				Output.setText("");
				MainPage.getInstance().changeLayout(0);
			}
		});
		btnBack.setBounds(10, 88, 75, 25);
		btnBack.setText("Back");
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
