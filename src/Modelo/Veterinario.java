/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Veterinario extends Usuario {
    
private int id_veterinario;
private String especialidad;
private Usuario usuario;

    public Veterinario(int id_veterinario, String especialidad, Usuario usuario) {
        this.id_veterinario = id_veterinario;
        this.especialidad = especialidad;
        this.usuario = usuario;
    }

    public Veterinario(int id_veterinario, String especialidad, Usuario usuario, String nombre, String email, String numTelefono, String contrasena, String TipoUsuario, int id_usuario) {
        super(nombre, email, numTelefono, contrasena, TipoUsuario, id_usuario);
        this.id_veterinario = id_veterinario;
        this.especialidad = especialidad;
        this.usuario = usuario;
    }

 public Veterinario() {
        super();
        this.id_veterinario = 0;
        this.especialidad = "";
        this.usuario = null;
    }

    public int getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(int id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
