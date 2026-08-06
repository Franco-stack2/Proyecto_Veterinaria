/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Expediente {
     private int idExpediente;
    private String nombreMascota;
    private String contactoEmergencia;
    private String condicionesPasadas;
    private String alergias;
     private int Id_mascota;
    
    
    // Constructor vacío
    public Expediente() {
        this.idExpediente = 0;
        this.nombreMascota = "";
        this.contactoEmergencia = "";
        this.condicionesPasadas = "";
        this.alergias = "";
    }

    // Constructor con parámetros
    public Expediente(int idExpediente, String nombreMascota, String contactoEmergencia, String condicionesPasadas, String alergias) {
        this.idExpediente = idExpediente;
        this.nombreMascota = nombreMascota;
        this.contactoEmergencia = contactoEmergencia;
        this.condicionesPasadas = condicionesPasadas;
        this.alergias = alergias;
    }

    // Getters y Setters

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public String getCondicionesPasadas() {
        return condicionesPasadas;
    }

    public void setCondicionesPasadas(String condicionesPasadas) {
        this.condicionesPasadas = condicionesPasadas;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public int getId_mascota() {
        return Id_mascota;
    }

    public void setId_mascota(int Id_mascota) {
        this.Id_mascota = Id_mascota;
    }
  
    
    
    
}
