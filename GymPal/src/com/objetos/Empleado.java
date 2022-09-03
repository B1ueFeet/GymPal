package com.objetos;

public class Empleado {

	// CREATE TABLE empleados( id_empleados serial, nombre varchar(20), apellido
	// varchar(20), cedula varchar(10), celular varchar(10),
	// direccion varchar(50), correo varchar(30), cargo int, username varchar(20),
	// password varchar(30), activo int, primary key (id_empleados));

	private String nombre, apellido, cedula, celular, direccion, correo, userName, password;
	private int cargo, activo;

	// CONSTRUCTORES

	public Empleado(String nombre, String apellido, String cedula, String celular, String direccion, String correo,
			String userName, String password, int cargo, int activo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.celular = celular;
		this.direccion = direccion;
		this.correo = correo;
		this.userName = userName;
		this.password = password;
		this.cargo = cargo;
		this.activo = activo;
	}

	public Empleado() {
	};

	// TO STRING

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" Nombre: ").append(nombre).append(" Apellido: ").append(apellido).append(" Cedula: ").append(cedula)
				.append(" Celular: ").append(celular).append(" Direccion: ").append(direccion).append(" Correo. E: ")
				.append(correo).append(" Cargo: ").append(cargo);
		return sb.toString();
	}

	// GETTERS Y SETTERS

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

}
