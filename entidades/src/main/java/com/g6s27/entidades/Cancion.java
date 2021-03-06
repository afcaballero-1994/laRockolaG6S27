package com.g6s27.entidades;

import java.util.ArrayList;

public class Cancion {
	private String nombre_cancion;
	private Album album;
	private ArrayList<String> autor = new ArrayList<String>();
	private String duracion_cancion;
	private String genero;

	public Cancion () {
		
	}
	public Cancion(String nombre_cancion, Album album, ArrayList<String> autor, String duracion_cancion,
			String genero) {
		super();
		this.nombre_cancion = nombre_cancion;
		this.album = album;
		this.autor = autor;
		this.duracion_cancion = duracion_cancion;
		this.genero = genero;
	}

	
	public String getNombre_cancion() {
		return nombre_cancion;
	}

	public void setNombre_cancion(String nombre_cancion) {
		this.nombre_cancion = nombre_cancion;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public ArrayList<String> getAutor() {
		return autor;
	}

	public void setAutor(ArrayList<String> autor) {
		this.autor = autor;
	}

	public String getDuracion_cancion() {
		return duracion_cancion;
	}

	public void setDuracion_cancion(String duracion_cancion) {
		this.duracion_cancion = duracion_cancion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	
	@Override
	public String toString() {
		return "Cancion [nombre_cancion=" + nombre_cancion + ", album=" + album.getNombre_album() + ", autor=" + autor
				+ ", duracion_cancion=" + duracion_cancion + ", genero=" + genero + ", anio lanzamiento = "+album.getAnio_lanzamiento() + "]";
	}
	
	

}
