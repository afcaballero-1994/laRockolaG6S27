package com.g6s27.entidades;

public class Album {
	private String nombre_album;
	private int anio_lanzamiento;

	public Album () {
		
	}
	
	public Album(String nombre_album, int anio_lanzamiento) {
		super();
		this.nombre_album = nombre_album;
		this.anio_lanzamiento = anio_lanzamiento;
	}

	
	public String getNombre_album() {
		return nombre_album;
	}

	public void setNombre_album(String nombre_album) {
		this.nombre_album = nombre_album;
	}

	public int getAnio_lanzamiento() {
		return anio_lanzamiento;
	}

	public void setAnio_lanzamiento(int anio_lanzamiento) {
		this.anio_lanzamiento = anio_lanzamiento;
	}

}
