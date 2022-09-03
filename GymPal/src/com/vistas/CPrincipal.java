package com.vistas;

import org.eclipse.swt.widgets.Display;

import com.controladores.ControlEmpleados;
import com.controladores.ControlPrincipal;
import com.modelos.ModeloEmpleado;
import com.modelos.ModeloPrincipal;
import com.objetos.Empleado;

public class CPrincipal {

	public CPrincipal() {
		Display display = new Display();
		// principal = new VPrincipal(display);
		/*
		 * VCarga carga = new VCarga(display); //Splash splashWindow = new
		 * Splash(display); while((Display.getCurrent().getShells().length != 0) &&
		 * !Display.getCurrent().getShells()[0].isDisposed()) {
		 * if(!display.readAndDispatch()) { display.sleep(); } }
		 */
		ModeloPrincipal modelo = new ModeloPrincipal();
		VPrincipal vista = new VPrincipal(display);
		ControlPrincipal control = new ControlPrincipal(vista, modelo);
		vista.setControlador(control);
		control.iniciarSesion();
		vista.open();

	}

	public static void main(String[] args) {
		new CPrincipal();
	}

}
