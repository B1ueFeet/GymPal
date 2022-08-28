package com.vistas;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import com.controladores.Verificador;


public class VCarga {

	protected Shell shell;
	//se define algunas variables globales
	private int splashPos =0;
	private final int SPLASH_MAXIMO= 100;
	private Display display;
	
	public VCarga(Display display) {
		this.display = display;
		open();
	}
	
	/**
	 * Open the window.
	 */
	public void open() {
		//Display display = Display.getDefault();
		createContents(display);
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(Display display ){
		//creacion de la imagen y la barra
		String dirS = this.getClass().getResource("/recursos/imagenes/splash.png").getPath();
		
		
		final Image IMAGEN = new Image(display, dirS);
		shell = new Shell(SWT.NONE);
		final ProgressBar BARRA = new ProgressBar(shell,SWT.NONE);
		
		//se pone como maximo el maximo definido antes
		BARRA.setMaximum(SPLASH_MAXIMO);
		//se crea y se inserta un label con la imagen
		Label label = new Label(shell,SWT.NONE);
		label.setImage(IMAGEN);
		//formlayout adapta los componentes a los cambios de la pantalla 
		FormLayout layout = new FormLayout();
		shell.setLayout(layout);
		//FormData permite compilar un conjunto de pares clave/valor
		FormData labelData = new FormData();
		//FormAttachment ancla los valores a algun componente
		labelData.right = new FormAttachment(100,0);
		labelData.bottom = new FormAttachment(100,0);
		label.setLayoutData(labelData);
		//lo mismo pero para la barra
	    FormData progressData = new FormData();
	    progressData.left = new FormAttachment(0, -5);
	    progressData.right = new FormAttachment(100, 0);
	    progressData.bottom = new FormAttachment(100, 0);
	    BARRA.setLayoutData(progressData);
	    //.pack() dimensiona el Splash para que todo su contenido esté EN o ENCIMA de sus tamaños 
	    shell.pack();
		//crea rectangulos de las medidas para guardarlas 
        Rectangle splashRect = shell.getBounds();
        Rectangle displayRect = display.getBounds();
        int x = (displayRect.width - splashRect.width) / 2;
        int y = (displayRect.height - splashRect.height) / 2;
        shell.setLocation(x, y);
		shell.open();
        //metodo para correr de forma asincrona
        display.asyncExec(new Runnable(){

			@Override
			public void run() {
				for(splashPos = 0; splashPos < SPLASH_MAXIMO; splashPos++){
					try {
						 
                        Thread.sleep(100);
                    }
                    catch(InterruptedException e) {
 
                        e.printStackTrace();
                    }
                    BARRA.setSelection(splashPos);
                }
				
				try {
					Verificador usr = new Verificador(display);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                shell.close();
                IMAGEN.dispose(); 
            }
        });
        
        while(splashPos != SPLASH_MAXIMO)
        {
            if(!display.readAndDispatch())
            {
                display.dispose();
            }
        }
	}
}
