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
public class ConsultasExpediente extends Conexion {


    public boolean registrar(Expediente exp) {
     
        String sql = "INSERT INTO expediente (nombreMascota, contactoEmergencia, condicionesPasadas, alergias) VALUES (?, ?, ?, ?)";
        
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, exp.getNombreMascota());
            ps.setString(2, exp.getContactoEmergencia());
            ps.setString(3, exp.getCondicionesPasadas());
            ps.setString(4, exp.getAlergias());
            
            return ps.executeUpdate() > 0; // Inserta el expediente en un milisegundo sin bloqueos relacionales
        } catch (SQLException e) {
            System.err.println("Error físico al registrar expediente en MySQL: " + e);
            return false;
        }
    }

 
    public boolean buscarExpedientePorNombre(Expediente exp) {
        String sql = "SELECT idExpediente, contactoEmergencia, condicionesPasadas, alergias FROM expediente WHERE LOWER(nombreMascota) = LOWER(?)";
        
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, exp.getNombreMascota()); 
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    exp.setIdExpediente(rs.getInt("idExpediente"));
                    exp.setContactoEmergencia(rs.getString("contactoEmergencia"));
                    exp.setCondicionesPasadas(rs.getString("condicionesPasadas"));
                    exp.setAlergias(rs.getString("alergias"));
                    return true; // Localizado con éxito
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Error al buscar en la tabla expediente: " + e);
            return false;
        }
    }

   
    public boolean modificar(Expediente exp) {
        String sql = "UPDATE expediente SET nombreMascota = ?, contactoEmergencia = ?, condicionesPasadas = ?, alergias = ? WHERE idExpediente = ?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, exp.getNombreMascota());
            ps.setString(2, exp.getContactoEmergencia());
            ps.setString(3, exp.getCondicionesPasadas());
            ps.setString(4, exp.getAlergias());
            ps.setInt(5, exp.getIdExpediente());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar expediente: " + e);
            return false;
        }
    }

    // 4. MÉTODO ELIMINAR: Borrado directo apuntando al idExpediente autoincremental
    public boolean eliminar(Expediente exp) {
        String sql = "DELETE FROM expediente WHERE idExpediente = ?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, exp.getIdExpediente());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar expediente: " + e);
            return false;
        }
    }
}