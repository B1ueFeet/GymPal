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

	protected Shell shlPersonalGympal;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VPersonal window = new VPersonal();
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
		shlPersonalGympal.open();
		shlPersonalGympal.layout();
		while (!shlPersonalGympal.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPersonalGympal = new Shell();
		shlPersonalGympal.setSize(566, 459);
		shlPersonalGympal.setText("Personal - GymPal");
		
		Label lblernombre = new Label(shlPersonalGympal, SWT.NONE);
		lblernombre.setBounds(23, 58, 70, 15);
		lblernombre.setText("1erNombre");
		
		Label lbldonombre = new Label(shlPersonalGympal, SWT.NONE);
		lbldonombre.setBounds(23, 93, 70, 15);
		lbldonombre.setText("2doNombre");
		
		Label lblApellido = new Label(shlPersonalGympal, SWT.NONE);
		lblApellido.setBounds(23, 128, 55, 15);
		lblApellido.setText("Apellido");
		
		Label lblCelular = new Label(shlPersonalGympal, SWT.NONE);
		lblCelular.setBounds(23, 164, 55, 15);
		lblCelular.setText("Celular");
		
		Label lblDireccion = new Label(shlPersonalGympal, SWT.NONE);
		lblDireccion.setBounds(23, 194, 55, 15);
		lblDireccion.setText("Direccion");
		
		Label lblCorreoE = new Label(shlPersonalGympal, SWT.NONE);
		lblCorreoE.setBounds(23, 236, 55, 15);
		lblCorreoE.setText("Correo. E");
		
		Label lblCedula = new Label(shlPersonalGympal, SWT.NONE);
		lblCedula.setBounds(23, 26, 55, 15);
		lblCedula.setText("Cedula");
		
		Combo combo = new Combo(shlPersonalGympal, SWT.NONE);
		combo.setBounds(111, 18, 191, 23);
		
		Combo combo_1 = new Combo(shlPersonalGympal, SWT.NONE);
		combo_1.setBounds(111, 50, 191, 23);
		
		Combo combo_2 = new Combo(shlPersonalGympal, SWT.NONE);
		combo_2.setBounds(111, 85, 191, 23);
		
		Combo combo_3 = new Combo(shlPersonalGympal, SWT.NONE);
		combo_3.setBounds(111, 125, 191, 23);
		
		Combo combo_4 = new Combo(shlPersonalGympal, SWT.NONE);
		combo_4.setBounds(111, 156, 191, 23);
		
		Combo combo_5 = new Combo(shlPersonalGympal, SWT.NONE);
		combo_5.setBounds(111, 194, 191, 23);
		
		Combo combo_6 = new Combo(shlPersonalGympal, SWT.NONE);
		combo_6.setBounds(111, 228, 191, 23);
		
		table = new Table(shlPersonalGympal, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(23, 290, 494, 109);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		Button btnCrearUsuario = new Button(shlPersonalGympal, SWT.NONE);
		btnCrearUsuario.setBounds(416, 26, 101, 25);
		btnCrearUsuario.setText("Crear  Usuario");
		
		Button btnEliminarUsuario = new Button(shlPersonalGympal, SWT.NONE);
		btnEliminarUsuario.setBounds(416, 70, 101, 25);
		btnEliminarUsuario.setText("Eliminar Usuario");
		
		Button btnActualizar = new Button(shlPersonalGympal, SWT.NONE);
		btnActualizar.setBounds(428, 118, 75, 25);
		btnActualizar.setText("Actualizar");
		
		Button btnVolver = new Button(shlPersonalGympal, SWT.NONE);
		btnVolver.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlPersonalGympal.dispose();
			}
		});
		btnVolver.setBounds(428, 194, 75, 25);
		btnVolver.setText("Volver");

	}

}
