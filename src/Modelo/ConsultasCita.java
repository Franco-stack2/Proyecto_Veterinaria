/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;

public class ConsultasCita extends Conexion {

    public boolean registrar(Cita cita) {
        String sql = "INSERT INTO cita (fecha, tipoCita, id_usuario, id_mascota) VALUES (?,?,?,?)";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cita.getFecha());
            ps.setString(2, cita.getTipoCita());
            ps.setInt(3, cita.getUsuario().getId_usuario());
            ps.setInt(4, cita.getMascota().getId_mascota());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar cita: " + e);
            return false;
        }
    }

    public boolean modificar(Cita cita) {
        String sql = "UPDATE cita SET fecha=?, tipoCita=?, id_usuario=?, id_mascota=? WHERE id_cita=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cita.getFecha());
            ps.setString(2, cita.getTipoCita());
            ps.setInt(3, cita.getUsuario().getId_usuario());
            ps.setInt(4, cita.getMascota().getId_mascota());
            ps.setInt(5, cita.getId_cita());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar cita: " + e);
            return false;
        }
    }

    public boolean eliminar(Cita cita) {
        String sql = "DELETE FROM cita WHERE id_cita=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cita.getId_cita());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar cita: " + e);
            return false;
        }
    }
    
    public boolean buscar(Cita cita) {
        String sql = "SELECT * FROM cita WHERE id_cita=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cita.getId_cita());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cita.setId_cita(rs.getInt("id_cita"));
                    cita.setFecha(rs.getString("fecha"));
                    cita.setTipoCita(rs.getString("tipoCita"));
                    Usuario usuario = new Usuario();
                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    cita.setUsuario(usuario);
                    Mascota mascota = new Mascota();
                    mascota.setId_mascota(rs.getInt("id_mascota"));
                    cita.setMascota(mascota);
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Error al buscar cita: " + e);
            return false;
        }
    }
}