package com.modelos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.objetos.Cliente;
import com.objetos.Conexion;
import com.objetos.Empleado;
import com.objetos.Productos;
import com.objetos.Usuario;

public class ModeloEmpleado {

	private Connection connection;
	private PreparedStatement sentencia;
	private boolean estadoOp;
	private String correo;

	// OBTENER USUARIO NOMBRE Y CONTRASEÑA
	public Empleado verificarExistencia(String usr) throws SQLException {
		String sql = null;
		ResultSet resultSet = null;
		Empleado e = new Empleado();
		estadoOp = false;
		connection = obtenerConexion();
		// select username,password,cargo,nombre,apellido from empleados where activo = 1 and username = 'socastillo'
		try {
			sql = "select * from empleados where (username = ? or cedula = ?)";
			sentencia = connection.prepareStatement(sql);
			sentencia.setString(1, usr);
			sentencia.setString(2, usr);
			resultSet = sentencia.executeQuery();

			if (resultSet.next()) {
				e.setNombre(resultSet.getString(2));
				e.setApellido(resultSet.getString(3));
				e.setCedula(resultSet.getString(4));
				e.setCelular(resultSet.getString(5));
				e.setDireccion(resultSet.getString(6));
				e.setCorreo(resultSet.getString(7));
				e.setCargo(resultSet.getInt(8));
				e.setUserName(resultSet.getString(9));
				e.setPassword(resultSet.getString(10));
			} else {
				return null;
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		} finally {
			connection.close();
			sentencia.close();

		}
		return e;
	}
	
    public HashSet<Empleado> LeerProductos() throws SQLException {
        String sql = null;
        ResultSet resultSet = null;
        connection = obtenerConexion();
        HashSet<Empleado> listaProductos = new HashSet<>();
        connection = obtenerConexion();

        try {
            sql = "SELECT * FROM empleados";
            sentencia = connection.prepareStatement(sql);
            resultSet = sentencia.executeQuery();
            resultSet.next();
            do {
            	System.out.println(resultSet.getString(9));
                Empleado auxProd = verificarExistencia(resultSet.getString(9));
                listaProductos.add(auxProd);
                System.out.println(auxProd);
            } while (resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
            sentencia.close();
        }
        return listaProductos;
    }


	// VERIFICAR ENVIAR CORREO
		public boolean correo(String cedula) throws SQLException {
			Empleado e = verificarExistencia(cedula);
			if(e==null) {
				return false;
			}else {

			System.out.println(e.toString());
			enviarCorreo(e);
			
			return true;
			}
		}
		
		// ENVIAR CORREO
		public void enviarCorreo(Empleado e) {

	        String from = "gympal.app@outlook.com"; // Dirección de correo electrónico del remitente
	        String to = e.getCorreo(); // Correo electrónico del destinatario
	        // Obtiene las propiedades del sistema, que se utilizan principalmente para establecer parámetros relacionados con el correo electrónico.
	        Properties properties = System.getProperties();
	        // Configure el servidor de transferencia de correo. Dado que esta es una operación de envío de correo, necesitamos configurar el protocolo smtp. De acuerdo con los requisitos del correo de sincronización oficial de Outlook, configure la dirección del protocolo, el número de puerto y el método de cifrado a su vez
	        properties.setProperty("mail.smtp.host", "smtp.office365.com");
	        properties.setProperty("mail.smtp.port", "587");
	        properties.setProperty("mail.smtp.starttls.enable", "true");
	        // Verificación del usuario y volver a la sesión, activar la verificación del usuario, configurar la contraseña de la cuenta para enviar correo electrónico.
	        properties.setProperty("mail.smtp.auth", "true");
	        Session session = Session.getDefaultInstance(properties, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("gympal.app@outlook.com", "mfdsa.3000"); // Contraseña de la cuenta
	            }
	        });

	        // Cree un objeto de mensaje MimeMessage, el encabezado del mensaje se configura con la dirección del buzón de envío y recepción, y el cuerpo del mensaje contiene el título y el contenido del mensaje. Tipo de destinatario: TO significa envío directo, CC significa CC y BCC significa CC secreto.
	        try {
	            MimeMessage message = new MimeMessage(session);
	            message.addHeader("X-Mailer", "Microsoft Outlook Express 6.00.2900.2869");
	            message.setFrom(new InternetAddress(from));
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            message.setSubject("Recuperacion de Usuario");
	            String correoe = String.format("Hola %s %s\nEste es el correo de recuperacion de"
	            		+ " cuenta\ntus credenciales son:\n\nNombre de Usuario:		%s\nContraseña:				%s\n\n"
	            		+ "Vuelve a la aplicacion para ingresar\nGracias por utilizar GYMpal", e.getNombre(),e.getApellido(),e.getUserName(),e.getPassword() );
	            message.setText(correoe);

	            Transport.send(message);
	            System.out.println("success");
	        } catch (MessagingException me) {
	        	System.out.println("failed");
	            me.printStackTrace();
	            
	        }

	    }

		private Connection obtenerConexion() throws SQLException {
			return Conexion.getConnection();

		}


}
