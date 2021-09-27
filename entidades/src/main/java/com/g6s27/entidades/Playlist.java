package com.g6s27.entidades;

import java.util.ArrayList;

public class Playlist {
	private ArrayList<Cancion> playlist = new ArrayList<Cancion>();
	private int id_usuario;
	private String nombre_playlist;

	public ArrayList<Cancion> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(ArrayList<Cancion> playlist) {
		this.playlist = playlist;
	}

	public String getNombre_playlist() {
		return nombre_playlist;
	}

	public void setNombre_playlist(String nombre_playlist) {
		this.nombre_playlist = nombre_playlist;
	}

	public int getId_usuario() {
		return id_usuario;
	}

}
