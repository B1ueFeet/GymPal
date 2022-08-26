package Crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	public static Connection getConnection() {
		String url ="jdbc:postgresql://localhost:5432/gympal";
		String usuario = "postgres";
		String contrasenia = "admin";
		Connection connection = null;
		
		if (connection ==null) {
			try {
				try {
					
					Class.forName("org.postgresql.Driver");
					
				}catch(ClassNotFoundException ex) {
					System.out.println("Error al registrar el driver de PotgresSQL"+ex);
					
				}
				
				connection =  DriverManager.getConnection(url,usuario,contrasenia);
				boolean valid = connection.isValid(50000);
				System.out.println(valid?"CONEXIÓN VÁLIDA":"CONEXIÓN FALLIDA");
				
			}catch(java.sql.SQLException sqle) {
				System.out.println("ERROR"+ sqle);
				
			}
			
		}
		return connection;
	}

}