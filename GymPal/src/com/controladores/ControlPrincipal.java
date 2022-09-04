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
		int op = 0;
		switch (e.widget.toString()) {
		case CLIENTES:
			op = 0;
			break;
		case EMPLEADOS:
			op = 1;
			break;
		case VENTAS:
			op = 2;
			vista.llenarLista(obtenerListaClientes());
			break;
		case INVENTARIO:
			op = 3;
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
		obtenerListaEmpleados();
		//vista.cargarTabla1(op);
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
	
	public void obtenerListaEmpleados() {
		ModeloEmpleado modeloU = new ModeloEmpleado();
		VUsuarios vistaU = new VUsuarios(vista.getDisplay());
		ControlEmpleados controlU = new ControlEmpleados(vistaU, modeloU);
		vistaU.setControlador(controlU);
		try {
			vista.cargarTablaEmpleados(modeloU.LeerProductos());
			vista.cargarTablaClientes(modeloU.LeerProductos());
			vista.cargarTablaVentas(modeloU.LeerProductos());
			vista.cargarTablaInventario(modeloU.LeerProductos());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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


}
