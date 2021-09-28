package com.g6s27.servicios;

import java.util.ArrayList;

import com.g6s27.commons.ManejoSimpleBD;
import com.g6s27.entidades.Album;
import com.g6s27.entidades.Cancion;

public class TestAgregarCancion {

	public static void main(String[] args) {
		ArrayList<String> resultado= ManejoSimpleBD.separarCadena("Anuel AA, Nicki Minaj, BANTU");
		Album album = new Album ("Spiderman: Into the Spider-Verse", 2018);
		Cancion prueba = new Cancion("Familia", album, resultado, "0:04:36", "Pop");
		AdministrarBaseDatos.agregarCancion(prueba);
		//AdministrarBaseDatos.eliminarCancion(prueba);
		//Next to me 350
		//I dont know why 310
		//whatever it takes 321
		//believer 324
		
		//Album:encore
		//Evil deeds  419
		//like toy soldiers mosh 239
		
		System.out.println(ManejoSimpleBD.consultarAutor(prueba.getNombre_cancion()));
		System.out.println(AdministrarBaseDatos.consultarCancion(prueba.getNombre_cancion()));
	}

}
