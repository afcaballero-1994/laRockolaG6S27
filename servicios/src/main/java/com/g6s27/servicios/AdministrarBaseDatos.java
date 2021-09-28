package com.g6s27.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.g6s27.commons.ManejoSimpleBD;
import com.g6s27.entidades.Album;
import com.g6s27.entidades.Cancion;
import com.g6s27.entidades.Conexion;

public class AdministrarBaseDatos {

	public static void agregarCancion(Cancion cancion) {

		Conexion conex = new Conexion();
		String sql = null;
		ArrayList<String> resultado = cancion.getAutor();
		for (String autor : resultado) {
			if (!ManejoSimpleBD.buscarAutor(autor)) {
				ManejoSimpleBD.ingresarAutorBD(resultado);
			}
		}

		boolean albumExiste = ManejoSimpleBD.buscarAlbum(cancion.getAlbum().getNombre_album());
		boolean generoExiste = ManejoSimpleBD.buscarGenero(cancion.getGenero());
		boolean cancionExiste = ManejoSimpleBD.buscarCancion(cancion.getNombre_cancion());
		if (!albumExiste) {
			ManejoSimpleBD.ingresarAlbum(cancion.getAlbum());
		}
		if (!generoExiste) {
			ManejoSimpleBD.ingresarGeneroBD(cancion.getGenero());
		}
		if (!cancionExiste) {
			sql = "insert into canciones (nombre_cancion, duracion_cancion, id_genero, id_album)";
			sql = sql
					+ String.format("values ('%s', '%s',", cancion.getNombre_cancion(), cancion.getDuracion_cancion());
			sql = sql
					+ String.format("(select id_genero from genero where nombre_genero = '%s'),", cancion.getGenero());
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

	public static void eliminarCancion(Cancion cancion) {
		boolean cancionExiste = ManejoSimpleBD.buscarCancion(cancion.getNombre_cancion());
		Conexion conn = new Conexion();
		Statement stmt = null;
		if (cancionExiste) {
			try {

				String sql = String.format(
						"update canciones\r\n" + "set estaEliminada = 1\r\n" + "where nombre_cancion = '%s'",
						cancion.getNombre_cancion());
				System.out.println(sql);
				stmt = conn.getCon().createStatement();
				stmt.executeUpdate(sql);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Cancion no existe en la base de datos");
		}
	}

	public static Cancion consultarCancion(String nombre_cancion) {
		boolean cancionExiste = ManejoSimpleBD.buscarCancion(nombre_cancion);
		if (cancionExiste) {
			Conexion conn = new Conexion();
			Statement stmt = null;
			try {

				String sql = String.format(
						"select c.nombre_cancion, c.duracion_cancion, a.nombre_album, a.anio_lanzamiento, g.nombre_genero\r\n"
								+ "from album a\r\n" + "inner join canciones c on a.id_album = c.id_album\r\n"
								+ "inner join canciones_autor ca on ca.id_cancion = c.id_cancion\r\n"
								+ "inner join autor au on au.id_autor = ca.id_autor\r\n"
								+ "inner join genero g on g.id_genero =  c.id_genero\r\n"
								+ "where nombre_cancion = '%s' and estaEliminada = 0;",
						nombre_cancion);

				stmt = conn.getCon().createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				Cancion cancion =  new Cancion();
				while (rs.next()) {
					cancion.setNombre_cancion(rs.getString("nombre_cancion"));
					cancion.setGenero(rs.getString("nombre_genero"));
					Album album_cancion = new Album(rs.getString("nombre_album"), rs.getInt("anio_lanzamiento"));
					cancion.setAlbum(album_cancion);
					cancion.setDuracion_cancion(rs.getString("duracion_cancion"));
					ArrayList<String> autores = ManejoSimpleBD.consultarAutor(nombre_cancion);
					cancion.setAutor(autores);
					return cancion;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
