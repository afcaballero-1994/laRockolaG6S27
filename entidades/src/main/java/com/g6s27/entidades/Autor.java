package com.g6s27.entidades;

public class Autor {
	private int id_autor;
	private String nombre_autor;

	public Autor(String nombre_autor) {
		super();
		this.nombre_autor = nombre_autor;
	}

	public String getNombre_autor() {
		return nombre_autor;
	}

	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}

	public int getId_autor() {
		return id_autor;
	}

	@Override
	public String toString() {
		return "Autor [Nombre Autor=" + nombre_autor + "]";
	}

}
