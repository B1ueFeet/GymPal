package com.vistas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class VFacturas {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VFacturas window = new VFacturas();
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
		shell.setSize(544, 503);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(22, 28, 55, 15);
		lblNewLabel.setText("Nombre:");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(22, 62, 55, 15);
		lblNewLabel_1.setText("Cédula / RUC");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(22, 94, 55, 15);
		lblNewLabel_2.setText("Celular");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(22, 130, 55, 15);
		lblNewLabel_3.setText("Direccion");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(22, 170, 55, 15);
		lblNewLabel_4.setText("Correo");
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setBounds(370, 10, 55, 15);
		lblNewLabel_5.setText("Factura N°: ");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(106, 28, 286, 23);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(106, 56, 286, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(106, 88, 286, 21);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(106, 124, 286, 21);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(106, 164, 286, 21);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(430, 45, 75, 25);
		btnNewButton.setText("New Button");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(430, 89, 75, 25);
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setBounds(440, 432, 75, 25);
		btnNewButton_2.setText("New Button");
		
		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.setBounds(350, 432, 75, 25);
		btnNewButton_3.setText("New Button");
		
		Button btnNewButton_4 = new Button(shell, SWT.NONE);
		btnNewButton_4.setBounds(262, 432, 75, 25);
		btnNewButton_4.setText("New Button");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(22, 202, 495, 208);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

	}
}
