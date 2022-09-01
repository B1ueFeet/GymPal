package com.controladores;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.eclipse.swt.widgets.Display;

import com.modelos.ModeloUsuario;
import com.objetos.Empleado.Cargo;
import com.vistas.VPrincipal;
import com.objetos.Usuario;

public class Verificador {

	String Usr, pas;

	public Verificador(Display display) throws SQLException {

		JTextField username = new JTextField();
		JTextField password = new JPasswordField();
		Object[] message = { "Username:", username, "Password:", password };

		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			if (verificarUsuario(username.getText(), password.getText())) {
				JOptionPane.showMessageDialog(null, "Hello " + username.getText());
				VPrincipal principal = new VPrincipal(display);
			} else {
				JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTOS");
				Verificador usr = new Verificador(display);
			}
		} else {
			System.out.println("Login canceled");
			System.exit(0);
		}
	}

	public boolean verificarUsuario(String str, String pas) throws SQLException {

		Usuario usr = new Usuario();
		ModeloUsuario ucd = new ModeloUsuario();
		usr = ucd.leerUsuario(str);

		if (usr == null) {
			return false;
		} else if (usr.getName().equals(str)) {
			if (usr.getPassword().equals(pas)) {
				return true;
			}
		}

		return false;
	}

}
