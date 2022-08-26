package com.vistas;

import org.eclipse.swt.widgets.Display;



public class VistaInicial {
	
	public static ReportWindow reportWindow;
	
	public VistaInicial() {
	    	Display display = new Display();
	    	reportWindow = new ReportWindow(display);
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
	    new VistaInicial();
	  }

}
