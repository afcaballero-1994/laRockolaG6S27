package com.g6s27.entidades;

public class Usuario {
	private int id_usuario;
	private String nombre_usuario;
	private String password;
	private boolean esAdministrador;

	
	public Usuario () {
		
	}
	public Usuario(String nombre_usuario, String password, boolean esAdministrador) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.password = password;
		this.esAdministrador = esAdministrador;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEsAdministrador() {
		return esAdministrador;
	}

	public void setEsAdministrador(boolean esAdministrador) {
		this.esAdministrador = esAdministrador;
	}

}
