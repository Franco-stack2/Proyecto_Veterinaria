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
public class ConsultasCita extends Conexion {
    
    public boolean registrar(Cita cita) {
        String sql = "INSERT INTO cita (id_cita, fecha, tipoCita, emailUsuario, nombreMascota) VALUES (?,?,?,?,?)";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cita.getId_cita());
            ps.setDate(2, (java.sql.Date) cita.getFecha());
            ps.setString(3, cita.getTipoCita());
            ps.setString(4, cita.getUsuario().getEmail());
            ps.setString(5, cita.getMascota().getNombreMascota());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar cita: " + e);
            return false;
        }
    }

    public boolean buscar(Cita cita) {
        String sql = "SELECT * FROM cita WHERE id_cita=?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cita.getId_cita());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cita.setId_cita(rs.getInt("id_cita"));
                    cita.setFecha(rs.getDate("fecha"));
                    cita.setTipoCita(rs.getString("tipoCita"));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Error al buscar cita: " + e);
            return false;
        }
    }

    public boolean modificar(Cita cita) {
        String sql = "UPDATE cita SET fecha=?, tipoCita=?, emailUsuario=?, nombreMascota=? WHERE id_cita=?";
        try (Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, (java.sql.Date) cita.getFecha());
            ps.setString(2, cita.getTipoCita());
            ps.setString(3, cita.getUsuario().getEmail());
            ps.setString(4, cita.getMascota().getNombreMascota());
            ps.setInt(5, cita.getId_cita());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar cita: " + e);
            return false;
        }
    }

    public boolean eliminar(Cita cita) {
        String sql = "DELETE FROM cita WHERE id_cita=?";
        try (Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cita.getId_cita());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar cita: " + e);
            return false;
        }
    }
}    