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
    private String nombre;
    private String email;
    private int numTelefono;
    private String contrasena;
    private Rol rol;
    
    
    
    public Usuario() {
        this.nombre = "";
        this.email = "";
        this.numTelefono = 0;
        this.contrasena = "";
        Rol rol;
}
    public Usuario(String nombre, String email, int numTelefono, String contrasena, String TipoUsuario) {
        this.nombre = nombre;
        this.email = email;
        this.numTelefono = numTelefono;
        this.contrasena = contrasena;
        this.rol = rol;
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

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    
}
