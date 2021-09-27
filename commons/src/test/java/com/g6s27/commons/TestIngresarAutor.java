package com.g6s27.commons;

import java.util.ArrayList;


public class TestIngresarAutor {

	public static void main(String[] args) {
		ArrayList<String> resultado= ManejoSimpleBD.separarCadena("Bob Marley, Michael Jackson , Percy");
		
		ManejoSimpleBD.ingresarAutorBD(resultado);
		
		ManejoSimpleBD.ingresarGeneroBD("Rock");
		
	}

}
