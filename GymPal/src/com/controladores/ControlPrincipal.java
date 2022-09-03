package com.controladores;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.modelos.ModeloEmpleado;
import com.modelos.ModeloPrincipal;
import com.vistas.VCarga;
import com.vistas.VPrincipal;
import com.vistas.VUsuarios;

public class ControlPrincipal implements Listener {

	private final String CLIENTES = "Button {Abrir Adminstracion de Clientes}";
	private final String EMPLEADOS = "Button {Abrir Administracion de Empleados}";
	private final String CONTABILIDAD = "Button {Abrir rea de Contabilidad}";
	private final String INVENTARIO = "Button {Abrir Administracion de inventario}";

	ModeloPrincipal modelo;
	VPrincipal vista;

	public ControlPrincipal(VPrincipal vista, ModeloPrincipal modelo) {
		this.modelo = modelo;
		this.vista = vista;
	}

	@Override
	public void handleEvent(Event e) {
		System.out.println(e.widget);
		switch (e.type) {
		case SWT.Selection:
			accionBoton(e);
			break;
		case SWT.TRAVERSE_RETURN:
			System.out.println("click de mouse");
			// vista.setPasswordText(vista.aumentarContador());
			break;
		}
	}

	public void accionBoton(Event e) {

		switch (e.widget.toString()) {
		case CLIENTES:
			adminClientes();
			break;
		case EMPLEADOS:
			adminEmpleados();
			break;
		case CONTABILIDAD:
			adminContabilidad();
			break;
		case INVENTARIO:
			adminInventario();
			break;
		default:
			break;
		}

	}

	public void iniciarSesion() {
		VCarga carga = new VCarga(vista.getDisplay());
		ModeloEmpleado modeloU = new ModeloEmpleado();
		VUsuarios vistaU = new VUsuarios(vista.getDisplay());
		ControlEmpleados controlU = new ControlEmpleados(vistaU, modeloU);
		vistaU.setControlador(controlU);
		vistaU.open();
	}

	public void adminClientes() {
		System.out.println("aqui va la ventana de clientes");

	}

	public void adminEmpleados() {
		System.out.println("aqui va la ventana de empleados");

	}

	public void adminContabilidad() {
		System.out.println("aqui va la ventana de contabilidad");

	}

	public void adminInventario() {
		System.out.println("aqui va la ventana de inventario");
	}

}
