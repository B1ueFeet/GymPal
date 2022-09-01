package com.modelos;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.objetos.Cliente;
import com.objetos.Conexion;
import com.objetos.Productos;
import com.objetos.Usuario;

public class UsrCrud {
	
	private Connection connection;
    private PreparedStatement sentencia;
    private boolean estadoOp;
	
	//select username,password,privilegio from usuarios where activo = 1 and username = 'socastillo'
    
    public Usuario leerUsuario(String usr) throws SQLException {
		String sql = null;
		ResultSet resultSet = null;
		Usuario p = new Usuario();
		estadoOp = false;
		connection = obtenerConexion();

		try {
			sql = "select username,password,privilegio from usuarios where activo = 1 and username = ?";
			sentencia = connection.prepareStatement(sql);

			sentencia.setString(1, usr);
			resultSet = sentencia.executeQuery(); 
			if (resultSet.next()) { 
				p.setName(resultSet.getString(1));
				p.setPassword(resultSet.getString(2));
				p.setPrivilegio(resultSet.getString(3));
			}else {return null;}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connection.close();
			sentencia.close();

		}
		return p;

	}
	

	
	
	
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();

	}
	
	
}
