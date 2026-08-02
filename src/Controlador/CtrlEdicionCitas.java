/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cita;
import Modelo.ConsultasCita;
import Vista.EdicionCitas;
import Vista.AvisosPlataforma; // este se necesita por la navegacion lateral
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class CtrlEdicionCitas implements ActionListener {

    private final Cita modelo;
    private final ConsultasCita consultas;
    private final EdicionCitas vista;

   
    public CtrlEdicionCitas(Cita modelo, ConsultasCita consultas, EdicionCitas vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;

        
        this.vista.getBtnAgregar().addActionListener(this);   
        this.vista.getBtnCancelar().addActionListener(this);  
        this.vista.getBtnMenuAvisos().addActionListener(this); 
    }

    // 4. INTERCEPTOR DE CLICS (Eventos de la interfaz)
    @Override
    public void actionPerformed(ActionEvent e) {

        // ACCIÓN A: NAVEGACIÓN LATERAL - IR A AVISOS
        if (e.getSource() == vista.getBtnMenuAvisos()) {
            
            AvisosPlataforma vistaAvisos = new AvisosPlataforma();
            //CtrlAvisosPlataforma ctrlAvisos = new CtrlAvisosPlataforma(vistaAvisos);  ESTO ES ESENCIAL NO TOCAR POR EL MOMENTO 
            
            vistaAvisos.setLocationRelativeTo(null);
            vistaAvisos.setVisible(true);
            
            this.vista.dispose(); // Cerramos la ventana de citas actual de forma limpia
        }

    
        if (e.getSource() == vista.getBtnAgregar()) {
            
          
            if (vista.getTxtIdCita().getText().trim().isEmpty() || vista.getTxtFechaHora().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el ID de la cita y la nueva fecha.");
                return;
            }

            try {
                // Pasamos los datos recolectados mediante Getters al Modelo
                modelo.setId_cita(Integer.parseInt(vista.getTxtIdCita().getText().trim()));
                modelo.setFecha(vista.getTxtFechaHora().getText().trim()); 

                
                if (consultas.modificar(modelo)) {
                    JOptionPane.showMessageDialog(null, "¡La fecha de su cita ha sido modificada con éxito!");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ninguna cita registrada con el ID ingresado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El ID de la cita debe ser un valor numérico entero.");
            }
        }

    
        if (e.getSource() == vista.getBtnCancelar()) {
            
           
            if (vista.getTxtIdCita().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el ID de la cita para cancelarla.");
                return;
            }

            try {
                // Pasamos el ID de la cita al modelo para el filtro DELETE
                modelo.setId_cita(Integer.parseInt(vista.getTxtIdCita().getText().trim()));

                // Ejecutamos el borrado físico en MySQL
                if (consultas.eliminar(modelo)) {
                    JOptionPane.showMessageDialog(null, "¡Su cita ha sido cancelada con éxito!");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ninguna cita activa con el ID ingresado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El ID de la cita debe ser un número entero válido.");
            }
        }
    }


    public void limpiar() {
        vista.getTxtIdCita().setText("");
        vista.getTxtFechaHora().setText("");
        vista.getTxtIdCita().requestFocus(); // Devuelve el cursor al primer campo
    }
}
    
   