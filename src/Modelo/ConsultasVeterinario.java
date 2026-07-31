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
public class ConsultasVeterinario extends Conexion {

    public boolean registrar(Veterinario vet) {
        String sql = "INSERT INTO veterinario (id_veterinario, especialidad, id_usuario) VALUES (?,?,?)";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, vet.getId_veterinario());
            ps.setString(2, vet.getEspecialidad());
            ps.setInt(3, vet.getId_usuario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar veterinario: " + e);
            return false;
        }
    }

    public boolean buscar(Veterinario vet) {
        String sql = "SELECT * FROM veterinario WHERE id_veterinario=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, vet.getId_veterinario());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    vet.setId_veterinario(rs.getInt("id_veterinario"));
                    vet.setEspecialidad(rs.getString("especialidad"));
                    Usuario usu = new Usuario();
                    usu.setId_usuario(rs.getInt("id_usuario"));
                    vet.setUsuario(usu);
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Error al buscar veterinario: " + e);
            return false;
        }
    }

    public boolean modificar(Veterinario vet) {
        String sql = "UPDATE veterinario SET especialidad=?, id_usuario=? WHERE id_veterinario=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, vet.getEspecialidad());
            ps.setInt(2, vet.getUsuario().getId_usuario());
            ps.setInt(3, vet.getId_veterinario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar veterinario: " + e);
            return false;
        }
    }

    public boolean eliminar(Veterinario vet) {
        String sql = "DELETE FROM veterinario WHERE id_veterinario=?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, vet.getId_veterinario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar veterinario: " + e);
            return false;
        }
    }
}