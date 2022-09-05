package com.controladores;

import java.sql.SQLException;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.modelos.ModeloCliente;
import com.modelos.ModeloEmpleado;
import com.modelos.ModeloPrincipal;
import com.objetos.Cliente;
import com.objetos.Empleado;
import com.vistas.VCarga;
import com.vistas.VCrudObjetos;
import com.vistas.VPrincipal;
import com.vistas.VUsuarios;

public  class ControlPrincipal implements Listener {

	private final String CLIENTES = "Button {Clientes}";
	private final String EMPLEADOS = "Button {Empleados}";
	private final String INVENTARIO = "Button {Inventario}";
	private final String CAMBIAR_USR = "Button {Cambiar Usuario}";
	private final String SALIR = "Button {Salir}";

	// CLIENTES

	private final String ACTUALIZAR_TABLA = "Button {Actualizar Tabla}";
	private final String ELIMINAR_CLI = "Button {Eliminar Cliente}";
	private final String NUEVO_CLI = "Button {Nuevo Cliente}";
	private final String TABLA = "Table {}";

	ModeloPrincipal modelo;
	VPrincipal vista;

	public ControlPrincipal(VPrincipal vista, ModeloPrincipal modelo) {
		this.modelo = modelo;
		this.vista = vista;

	}

	@Override
	public void handleEvent(Event e) {
		System.out.println(e);
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
		int op = 0;
		switch (e.widget.toString()) {
		case ACTUALIZAR_TABLA:
		case CLIENTES:
			op = 0;
			vista.cargarTablaClientes(obtenerListaClientes());
			break;
		case NUEVO_CLI:
			ventanaCrudObjetos(0);
			break;
		case ELIMINAR_CLI:
			System.out.println(vista.getAuxT());
			break;
		case EMPLEADOS:
			op = 1;
			vista.cargarTablaEmpleados(obtenerListaEmpleados());
			break;
		case INVENTARIO:
			op = 2;
			break;
		case CAMBIAR_USR:
			vista.pausar(true);
			ventanaUsuarios();
			vista.pausar(false);
			break;
		case SALIR:
			vista.apagar();
			return;
		default:
			break;
		}
		// obtenerListaEmpleados();
		// vista.cargarTabla1(op);
		vista.showComposite(op);

	}

	public void iniciarSesion() {
		// VCarga carga = new VCarga(vista.getDisplay());
		ventanaUsuarios();
	}

	public void ventanaUsuarios() {
		ModeloEmpleado modeloU = new ModeloEmpleado();
		VUsuarios vistaU = new VUsuarios(vista.getDisplay());
		ControlEmpleados controlU = new ControlEmpleados(vistaU, modeloU);
		vistaU.setControlador(controlU);
		try {
			modeloU.LeerProductos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vistaU.open();
		vista.setEmpleado(controlU.getCargo(), controlU.getEmpleado());
		vista.controlAcceso(controlU.getCargo());
	}

	public List<Empleado> obtenerListaEmpleados() {
		ModeloEmpleado modeloU = new ModeloEmpleado();
		try {
			return modeloU.LeerProductos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public List<Cliente> obtenerListaClientes() {
		ModeloCliente modeloU = new ModeloCliente();
		try {
			return modeloU.listaClientes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public void ventanaCrudObjetos(int estado) {
		ModeloEmpleado modeloE = new ModeloEmpleado();
		ModeloCliente modeloC = new ModeloCliente();
		VCrudObjetos vistaC = new VCrudObjetos(vista.getDisplay());
		ControlCrudObjetos control = new ControlCrudObjetos(vistaC, modeloE, modeloC);
		vistaC.setControlador(control);
		vistaC.open(estado);
	}
	

}
