package com.g6s27.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.g6s27.entidades.Cancion;
import com.g6s27.servicios.AdministrarBaseDatos;

@Path ("/canciones")
public class CancionesRest {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Cancion> getUsuarios() {
		return AdministrarBaseDatos.mostrarCanciones();
	}
	@Path("/{cancion}")
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Cancion buscarCancion(@PathParam("cancion") String nombre_cancion) {
		return AdministrarBaseDatos.consultarCancion(nombre_cancion);
	}
	@Path("/agregar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void agregarCancion(Cancion cancion) {
		AdministrarBaseDatos.agregarCancion(cancion);
		System.out.println(cancion);
	}
	@Path("/eliminar")
	@DELETE
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String eliminarCancion (String nombre_cancion) {
		return AdministrarBaseDatos.eliminarCancion(nombre_cancion);
	}
}
