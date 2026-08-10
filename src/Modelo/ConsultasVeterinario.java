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
import java.sql.*;

public class ConsultasVeterinario extends Conexion {

    public boolean registrar(Veterinario vet) {

        String sql = "INSERT INTO veterinario (id_usuario) VALUES (?)";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, vet.getId_usuario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar veterinario: " + e);
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
