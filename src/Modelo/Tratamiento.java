/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

public class Tratamiento {
    
    private int id_tratamiento;
    private String diagnostico;
    private String tratamiento;
    private Date fecha;
    private Expediente expediente;

    public Tratamiento() {
        this.id_tratamiento = 0;
        this.diagnostico = "";
        this.tratamiento = "";
        this.fecha = null;
        this.expediente = null;
    }

    public Tratamiento(int id_tratamiento, String diagnostico,
            String tratamiento, Date fecha, Expediente expediente) {

        this.id_tratamiento = id_tratamiento;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.fecha = fecha;
        this.expediente = expediente;
    }

    public int getId_tratamiento() {
        return id_tratamiento;
    }

    public void setId_tratamiento(int id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }
    
    
}
