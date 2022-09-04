package com.vistas;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import com.controladores.ControlPrincipal;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class VPrincipal {

	protected Shell shell;
	protected Display display;
	private Composite compUsuario, compBotones, compTabla, compPestanias, comBtnVentas;
	private Button btnEmpleados, btnClientes, btnVentas, btnInventario, btnCambiarUsr, separador, btnSalir;
	private Label lblNombre, lblCargo, lblFoto;
	private Button btnIngresar;
	private Button btnNewButton_1;
	private Button btnNewButton_3;
	private Button btnNewButton_4;
	private Spinner spinner;
	private Label lblNewLabel;
	private Combo combo;
	private Combo combo_1;
	private Label lblNewLabel_1;
	private Label lblNewLabel_2;
	private Composite comBtnClientes;
	private Button btnNewButton_2;
	private Button btnNewButton_5;
	private Button btnNewButton_6;
	private Button btnNewButton_7;
	private Composite comBtnEmpleados;
	private Button btnNewButton_8;
	private Button btnNewButton_9;
	private Button btnNewButton_10;
	private Button btnNewButton_11;
	private Composite comBtnInventario;
	private Button btnNewButton_12;
	private Button btnNewButton_13;
	private Button btnNewButton_14;
	private Button btnNewButton_15;
	private Button btnSalir_1;
	private Button btnSalir_2;
	private Button btnSalir_3;
	private Button separador_1;
	private Table table;;

	public VPrincipal(Display display) {
		this.display = display;
		createContents();
	}

	public static void main(String[] args) {
		try {
			VPrincipal window = new VPrincipal(Display.getDefault());
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
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
		shell.setSize(900, 600);
		shell.setText("SWT Application");
		shell.setLayout(new FormLayout());

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		compUsuario = new Composite(shell, SWT.BORDER);
		compUsuario.setLayout(null);
		FormData fd_composite = new FormData();
		fd_composite.right = new FormAttachment(0, 300);
		fd_composite.top = new FormAttachment(0, 30);
		fd_composite.left = new FormAttachment(0, 30);
		fd_composite.bottom = new FormAttachment(20, 0);
		compUsuario.setLayoutData(fd_composite);

		compPestanias = new Composite(shell, SWT.NONE);
		compPestanias.setLayout(new RowLayout(SWT.HORIZONTAL));
		FormData fd_composite1 = new FormData();
		fd_composite1.top = new FormAttachment(compUsuario, 15);
		fd_composite1.bottom = new FormAttachment(100, -30);
		fd_composite1.left = new FormAttachment(0, 30);
		fd_composite1.right = new FormAttachment(0, 300);
		compPestanias.setLayoutData(fd_composite1);

		compBotones = new Composite(shell, SWT.BORDER);
		compBotones.setLayout(new StackLayout());
		FormData fd_composite_1 = new FormData();
		fd_composite_1.top = new FormAttachment(0, 30);
		fd_composite_1.left = new FormAttachment(compUsuario, 20);
		fd_composite_1.right = new FormAttachment(100, -30);
		fd_composite_1.bottom = new FormAttachment(20, 0);
		compBotones.setLayoutData(fd_composite_1);

		compTabla = new Composite(shell, SWT.NONE);
		compTabla.setLayout(new FormLayout());
		FormData fd_composite_2 = new FormData();
		fd_composite_2.right = new FormAttachment(compBotones, 0, SWT.RIGHT);
		fd_composite_2.top = new FormAttachment(compPestanias, 0, SWT.TOP);
		fd_composite_2.bottom = new FormAttachment(100, -30);
		fd_composite_2.left = new FormAttachment(compUsuario, 20);
		compTabla.setLayoutData(fd_composite_2);
		
		table = new Table(compTabla, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_table = new FormData();
		fd_table.top = new FormAttachment(0, 0);
		fd_table.left = new FormAttachment(0, 0);
		fd_table.bottom = new FormAttachment(100,-1);
		fd_table.right = new FormAttachment(100,-1);
		table.setLayoutData(fd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);


		
		comBtnClientes = new Composite(compBotones, SWT.NONE);
		comBtnClientes.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		btnNewButton_6 = new Button(comBtnClientes, SWT.NONE);
		btnNewButton_6.setText("Nuevo Cliente");
		
		btnNewButton_7 = new Button(comBtnClientes, SWT.NONE);
		btnNewButton_7.setText("Eliminar Cliente");
		
		btnNewButton_5 = new Button(comBtnClientes, SWT.NONE);
		btnNewButton_5.setText("Actualizar Cliente");
		
		btnNewButton_2 = new Button(comBtnClientes, SWT.NONE);
		btnNewButton_2.setText("Actualizar Tabla");
		
		comBtnEmpleados = new Composite(compBotones, SWT.NONE);
		comBtnEmpleados.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		btnNewButton_8 = new Button(comBtnEmpleados, SWT.NONE);
		btnNewButton_8.setText("Nuevo Empleado");
		
		btnNewButton_9 = new Button(comBtnEmpleados, SWT.NONE);
		btnNewButton_9.setText("Eliminar Empleado");
		
		btnNewButton_10 = new Button(comBtnEmpleados, SWT.NONE);
		btnNewButton_10.setText("Actualizar Empleado");
		
		btnNewButton_11 = new Button(comBtnEmpleados, SWT.NONE);
		btnNewButton_11.setText("Actualizar Tabla");
		
		comBtnInventario = new Composite(compBotones, SWT.NONE);
		comBtnInventario.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		btnNewButton_12 = new Button(comBtnInventario, SWT.NONE);
		btnNewButton_12.setText("Nuevo Producto");
		
		btnNewButton_13 = new Button(comBtnInventario, SWT.NONE);
		btnNewButton_13.setText("Eliminar Producto");
		
		btnNewButton_14 = new Button(comBtnInventario, SWT.NONE);
		btnNewButton_14.setText("Actualizar Producto");
		
		btnNewButton_15 = new Button(comBtnInventario, SWT.NONE);
		btnNewButton_15.setText("Actualizar Tabla");
		
		


		btnClientes = new Button(compPestanias, SWT.NONE);
		btnClientes.setLayoutData(new RowData(264, SWT.DEFAULT));
		btnClientes.setText("Clientes");

		btnEmpleados = new Button(compPestanias, SWT.NONE);
		btnEmpleados.setLayoutData(new RowData(264, SWT.DEFAULT));
		btnEmpleados.setText("Empleados");

		btnVentas = new Button(compPestanias, SWT.NONE);
		btnVentas.setLayoutData(new RowData(264, SWT.DEFAULT));
		btnVentas.setText("Ventas");

		btnInventario = new Button(compPestanias, SWT.NONE);
		btnInventario.setLayoutData(new RowData(264, SWT.DEFAULT));
		btnInventario.setText("Inventario");

		btnCambiarUsr = new Button(compPestanias, SWT.NONE);
		btnCambiarUsr.setLayoutData(new RowData(264, SWT.DEFAULT));
		btnCambiarUsr.setText("Cambiar Usuario");

		separador = new Button(compPestanias, SWT.NONE);
		separador.setLayoutData(new RowData(264, 99));
		separador.setText("separador");
		separador.setVisible(false);
		
		btnSalir = new Button(compPestanias, SWT.NONE);
		btnSalir.setLayoutData(new RowData(264, SWT.DEFAULT));
		btnSalir.setText("Salir");
		
		separador_1 = new Button(compPestanias, SWT.NONE);
		separador_1.setLayoutData(new RowData(240, 39));
		separador_1.setVisible(false);
		separador_1.setText("separador");

		lblNombre = new Label(compUsuario, SWT.NONE);
		lblNombre.setBounds(100, 10, 160, 37);

		lblCargo = new Label(compUsuario, SWT.NONE);
		lblCargo.setBounds(100, 53, 156, 15);

		lblFoto = new Label(compUsuario, SWT.NONE);
		lblFoto.setBounds(10, 10, 65, 58);
		
		cargarBtnVentas();

	}

	public void setControlador(ControlPrincipal c) {
		btnClientes.addListener(SWT.Selection, c);
		btnEmpleados.addListener(SWT.Selection, c);
		btnVentas.addListener(SWT.Selection, c);
		btnInventario.addListener(SWT.Selection, c);
		btnCambiarUsr.addListener(SWT.Selection, c);
		btnSalir.addListener(SWT.Selection, c);

	}

	public void apagar() {
		shell.close();
	}

	public void pausar(boolean b) {
		shell.setVisible(!b);
	}

	public Display getDisplay() {
		return display;
	}

	public void setEmpleado(int cargo, String nombre) {
		lblNombre.setText(nombre);
		String str = "";
		switch (cargo) {
		case 0:
			str = "Gerente";
			break;
		case 1:
			str = "Entrenador";
			break;
		}

		lblCargo.setText(str);
	}

	public void controlAcceso(int cargo) {
		if (cargo == 1) {
			btnEmpleados.setEnabled(false);
			btnEmpleados.setVisible(false);
			btnInventario.setEnabled(false);
			btnInventario.setVisible(false);

		}
	}

	public void showComposite(int op) {
		StackLayout layout = (StackLayout) compBotones.getLayout();
		switch (op) {
		case 0:
			layout.topControl = comBtnClientes;
			break;
		case 1:
			layout.topControl = comBtnEmpleados;
			break;
		case 2:
			layout.topControl = comBtnVentas;
			break;
		case 3:
			layout.topControl = comBtnInventario;
			break;
		default:
			break;

		}
		compBotones.layout();
	}
	
	private void cargarBtnVentas() {
		comBtnVentas = new Composite(compBotones, SWT.NONE);
		comBtnVentas.setLayout(new FormLayout());
		
		btnIngresar = new Button(comBtnVentas, SWT.NONE);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(0, 10);
		fd_btnNewButton.right = new FormAttachment(100, -10);
		btnIngresar.setLayoutData(fd_btnNewButton);
		btnIngresar.setText("Ingresar");
		
		btnNewButton_1 = new Button(comBtnVentas, SWT.NONE);
		FormData fd_btnNewButton_1 = new FormData();
		fd_btnNewButton_1.top = new FormAttachment(btnIngresar, 4);
		fd_btnNewButton_1.left = new FormAttachment(btnIngresar, 0, SWT.LEFT);
		btnNewButton_1.setLayoutData(fd_btnNewButton_1);
		btnNewButton_1.setText("Eliminar");
		
		btnNewButton_3 = new Button(comBtnVentas, SWT.NONE);
		FormData fd_btnNewButton_3 = new FormData();
		fd_btnNewButton_3.bottom = new FormAttachment(btnIngresar, 0, SWT.BOTTOM);
		fd_btnNewButton_3.right = new FormAttachment(btnIngresar, -6);
		btnNewButton_3.setLayoutData(fd_btnNewButton_3);
		btnNewButton_3.setText("Agregar P.");
		
		btnNewButton_4 = new Button(comBtnVentas, SWT.NONE);
		FormData fd_btnNewButton_4 = new FormData();
		fd_btnNewButton_4.top = new FormAttachment(btnIngresar, 0, SWT.TOP);
		fd_btnNewButton_4.right = new FormAttachment(btnNewButton_3, -6);
		btnNewButton_4.setLayoutData(fd_btnNewButton_4);
		btnNewButton_4.setText("Agregar U");
		
		spinner = new Spinner(comBtnVentas, SWT.BORDER);
		FormData fd_spinner = new FormData();
		fd_spinner.bottom = new FormAttachment(btnNewButton_1, 0, SWT.BOTTOM);
		fd_spinner.right = new FormAttachment(btnNewButton_1, -6);
		spinner.setLayoutData(fd_spinner);
		
		lblNewLabel = new Label(comBtnVentas, SWT.NONE);
		lblNewLabel.setAlignment(SWT.RIGHT);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.right = new FormAttachment(spinner, -6);
		fd_lblNewLabel.top = new FormAttachment(btnNewButton_1, 5, SWT.TOP);
		fd_lblNewLabel.left = new FormAttachment(btnNewButton_4, 10, SWT.LEFT);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("Cantidad");
		
		combo = new Combo(comBtnVentas, SWT.NONE);
		FormData fd_combo = new FormData();
		fd_combo.top = new FormAttachment(btnIngresar, 2, SWT.TOP);
		fd_combo.right = new FormAttachment(btnNewButton_4, -6);
		combo.setLayoutData(fd_combo);
		
		combo_1 = new Combo(comBtnVentas, SWT.NONE);
		fd_combo.left = new FormAttachment(combo_1, 0, SWT.LEFT);
		FormData fd_combo_1 = new FormData();
		fd_combo_1.right = new FormAttachment(lblNewLabel, -16);
		fd_combo_1.top = new FormAttachment(btnNewButton_1, 2, SWT.TOP);
		combo_1.setLayoutData(fd_combo_1);
		
		lblNewLabel_1 = new Label(comBtnVentas, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.RIGHT);
		FormData fd_lblNewLabel_1 = new FormData();
		fd_lblNewLabel_1.bottom = new FormAttachment(btnIngresar, 0, SWT.BOTTOM);
		fd_lblNewLabel_1.right = new FormAttachment(combo, -6);
		fd_lblNewLabel_1.top = new FormAttachment(btnIngresar, 0, SWT.TOP);
		fd_lblNewLabel_1.left = new FormAttachment(0, 10);
		lblNewLabel_1.setLayoutData(fd_lblNewLabel_1);
		lblNewLabel_1.setText("Cliente:  ");
		
		lblNewLabel_2 = new Label(comBtnVentas, SWT.NONE);
		fd_combo_1.left = new FormAttachment(lblNewLabel_2, 6);
		lblNewLabel_2.setAlignment(SWT.RIGHT);
		FormData fd_lblNewLabel_2 = new FormData();
		fd_lblNewLabel_2.bottom = new FormAttachment(btnNewButton_1, 0, SWT.BOTTOM);
		fd_lblNewLabel_2.right = new FormAttachment(0, 124);
		fd_lblNewLabel_2.left = new FormAttachment(0, 10);
		fd_lblNewLabel_2.top = new FormAttachment(btnNewButton_1, 0, SWT.TOP);
		lblNewLabel_2.setLayoutData(fd_lblNewLabel_2);
		lblNewLabel_2.setText("Producto:  ");
				
		btnSalir_1 = new Button(compPestanias, SWT.NONE);
		btnSalir_1.setLayoutData(new RowData(264, SWT.DEFAULT));
		btnSalir_1.setText("Imprimir Factura");
		
		btnSalir_2 = new Button(compPestanias, SWT.NONE);
		btnSalir_2.setLayoutData(new RowData(264, SWT.DEFAULT));
		btnSalir_2.setText("Guardar Factura");
		
		btnSalir_3 = new Button(compPestanias, SWT.NONE);
		btnSalir_3.setLayoutData(new RowData(264, SWT.DEFAULT));
		btnSalir_3.setText("Reiniciar");
	}
}
