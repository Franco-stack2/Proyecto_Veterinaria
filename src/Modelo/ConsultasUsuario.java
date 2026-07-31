/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;

/**
 *
 * @author alfar
 */
public class ConsultasUsuario extends Conexion {


    public boolean registrar(Usuario usu) {

        String sql = "INSERT INTO usuario "
                + "(nombre, email, numTelefono, contrasena, TipoUsuario) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getEmail());
            ps.setString(3, usu.getNumTelefono());
            ps.setString(4, usu.getContrasena());
            ps.setString(5, usu.getTipoUsuario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario: " + e);
            return false;
        }
    }

    public boolean buscar(Usuario usu) {
        String sql = "SELECT * FROM usuario WHERE id_usuario=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usu.getEmail());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usu.setId_usuario(rs.getInt("id_usuario"));
                    usu.setNombre(rs.getString("nombre"));
                    usu.setEmail(rs.getString("email"));
                    usu.setNumTelefono(rs.getString("numTelefono"));
                    usu.setContrasena(rs.getString("contrasena"));
                    usu.setTipoUsuario(rs.getString("TipoUsuario"));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Error al buscar usuario: " + e);
            return false;
        }
    }

    public boolean iniciarSesion(Usuario usu) {
        String sql = "SELECT * FROM usuario "
                + "WHERE email=? AND contrasena=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usu.getEmail());
            ps.setString(2, usu.getContrasena());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usu.setId_usuario(rs.getInt("id_usuario"));
                    usu.setNombre(rs.getString("nombre"));
                    usu.setEmail(rs.getString("email"));
                    usu.setNumTelefono(rs.getString("numTelefono"));
                    usu.setContrasena(rs.getString("contrasena"));
                    usu.setTipoUsuario(rs.getString("TipoUsuario"));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Error al iniciar sesión: " + e);
            return false;
        }
    }

    public boolean modificar(Usuario usu) {
        String sql = "UPDATE usuario SET "
                + "nombre=?, numTelefono=?, contrasena=?, TipoUsuario=? "
                + "WHERE id_usuario=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getNumTelefono());
            ps.setString(3, usu.getContrasena());
            ps.setString(4, usu.getTipoUsuario());
            ps.setInt(5, usu.getId_usuario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar usuario: " + e);
            return false;
        }
    }

    public boolean eliminar(Usuario usu) {
        String sql = "DELETE FROM usuario WHERE id_usuario=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, usu.getId_usuario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e);
            return false;
        }
    }
}