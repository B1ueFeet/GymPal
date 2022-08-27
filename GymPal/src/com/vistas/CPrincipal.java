package com.vistas;

import org.eclipse.swt.widgets.Display;

import com.objetos.Empleado;




public class CPrincipal {
	
	public CPrincipal() {
	    	Display display = new Display();
	    	//principal = new VPrincipal(display);
	    	VCarga carga  = new VCarga(display);
	        //Splash splashWindow = new Splash(display);
	        while((Display.getCurrent().getShells().length != 0) && !Display.getCurrent().getShells()[0].isDisposed())
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
	    new CPrincipal();
	  }

}
