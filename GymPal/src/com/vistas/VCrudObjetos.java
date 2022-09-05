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
import org.eclipse.swt.widgets.Combo;

public class VCrudObjetos {

	protected Shell shell;
	private Text tApellido;
	private Text tCedula;
	private Text tCelular;
	private Text tDireccion;
	private Text tCorreo;
	private Display display;
	private Composite compClientes;
	private Composite compEmpleados;
	private Composite compInventario;
	private Button btnActualizarCli, btnCancelar, btnNuevoCli;

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	private int estado;
	private Text tNombre;

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
		this.estado = estado;
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

		tApellido = new Text(compClientes, SWT.BORDER);
		FormData fd_tApellido = new FormData();
		fd_tApellido.top = new FormAttachment(lblIngreseLosDatos, 80);
		fd_tApellido.right = new FormAttachment(100, -107);
		fd_tApellido.left = new FormAttachment(lblNewLabel_1, 32);
		tApellido.setLayoutData(fd_tApellido);

		tCedula = new Text(compClientes, SWT.BORDER);
		FormData fd_tCedula = new FormData();
		fd_tCedula.right = new FormAttachment(100, -107);
		fd_tCedula.left = new FormAttachment(lblNewLabel_2, 41);
		fd_tCedula.top = new FormAttachment(tApellido, 21);
		tCedula.setLayoutData(fd_tCedula);

		tCelular = new Text(compClientes, SWT.BORDER);
		FormData fd_tCelular = new FormData();
		fd_tCelular.right = new FormAttachment(100, -107);
		fd_tCelular.left = new FormAttachment(lblNewLabel_3, 39);
		fd_tCelular.top = new FormAttachment(tCedula, 19);
		tCelular.setLayoutData(fd_tCelular);

		tDireccion = new Text(compClientes, SWT.BORDER);
		FormData fd_tDireccion = new FormData();
		fd_tDireccion.right = new FormAttachment(100, -107);
		fd_tDireccion.left = new FormAttachment(lblNewLabel_4, 32);
		fd_tDireccion.top = new FormAttachment(lblNewLabel_4, 0, SWT.TOP);
		tDireccion.setLayoutData(fd_tDireccion);

		tCorreo = new Text(compClientes, SWT.BORDER);
		FormData fd_tCorreo = new FormData();
		fd_tCorreo.right = new FormAttachment(100, -107);
		fd_tCorreo.left = new FormAttachment(lblNewLabel_5, 32);
		fd_tCorreo.top = new FormAttachment(lblNewLabel_5, 0, SWT.TOP);
		tCorreo.setLayoutData(fd_tCorreo);

		btnCancelar = new Button(compClientes, SWT.NONE);
		FormData fd_btnCancelar = new FormData();
		fd_btnCancelar.bottom = new FormAttachment(100, -27);
		fd_btnCancelar.left = new FormAttachment(lblNewLabel_4, 0, SWT.LEFT);
		btnCancelar.setLayoutData(fd_btnCancelar);
		btnCancelar.setText("Cancelar");

		btnNuevoCli = new Button(compClientes, SWT.NONE);
		FormData fd_btnNuevoCli = new FormData();
		fd_btnNuevoCli.top = new FormAttachment(btnCancelar, 0, SWT.TOP);
		fd_btnNuevoCli.left = new FormAttachment(btnCancelar, 119);
		btnNuevoCli.setLayoutData(fd_btnNuevoCli);
		btnNuevoCli.setText("Nuevo");

		btnActualizarCli = new Button(compClientes, SWT.NONE);
		FormData fd_btnActualizarCli = new FormData();
		fd_btnActualizarCli.right = new FormAttachment(100, -107);
		fd_btnActualizarCli.top = new FormAttachment(btnCancelar, 0, SWT.TOP);
		btnActualizarCli.setLayoutData(fd_btnActualizarCli);
		btnActualizarCli.setText("actualizar");
		
		tNombre = new Text(compClientes, SWT.BORDER);
		FormData fd_tNombre = new FormData();
		fd_tNombre.left = new FormAttachment(tApellido, 0, SWT.LEFT);
		fd_tNombre.top = new FormAttachment(lblNewLabel, 0, SWT.TOP);
		fd_tNombre.right = new FormAttachment(tApellido, 0, SWT.RIGHT);
		tNombre.setLayoutData(fd_tNombre);

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

		btnCancelar.addListener(SWT.Selection, c);
		// CLIENTES
		btnActualizarCli.addListener(SWT.Selection, c);
		btnNuevoCli.addListener(SWT.Selection, c);

	}

	public void apagar() {
		shell.close();
	}

	public void pausar(boolean b) {
		shell.setVisible(!b);
	}
	
	public String getNombreCli() {
		return tNombre.getText();
	}
	public String getApellidoCli() {
		return tApellido.getText();
	}
	public String getCedulaCli() {
		return tCedula.getText();
	}
	public String getCelularCli() {
		return tCelular.getText();
	}
	public String getDireccionCli() {
		return tDireccion.getText();
	}
	public String getCorreoCli() {
		return tCorreo.getText();
	}
}
