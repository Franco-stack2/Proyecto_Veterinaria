/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Mascota; 
import Modelo.ConsultasMascota; 
import Vista.RegistroMascotas; 
import Vista.FrmExpedienteMedico; 
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

       
        this.vista.getBtnAgregar().addActionListener(this); 
        this.vista.getBtnCancelar().addActionListener(this); 
        this.vista.getBtnExpedienteMedico().addActionListener(this); 
        this.vista.getBtnRegistro().addActionListener(this); 
    } 
    
    @Override 
    public void actionPerformed(ActionEvent e) { 


        if (e.getSource() == vista.getBtnAgregar()) { 

       
            String telefonoInput = vista.getTxtTelefonoDuenio().getText().trim();

          
            modelo.setNombreMascota(vista.getTxtNombreMascota().getText().trim()); 
            modelo.setRazaMascota(vista.getTxtRaza().getText().trim()); 
            modelo.setVacunas(vista.getTxtVacunasregistrados().getText().trim()); 
            modelo.setServicios(vista.getTxtServiciosregistrados().getText().trim()); 
            modelo.setMedicamentos(vista.getTxtMedicamentosregistrados().getText().trim()); 

    
            if (modelo.getNombreMascota().isEmpty() 
                    || modelo.getRazaMascota().isEmpty() 
                    || modelo.getVacunas().isEmpty() 
                    || modelo.getServicios().isEmpty() 
                    || modelo.getMedicamentos().isEmpty()
                    || telefonoInput.isEmpty()) { 
                
                JOptionPane.showMessageDialog(null, "Debe completar todos los campos del formulario.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                return; 
            }
            
      
            int idDuenoEncontrado = consultas.buscarIdDuenoPorTelefono(telefonoInput);
            
            if (idDuenoEncontrado > 0) {
     
                modelo.setId_dueno(idDuenoEncontrado); 
                
           
                if (consultas.registrar(modelo)) {
                    JOptionPane.showMessageDialog(null, "Mascota registrada correctamente y enlazada a su dueño.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Error físico al intentar registrar la mascota en la base de datos.", "Error SQL", JOptionPane.ERROR_MESSAGE);
                }
            } else {
           
                JOptionPane.showMessageDialog(null, "El teléfono ingresado no pertenece a ningún dueño registrado.\nPor favor, dé de alta al dueño primero.", "Dueño no encontrado", JOptionPane.ERROR_MESSAGE);
            }
        } 
        
        if (e.getSource() == vista.getBtnCancelar()) { 
            limpiarCampos(); 
            JOptionPane.showMessageDialog(null, "Los campos del formulario fueron limpiados.", "Cancelar", JOptionPane.INFORMATION_MESSAGE);
        } 
     
        if (e.getSource() == vista.getBtnExpedienteMedico()) {
  
    FrmExpedienteMedico vistaExpedienteMedico = new FrmExpedienteMedico(); 
    
   
    Modelo.Expediente modeloExp = new Modelo.Expediente();
    Modelo.ConsultasExpediente consultasExp = new Modelo.ConsultasExpediente();
    

    Controlador.CtrlExpedienteMedico ctrlExp = new Controlador.CtrlExpedienteMedico(
        modeloExp, 
        consultasExp, 
        vistaExpedienteMedico
    );
    
    vistaExpedienteMedico.setLocationRelativeTo(null); 
    vistaExpedienteMedico.setVisible(true); 
    
    this.vista.dispose(); 
}
        

        if (e.getSource() == vista.getBtnRegistro()) {
 
        }
    }


    private void limpiarCampos() { 
        vista.getTxtTelefonoDuenio().setText("");
        vista.getTxtNombreMascota().setText(""); 
        vista.getTxtRaza().setText(""); 
        vista.getTxtVacunasregistrados().setText(""); 
        vista.getTxtServiciosregistrados().setText(""); 
        vista.getTxtMedicamentosregistrados().setText(""); 
        vista.getTxtTelefonoDuenio().requestFocus(); 
    }
}     