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
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO cita (id_cita, fecha, tipoCita, emailUsuario, nombreMascota) VALUES (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cita.getId_cita());
            ps.setDate(2, (Date) cita.getFecha());
            ps.setString(3, cita.getTipoCita());
            ps.setString(4, cita.getUsuario().getEmail());
            ps.setString(5, cita.getMascota().getNombreMascota());
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

    public boolean buscar(Cita cita) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection con = getConexion();

        String sql = "SELECT * FROM cita WHERE id_cita=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cita.getId_cita());
            rs = ps.executeQuery();

            if (rs.next()) {
                cita.setId_cita(rs.getInt("id de la cita"));
                cita.setFecha(rs.getDate("fecha"));
                cita.setTipoCita(rs.getString("tipo de Cita"));
                
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
    
    