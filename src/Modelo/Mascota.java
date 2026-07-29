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

    // Constructor vacío (por defecto)
    public Mascota() {
        this.nombreMascota = "";
        this.razaMascota = "";
        this.vacunas = "";
        this.servicios = "";
        this.medicamentos= "";
    }

    // Constructor con parámetros
    public Mascota(String nombreMascota, String razaMascota, String vacunas, String servicios, String medicamentos) {
        this.nombreMascota = nombreMascota;
        this.razaMascota = razaMascota;
        this.vacunas = vacunas;
        this.servicios = servicios;
        this.medicamentos = medicamentos;
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
}
    // Getters y Setters
