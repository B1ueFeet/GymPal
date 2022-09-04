package com.controladores;


import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.modelos.ModeloEmpleado;
import com.objetos.Empleado;
import com.vistas.VUsuarios;

public class ControlEmpleados implements Listener {

	ModeloEmpleado modelo;
	VUsuarios vista;
	private final String INGRESAR = "Button {Ingresar}";
	private final String CANCELAR = "Button {Cancelar}";
	private final String RECUPERAR = "Button {¿Olvidaste tu Uusario?}";
	private String empleado;
	private int cargo;

	public ControlEmpleados(VUsuarios vista, ModeloEmpleado modeloU) {
		this.modelo = modeloU;
		this.vista = vista;
	}

	@Override
	public void handleEvent(Event e) {
		System.out.println(e.widget);
		switch (e.type) {
		case SWT.Selection:
			accionBoton(e);
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
			siguienteAccion(verificarUsuario(vista.getUsuario(), vista.getContrasenia()));

			break;
		case RECUPERAR:

			recuperarUsuario();
			System.out.println("aqui termina de enviar el correo");
			break;
		case CANCELAR:
			System.exit(0);
			break;
		default:
			break;
		}

	}

	public boolean verificarUsuario(String str, String pas) {

		Empleado usr = new Empleado();

		try {
			usr = this.modelo.verificarExistencia(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (usr == null) {
			return false;
		} else if (usr.getUserName().equals(str)) {
			if (usr.getPassword().equals(pas)) {
				empleado = usr.getNombre() + " " + usr.getApellido();
				cargo = usr.getCargo();
				return true;
			}
		}

		return false;
	}

	private void recuperarUsuario() {
		String cedula = JOptionPane.showInputDialog("Ingrese su cedula");

		try {
			if (modelo.correo(cedula)) {
				JOptionPane.showMessageDialog(null, "Se ha enviado la informacion de ingreso a tu correo");
			} else {
				JOptionPane.showMessageDialog(null,
						"la cedula ingresada es incorrecta o el ususario ya no trabaja aqui");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void siguienteAccion(boolean b) {
		if (b) {
			JOptionPane.showMessageDialog(null, "Bienvenido " + empleado);
			vista.apagar();
		} else {
			JOptionPane.showMessageDialog(null, "Usuario o ContraseÃ±a Incorrectos", CANCELAR, 0);
		}
	}
	
	public String getEmpleado() {
		return empleado;
	}
	public int getCargo() {
		return cargo;
	}

}
