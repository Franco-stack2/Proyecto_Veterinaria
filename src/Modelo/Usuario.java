/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author alfar
 */
public class Usuario {
    private int id_usuario;
    private String nombre;
    private String email;
    private String numTelefono;
    private String contrasena;
    private String TipoUsuario;
    
    public Usuario() {
        this.nombre = "";
        this.email = "";
        this.numTelefono = "";
        this.contrasena = "";
        this.TipoUsuario = "";
        this.id_usuario = 0;
}
    public Usuario(String nombre, String email, String numTelefono, String contrasena, String TipoUsuario,int id_usuario) {
        this.nombre = nombre;
        this.email = email;
        this.numTelefono = numTelefono;
        this.contrasena = contrasena;
        this.TipoUsuario = TipoUsuario;
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
    
}
