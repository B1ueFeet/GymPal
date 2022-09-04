package com.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.objetos.Conexion;
import com.objetos.Cliente;

public class ModeloCliente {
	
	private Connection connection;
    private PreparedStatement sentencia;
    private boolean estadoOp;
	
    
    public List<Cliente> listaClientes() throws SQLException {
        String sql = null;
        ResultSet resultSet = null;
        connection = obtenerConexion();
        List<Cliente> listaProductos = new ArrayList<>();
        connection = obtenerConexion();

        try {
            sql = "SELECT * FROM clientes";
            sentencia = connection.prepareStatement(sql);
            resultSet = sentencia.executeQuery();
            resultSet.next();
            do {
            	Cliente auxProd = new Cliente();
                auxProd.setNombre(resultSet.getString(2));
                auxProd.setApellido(resultSet.getString(3));
                auxProd.setCedula(resultSet.getString(4));
                auxProd.setCelular(resultSet.getString(5));
                auxProd.setDireccion(resultSet.getString(6));
                auxProd.setCorreo(resultSet.getString(7));
                auxProd.setActivo(resultSet.getInt(8));
           
                
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

	
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();

	}
}
