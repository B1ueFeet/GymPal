package com.vistas;

import org.eclipse.swt.widgets.Display;

import com.controladores.ControlEmpleados;
import com.modelos.ModeloEmpleado;
import com.objetos.Empleado;




public class CPrincipal {
	
	public CPrincipal() {
	    	Display display = new Display();
	    	//principal = new VPrincipal(display);
	    	/*
	    	VCarga carga  = new VCarga(display);
	        //Splash splashWindow = new Splash(display);
	        while((Display.getCurrent().getShells().length != 0) && !Display.getCurrent().getShells()[0].isDisposed())
	        {
	             if(!display.readAndDispatch())
	             {
	                 display.sleep();
	             }
	        }  */
	        ModeloEmpleado modeloU = new ModeloEmpleado();
	        VUsuarios vistaU = new  VUsuarios(display);
	        ControlEmpleados controlU =new ControlEmpleados(vistaU,modeloU);
	       vistaU.setControlador(controlU);
	       vistaU.open();
	       while(!Display.getCurrent().getShells()[0].isDisposed())
	        {
	             if(!display.readAndDispatch())
	             {
	                 display.sleep();
	             }
	        } 
	    }
	
	public static void main(String[] args) 
	  {
	    new CPrincipal();
	  }

}

