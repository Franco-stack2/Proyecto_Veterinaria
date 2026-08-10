/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;

public class ConsultasCita extends Conexion {

public boolean registrar(Cita cita) {
  
    String sql = "INSERT INTO cita (fecha, tipoCita) VALUES (?, ?)";
    
    try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, cita.getFecha());
        ps.setString(2, cita.getTipoCita());
        
        return ps.executeUpdate() > 0; 
    } catch (SQLException e) {
        System.err.println("Error directo al registrar cita limpia: " + e);
        return false;
    }
}
    public int obtenerUltimoIdCita() {
  
    String sql = "SELECT MAX(id_cita) AS ultimo FROM cita";
    try (Connection con = getConexion(); 
         PreparedStatement ps = con.prepareStatement(sql); 
         ResultSet rs = ps.executeQuery()) {
        
        if (rs.next()) {
            return rs.getInt("ultimo");
        }
        return 0;
    } catch (SQLException e) {
        System.err.println("Error al recuperar el último número de cita: " + e);
        return 0;
    }
}
 public boolean modificar(Cita cita) {

    String sql = "UPDATE cita SET fecha = ? WHERE id_cita = ?";
    try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, cita.getFecha());
        ps.setInt(2, cita.getId_cita()); 
        
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        System.err.println("Error físico al modificar fecha de la cita: " + e);
        return false;
    }
}

 
    public boolean eliminar(Cita cita) {
        String sql = "DELETE FROM cita WHERE id_cita = ?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cita.getId_cita());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error físico al eliminar cita en MySQL: " + e);
            return false;
        }
    }
    
   
    public boolean buscar(Cita cita) {
        String sql = "SELECT id_cita, fecha, tipoCita FROM cita WHERE id_cita = ?";
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cita.getId_cita());
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
     
                    cita.setId_cita(rs.getInt("id_cita"));
                    cita.setFecha(rs.getString("fecha"));
                    cita.setTipoCita(rs.getString("tipoCita"));
           
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Error físico al buscar cita en MySQL: " + e);
            return false;
        }
    }
    } 