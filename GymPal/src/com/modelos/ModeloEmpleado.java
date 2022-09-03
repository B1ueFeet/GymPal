package com.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.objetos.Cliente;
import com.objetos.Conexion;
import com.objetos.Empleado;
import com.objetos.Productos;
import com.objetos.Usuario;

public class ModeloEmpleado {

	private Connection connection;
	private PreparedStatement sentencia;
	private boolean estadoOp;

	// OBTENER USUARIO NOMBRE Y CONTRASEÑA
	public Empleado verificarUsuario(String usr) throws SQLException {
		String sql = null;
		ResultSet resultSet = null;
		Empleado e = new Empleado();
		estadoOp = false;
		connection = obtenerConexion();
		// select username,password,cargo,nombre,apellido from empleados where activo = 1 and username = 'socastillo'
		try {
			sql = "select username,password,privilegio from usuarios where activo = 1 and username = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setString(1, usr);
			resultSet = sentencia.executeQuery();

			if (resultSet.next()) {
				e.setUserName(usr);
				e.setPassword(resultSet.getString(2));
				e.setCargo(resultSet.getInt(3));
				e.setNombre(resultSet.getString(4));
				e.setApellido(resultSet.getString(5));
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

	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();

	}

}
