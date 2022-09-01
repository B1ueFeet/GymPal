package com.vistas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;

public class VPersonal {

	protected Shell shell;
	private Table table;
	private Display display;

	
	/**
	 * Launch the application.
	 * @param args
	 */
	public VPersonal(Display display) {
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
		shell.setSize(566, 459);
		shell.setText("Personal - GymPal");
		shell.setLayout(null);
		
		Label lblNombre = new Label(shell, SWT.NONE);
		lblNombre.setBounds(31, 21, 55, 15);
		lblNombre.setText("Nombre: ");
		
		Label lblCargo = new Label(shell, SWT.NONE);
		lblCargo.setBounds(282, 21, 55, 15);
		lblCargo.setText("Cargo: ");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(92, 21, 147, 23);
		
		Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setBounds(343, 21, 147, 23);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(31, 64, 459, 237);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		Button btnCambiar = new Button(shell, SWT.NONE);
		btnCambiar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				VPersonalM perMod = new VPersonalM(display);
				do {
					if(perMod.shell.isDisposed()) {
						shell.setVisible(true);
					}	
				}while(!perMod.shell.isDisposed());
				
			}
		});
		btnCambiar.setBounds(228, 335, 75, 25);
		btnCambiar.setText("Cambiar");
		
		Button btnVolver = new Button(shell, SWT.NONE);
		btnVolver.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				VPrincipal principal = new VPrincipal(display);
				do {
					if(principal.shell.isDisposed()) {
						shell.setVisible(true);
					}	
				}while(!principal.shell.isDisposed());
			}
		});
		btnVolver.setBounds(385, 335, 75, 25);
		btnVolver.setText("Volver");
		
		Button btnCrear = new Button(shell, SWT.NONE);
		btnCrear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				VPersonalCA perCrear = new VPersonalCA(display);
				do {
					if(perCrear.shell.isDisposed()) {
						shell.setVisible(true);
					}	
				}while(!perCrear.shell.isDisposed());
			}
		});
		btnCrear.setBounds(58, 335, 75, 25);
		btnCrear.setText("Crear");

	}
}
