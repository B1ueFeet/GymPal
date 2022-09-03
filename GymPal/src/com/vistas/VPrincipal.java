package com.vistas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.controladores.ControlEmpleados;
import com.controladores.ControlPrincipal;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;

public class VPrincipal {

	protected Shell shell;
	protected Display display;
	private Composite compUsuario,compBotones, compTabla, compPestanias;
	private Table table_1;

	public VPrincipal(Display display) {
		this.display = display;
		createContents();
	}

	public static void main(String[] args) {
		try {
			VPrincipal window = new VPrincipal(Display.getDefault());
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shell = new Shell();
		shell.setSize(900, 600);
		shell.setText("SWT Application");
		shell.setLayout(new FormLayout());

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		compUsuario = new Composite(shell, SWT.NONE);
		compUsuario.setLayout(null);
		FormData fd_composite = new FormData();
		fd_composite.right = new FormAttachment(0, 300);
		fd_composite.top = new FormAttachment(0, 30);
		fd_composite.left = new FormAttachment(0, 30);
		compUsuario.setLayoutData(fd_composite);
		
		compPestanias = new Composite(shell, SWT.NONE);
		compPestanias.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_composite1 = new FormData();
		fd_composite1.top = new FormAttachment(compUsuario, 15);
		fd_composite1.bottom = new FormAttachment(100, -30);
		fd_composite1.left = new FormAttachment(0, 30);
		fd_composite1.right = new FormAttachment(0, 300);
		compPestanias.setLayoutData(fd_composite1);
		
		compBotones = new Composite(shell, SWT.NONE);
		compBotones.setLayout(null);
		FormData fd_composite_1 = new FormData();
		fd_composite_1.top = new FormAttachment(0, 30);
		fd_composite_1.left = new FormAttachment(compUsuario, 16);
		fd_composite_1.right = new FormAttachment(100, -30);
		compBotones.setLayoutData(fd_composite_1);
		
		compTabla = new Composite(shell, SWT.NONE);
		compTabla.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_composite_2 = new FormData();
		fd_composite_2.right = new FormAttachment(compBotones, 0, SWT.RIGHT);
		fd_composite_2.top = new FormAttachment(compPestanias, 0, SWT.TOP);
		fd_composite_2.bottom = new FormAttachment(100, -30);
		fd_composite_2.left = new FormAttachment(compUsuario, 16);
		compTabla.setLayoutData(fd_composite_2);
		
		table_1 = new Table(compTabla, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);

	}

	public void setControlador(ControlPrincipal c) {

	}

	public void apagar() {
		shell.close();
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}
}
