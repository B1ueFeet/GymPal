package com.vistas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Principal {

	protected Shell shell;
	private Display display;
	
	public Principal(Display display) {
		this.display = display;
	}
	
	public static void main(String[] args) {
		try {
			Principal window = new Principal(Display.getDefault());
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		shell = new Shell();
		shell.setSize(610, 421);
		shell.setText("SWT Application");

	}

}
