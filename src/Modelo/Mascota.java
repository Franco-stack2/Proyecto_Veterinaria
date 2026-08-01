/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Mascota {
    private String nombreMascota;
    private String razaMascota;
    private String vacunas;
    private String servicios;
    private String medicamentos;
    private int id_mascota;

    // Constructor vacío (por defecto)
    public Mascota() {
        this.nombreMascota = "";
        this.razaMascota = "";
        this.vacunas = "";
        this.servicios = "";
        this.medicamentos= "";
        this.id_mascota= 0;
    }

    // Constructor con parámetros
    public Mascota(String nombreMascota, String razaMascota, String vacunas, String servicios, String medicamentos, int id_mascota) {
        this.nombreMascota = nombreMascota;
        this.razaMascota = razaMascota;
        this.vacunas = vacunas;
        this.servicios = servicios;
        this.medicamentos = medicamentos;
        this.id_mascota = id_mascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRazaMascota() {
        return razaMascota;
    }

    public void setRazaMascota(String razaMascota) {
        this.razaMascota = razaMascota;
    }

    public String getVacunas() {
        return vacunas;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }
    
    
    
    
}

    // Getters y Setters
