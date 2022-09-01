package com.objetos;



public class Personal {

	

	private int id;
	private String primerNombre;
	private String segundoNombre;
	private String apellido;
	private String celular;
	private String direccion;
	private String correoE;
	
	public Personal() {
		// TODO Auto-generated constructor stub
	}
	
	public Personal(int id,String primerNombre,String segundoNombre, String apellido, String celular, String direccion, String correoE) {
		// TODO Auto-generated constructor stub
	this.primerNombre = primerNombre;
	this.segundoNombre = segundoNombre;
	this.apellido = apellido;
	this.celular = celular;
	this.direccion = direccion;
	this.correoE = correoE;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("PrimerNombre: ")
		  .append(primerNombre)
		  .append("SegundoNombre: ")
		  .append(segundoNombre)
		  .append(" Apellido: ")
		  .append(apellido)
		  .append(" Celulaa: ")
		  .append(celular)
		  .append(" Direccion: ")
		  .append(direccion)
		  .append("Correo Electronico: ")
		  .append(correoE);
		return sb.toString();
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPrimerNombre() {
		return primerNombre;
	}


	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}


	public String getSegundoNombre() {
		return segundoNombre;
	}


	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
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


	public String getCorreoE() {
		return correoE;
	}


	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}
	
	
	
	
}
