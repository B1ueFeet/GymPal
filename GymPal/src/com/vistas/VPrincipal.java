package com.vistas;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class VPrincipal {

	protected Shell shell;
	private Display display;
	
	public VPrincipal(Display display) {
		this.display = display;
		open();
	}
	


	/**
	 * Open the window.
	 */
	public void open() {
		createContents();
		shell.open();
		shell.layout();

	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		String dirI = this.getClass().getResource("/recursos/imagenes/icono_colores.png").getPath();
		final Image ICONO = new Image(display,dirI);
		shell = new Shell();
		shell.setImage(ICONO);
		shell.setSize(610, 421);
		shell.setText("GYMpal");

	}

}
