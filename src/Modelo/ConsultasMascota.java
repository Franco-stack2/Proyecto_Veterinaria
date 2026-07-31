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
public class ConsultasMascota extends Conexion {

    public boolean registrar(Mascota mas) {
        String sql = "INSERT INTO mascota (nombreMascota, razaMascota, vacunas, servicios, medicamentos) VALUES (?,?,?,?,?)";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mas.getNombreMascota());
            ps.setString(2, mas.getRazaMascota());
            ps.setString(3, mas.getVacunas());
            ps.setString(4, mas.getServicios());
            ps.setString(5, mas.getMedicamentos());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar mascota: " + e);
            return false;
        }
    }

    public boolean buscar(Mascota mas) {
        String sql = "SELECT * FROM mascota WHERE nombreMascota=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mas.getNombreMascota());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    mas.setNombreMascota(rs.getString("nombreMascota"));
                    mas.setRazaMascota(rs.getString("razaMascota"));
                    mas.setVacunas(rs.getString("vacunas"));
                    mas.setServicios(rs.getString("servicios"));
                    mas.setMedicamentos(rs.getString("medicamentos"));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Error al buscar mascota: " + e);
            return false;
        }
    }

    public boolean modificar(Mascota mas) {
        String sql = "UPDATE mascota SET razaMascota=?, vacunas=?, servicios=?, medicamentos=? WHERE nombreMascota=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mas.getRazaMascota());
            ps.setString(2, mas.getVacunas());
            ps.setString(3, mas.getServicios());
            ps.setString(4, mas.getMedicamentos());
            ps.setString(5, mas.getNombreMascota());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar mascota: " + e);
            return false;
        }
    }

    public boolean eliminar(Mascota mas) {
        String sql = "DELETE FROM mascota WHERE nombreMascota=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mas.getNombreMascota());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar mascota: " + e);
            return false;
        }
    }
}