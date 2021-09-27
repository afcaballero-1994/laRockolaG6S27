package com.g6s27.servicios;

import com.g6s27.entidades.Usuario;

public class TestAgregarUsuario {

	public static void main(String[] args) {
		Usuario cliente = new Usuario("cepalomo", "87612345621", false);
		Usuario cliente2 = new Usuario("afperez", "77123456", false);
		Usuario cliente3 = new Usuario("melino", "666123456", false);
		Usuario cliente4 = new Usuario("poro", "1234555666", false);
		Usuario cliente5 = new Usuario("purusio", "12345216", true);
		System.out.println(AdministrarUsuarios.agregarUsuario(cliente));
		System.out.println(AdministrarUsuarios.agregarUsuario(cliente2));
		System.out.println(AdministrarUsuarios.agregarUsuario(cliente3));
		System.out.println(AdministrarUsuarios.agregarUsuario(cliente4));
		System.out.println(AdministrarUsuarios.agregarUsuario(cliente5));
		

	}

}
