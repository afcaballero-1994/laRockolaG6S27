package com.g6s27.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.g6s27.entidades.Usuario;
import com.g6s27.servicios.AdministrarUsuarios;

@Path("/usuarios")
public class UsuarioRest {
	@Path("/listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Usuario> getUsuarios(){
		return AdministrarUsuarios.consultarUsuarios();
	}
	@Path("/buscar")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario buscarUsuario(String nombre_usuario){
		return AdministrarUsuarios.buscarUsuario(nombre_usuario);
	}
}
