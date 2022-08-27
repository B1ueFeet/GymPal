package com.modelos;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.objetos.Cliente;
import com.objetos.Conexion;

public class ClienteCrud {
	
	private Connection connection;
    private PreparedStatement sentencia;
    private boolean estadoOp;
	
	public boolean crear(Cliente c) throws SQLException {
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO productos(nombre, cantidad, precio)\n" + 
					"VALUES(?,?,?)";
			sentencia = connection.prepareStatement(sql);
			sentencia.setString(1, c.getNombre());
			sentencia.setInt(2, c.getCedula());
			sentencia.setString(3, c.getCorreo());
			
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
	
	public Cliente leerProducto(int id) throws SQLException {
		String sql = null;
		ResultSet resultSet = null;
		Cliente c = new Cliente();
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "select * from productos where _id = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1, id);
			
			resultSet = sentencia.executeQuery();
			
			if(resultSet.next()) {
				c.setId(resultSet.getInt(1));
				c.setNombre(resultSet.getString(2));
				c.setCedula(resultSet.getInt(3));
				c.setCorreo(resultSet.getString(4));
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		finally{
			connection.close();
			sentencia.close();
		}
		
		return c;
	}
	
	public boolean actualizar(Cliente cliente, int _id) throws SQLException{
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE productos SET nombre = ? , precio = ?, cantidad = ? \n "
					+ " WHERE _id = ?";
			
			sentencia = connection.prepareStatement(sql);
			sentencia.setString(1, cliente.getNombre());
			sentencia.setInt(2, cliente.getCedula());
			sentencia.setString(3, cliente.getCorreo());
			sentencia.setInt(4, _id);
			
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
	
	public boolean eliminar(int _id) throws SQLException {
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
	
	public List<Cliente> obtenerProductos(int _id, String nombre, int cedula, String correo) throws SQLException{
		
		ResultSet resulSet = null; 
		List<Cliente> listaProductos = new ArrayList<>();
		
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
