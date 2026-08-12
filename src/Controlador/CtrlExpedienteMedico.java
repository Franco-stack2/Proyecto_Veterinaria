/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Expediente;
import Modelo.ConsultasExpediente;
import Vista.FrmExpedienteMedico; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlExpedienteMedico implements ActionListener {

    private final Expediente modelo;
    private final ConsultasExpediente consultas;
    private final FrmExpedienteMedico vista;

  
   public CtrlExpedienteMedico(Expediente modelo, ConsultasExpediente consultas, FrmExpedienteMedico vista) {

    this.modelo = modelo;
    this.consultas = consultas;
    this.vista = vista;

    // Escuchadores de clics (Listeners)
    this.vista.getBtnAnadir().addActionListener(this);
    this.vista.getBtnCancelar().addActionListener(this);
    this.vista.getBtnExpedienteMedico().addActionListener(this);
    this.vista.getBtnRegistro().addActionListener(this);
}

    @Override
    public void actionPerformed(ActionEvent e) {

     
        if (e.getSource() == vista.getBtnAnadir()) {
            
            if (vista.getTxtNombreMascota().getText().trim().isEmpty() 
                    || vista.getTxtNumEmergencia().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete los campos obligatorios ", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }

      
            modelo.setNombreMascota(vista.getTxtNombreMascota().getText().trim());
            modelo.setContactoEmergencia(vista.getTxtNumEmergencia().getText().trim());
            modelo.setCondicionesPasadas(vista.getTxtCondicionesPasadas().getText().trim());
            modelo.setAlergias(vista.getTxtAlergias().getText().trim());

          
            if (consultas.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "¡Expediente médico registrado correctamente en el sistema!", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error físico al intentar registrar el expediente.", "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        }

  
        if (e.getSource() == vista.getBtnRegistro()) {
        
          Vista.RegistroMascotas vistaRegistro = new Vista.RegistroMascotas(); 
            Modelo.Mascota modeloMascota = new Modelo.Mascota();
            Modelo.ConsultasMascota consultasMascota = new Modelo.ConsultasMascota();
            
            Controlador.CtrlRegistroMascotas ctrlRegistro = new Controlador.CtrlRegistroMascotas(
                modeloMascota, 
                consultasMascota, 
                vistaRegistro
            );
            
            vistaRegistro.setLocationRelativeTo(null); 
            vistaRegistro.setVisible(true); 
            
            this.vista.dispose();
        }

    
        if (e.getSource() == vista.getBtnExpedienteMedico()) {
            
          
        }


        if (e.getSource() == vista.getBtnCancelar()) {
            limpiar();
            JOptionPane.showMessageDialog(null, "Los campos del formulario fueron limpiados.");
        }
    }


    public void limpiar() {
        vista.getTxtNombreMascota().setText("");
        vista.getTxtNumEmergencia().setText("");
        vista.getTxtCondicionesPasadas().setText("");
        vista.getTxtAlergias().setText("");
        
        modelo.setIdExpediente(0); 
        vista.getTxtNombreMascota().requestFocus(); 
    }
}