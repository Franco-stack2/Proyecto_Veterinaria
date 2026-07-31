/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Duenio extends Usuario {
    
    
private int id_dueno;

    public Duenio(int id_dueno) {
        this.id_dueno = id_dueno;
    }

    public Duenio(int id_dueno, String nombre, String email, String numTelefono, String contrasena, String TipoUsuario, int id_usuario) {
        super(nombre, email, numTelefono, contrasena, TipoUsuario, id_usuario);
        this.id_dueno = id_dueno;
    }

      public Duenio() {
        super();
        this.id_dueno = 0;
    }

    public int getId_dueno() {
        return id_dueno;
    }

    public void setId_dueno(int id_dueno) {
        this.id_dueno = id_dueno;
    }

    
      
    
    
}
