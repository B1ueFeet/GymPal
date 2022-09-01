package com.controladores;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.modelos.ModeloUsuario;
import com.objetos.Usuario;
import com.vistas.VUsuarios;

public class ControlUsuarios implements Listener{
	
	ModeloUsuario modelo;
	VUsuarios vista;
	private final String INGRESAR = "Button {Ingresar}";
	private final String CANCELAR = "Button {Cancelar}";
	private final String RECUPERAR = "Button {¿Olvidaste tu Uusario?}";
	
	
	
	
	
	public ControlUsuarios(VUsuarios vista, ModeloUsuario modelo) {
		this.modelo = modelo;
		this.vista = vista;
	}




	@Override
	public void handleEvent(Event e) {
		System.out.println(e.widget);
		switch (e.type) {
		case SWT.Selection:
			accionBoton(e);
			System.out.println("Vas bien");
			break;
		case SWT.TRAVERSE_RETURN:
			System.out.println("click de mouse");
			vista.setPasswordText(vista.aumentarContador());
			break;
		}
		
	}
	
	public void accionBoton(Event e) {
		
		switch (e.widget.toString()) {
		case INGRESAR:
			siguienteAccion(verificarUsuario(vista.getUsuario(),vista.getContraseña()));
				
			
			break;
		case RECUPERAR:
			System.out.println("aqui se enviaria un correo");
			break;
		case CANCELAR:
			System.exit(0);
			break;
		default:
			break;
		}
		
	}
	
	public boolean verificarUsuario(String str, String pas) {

		Usuario usr = new Usuario();
		ModeloUsuario ucd = new ModeloUsuario();

			try {
				usr = ucd.leerUsuario(str);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		if (usr == null) {
			return false;
		} else if (usr.getName().equals(str)) {
			if (usr.getPassword().equals(pas)) {
				return true;
			}
		}

		return false;
	}
	
	private void siguienteAccion(boolean b) {
		if (b) {
            JOptionPane.showMessageDialog(null, "Ingreso Exitoso");
			vista.apagar();
		}else {
			JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectos", CANCELAR, 0);
		}
	}
	
	


}
