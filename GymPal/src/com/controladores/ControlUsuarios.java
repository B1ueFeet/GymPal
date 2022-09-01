package com.controladores;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.modelos.ModeloUsuario;
import com.vistas.VUsuarios;

public class ControlUsuarios implements Listener{
	
	ModeloUsuario modelo;
	VUsuarios vista;
	
	
	
	
	public ControlUsuarios(VUsuarios vista, ModeloUsuario modelo) {
		this.modelo = modelo;
		this.vista = vista;
	}




	@Override
	public void handleEvent(Event e) {
		System.out.println(e.touches);
		switch (e.type) {
		case SWT.Selection:
			System.out.println("Vas bien");
			break;
		case SWT.TRAVERSE_RETURN:
			System.out.println("click de mouse");
			//vista.setPasswordText(vista.aumentarContador());
			break;
		}
		
	}
	
	


}
