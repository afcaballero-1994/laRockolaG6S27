package com.g6s27.entidades;

import java.util.ArrayList;

public class Sugerencia {
	private ArrayList<Cancion> sugerencias = new ArrayList<Cancion>();
	private int id_usuario;

	public ArrayList<Cancion> getSugerencias() {
		return sugerencias;
	}

	public void setSugerencias(ArrayList<Cancion> sugerencias) {
		this.sugerencias = sugerencias;
	}

	public int getId_usuario() {
		return id_usuario;
	}

}
