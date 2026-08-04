/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cita;
import Modelo.ConsultasCita;
import Vista.FrmExpedienteMedico;
import Vista.FrmGenerarcionReportes;
import Vista.RegistroMascotas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class CtrlRegistroMascotas implements ActionListener {
    
   

    private final Cita modelo;
    private final ConsultasCita consultas;
    private final RegistroMascotas vista;
   
    public CtrlRegistroMascotas (Cita modelo, ConsultasCita consultas, RegistroMascotas vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
     
 
        this.vista.getBtnAgregar().addActionListener(this); 
        this.vista.getBtnCancelar().addActionListener(this); 
        this.vista.getBtnExpedienteMedico().addActionListener(this); 
        this.vista.getBtnGenerarReportes().addActionListener(this);
        this.vista.getBtnRegistro().addActionListener(this); 
        this.vista.getTxtMedicamentosregistrados().addActionListener(this); 
        this.vista.getTxtNombreMascota().addActionListener(this); 
        this.vista.getTxtRaza().addActionListener(this);
        this.vista.getTxtVacunasregistrados().addActionListener(this);
        this.vista.getTxtServiciosregistrados().addActionListener(this);
       
        
    }
  
  
    @Override
    public void actionPerformed(ActionEvent e) {

  
        
        //para abrir pagina de expediente medico, funcion del boton expediente medico
        if (e.getSource() == vista.getBtnExpedienteMedico()) {
          
            FrmExpedienteMedico vistaExpedienteMedico = new FrmExpedienteMedico();
            CtrlExpedienteMedico ctrlExpedienteMedico = new CtrlExpedienteMedico ();//vistaExpedienteMedico);
            vistaExpedienteMedico.setLocationRelativeTo(null);
            vistaExpedienteMedico.setVisible(true);
            
            this.vista.dispose(); // que se cierre
            //expediente medico
            
        }
            //generacion reportes
            
            //para abrir pagina de generacion de reportes, funcion del boton generar reporte
        if (e.getSource() == vista.getBtnGenerarReportes()) {
          
            FrmGenerarcionReportes vistaGenerarcionReportes  = new FrmGenerarcionReportes ();
            CtrlGenerarcionReportes ctrlGenerarcionReportes  = new CtrlGenerarcionReportes  ();//vistaGenerarcionReportes );
            vistaGenerarcionReportes.setLocationRelativeTo(null);
            vistaGenerarcionReportes.setVisible(true);
  
    
        }
        
    }
}

        