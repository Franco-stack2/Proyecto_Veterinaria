/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Medicamento {
    private int id_medicamento;
    private String nombre;
    private String dosis;
    private Tratamiento tratamiento;

    public Medicamento() {
        this.id_medicamento = 0;
        this.nombre = "";
        this.dosis = "";
        this.tratamiento = null;
    }

    public Medicamento(int id_medicamento, String nombre,
            String dosis, Tratamiento tratamiento) {

        this.id_medicamento = id_medicamento;
        this.nombre = nombre;
        this.dosis = dosis;
        this.tratamiento = tratamiento;
    }

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }
}
