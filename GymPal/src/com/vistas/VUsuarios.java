package com.vistas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import com.controladores.ControlUsuarios;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class VUsuarios {

	protected Shell shell;
	protected Display display;
	private Text userName, password;
	Button ingresar, recuperarU, cancelar;
	Label mostrarContraseña;
	int contador = 0;

	public VUsuarios(Display display) {
		this.display = display;
		createContents();
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VUsuarios window = new VUsuarios(Display.getDefault());
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
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
		shell.setSize(543, 351);
		shell.setText("SWT Application");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(54, 27, 55, 15);
		lblNewLabel.setText("Ingrese Usuario y Contraseña");

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(54, 93, 55, 15);
		lblNewLabel_1.setText("Usuario:");

		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(54, 134, 55, 15);
		lblNewLabel_2.setText("Contraseña:");

		mostrarContraseña = new Label(shell, SWT.NONE);
		mostrarContraseña.setAlignment(SWT.RIGHT);
		mostrarContraseña.setBounds(360, 161, 118, 15);
		mostrarContraseña.setText("Mostrar Contraseña");

		recuperarU = new Button(shell, SWT.NONE);
		recuperarU.setBounds(54, 227, 140, 25);
		recuperarU.setText("¿Olvidaste tu Uusario?");

		cancelar = new Button(shell, SWT.NONE);
		cancelar.setBounds(298, 227, 75, 25);
		cancelar.setText("Cancelar");

		ingresar = new Button(shell, SWT.NONE);
		ingresar.setBounds(403, 227, 75, 25);
		ingresar.setText("Ingresar");

		userName = new Text(shell, SWT.BORDER);
		userName.setBounds(194, 87, 285, 21);

		password = new Text(shell, SWT.BORDER);
		password.setBounds(194, 134, 285, 21);
		password.setEchoChar('*');

	}

	public void setControlador(ControlUsuarios c) {

		recuperarU.addListener(SWT.Selection, c);
		cancelar.addListener(SWT.Selection, c);
		ingresar.addListener(SWT.Selection, c);
		

		mostrarContraseña.addListener(SWT.TRAVERSE_RETURN, c);

	}

	public void setPasswordText(int e) {
		if ((contador % 2) == 0) {
			password.setEchoChar('*');
		} else {
			password.setEchoChar((char) 0);
		}

	}
	
	public int aumentarContador() {
		return contador ++;
	}
	
	public String getContraseña() {
		return password.getText();
	}
	public String getUsuario() {
		return userName.getText();
	}
	
	public void apagar() {
		display.sleep();
	}
	
}
