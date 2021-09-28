package com.g6s27.commons;

import java.util.ArrayList;


public class TestIngresarAutor {

	public static void main(String[] args) {
		ArrayList<String> resultado= ManejoSimpleBD.separarCadena("Skylar Grey, Dr. Dre, Eminem");
		
		ManejoSimpleBD.ingresarAutorBD(resultado);
		
		//ManejoSimpleBD.ingresarGeneroBD("Rock");
		
	}

}
