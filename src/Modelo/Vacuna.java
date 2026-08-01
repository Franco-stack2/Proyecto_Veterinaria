/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.util.Date;

public class Vacuna {
    private int id_vacuna;
    private String nombre;
    private Date fecha_aplicacion;
    private Date proxima_dosis;
    private Mascota mascota;

    public Vacuna() {
        this.id_vacuna = 0;
        this.nombre = "";
        this.fecha_aplicacion = null;
        this.proxima_dosis = null;
        this.mascota = null;
    }

    public Vacuna(int id_vacuna, String nombre, Date fecha_aplicacion,
            Date proxima_dosis, Mascota mascota) {
        this.id_vacuna = id_vacuna;
        this.nombre = nombre;
        this.fecha_aplicacion = fecha_aplicacion;
        this.proxima_dosis = proxima_dosis;
        this.mascota = mascota;
    }

    public int getId_vacuna() {
        return id_vacuna;
    }

    public void setId_vacuna(int id_vacuna) {
        this.id_vacuna = id_vacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(Date fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public Date getProxima_dosis() {
        return proxima_dosis;
    }

    public void setProxima_dosis(Date proxima_dosis) {
        this.proxima_dosis = proxima_dosis;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    
}
