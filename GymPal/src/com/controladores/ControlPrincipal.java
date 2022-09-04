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

	private final String CLIENTES = "Button {Clientes}";
	private final String EMPLEADOS = "Button {Empleados}";
	private final String VENTAS = "Button {Ventas}";
	private final String INVENTARIO = "Button {Inventario}";
	private final String CAMBIAR_USR = "Button {Cambiar Usuario}";
	private final String SALIR = "Button {Salir}";

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
		case VENTAS:
			adminVentas();
			break;
		case INVENTARIO:
			adminInventario();
			break;
		case CAMBIAR_USR:
			vista.pausar(true);
			ventanaUsuarios();
			vista.pausar(false);
			break;
		case SALIR:
			vista.apagar();
			break;
		default:
			break;
		}

	}

	public void iniciarSesion() {
		VCarga carga = new VCarga(vista.getDisplay());
		ventanaUsuarios();
	}
	
	public void ventanaUsuarios() {
		ModeloEmpleado modeloU = new ModeloEmpleado();
		VUsuarios vistaU = new VUsuarios(vista.getDisplay());
		ControlEmpleados controlU = new ControlEmpleados(vistaU, modeloU);
		vistaU.setControlador(controlU);
		vistaU.open();
		vista.setEmpleado(controlU.getCargo(), controlU.getEmpleado());
		vista.controlAcceso(controlU.getCargo());
	}

	public void adminClientes() {
		System.out.println("aqui va la ventana de clientes");

	}

	public void adminEmpleados() {
		System.out.println("aqui va la ventana de empleados");

	}

	public void adminVentas() {
		System.out.println("aqui va la ventana de contabilidad");

	}

	public void adminInventario() {
		System.out.println("aqui va la ventana de inventario");
	}
}

