package com.vistas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class VPersonalM {

	protected Shell shell;
	private Table table;
	private Display display;

	/**
	 * Launch the application.
	 * @param args
	 */
	public VPersonalM(Display display) {
		// TODO Auto-generated constructor stub
		this.display = display;
		open();
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
		
		Label lblCargo = new Label(shell, SWT.NONE);
		lblCargo.setBounds(21, 34, 55, 15);
		lblCargo.setText("Cargo");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(101, 31, 186, 23);
		
		Button btnEliminar = new Button(shell, SWT.NONE);
		btnEliminar.setBounds(21, 85, 75, 25);
		btnEliminar.setText("Eliminar");
		
		Button btnActualizar = new Button(shell, SWT.NONE);
		btnActualizar.setBounds(156, 85, 75, 25);
		btnActualizar.setText("Actualizar");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(21, 134, 380, 110);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		Button btnVolver = new Button(shell, SWT.NONE);
		btnVolver.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				VPersonal personal = new VPersonal(display);
				do {
					if(personal.shell.isDisposed()) {
						shell.setVisible(true);
					}	
				}while(!personal.shell.isDisposed());
			}
		});
		btnVolver.setBounds(336, 85, 75, 25);
		btnVolver.setText("Volver");

	}
}
