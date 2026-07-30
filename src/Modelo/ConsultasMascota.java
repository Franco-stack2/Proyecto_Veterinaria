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

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO mascota (nombreMascota, razaMascota, vacunas, servicios, medicamentos) VALUES (?,?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);

            ps.setString(1, mas.getNombreMascota());
            ps.setString(2, mas.getRazaMascota());
            ps.setString(3, mas.getVacunas());
            ps.setString(4, mas.getServicios());
            ps.setString(5, mas.getMedicamentos());
            ps.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }

    }

    public boolean buscar(Mascota mas) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM mascota WHERE nombreMascota=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mas.getNombreMascota());
            
            rs = ps.executeQuery();

            if (rs.next()) {
                mas.setNombreMascota(rs.getString("nombreMascota"));
                mas.setRazaMascota(rs.getString("razaMascota"));
                mas.setVacunas(rs.getString("vacunas"));
                mas.setServicios(rs.getString("servicios"));
                mas.setMedicamentos(rs.getString("medicamentos"));
                
                return true;
            }
            return false;

        } catch (SQLException e) {

            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
