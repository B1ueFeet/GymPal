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
    
    public boolean actualizar(Cliente cli, String selected) throws SQLException {
        String sql = null;
        estadoOp = false;
        connection = obtenerConexion();
        String nombre , apellido, cedula ,celular ,direccion, correo ;
        
        if (cli.getNombre() == "")nombre = "";
        else nombre = "nombre = '" + cli.getNombre() + "' ,";
        
        if (cli.getApellido() == "") apellido = "";
        else apellido = "apellido = '" + cli.getApellido() + "' ,";
        
        if (cli.getCedula() == "") cedula = "";
        else cedula = "cedula = '" + cli.getCedula() + "' ,";
        
        if (cli.getCelular() == "") celular = "";
        else celular = "celular = '" + cli.getCelular() + "' ,";
        
        if (cli.getDireccion() == "")  direccion = "";
        else  direccion = "direccion = '" + cli.getDireccion() + "' ,";
        
        if (cli.getCorreo() == "") correo ="";
        else correo = "correo = '" + cli.getCorreo()+ "' ,";

        try {
            connection.setAutoCommit(false);
            sql = String.format("UPDATE clientes SET %s %s %s %s %s %s activo = 1 WHERE nombre = ?", nombre,apellido,cedula,celular,direccion, correo);
            
            sentencia = connection.prepareStatement(sql);          
            sentencia.setString(1, selected);
            
            System.out.println(sentencia);
           estadoOp = sentencia.executeUpdate() > 0;
            	connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            sentencia.close();
            connection.close();
        }
        return estadoOp;
    }
    
    public boolean crear(Cliente p) throws SQLException { // Este método reemplaza la sentencia Insert
        String sql = null;
        estadoOp = false;
        connection = obtenerConexion(); //este método está en esta misma clase, más abajito

        try {

            connection.setAutoCommit(false); //q no se ejecute automaticamente el commit. Commit = procesar comandos SQL permanentes en la base de datos.
            sql = "INSERT INTO clientes(nombre,apellido,cedula,celular,direccion,correo,activo) values(?,?,?,?,?,?,1)";
            sentencia = connection.prepareStatement(sql);

            sentencia.setString(1, p.getNombre());
            sentencia.setString(2, p.getApellido());
            sentencia.setString(3, p.getCedula());
            sentencia.setString(4, p.getCelular());
            sentencia.setString(5, p.getDireccion());
            sentencia.setString(6, p.getCorreo());

            estadoOp = sentencia.executeUpdate() > 0;
            connection.commit();
            sentencia.close();
            connection.close();

        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();

        } finally {
            connection.close(); 
        }
        return estadoOp;
    }

	
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();

	}
}
