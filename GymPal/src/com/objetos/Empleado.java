package com.objetos;



public class Empleado {
	
	// GERENTE A TODO, ENTRENADOR A LISTA DE CLIENTES, RECEPCIONISTA A CONTABILIDAD Y FACTURAS PERO SIN ELIMINAR
	public enum Cargo
	{
	    GERENTE, ENTRENADOR, RECEPCIONISTA;
	}

	private int id;
	private String nombre;
	private String apellido;
	private int cedula;
	private Cargo cargo;

	public Empleado() {
		// TODO Auto-generated constructor stub
	}
	public Empleado(int id, String nombre, String apellido, int cedula, Cargo cargo) {
		// TODO Auto-generated constructor stub
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.cargo = cargo;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: ")
		  .append(nombre)
		  .append(" Apellido: ")
		  .append(apellido)
		  .append(" Cedula: ")
		  .append(cedula)
		  .append(" Cargo: ")
		  .append(cargo);
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(String sc) {
		Cargo aux = null;
		switch (sc) {
		case "GERENTE":
			aux = Cargo.GERENTE;
			break;
		case "ENTRENADOR":
			aux = Cargo.ENTRENADOR;
			break;
		case "RECEPCIONISTA":
			aux = Cargo.RECEPCIONISTA;
			break;
		default:
			break;
		}
		
		this.cargo = aux;
		
	}

	
	
	
}
