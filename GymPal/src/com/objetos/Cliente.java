package com.objetos;


public class Cliente {

	private String nombre, apellido, cedula, celular, direccion, correo;
	private int activo;
	
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	


	public Cliente(String nombre, String apellido, String cedula, String celular, String direccion, String correo,
			int activo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.celular = celular;
		this.direccion = direccion;
		this.correo = correo;
		this.activo = activo;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: ")
		  .append(nombre)
		  .append(" Cedula: ")
		  .append(cedula)
		  .append(" Correo: ")
		  .append(correo);
		return sb.toString();
	}




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




	public int getActivo() {
		return activo;
	}




	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	
	
}