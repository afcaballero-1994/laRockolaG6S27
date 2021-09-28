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

	public static String eliminarCancion(String nombre_cancion) {
		boolean cancionExiste = ManejoSimpleBD.buscarCancion(nombre_cancion);
		Conexion conn = new Conexion();
		Statement stmt = null;
		if (cancionExiste) {
			try {

				String sql = String.format(
						"update canciones\r\n" + "set estaEliminada = 1\r\n" + "where nombre_cancion = '%s'",
						nombre_cancion);
				stmt = conn.getCon().createStatement();
				stmt.executeUpdate(sql);
				return "Cancion eliminada exitosamente";

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return "Cancion no existe en la base de datos";
		}
		
		return "Error al eliminar el registro";
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
								+ "inner join genero g on g.id_genero =  c.id_genero\r\n"
								+ "where nombre_cancion = 'Familia' and estaEliminada = 0;",
						nombre_cancion);

				stmt = conn.getCon().createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				Cancion cancion = new Cancion();
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

	public static ArrayList<Cancion> mostrarCanciones() {
		Conexion conn = new Conexion();
		Statement stmt = null;
		try {

			String sql = "select c.nombre_cancion, c.duracion_cancion, a.nombre_album, a.anio_lanzamiento, g.nombre_genero\r\n"
					+ "from album a\r\n" + "inner join canciones c on a.id_album = c.id_album\r\n"
					+ "inner join genero g on g.id_genero =  c.id_genero\r\n" + "where estaEliminada = 0;";

			ArrayList<Cancion> canciones = new ArrayList<Cancion>();
			stmt = conn.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Cancion cancion = new Cancion();
				cancion.setNombre_cancion(rs.getString("nombre_cancion"));
				cancion.setGenero(rs.getString("nombre_genero"));
				Album album_cancion = new Album(rs.getString("nombre_album"), rs.getInt("anio_lanzamiento"));
				cancion.setAlbum(album_cancion);
				cancion.setDuracion_cancion(rs.getString("duracion_cancion"));
				ArrayList<String> autores = ManejoSimpleBD.consultarAutor(cancion.getNombre_cancion());
				cancion.setAutor(autores);
				canciones.add(cancion);
			}
			return canciones;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
