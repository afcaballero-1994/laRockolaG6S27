package com.g6s27.servicios;

import java.util.ArrayList;

import com.g6s27.commons.ManejoSimpleBD;
import com.g6s27.entidades.Album;
import com.g6s27.entidades.Cancion;

public class TestAgregarCancion {

	public static void main(String[] args) {
		ArrayList<String> resultado= ManejoSimpleBD.separarCadena("Eminem, Dr. Dre");
		Album album = new Album ("Shady", 2012);
		ManejoSimpleBD.ingresarAlbum(album);
		Cancion prueba = new Cancion("8 miles", album, resultado, "0:02:50", "Hip Hop");
		AdministrarBaseDatos.agregarCancion(prueba);
		boolean album_encontrado = ManejoSimpleBD.buscarAlbum("Evolve");
		if (album_encontrado) {
			System.out.println("Album se encuentra en la base de datos");
		}
		
		System.out.println(ManejoSimpleBD.buscarGenero("Rock"));
	}

}
