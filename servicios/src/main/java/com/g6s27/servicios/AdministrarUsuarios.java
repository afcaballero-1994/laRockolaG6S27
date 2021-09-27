package com.g6s27.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.g6s27.entidades.Conexion;
import com.g6s27.entidades.Usuario;

public class AdministrarUsuarios {
	public static String agregarUsuario(Usuario usuario) {
		Conexion conex = new Conexion();
		String Sql = "insert into usuarios (nombre_usuario,password,esAdministrador)";
		Sql = Sql + "values(?,?,?)";

		try {
			PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
			pstm.setString(1, usuario.getNombre_usuario());
			pstm.setString(2, usuario.getPassword());
			pstm.setBoolean(3, usuario.isEsAdministrador());
			pstm.executeUpdate();
			return "Usuario registrado exitosamente";

		} catch (SQLException e) {
			System.out.println(e);
			return "No se pudo registrar el usuario";
		}

	}

	public static ArrayList<Usuario> consultarUsuarios() {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Conexion conn = new Conexion();
		String sql = "select * from usuarios";

		try {
			Statement stm = conn.getCon().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Usuario usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("password"),
						rs.getBoolean("esAdministrador"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public static Usuario buscarUsuario(String nombre_usuario) {
		Conexion conn = new Conexion();
		String Sql = String.format("select * from usuarios where nombre_usuario = '%s'", nombre_usuario);
		PreparedStatement pstm;
		try {
			pstm = conn.getCon().prepareStatement(Sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("password"),
						rs.getBoolean("esAdministrador"));
				return usuario;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static String eliminarUsuario(String nombre_usuario) {
		Conexion conn = new Conexion();
		String sql = String.format("delete from usuarios where nombre_usuario = '%s'", nombre_usuario);
		try {
			PreparedStatement pstm = conn.getCon().prepareStatement(sql);
			pstm.executeUpdate();
		} catch (SQLException excepcion) {
			System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
			return "{\"Accion\":\"Error\"}";
		}
		return "{\"Accion\":\"Registro Borrado\"}";
	}
}
