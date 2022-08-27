package com.objetos;

public class Usuario {
	
	private String name, password, privilegio;
	
	
	
	
	public Usuario() {
	}




	public Usuario(String name, String password, String privilegio) {
		super();
		this.name = name;
		this.password = password;
		this.privilegio = privilegio;
		
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getPrivilegio() {
		return privilegio;
	}




	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}






}
