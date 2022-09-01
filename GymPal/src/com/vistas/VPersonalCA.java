package com.vistas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class VPersonalCA {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Display display;

	/**
	 * Launch the application.
	 * @param args
	 */
	public VPersonalCA(Display display) {
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
		
		Label lblPrimernombre = new Label(shell, SWT.NONE);
		lblPrimernombre.setBounds(10, 10, 86, 15);
		lblPrimernombre.setText("1er Nombre");
		
		Label lbldoNombre = new Label(shell, SWT.NONE);
		lbldoNombre.setBounds(10, 38, 67, 15);
		lbldoNombre.setText("2do Nombre");
		
		Label lblApellido = new Label(shell, SWT.NONE);
		lblApellido.setBounds(10, 72, 55, 15);
		lblApellido.setText("Apellido");
		
		Label lblCedula = new Label(shell, SWT.NONE);
		lblCedula.setBounds(10, 100, 55, 15);
		lblCedula.setText("C\u00E9dula:");
		
		Label lblCelular = new Label(shell, SWT.NONE);
		lblCelular.setBounds(10, 129, 55, 15);
		lblCelular.setText("Celular:");
		
		Label lblDireccion = new Label(shell, SWT.NONE);
		lblDireccion.setBounds(10, 160, 55, 15);
		lblDireccion.setText("Direcci\u00F3n:");
		
		Label lblCorreoE = new Label(shell, SWT.NONE);
		lblCorreoE.setBounds(10, 189, 55, 15);
		lblCorreoE.setText("Correo. E:");
		
		Label lblCargo = new Label(shell, SWT.NONE);
		lblCargo.setBounds(10, 219, 55, 15);
		lblCargo.setText("Cargo:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(104, 10, 195, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(104, 38, 195, 21);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(104, 72, 195, 21);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(104, 100, 195, 21);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(104, 129, 195, 21);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(104, 160, 195, 21);
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(104, 189, 195, 21);
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(104, 219, 195, 23);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(336, 38, 75, 25);
		btnNewButton.setText("Crear");
		
		Button btnActualizar = new Button(shell, SWT.NONE);
		btnActualizar.setBounds(336, 89, 75, 25);
		btnActualizar.setText("Actualizar");
		
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
		btnVolver.setBounds(336, 209, 75, 25);
		btnVolver.setText("Volver");

	}
}
