package com.g6s27.servicios;

import java.util.ArrayList;

import com.g6s27.commons.ManejoSimpleBD;
import com.g6s27.entidades.Album;
import com.g6s27.entidades.Cancion;

public class TestAgregarCancion {

	public static void main(String[] args) {
		ArrayList<String> resultado= ManejoSimpleBD.separarCadena("Rihanna, Eminem");
		Album album = new Album ("Recovery", 2010);
		Cancion prueba = new Cancion("Love the way you lie", album, resultado, "0:04:50", "Rap");
		AdministrarBaseDatos.agregarCancion(prueba);
		//AdministrarBaseDatos.eliminarCancion(prueba);
		//Next to me 350
		//I dont know why 310
		//whatever it takes 321
		//believer 324
		
		//Album:encore
		//Evil deeds  419
		//like toy soldiers mosh 239
		
		//System.out.println(ManejoSimpleBD.consultarAutor(prueba.getNombre_cancion()));
		//System.out.println(AdministrarBaseDatos.consultarCancion(prueba.getNombre_cancion()));
		System.out.println(AdministrarBaseDatos.mostrarCanciones());
	}

}
