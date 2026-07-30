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
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO expediente (idExpediente, nombreMascota, contactoEmergencia, condicionesPasadas, alergias) VALUES (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, exp.getIdExpediente());
            ps.setString(2, exp.getNombreMascota());
            ps.setString(3, exp.getContactoEmergencia());
            ps.setString(4, exp.getCondicionesPasadas());
            ps.setString(5, exp.getAlergias());
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

    public boolean buscar(Expediente exp) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM expediente WHERE idExpediente=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, exp.getIdExpediente());

            rs = ps.executeQuery();

            if (rs.next()) {
                exp.setIdExpediente(rs.getInt("idExpediente"));
                exp.setNombreMascota(rs.getString("nombreMascota"));
                exp.setContactoEmergencia(rs.getString("contactoEmergencia"));
                exp.setCondicionesPasadas(rs.getString("condicionesPasadas"));
                exp.setAlergias(rs.getString("alergias"));

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
    
