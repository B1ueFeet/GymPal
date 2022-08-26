package com.modelos;


public class Cliente {

	private int id;
	private String nombre;
	private int cedula;
	private String correo;
	
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	public Cliente(int id, String nombre, int cedula, String correo) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nombre = nombre;
		this.cedula = cedula;
		this.correo = correo;
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
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCedula() {
		return cedula;
	}


	public void setCedula(int cedula) {
		this.cedula = cedula;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
