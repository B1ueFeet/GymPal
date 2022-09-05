package com.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.objetos.Conexion;
import com.objetos.Productos;

//crear un prodcuto,eliminar,consultar,actualizar
public class ProductosCrud { // Create, Read, Update, Delete

	private Connection connection;
	private PreparedStatement sentencia;
	private boolean estadoOp;
	private String sql = null;

	public boolean crear(Productos p) throws SQLException {

		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();

		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO productos(nombre,cantidad,precio) VALUES(?,?,?)";
			sentencia = connection.prepareStatement(sql);

			sentencia.setString(1, p.getNombre());
			sentencia.setInt(2, p.getCantidad());
			sentencia.setDouble(3, p.getPrecio());
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

	public Productos leerProductos(int idProducto) throws SQLException {
		String sql = null;
		ResultSet resultSet = null;
		Productos p = new Productos();
		estadoOp = false;
		connection = obtenerConexion();

		try {
			sql = "select* from productos where id=?";
			sentencia = connection.prepareStatement(sql);

			sentencia.setInt(1, idProducto);
			resultSet = sentencia.executeQuery(); // "select* from productos where id=5}"
			if (resultSet.next()) { // id nombre 3 1,4
				p.setId(resultSet.getInt(1));
				p.setNombre(resultSet.getString(2));
				p.setCantidad(resultSet.getInt(3));
				p.setPrecio(resultSet.getDouble(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connection.close();
			sentencia.close();

		}
		return p;

	}

	public boolean actualizar(Productos produc, int id) throws SQLException {
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();

		try {
			connection.setAutoCommit(false);
			sql = "UPDATE productos SET nombre =?, cantidad =?, precio =?" + "    WHERE id =?";

			sentencia = connection.prepareStatement(sql);
			sentencia.setString(1, produc.getNombre());
			sentencia.setInt(2, produc.getCantidad());
			sentencia.setDouble(3, produc.getPrecio());
			sentencia.setInt(4, id);
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

	public boolean eliminar(int id) throws SQLException {

		try {
			connection.setAutoCommit(false);
			sql = "DELETE from productos where id=?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1, id);
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

	public List<Productos> obtenerProductos() throws SQLException {

		ResultSet resultSet = null;
		List<Productos> listaProductos = new ArrayList<>();
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();

		try {
			connection.setAutoCommit(false);
			sql = "SELECT * FROM public.productos";
			sentencia = connection.prepareStatement(sql);
			resultSet = sentencia.executeQuery(sql);
			while (resultSet.next()) {
				Productos p = new Productos();
				p.setId(resultSet.getInt(1));
				p.setNombre(resultSet.getString(2));
				p.setCantidad(resultSet.getInt(3));
				p.setPrecio(resultSet.getDouble(4));
				listaProductos.add(p);

			}
			;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			sentencia.close();
			connection.close();

		}
		return listaProductos;

	}
	

	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();

	}

}
