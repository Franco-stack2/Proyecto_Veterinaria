/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.Conexion;
import Modelo.Usuario;
import java.sql.*;
/**
 *
 * @author alfar
 */
public class ConsultasUsuario extends Conexion {

    public boolean registrar(Usuario usu) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuario (nombre, email, numTelefono, contrasena, TipoUsuario) VALUES (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getEmail());
            ps.setInt(3, usu.getNumTelefono());
            ps.setString(4, usu.getContrasena());
            ps.setString(5, usu.getTipoUsuario());
            ps.execute();
            return true;
            
        } catch(SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch(SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscar(Usuario usu) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection con = getConexion();

        String sql = "SELECT * FROM usuario WHERE email=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getEmail());
            rs = ps.executeQuery();
            
            if(rs.next()) {
                usu.setNombre(rs.getString("nombre"));
                usu.setEmail(rs.getString("email"));
                usu.setNumTelefono(rs.getInt("numTelefono"));
                usu.setContrasena(rs.getString("contrasena"));
                usu.setTipoUsuario(rs.getString("TipoUsuario"));
                return true;
            }
            return false;
        } catch(SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch(SQLException e) {
                System.err.println(e);
            }
        }
    }
    public boolean iniciarSesion(Usuario usu) {
    PreparedStatement ps = null;
    ResultSet rs = null;

    Connection con = getConexion();

    String sql = "SELECT * FROM usuario WHERE email=? AND contrasena=?";

    try {
        ps = con.prepareStatement(sql);

        ps.setString(1, usu.getEmail());
        ps.setString(2, usu.getContrasena());

        rs = ps.executeQuery();

        if (rs.next()) {
            usu.setNombre(rs.getString("nombre"));
            usu.setEmail(rs.getString("email"));
            usu.setNumTelefono(rs.getInt("numTelefono"));
            usu.setContrasena(rs.getString("contrasena"));
            usu.setTipoUsuario(rs.getString("TipoUsuario"));

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
