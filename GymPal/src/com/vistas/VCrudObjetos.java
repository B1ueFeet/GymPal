package com.vistas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.controladores.ControlCrudObjetos;

import org.eclipse.swt.widgets.Button;

public class VCrudObjetos {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Display display;
	private Composite compClientes;
	private Composite compEmpleados;
	private Composite compInventario;

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public VCrudObjetos(Display display) {
		this.display = display;
		createContents();
	}

	public static void main(String[] args) {
		try {
			VCrudObjetos window = new VCrudObjetos(Display.getDefault());
			window.open(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open(int estado) {
		showComposite(estado);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shell = new Shell();
		shell.setSize(634, 476);
		shell.setText("SWT Application");
		shell.setLayout(new StackLayout());

		compClientes = new Composite(shell, SWT.NONE);
		compClientes.setLayout(new FormLayout());

		Label lblNuevoCliente = new Label(compClientes, SWT.NONE);
		FormData fd_lblNuevoCliente = new FormData();
		fd_lblNuevoCliente.top = new FormAttachment(0, 36);
		fd_lblNuevoCliente.left = new FormAttachment(0, 51);
		fd_lblNuevoCliente.right = new FormAttachment(0, 142);
		lblNuevoCliente.setLayoutData(fd_lblNuevoCliente);
		lblNuevoCliente.setText("Nuevo Cliente");

		Label lblIngreseLosDatos = new Label(compClientes, SWT.NONE);
		FormData fd_lblIngreseLosDatos = new FormData();
		fd_lblIngreseLosDatos.left = new FormAttachment(0, 51);
		fd_lblIngreseLosDatos.right = new FormAttachment(0, 214);
		fd_lblIngreseLosDatos.top = new FormAttachment(lblNuevoCliente, 6);
		lblIngreseLosDatos.setLayoutData(fd_lblIngreseLosDatos);
		lblIngreseLosDatos.setText("Ingrese los datos");

		Label lblNewLabel = new Label(compClientes, SWT.NONE);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.top = new FormAttachment(lblIngreseLosDatos, 43);
		fd_lblNewLabel.left = new FormAttachment(0, 107);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("Nombre");

		Label lblNewLabel_1 = new Label(compClientes, SWT.NONE);
		FormData fd_lblNewLabel_1 = new FormData();
		fd_lblNewLabel_1.left = new FormAttachment(0, 107);
		fd_lblNewLabel_1.top = new FormAttachment(lblNewLabel, 22);
		lblNewLabel_1.setLayoutData(fd_lblNewLabel_1);
		lblNewLabel_1.setText("Apellido");

		Label lblNewLabel_2 = new Label(compClientes, SWT.NONE);
		FormData fd_lblNewLabel_2 = new FormData();
		fd_lblNewLabel_2.left = new FormAttachment(0, 107);
		fd_lblNewLabel_2.top = new FormAttachment(lblNewLabel_1, 27);
		lblNewLabel_2.setLayoutData(fd_lblNewLabel_2);
		lblNewLabel_2.setText("cedula");

		Label lblNewLabel_3 = new Label(compClientes, SWT.NONE);
		FormData fd_lblNewLabel_3 = new FormData();
		fd_lblNewLabel_3.left = new FormAttachment(0, 107);
		fd_lblNewLabel_3.top = new FormAttachment(lblNewLabel_2, 25);
		lblNewLabel_3.setLayoutData(fd_lblNewLabel_3);
		lblNewLabel_3.setText("Celular");

		Label lblNewLabel_4 = new Label(compClientes, SWT.NONE);
		FormData fd_lblNewLabel_4 = new FormData();
		fd_lblNewLabel_4.left = new FormAttachment(0, 101);
		fd_lblNewLabel_4.top = new FormAttachment(lblNewLabel_3, 26);
		fd_lblNewLabel_4.right = new FormAttachment(lblNewLabel, 0, SWT.RIGHT);
		lblNewLabel_4.setLayoutData(fd_lblNewLabel_4);
		lblNewLabel_4.setText("Direccion");

		Label lblNewLabel_5 = new Label(compClientes, SWT.NONE);
		FormData fd_lblNewLabel_5 = new FormData();
		fd_lblNewLabel_5.left = new FormAttachment(0, 115);
		fd_lblNewLabel_5.top = new FormAttachment(lblNewLabel_4, 24);
		fd_lblNewLabel_5.right = new FormAttachment(lblNewLabel, 0, SWT.RIGHT);
		lblNewLabel_5.setLayoutData(fd_lblNewLabel_5);
		lblNewLabel_5.setText("Correo");

		text = new Text(compClientes, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.top = new FormAttachment(lblIngreseLosDatos, 43);
		fd_text.right = new FormAttachment(lblNewLabel, 360, SWT.RIGHT);
		fd_text.left = new FormAttachment(lblNewLabel, 32);
		text.setLayoutData(fd_text);

		text_1 = new Text(compClientes, SWT.BORDER);
		FormData fd_text_1 = new FormData();
		fd_text_1.right = new FormAttachment(text, 0, SWT.RIGHT);
		fd_text_1.top = new FormAttachment(text, 16);
		fd_text_1.left = new FormAttachment(text, 0, SWT.LEFT);
		text_1.setLayoutData(fd_text_1);

		text_2 = new Text(compClientes, SWT.BORDER);
		FormData fd_text_2 = new FormData();
		fd_text_2.right = new FormAttachment(text, 0, SWT.RIGHT);
		fd_text_2.top = new FormAttachment(text_1, 21);
		fd_text_2.left = new FormAttachment(text, 0, SWT.LEFT);
		text_2.setLayoutData(fd_text_2);

		text_3 = new Text(compClientes, SWT.BORDER);
		FormData fd_text_3 = new FormData();
		fd_text_3.right = new FormAttachment(text, 0, SWT.RIGHT);
		fd_text_3.top = new FormAttachment(text_2, 19);
		fd_text_3.left = new FormAttachment(text, 0, SWT.LEFT);
		text_3.setLayoutData(fd_text_3);

		text_4 = new Text(compClientes, SWT.BORDER);
		FormData fd_text_4 = new FormData();
		fd_text_4.right = new FormAttachment(text, 0, SWT.RIGHT);
		fd_text_4.left = new FormAttachment(text, 0, SWT.LEFT);
		fd_text_4.top = new FormAttachment(lblNewLabel_4, 0, SWT.TOP);
		text_4.setLayoutData(fd_text_4);

		text_5 = new Text(compClientes, SWT.BORDER);
		FormData fd_text_5 = new FormData();
		fd_text_5.right = new FormAttachment(text, 0, SWT.RIGHT);
		fd_text_5.left = new FormAttachment(text, 0, SWT.LEFT);
		fd_text_5.top = new FormAttachment(lblNewLabel_5, 0, SWT.TOP);
		text_5.setLayoutData(fd_text_5);

		Button btnCancelar = new Button(compClientes, SWT.NONE);
		FormData fd_btnCancelar = new FormData();
		fd_btnCancelar.bottom = new FormAttachment(100, -27);
		fd_btnCancelar.left = new FormAttachment(lblNewLabel_4, 0, SWT.LEFT);
		btnCancelar.setLayoutData(fd_btnCancelar);
		btnCancelar.setText("Cancelar");

		Button btnNuevo = new Button(compClientes, SWT.NONE);
		FormData fd_btnNuevo = new FormData();
		fd_btnNuevo.top = new FormAttachment(btnCancelar, 0, SWT.TOP);
		fd_btnNuevo.left = new FormAttachment(btnCancelar, 119);
		btnNuevo.setLayoutData(fd_btnNuevo);
		btnNuevo.setText("Nuevo");

		Button btnActualizar = new Button(compClientes, SWT.NONE);
		FormData fd_btnActualizar = new FormData();
		fd_btnActualizar.top = new FormAttachment(btnCancelar, 0, SWT.TOP);
		fd_btnActualizar.right = new FormAttachment(text, 0, SWT.RIGHT);
		btnActualizar.setLayoutData(fd_btnActualizar);
		btnActualizar.setText("actualizar");

		compEmpleados = new Composite(shell, SWT.NONE);
		compEmpleados.setLayout(new StackLayout());

		compInventario = new Composite(shell, SWT.NONE);
		compInventario.setLayout(new StackLayout());

	}
	
	public void showComposite(int op) {
		StackLayout layout = (StackLayout) shell.getLayout();
		switch (op) {
		case 0:
			layout.topControl = compClientes;
			break;
		case 1:
			layout.topControl = compEmpleados;
			break;
		case 2:
			layout.topControl = compInventario;
			break;
		default:
			break;

		}
		shell.layout();
	}

	public void setControlador(ControlCrudObjetos c) {
		
	}
}
