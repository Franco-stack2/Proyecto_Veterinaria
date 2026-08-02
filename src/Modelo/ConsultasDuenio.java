/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;

public class ConsultasDuenio extends Conexion {

    public boolean registrar(Duenio duenio) {
        String sql = "INSERT INTO duenio (id_usuario) VALUES (?)";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, duenio.getId_usuario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar duenio: " + e);
            return false;
        }
    }

    public boolean buscar(Duenio duenio) {
        String sql = "SELECT d.id_dueno, u.id_usuario, u.nombre, u.email, u.numTelefono, u.contrasena, u.TipoUsuario "
                + "FROM duenio d "
                + "INNER JOIN usuario u "
                + "ON d.id_usuario = u.id_usuario "
                + "WHERE d.id_dueno = ?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, duenio.getId_dueno());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    duenio.setId_dueno(rs.getInt("id_dueno"));
                    duenio.setId_usuario(rs.getInt("id_usuario"));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Error al buscar duenio: " + e);
            return false;
        }
    }

    public boolean modificar(Duenio duenio) {
        String sql = "UPDATE duenio SET id_usuario=? WHERE id_dueno=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, duenio.getId_usuario());
            ps.setInt(2, duenio.getId_dueno());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar duenioo: " + e);
            return false;
        }
    }

    public boolean eliminar(Duenio duenio) {
        String sql = "DELETE FROM duenio WHERE id_dueno=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, duenio.getId_dueno());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar duenio: " + e);
            return false;
        }
    }
}

