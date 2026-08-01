/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.util.Date;

public class Cita {
    
    
    private int id_cita;
    private String fecha;
    private String tipoCita;
    private Usuario usuario;
    private Mascota mascota;

    public Cita(int id_cita, String fecha, String tipoCita, Usuario usuario, Mascota mascota) {
        this.id_cita = id_cita;
        this.fecha = fecha;
        this.tipoCita = tipoCita;
        this.usuario = usuario;
        this.mascota = mascota;
    }
    
        public Cita() {
        this.id_cita = 0;
        this.fecha = "";
        this.tipoCita = "";
        this.usuario = null;
        this.mascota = null;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    
    
    
    
}
