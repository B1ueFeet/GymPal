package com.controladores;

import org.eclipse.swt.widgets.Display;

import com.modelos.Empleado;
import com.vistas.Principal;
import com.vistas.Splash;
import com.vistas.VentanaSiguiente;



public class VistaInicial {
	
	public static Principal principal;
	
	public VistaInicial() {
	    	Display display = new Display();
	    	principal = new Principal(display);
	        Splash splashWindow = new Splash(display);
	        while((Display.getCurrent().getShells().length != 0)
	                 && !Display.getCurrent().getShells()[0].isDisposed())
	        {
	             if(!display.readAndDispatch())
	             {
	                 display.sleep();
	             }
	        }    	
	    }
	
	public static void main(String[] args) 
	  {
		Empleado emp = new Empleado(1,"S","a",1717171717, Empleado.Cargo.GERENTE );
		System.out.println(emp.getCargo());
	    new VistaInicial();
	  }

}
