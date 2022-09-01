package com.vistas;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;

import com.controladores.Verificador;

import org.eclipse.swt.custom.ViewForm;

import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class VPrincipal {

	protected Shell shell;
	private Display display;
	
	public Shell getShell() {
		return shell;
	}

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
	    Image image = new Image(display, dirI);
	    final Tray tray = display.getSystemTray();

		shell = new Shell();
		shell.setImage(ICONO);
		shell.setSize(610, 421);
		shell.setText("GYMpal");
		
		//tray
	    if (tray == null) {
	        System.out.println("The system tray is not available");
	      } else {
	        final TrayItem item = new TrayItem(tray, SWT.NONE);
	        item.setToolTipText("SWT TrayItem");
	        item.addListener(SWT.Show, new Listener() {
	          public void handleEvent(Event event) {
	            System.out.println("show");
	          }
	        });
	        item.addListener(SWT.Hide, new Listener() {
	          public void handleEvent(Event event) {
	            System.out.println("hide");
	          }
	        });
	        item.addListener(SWT.Selection, new Listener() {
	          public void handleEvent(Event event) {
	            System.out.println("selection");
	          }
	        });
	        item.addListener(SWT.DefaultSelection, new Listener() {
	          public void handleEvent(Event event) {
	            System.out.println("default selection");
	          }
	        });
	        final Menu menu = new Menu(shell, SWT.POP_UP);
	        for (int i = 0; i < 8; i++) {
	          MenuItem mi = new MenuItem(menu, SWT.PUSH);
	          mi.setText("Item" + i);
	          mi.addListener(SWT.Selection, new Listener() {
	            public void handleEvent(Event event) {
	              System.out.println("selection " + event.widget);
	            }
	          });
	          if (i == 0)
	            menu.setDefaultItem(mi);
	        }
	        item.addListener(SWT.MenuDetect, new Listener() {
	          public void handleEvent(Event event) {
	            menu.setVisible(true);
	          }
	        });
	        item.setImage(image);
	      }
	      // fin del tray
		
		PopupMenu popup = new PopupMenu();
		
		ViewForm viewForm = new ViewForm(shell, SWT.NONE);
		viewForm.setBounds(278, 164, 0, 0);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				Prueba pr = new Prueba(display);
				do {
					if(pr.shell.isDisposed()) {
						shell.setVisible(true);
					}
				}while(!pr.shell.isDisposed());
			}
		});
		btnNewButton.setBounds(47, 44, 75, 25);
		btnNewButton.setText("Inventario");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				VFacturas facturas = new VFacturas(display);
				do {
					if(facturas.shell.isDisposed()) {
						shell.setVisible(true);
					}
				}while(!facturas.shell.isDisposed());
			//
			}
		});
		btnNewButton_1.setBounds(47, 118, 75, 25);
		btnNewButton_1.setText("Caja");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		shell.setVisible(false);
				VPersonal personal = new VPersonal(display);
				do {
					if(personal.shell.isDisposed()) {
						shell.setVisible(true);
					}	
				}while(!personal.shell.isDisposed());
			}
		});
		btnNewButton_2.setBounds(486, 44, 75, 25);
		btnNewButton_2.setText("Personal");
		
		
		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		btnNewButton_3.setBounds(486, 118, 75, 25);
		btnNewButton_3.setText("Contabilidad");
		
		Button btnNewButton_4 = new Button(shell, SWT.NONE);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_4.setBounds(486, 343, 75, 25);
		btnNewButton_4.setText("Salir");
		
		Button btnNewButton_5 = new Button(shell, SWT.NONE);
		btnNewButton_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				try {
					Verificador usr = new Verificador(display);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_5.setBounds(388, 343, 75, 25);
		btnNewButton_5.setText("Cambiar de usuario");
		


	}
}
