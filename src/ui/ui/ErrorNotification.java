package ui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ErrorNotification extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private String errorText;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ErrorNotification(Shell parent, int style, String errorText) {
		super(parent, style);
		setText("SWT Dialog");
		this.errorText = errorText;
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(450, 300);
		shell.setText(getText());
		
		text = new Text(shell, SWT.BORDER);
		text.setEnabled(false);
		text.setEditable(false);
		text.setText(errorText);
		text.setBounds(10, 10, 401, 105);
		
		Button btnOk = new Button(shell, SWT.NONE);
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
			}
		});
		btnOk.setBounds(172, 175, 75, 25);
		btnOk.setText("OK");

	}

}
