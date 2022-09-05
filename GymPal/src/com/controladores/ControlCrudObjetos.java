package com.controladores;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.modelos.ModeloCliente;
import com.modelos.ModeloEmpleado;
import com.objetos.Cliente;
import com.objetos.Empleado;
import com.vistas.VCrudObjetos;
import com.vistas.VUsuarios;

public class ControlCrudObjetos implements Listener{
	
	private final String NUEVO = "Button {Nuevo}";
	private final String CANCELAR = "Button {Cancelar}";
	private final String ACTUALIZAR = "Button {actualizar}";
	
	ModeloEmpleado modeloE;
	ModeloCliente modeloC;
	//modeloProductos modeloP;
	VCrudObjetos vista;

	
	
	public ControlCrudObjetos(VCrudObjetos vista , ModeloEmpleado modeloE , ModeloCliente modeloC) {
		this.modeloE = modeloE;
		this.modeloC= modeloC;
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
			//vista.setPasswordText(vista.aumentarContador());
			break;
		}
	}
	
	public void accionBoton(Event e) {
		
		
		switch (e.widget.toString()) {
		case NUEVO:
			nuevo(vista.getEstado());
			break;
		case ACTUALIZAR:
			actualizar(vista.getEstado());
			break;
		case CANCELAR:
			vista.apagar();
			break;
		default:
			break;
		}

	}
	
	public void actualizar(int estado) {
		switch (estado) {
		case 0:
			System.out.println("aqui se actualizaria");
			List<String> strings = obtenerListaClientes().stream().map(a-> a.getNombre() + " " + a.getApellido()).collect(Collectors.toList());
			String[] nombres = new String[strings.size()];
			nombres = strings.toArray(nombres);
			Object opcion = JOptionPane.showInputDialog(null,"Selecciona un color", "Elegir",JOptionPane.QUESTION_MESSAGE,null,nombres, nombres[0]);			
			String resultado [] = opcion.toString().split(" ");
			//String nombre, String apellido, String cedula, String celular, String direccion, String correo, int activo
			Cliente c = new Cliente (vista.getNombreCli(),vista.getApellidoCli(),vista.getCedulaCli(),vista.getCelularCli(),vista.getDireccionCli(),vista.getCorreoCli(),1);
			try {
				modeloC.actualizar(c , resultado[0]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1:
			
			break;
		case 2:
			vista.apagar();
			break;
		default:
			break;
		}
	}
	public void nuevo(int estado) {
		switch (estado) {
		case 0:
			Cliente c = new Cliente (vista.getNombreCli(),vista.getApellidoCli(),vista.getCedulaCli(),vista.getCelularCli(),vista.getDireccionCli(),vista.getCorreoCli(),1);
			try {
				modeloC.crear(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
		case 1:
			
			break;
		case 2:
			vista.apagar();
			break;
		default:
			break;
		}
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

}
