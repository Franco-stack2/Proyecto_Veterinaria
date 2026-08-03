/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cita;
import Modelo.ConsultasCita;
import Vista.FrmRegistro;
import Vista.RegistroMascotas;
import Vista.RegistroVeterinarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class CtrlRegistro implements ActionListener {
    
   

    //private final Cita modelo;
    private final ConsultasCita consultas;
    private final FrmRegistro vista;

   
    public CtrlRegistro(ConsultasCita consultas, FrmRegistro vista) {
        //this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
     

        
        this.vista.getBtnExpedienteMedico().addActionListener(this); 
        this.vista.getBtnGenerarReportes().addActionListener(this);
        this.vista.getBtnRegistrarDuenos().addActionListener(this);  
        this.vista.getBtnRegistrarMascotasyHistorial().addActionListener(this); 
        this.vista.getBtnRegistrarVeterinarios().addActionListener(this);
        this.vista.getBtnRegistros().addActionListener(this);
    }

  
  
    @Override
    public void actionPerformed(ActionEvent e) {

   //para abrir pagina de registrar veterinarior, funcion del boton registro veterinario
        if (e.getSource() == vista.getBtnRegistrarVeterinarios()) {
                                
            RegistroVeterinarios vistaRegistroVeterinarios = new RegistroVeterinarios();
            CtrlRegistroVeterinarios ctrlRegistroVeterinarios = new CtrlRegistroVeterinarios ();//vistaRegistroVeterinarios);
            vistaRegistroVeterinarios.setLocationRelativeTo(null);
            vistaRegistroVeterinarios.setVisible(true);
            
            this.vista.dispose(); // que se cierre
        }
        
         //para abrir pagina de registrar mascotas, funcion del boton registro veterinario
        if (e.getSource() == vista.getBtnRegistrarMascotasyHistorial()) {
          
            RegistroMascotas vistaRegistroMascotas = new RegistroMascotas();
            CtrlRegistroMascotas ctrlRegistroMascotas = new CtrlRegistroMascotas ();//vistaRegistroVeterinarios);
            vistaRegistroMascotas.setLocationRelativeTo(null);
            vistaRegistroMascotas.setVisible(true);
            
            this.vista.dispose(); // que se cierre
  
    
    }


    }}
