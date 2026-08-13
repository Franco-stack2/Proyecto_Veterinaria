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

    String sql = "INSERT INTO mascota (nombreMascota, razaMascota, vacunas, servicios, medicamentos, id_dueno) VALUES (?, ?, ?, ?, ?, ?)";
    
    try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, mas.getNombreMascota());
        ps.setString(2, mas.getRazaMascota());
        ps.setString(3, mas.getVacunas());
        ps.setString(4, mas.getServicios());
        ps.setString(5, mas.getMedicamentos());
        ps.setInt(6, mas.getId_dueno()); 
        
        return ps.executeUpdate() > 0; 
        
    } catch (SQLException e) {
     
        System.err.println("Error crítico en el INSERT de la mascota: " + e.getMessage());
        return false;
    }
}

   public boolean buscar(Mascota mas) {
    String sql = "SELECT * FROM mascota WHERE id_mascota=?";
    try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, mas.getId_mascota());

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                mas.setId_mascota(rs.getInt("id_mascota"));
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
    String sql = "UPDATE mascota SET nombreMascota=?, razaMascota=?, vacunas=?, servicios=?, medicamentos=? WHERE id_mascota=?";

    try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, mas.getNombreMascota());
        ps.setString(2, mas.getRazaMascota());
        ps.setString(3, mas.getVacunas());
        ps.setString(4, mas.getServicios());
        ps.setString(5, mas.getMedicamentos());
        ps.setInt(6, mas.getId_mascota());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        System.err.println("Error al modificar mascota: " + e);
        return false;
    }
}

  public boolean eliminar(Mascota mas) {
    String sql = "DELETE FROM mascota WHERE id_mascota=?";

    try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, mas.getId_mascota());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        System.err.println("Error al eliminar mascota: " + e);
        return false;
    }
}
    public boolean buscarPorNombreMascota(Mascota mas) {
    
    String sql = "SELECT id_mascota, razaMascota, vacunas, servicios, medicamentos FROM mascota WHERE LOWER(nombreMascota) = LOWER(?)";
    
    try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, mas.getNombreMascota());
        
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
   
                mas.setId_mascota(rs.getInt("id_mascota")); 
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
    public boolean actualizarHistorialCita(Mascota mas) {

    String sql = "UPDATE mascota SET vacunas = ?, servicios = ?, medicamentos = ? WHERE id_mascota = ?";
    
    try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, mas.getVacunas());
        ps.setString(2, mas.getServicios());
        ps.setString(3, mas.getMedicamentos());
        

        ps.setInt(4, mas.getId_mascota()); 
        
        return ps.executeUpdate() > 0; 
        
    } catch (SQLException e) {
        System.err.println("Error al actualizar datos médicos de la mascota: " + e);
        return false;
    }
}
    public int buscarIdDuenoPorTelefono(String telefono) {
   
    String sql = "SELECT duenio.id_dueno FROM duenio "
           + "INNER JOIN usuario ON duenio.id_usuario = usuario.id_usuario WHERE usuario.numTelefono = ?";
    
    try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, telefono);
        
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id_dueno");
            }
        }
        return 0;
    } catch (SQLException e) {
        System.err.println("Error al buscar ID del dueño: " + e);
        return 0;
    }
}


    
}