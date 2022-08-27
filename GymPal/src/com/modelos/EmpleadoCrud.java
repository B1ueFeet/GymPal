package com.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.objetos.Conexion;
import com.objetos.Empleado;


public class EmpleadoCrud {

	private Connection connection;
    private PreparedStatement sentencia;
    private boolean estadoOp;
	
	public boolean crearE(Empleado emp) throws SQLException {
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO productos(nombre, cantidad, precio)\n" + 
					"VALUES(?,?,?)";
			sentencia = connection.prepareStatement(sql);
			sentencia.setString(1, emp.getNombre());
			sentencia.setString(2, emp.getApellido());
			sentencia.setInt(3, emp.getCedula());
			sentencia.setString(4, emp.getCargo().toString());
			
			estadoOp = sentencia.executeUpdate() > 0;
			connection.commit();
			sentencia.close();
			connection.close();
			
		}catch(SQLException e) {
			
			connection.rollback();
			e.printStackTrace();
		}
		
		finally{
			connection.close();
		}
		
		return estadoOp;
	}
	
	public Empleado leerE(int id) throws SQLException {
		String sql = null;
		ResultSet resultSet = null;
		Empleado emp = new Empleado();
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "select * from productos where _id = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1, id);
			
			resultSet = sentencia.executeQuery();
			
			if(resultSet.next()) {
				emp.setId(resultSet.getInt(1));
				emp.setNombre(resultSet.getString(2));
				emp.setApellido(resultSet.getString(3));
				emp.setCedula(resultSet.getInt(4));
				emp.setCargo(resultSet.getString(5));
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		finally{
			connection.close();
			sentencia.close();
		}
		
		return emp;
	}
	
	public boolean actualizarE(Empleado empleado, int _id) throws SQLException{
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE productos SET nombre = ? , precio = ?, cantidad = ? \n "
					+ " WHERE _id = ?";
			
			sentencia = connection.prepareStatement(sql);
			sentencia.setString(1, empleado.getNombre());
			sentencia.setString(2, empleado.getApellido());
			sentencia.setInt(3, empleado.getCedula());
			sentencia.setString(4, empleado.getCargo().toString());
			sentencia.setInt(5, _id);
			
			estadoOp = sentencia.executeUpdate() > 0;
			connection.commit();
			
			
		}catch(SQLException e){

			connection.rollback();
			e.printStackTrace();
		}
		finally {
			sentencia.close();
			connection.close();
		}
		return estadoOp;
	}
	
	public boolean eliminarE(int _id) throws SQLException {
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();
			
		try {
			connection.setAutoCommit(false);
			sql = "DELETE from productos WHERE _id = ?";
			
			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1, _id);
			
			estadoOp = sentencia.executeUpdate() > 0;
			connection.commit();
			
		}catch(SQLException e) {
			connection.rollback();
			e.printStackTrace();
			
		}finally {
			sentencia.close();
			connection.close();
		}return estadoOp;
	}
	
	public List<Empleado> obtenerE(int _id, String nombre, String apellido,int cedula, String cargo) throws SQLException{
		
		ResultSet resulSet = null; 
		List<Empleado> listaProductos = new ArrayList<>();
		
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "";
			sentencia = connection.prepareStatement(sql);
			resulSet = sentencia.executeQuery(sql);
			
			while(resulSet.next()  ) {

				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			sentencia.close();
			connection.close();
		}return listaProductos;
	}
	
	private Connection obtenerConexion() throws SQLException{
		
		return Conexion.getConnection();
	}
}
