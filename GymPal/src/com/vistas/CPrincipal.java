package com.vistas;

import org.eclipse.swt.widgets.Display;

import com.controladores.ControlUsuarios;
import com.modelos.ModeloUsuario;
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
	        ModeloUsuario modeloU = new ModeloUsuario();
	        VUsuarios vistaU = new  VUsuarios(display);
	       ControlUsuarios controlU =new ControlUsuarios(vistaU,modeloU);
	       vistaU.setControlador(controlU);
	       vistaU.open();
	       
	    }
	
	public static void main(String[] args) 
	  {
		Empleado emp = new Empleado(1,"S","a",1717171717, Empleado.Cargo.GERENTE );
		System.out.println(emp.getCargo());
	    new CPrincipal();
	  }

}
