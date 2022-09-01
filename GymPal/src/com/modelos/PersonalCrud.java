package com.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.objetos.Conexion;
import com.objetos.Personal;



public class PersonalCrud {

	private Connection connection;
    private PreparedStatement sentencia;
    private boolean estadoOp;
    
    public boolean crearE(Personal per) throws SQLException {
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO personal(primerNombre, segundoNombre, apellido, celular, direccion, correo.E)\n" + 
					"VALUES(?,?,?,?,?,?)";
			sentencia = connection.prepareStatement(sql);
			sentencia.setString(1, per.getPrimerNombre());
			sentencia.setString(2, per.getSegundoNombre());
			sentencia.setString(3, per.getApellido());
			sentencia.setString(4, per.getCelular());
			sentencia.setString(5, per.getDireccion());
			sentencia.setString(6, per.getCorreoE());
			
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
    
    public Personal leerE(int id) throws SQLException {
		String sql = null;
		ResultSet resultSet = null;
		Personal per = new Personal();
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "select * from personal where _id = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1, id);
			
			resultSet = sentencia.executeQuery();
			
			if(resultSet.next()) {
				per.setId(resultSet.getInt(1));
				per.setPrimerNombre(resultSet.getString(2));
				per.setSegundoNombre(resultSet.getString(3));
				per.setApellido(resultSet.getString(4));
				per.setCelular(resultSet.getString(5));
				per.setDireccion(resultSet.getString(6));
				per.setCorreoE(resultSet.getString(7));
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		finally{
			connection.close();
			sentencia.close();
		}
		
		return per;
	}
    
    public boolean actualizarE(Personal personal, int _id) throws SQLException{
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE personal SET primerNombre = ?, segundoNombre = ? , apellido = ?, celular = ?, direccion = ?, correo.E = ? \n "
					+ " WHERE _id = ?";
			
			sentencia = connection.prepareStatement(sql);
			sentencia.setString(1, personal.getPrimerNombre());
			sentencia.setString(2, personal.getSegundoNombre());
			sentencia.setString(3, personal.getApellido());
			sentencia.setString(4, personal.getCelular());
			sentencia.setString(5, personal.getDireccion());
			sentencia.setString(6, personal.getCorreoE());
			sentencia.setInt(7, _id);
			
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
			sql = "DELETE from personal WHERE _id = ?";
			
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
    
    

    public List<Personal> obtenerE(int _id, String primerNombre, String segundoNombre, String apellido,String celular, String direccion, String correoE) throws SQLException{
		
		ResultSet resulSet = null; 
		List<Personal> listaPersonal = new ArrayList<>();
		
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
		}return listaPersonal;
	}
	
	private Connection obtenerConexion() throws SQLException{
		
		return Conexion.getConnection();
	}
}
