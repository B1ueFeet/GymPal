package com.modelos;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.eclipse.swt.widgets.Display;

import com.modelos.Empleado.Cargo;

public class Verificador {
	
	String Usr, pas;
		
	public Verificador() {
		
		JTextField username = new JTextField();
		JTextField password = new JPasswordField();
		Object[] message = {
		    "Username:", username,
		    "Password:", password
		};

		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
		    if (username.getText().equals("h") && password.getText().equals("h")) {
		        System.out.println("Login successful");
		    } else {
		        System.out.println("login failed");
		    }
		} else {
		    System.out.println("Login canceled");
		}
		
		JOptionPane.showMessageDialog(null, "Hello ");
		
	}
		

	
	
	public void verificarUsuario(String str) {
	
			Cargo aux = null;
			switch (str) {
			case "GERENTE":
				aux = Cargo.GERENTE;
				break;
			case "ENTRENADOR":
				aux = Cargo.ENTRENADOR;
				break;
			case "RECEPCIONISTA":
				aux = Cargo.RECEPCIONISTA;
				break;
			default:
				break;
			}
			
			this.cargo = aux;
			
		}
		
	}



