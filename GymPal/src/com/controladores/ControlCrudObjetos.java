package com.controladores;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.modelos.ModeloCliente;
import com.modelos.ModeloEmpleado;
import com.vistas.VCrudObjetos;
import com.vistas.VUsuarios;

public class ControlCrudObjetos implements Listener{
	
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
			//accionBoton(e);
			break;
		case SWT.TRAVERSE_RETURN:
			System.out.println("click de mouse");
			//vista.setPasswordText(vista.aumentarContador());
			break;
		}
	}
	
	

}
