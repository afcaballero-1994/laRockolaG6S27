package com.g6s27.servicios;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.g6s27.commons.ManejoSimpleBD;
import com.g6s27.entidades.Cancion;
import com.g6s27.entidades.Conexion;

public class AdministrarBaseDatos {

	public static void agregarCancion(Cancion cancion) {

		Conexion conex = new Conexion();
		String sql = null;
		ArrayList<String> resultado = cancion.getAutor();
		ManejoSimpleBD.ingresarAutorBD(resultado);
		ManejoSimpleBD.ingresarGeneroBD(cancion.getGenero());
		//boolean albumExiste = ManejoSimpleBD.buscarAlbum(cancion.getAlbum().getNombre_album());
		//boolean generoExiste = ManejoSimpleBD.buscarGenero(cancion.getGenero());

		sql = "insert into canciones (nombre_cancion, duracion_cancion, id_genero, id_album)";
		sql = sql + String.format("values ('%s', '%s',", cancion.getNombre_cancion(), cancion.getDuracion_cancion());
		sql = sql + String.format("(select id_genero from genero where nombre_genero = '%s'),", cancion.getGenero());
		sql = sql + String.format("(select id_album from album where nombre_album = '%s') )",
				cancion.getAlbum().getNombre_album());

		try {

			PreparedStatement pstm = conex.getCon().prepareStatement(sql);
			pstm.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
		}

		ManejoSimpleBD.ingresarCancionesAutor(cancion);

	}
}
