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

public class VPrincipal {

	protected Shell shell;
	protected Display display;
	private Composite compUsuario, compBotones, compTabla, compPestanias,composite,composite_1,composite_2,composite_3;
	private Table table_1;
	private Button btnEmpleados, btnClientes, btnVentas, btnInventario,btnCambiarUsr,separador,btnSalir;
	private Label lblNombre, lblCargo, lblFoto;
;

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

		compUsuario = new Composite(shell, SWT.NONE);
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

		compBotones = new Composite(shell, SWT.NONE);
		compBotones.setLayout(null);
		FormData fd_composite_1 = new FormData();
		fd_composite_1.top = new FormAttachment(0, 30);
		fd_composite_1.left = new FormAttachment(compUsuario, 20);
		fd_composite_1.right = new FormAttachment(100, -30);
		fd_composite_1.bottom = new FormAttachment(20, 0);
		compBotones.setLayoutData(fd_composite_1);

		compTabla = new Composite(shell, SWT.NONE);
		compTabla.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_composite_2 = new FormData();
		fd_composite_2.right = new FormAttachment(compBotones, 0, SWT.RIGHT);		
		fd_composite_2.top = new FormAttachment(compPestanias, 0, SWT.TOP);
		fd_composite_2.bottom = new FormAttachment(100, -30);
		fd_composite_2.left = new FormAttachment(compUsuario, 20);
		compTabla.setLayoutData(fd_composite_2);

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
		separador.setLayoutData(new RowData(264, 95));
		separador.setText("separador");
		separador.setVisible(false);
		
		btnSalir = new Button(compPestanias, SWT.NONE);
		btnSalir.setLayoutData(new RowData(264, SWT.DEFAULT));
		btnSalir.setText("Salir");
		


		lblNombre = new Label(compUsuario, SWT.NONE);
		lblNombre.setBounds(100, 10, 160, 37);

		lblCargo = new Label(compUsuario, SWT.NONE);
		lblCargo.setBounds(100, 53, 79, 15);

		lblFoto = new Label(compUsuario, SWT.NONE);
		lblFoto.setBounds(10, 10, 65, 58);



		table_1 = new Table(compTabla, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);

		
		composite = new Composite(compBotones, SWT.NONE);
		composite.setBounds(0, 0, 534, 78);
		
		composite_1 = new Composite(compBotones, SWT.NONE);
		composite_1.setSize(534, 78);
		
		composite_2 = new Composite(compBotones, SWT.NONE);
		composite_2.setSize(534, 78);
		
		composite_3 = new Composite(compBotones, SWT.NONE);
		composite_3.setSize(534, 78);
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
}
