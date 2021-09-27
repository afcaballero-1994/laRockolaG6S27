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
	public static ArrayList<Usuario> consultarUsuarios (){
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Conexion conn = new Conexion ();
		String sql = "select * from usuarios";
		
		try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getString("nombre_usuario"), rs.getString("password"), rs.getBoolean("esAdministrador"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
	}
}
