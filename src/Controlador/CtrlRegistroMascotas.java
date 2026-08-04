/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Mascota; 
import Modelo.ConsultasMascota; 
import Vista.RegistroMascotas; 
import Vista.FrmExpedienteMedico; 
import Vista.FrmGenerarcionReportes; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.JOptionPane; 

public class CtrlRegistroMascotas implements ActionListener { 
    
    
    private final Mascota modelo;
    private final ConsultasMascota consultas; 
    private final RegistroMascotas vista; 
    
    public CtrlRegistroMascotas(Mascota modelo, ConsultasMascota consultas, RegistroMascotas vista) { 
        
        this.modelo = modelo;
        this.consultas = consultas; 
        this.vista = vista; 

// Botones de la vista 
        this.vista.getBtnAgregar().addActionListener(this); 
        this.vista.getBtnCancelar().addActionListener(this); 
        this.vista.getBtnExpedienteMedico().addActionListener(this); 
        this.vista.getBtnGenerarReportes().addActionListener(this); 
        this.vista.getBtnRegistro().addActionListener(this); } 
    
    @Override 
    
   public void actionPerformed(ActionEvent e) { 

// boton agregar
        if (e.getSource() == vista.getBtnAgregar()) { 

        // Obtener los datos de la vista 
        
        modelo.setNombreMascota(vista.getTxtNombreMascota().getText()); 
        modelo.setRazaMascota(vista.getTxtRaza().getText()); 
        modelo.setVacunas(vista.getTxtVacunasregistrados().getText()); 
        modelo.setServicios(vista.getTxtServiciosregistrados().getText()); 
        modelo.setMedicamentos(vista.getTxtMedicamentosregistrados().getText()); 

        // Validar que los campos no estén vacíos 
        if (modelo.getNombreMascota().isEmpty() 
                
                || modelo.getRazaMascota().isEmpty() 
                || modelo.getVacunas().isEmpty() 
                || modelo.getServicios().isEmpty() 
                || modelo.getMedicamentos().isEmpty()) { 
            
            JOptionPane.showMessageDialog( 
                    null, 
                    "Debe completar todos los campos.", 
                    "Campos vacíos", 
                    JOptionPane.WARNING_MESSAGE );
         
            return; 
        }
                // Registrar mascota en la base de datos 
        
                if (consultas.registrar(modelo)) {
                    
                    JOptionPane.showMessageDialog( 
                            null, 
                            "Mascota registrada correctamente.", 
                            "Registro exitoso", 
                            JOptionPane.INFORMATION_MESSAGE 
                    );
                }
                      limpiarCampos();
                      
                } else {
            
            
                      JOptionPane.showMessageDialog(
                              null,
                              "No se pudo registrar la mascota.", 
                              "Error", 
                              JOptionPane.ERROR_MESSAGE
                      );
        } 
    
 
    // boton cancelar
    if (e.getSource() == vista.getBtnCancelar()) { 

        limpiarCampos(); 
        
        JOptionPane.showMessageDialog( null,
        "Los campos fueron limpiados.",
        "Cancelar", 
        JOptionPane.INFORMATION_MESSAGE );
} 
        // boton expediente medico
       if (e.getSource() == vista.getBtnExpedienteMedico()) {

        FrmExpedienteMedico vistaExpedienteMedico = new FrmExpedienteMedico(); 

        vistaExpedienteMedico.setLocationRelativeTo(null); 
        vistaExpedienteMedico.setVisible(true); 

        vista.dispose(); 

} 

    // Boton generar reportes
    if (e.getSource() == vista.getBtnGenerarReportes()) { 

    FrmGenerarcionReportes vistaGenerarReportes = new FrmGenerarcionReportes(); 

    vistaGenerarReportes.setLocationRelativeTo(null); 
    vistaGenerarReportes.setVisible(true); 

    vista.dispose(); 
} 
    
   }
// limpiar campos
   private void limpiarCampos() { 
        vista.getTxtNombreMascota().setText(""); 
        vista.getTxtRaza().setText(""); 
        vista.getTxtVacunasregistrados().setText(""); 
        vista.getTxtServiciosregistrados().setText(""); 
        vista.getTxtMedicamentosregistrados().setText(""); 
   
}

        
}
        