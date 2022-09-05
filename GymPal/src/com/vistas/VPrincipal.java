package com.vistas;

import java.util.HashSet;
import java.util.List;

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
import com.objetos.Cliente;
import com.objetos.Empleado;

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
import org.eclipse.swt.custom.StyledText;

public class VPrincipal {
	
	ControlPrincipal p = null;

	protected Shell shell;
	protected Display display;
	private Composite compUsuario, compBotones, compTabla, compPestanias, compEmpleados;
	private Button btnEmpleados, btnClientes, btnInventario, btnCambiarUsr, separador, btnSalir;
	private Label lblNombre, lblCargo, lblFoto;
	private Composite comBtnClientes;
	private Button btnCliTabla;
	private Button btnCliNuevo;
	private Button btnCliEliminar;
	private Composite comBtnEmpleados;
	private Button btnNewButton_8;
	private Button btnNewButton_9;
	private Button btnNewButton_11;
	private Composite comBtnInventario;
	private Button btnNewButton_12;
	private Button btnNewButton_13;
	private Button btnNewButton_15;
	private Button separador_1;
	TableColumn tblclmnNewColumn1, tblclmnNewColumn2, tblclmnNewColumn3, tblclmnNewColumn4;
	private Composite compClientes;
	private Composite compVentas;
	private Composite compInventario;
	Table auxT = null;

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
		compTabla.setLayout(new StackLayout());
		FormData fd_composite_2 = new FormData();
		fd_composite_2.right = new FormAttachment(compBotones, 0, SWT.RIGHT);
		fd_composite_2.top = new FormAttachment(compPestanias, 0, SWT.TOP);
		fd_composite_2.bottom = new FormAttachment(100, -30);
		fd_composite_2.left = new FormAttachment(compUsuario, 20);
		compTabla.setLayoutData(fd_composite_2);

		comBtnClientes = new Composite(compBotones, SWT.NONE);
		comBtnClientes.setLayout(new FillLayout(SWT.HORIZONTAL));

		btnCliNuevo = new Button(comBtnClientes, SWT.NONE);
		btnCliNuevo.setText("Nuevo Cliente");

		btnCliEliminar = new Button(comBtnClientes, SWT.NONE);
		btnCliEliminar.setText("Eliminar Cliente");

		btnCliTabla = new Button(comBtnClientes, SWT.NONE);
		btnCliTabla.setText("Actualizar Tabla");

		comBtnEmpleados = new Composite(compBotones, SWT.NONE);
		comBtnEmpleados.setLayout(new FillLayout(SWT.HORIZONTAL));

		btnNewButton_8 = new Button(comBtnEmpleados, SWT.NONE);
		btnNewButton_8.setText("Nuevo Empleado");

		btnNewButton_9 = new Button(comBtnEmpleados, SWT.NONE);
		btnNewButton_9.setText("Eliminar Empleado");

		btnNewButton_11 = new Button(comBtnEmpleados, SWT.NONE);
		btnNewButton_11.setText("Actualizar Tabla");

		comBtnInventario = new Composite(compBotones, SWT.NONE);
		comBtnInventario.setLayout(new FillLayout(SWT.HORIZONTAL));

		btnNewButton_12 = new Button(comBtnInventario, SWT.NONE);
		btnNewButton_12.setText("Nuevo Producto");

		btnNewButton_13 = new Button(comBtnInventario, SWT.NONE);
		btnNewButton_13.setText("Eliminar Producto");

		btnNewButton_15 = new Button(comBtnInventario, SWT.NONE);
		btnNewButton_15.setText("Actualizar Tabla");

		btnClientes = new Button(compPestanias, SWT.NONE);
		btnClientes.setLayoutData(new RowData(264, SWT.DEFAULT));
		btnClientes.setText("Clientes");

		btnEmpleados = new Button(compPestanias, SWT.NONE);
		btnEmpleados.setLayoutData(new RowData(264, SWT.DEFAULT));
		btnEmpleados.setText("Empleados");

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



	}

	public void setControlador(ControlPrincipal c) {
		btnClientes.addListener(SWT.Selection, c);
		btnEmpleados.addListener(SWT.Selection, c);
		btnInventario.addListener(SWT.Selection, c);
		btnCambiarUsr.addListener(SWT.Selection, c);
		btnSalir.addListener(SWT.Selection, c);
		
		p = c;
		// CLIENTES

		btnCliNuevo.addListener(SWT.Selection, c);
		btnCliEliminar.addListener(SWT.Selection, c);
		btnCliTabla.addListener(SWT.Selection, c);

		// USUARIOS

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
		lblCargo.setText(setCargoToText(cargo));
	}

	public String setCargoToText(int i) {
		String str = "";
		switch (i) {
		case 0:
			str = "Gerente";
			break;
		case 1:
			str = "Entrenador";
			break;
		}
		return str;
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
		StackLayout layout2 = (StackLayout) compTabla.getLayout();
		switch (op) {
		case 0:
			layout.topControl = comBtnClientes;
			layout2.topControl = compClientes;

			break;
		case 1:
			layout.topControl = comBtnEmpleados;
			layout2.topControl = compEmpleados;
			break;
		case 2:
			layout.topControl = comBtnInventario;
			layout2.topControl = compInventario;
			break;
		default:
			break;

		}
		compBotones.layout();
		compTabla.layout();
	}

	public void cargarTablaEmpleados(List<Empleado> list) {

		// compEmpleados.dispose();
		compEmpleados = new Composite(compTabla, SWT.NONE);
		compEmpleados.setLayout(new FillLayout(SWT.HORIZONTAL));

		Table tabla = new Table(compEmpleados, SWT.BORDER | SWT.CHECK | SWT.FULL_SELECTION | SWT.MULTI);
		tabla.setLinesVisible(true);
		tabla.setHeaderVisible(true);

		String[] titles2 = { "ID", "Nombre", "Cedula", "Direccion", "Cargo", "Activo" };
		for (int i = 0; i < titles2.length; i++) {
			TableColumn tblclmnNewColumn2 = new TableColumn(tabla, SWT.NONE);
			// tblclmnNewColumn.setWidth(100);
			tblclmnNewColumn2.setText(titles2[i]);
		}
		for (int i = 0; i < titles2.length; i++) {
			tabla.getColumn(i).pack();
		}

		int i = 0;
		String str = "";

		for (Empleado a : list) {
			switch (a.getCargo()) {
			case 0:
				str = "Gerente";
				break;
			case 1:
				str = "Entrenador";
				break;
			}
			TableItem item = new TableItem(tabla, SWT.NONE);
			item.setText(new String[] { "" + i, a.getNombre() + " " + a.getApellido(), a.getCedula(), a.getDireccion(),
					str, "" + a.getActivo() });
		}

	}

	public void cargarTablaClientes(List<Cliente> list) {

		// compClientes.dispose();
		compClientes = new Composite(compTabla, SWT.NONE);
		compClientes.setLayout(new FillLayout(SWT.HORIZONTAL));

		Table tabla = new Table(compClientes, SWT.BORDER | SWT.CHECK | SWT.FULL_SELECTION | SWT.MULTI);
		tabla.setLinesVisible(true);
		tabla.setHeaderVisible(true);

		String[] titles = { "ID", "Nombre", "Cedula", "Direccion", "Activo" };
		for (int i = 0; i < titles.length; i++) {
			TableColumn tblclmnNewColumn = new TableColumn(tabla, SWT.NONE);
			// tblclmnNewColumn.setWidth(100);
			tblclmnNewColumn.setText(titles[i]);
		}
		for (int i = 0; i < titles.length; i++) {
			tabla.getColumn(i).pack();
		}

		int i = 0;
		String str = "";

		for (Cliente a : list) {

			TableItem item = new TableItem(tabla, SWT.NONE);
			item.setText(new String[] { i+"", a.getNombre() + " " + a.getApellido(), a.getCedula(), a.getDireccion(),
					"" + a.getActivo() });
		}
		
		//tabla.getc
		auxT = tabla;
		tabla.addListener(SWT.Selection, p);
		tabla.addListener(SWT.DefaultSelection, p);
		System.out.println(tabla.getSelection());
		
		
	}

	public void controladorRespaldo() {

	}

	public void cargarTablaVentas(HashSet<Empleado> listaProductos) {

		// compVentas.dispose();
		compVentas = new Composite(compTabla, SWT.NONE);
		compVentas.setLayout(new FillLayout(SWT.HORIZONTAL));

		Table tabla = new Table(compVentas, SWT.BORDER | SWT.CHECK | SWT.FULL_SELECTION | SWT.MULTI);
		tabla.setLinesVisible(true);
		tabla.setHeaderVisible(true);

		String[] titles2 = { "codigo", "cantidad", "		Description		", "precio Unitario", "precio Total" };
		for (int i = 0; i < titles2.length; i++) {
			TableColumn tblclmnNewColumn2 = new TableColumn(tabla, SWT.NONE);
			// tblclmnNewColumn.setWidth(100);
			tblclmnNewColumn2.setText(titles2[i]);
		}
		for (int i = 0; i < titles2.length; i++) {
			tabla.getColumn(i).pack();
		}

		int i = 0;
		String str = "";

		for (Empleado a : listaProductos) {
			switch (a.getCargo()) {
			case 0:
				str = "Gerente";
				break;
			case 1:
				str = "Entrenador";
				break;
			}
			TableItem item = new TableItem(tabla, SWT.NONE);
			item.setText(new String[] { "" + i, a.getNombre() + " " + a.getApellido(), a.getCedula(), a.getDireccion(),
					str, "" + a.getActivo() });
		}

	}

	public void cargarTablaInventario(HashSet<Empleado> listaProductos) {

		// compInventario.dispose();
		compInventario = new Composite(compTabla, SWT.NONE);
		compInventario.setLayout(new FillLayout(SWT.HORIZONTAL));

		Table tabla = new Table(compInventario, SWT.BORDER | SWT.CHECK | SWT.FULL_SELECTION | SWT.MULTI);
		tabla.setLinesVisible(true);
		tabla.setHeaderVisible(true);

		String[] titles2 = { "ID", "Codigo", "		Description		", "precio Unitario", "descuento %" };
		for (int i = 0; i < titles2.length; i++) {
			TableColumn tblclmnNewColumn2 = new TableColumn(tabla, SWT.NONE);
			// tblclmnNewColumn.setWidth(100);
			tblclmnNewColumn2.setText(titles2[i]);
		}
		for (int i = 0; i < titles2.length; i++) {
			tabla.getColumn(i).pack();
		}

		int i = 0;
		String str = "";

		for (Empleado a : listaProductos) {
			switch (a.getCargo()) {
			case 0:
				str = "Gerente";
				break;
			case 1:
				str = "Entrenador";
				break;
			}
			TableItem item = new TableItem(tabla, SWT.NONE);
			item.setText(new String[] { "" + i, a.getNombre() + " " + a.getApellido(), a.getCedula(), a.getDireccion(),
					str, "" + a.getActivo() });
		}

	}


	
	public String getAuxT() {
		
		return auxT.getItem(auxT.getSelectionIndex()).toString();
	}


}
