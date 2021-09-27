package com.g6s27.servicios;

import com.g6s27.entidades.Usuario;

public class TestAgregarUsuario {

	public static void main(String[] args) {
		Usuario cliente = new Usuario ("cepalomo", "123456", true);
		
		System.out.println(AdministrarUsuarios.agregarUsuario(cliente));
		
	}

}
