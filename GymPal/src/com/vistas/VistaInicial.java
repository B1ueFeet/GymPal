package com.vistas;

import org.eclipse.swt.widgets.Display;

public class VistaInicial {
	
	public static Facturas factura;
	
	public VistaInicial() {
		 Display display = new Display();
	      //factura = new Facturas(display);
	        Splash splashWindow = new Splash(display);
	        while((Display.getCurrent().getShells().length != 0)
	                 && !Display.getCurrent().getShells()[0].isDisposed()){
	        	
	             if(!display.readAndDispatch())
	             {
	                 display.sleep();
	             }
	        }     
	}
	
	public static void main(String[] args) 
	  {
	    new VistaInicial();
	  }

}
