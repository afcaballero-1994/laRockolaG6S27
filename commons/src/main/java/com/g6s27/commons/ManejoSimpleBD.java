package com.g6s27.commons;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.g6s27.entidades.Album;
import com.g6s27.entidades.Cancion;
import com.g6s27.entidades.Conexion;

public class ManejoSimpleBD {
	public static ArrayList<String> separarCadena(String autores) {
		String[] divididos = autores.split(",");
		ArrayList<String> autorBD = new ArrayList<String>();

		for (String autor : divididos) {
			System.out.println(autor.trim());
			autorBD.add(autor.trim());
		}

		return autorBD;
	}

	public static void ingresarAutorBD(ArrayList<String> autorBD) {

		Conexion conex = new Conexion();
		String Sql = "insert into autor (nombre_autor) ";
		Sql = Sql + "values(?)";

		try {
			for (String autor : autorBD) {
				PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
				pstm.setString(1, autor);
				pstm.executeUpdate();
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void ingresarGeneroBD(String genero) {
		Conexion conex = new Conexion();
		String Sql = "insert into genero (nombre_genero) ";
		Sql = Sql + "values(?)";

		try {

			PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
			pstm.setString(1, genero);
			pstm.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void ingresarAlbum(Album album) {
		Conexion conex = new Conexion();
		String sql = String.format("insert into album (nombre_album, anio_lanzamiento) values ('%s', %d);",
				album.getNombre_album(), album.getAnio_lanzamiento());

		try {

			PreparedStatement pstm = conex.getCon().prepareStatement(sql);
			pstm.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void ingresarCancionesAutor(Cancion cancion) {
		Conexion conex = new Conexion();
		ArrayList<String> autores = cancion.getAutor();
		for (String autor : autores) {
			String sql = String.format(
					"insert into canciones_autor (id_cancion, id_autor)\r\n"
							+ "select id_cancion, id_autor from canciones, autor\r\n"
							+ "where nombre_cancion = '%s' and nombre_autor = '%s';",
					cancion.getNombre_cancion(), autor);
			try {

				PreparedStatement pstm = conex.getCon().prepareStatement(sql);
				pstm.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

	public static boolean buscarAlbum(String nombre_album) {
		Conexion conn = new Conexion();
		String sql = String.format("SELECT nombre_album FROM album where nombre_album = '%s';", nombre_album);
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.getCon().createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean buscarGenero(String nombre_genero) {
		Conexion conn = new Conexion();
		String sql = String.format("SELECT nombre_genero FROM genero where nombre_genero = '%s';", nombre_genero);
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.getCon().createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean buscarAutor(String nombre_autor) {
		Conexion conn = new Conexion();
		String sql = String.format("SELECT nombre_autor FROM autor where nombre_autor = '%s';", nombre_autor);
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.getCon().createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean buscarCancion(String nombre_cancion) {
		Conexion conn = new Conexion();
		String sql = String.format("SELECT nombre_cancion FROM canciones where nombre_cancion = '%s';", nombre_cancion);
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.getCon().createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
