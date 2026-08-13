/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Expediente;
import Modelo.ConsultasExpediente;
import Vista.HistorialPacientes;
import Vista.RegistroMedicoCitas;
import Vista.AgendarCita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlHistorialPacientes implements ActionListener {
    
    private final Expediente modelo;
    private final ConsultasExpediente consultas;
    private final HistorialPacientes vista;


    public CtrlHistorialPacientes(Expediente modelo, ConsultasExpediente consultas, HistorialPacientes vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;

        // se le asigna accion al botón "Buscar" inferior derecho
        this.vista.getBtnBuscar().addActionListener(this);
        
        // se asignan acciones a las opciones del menú lateral izquierdo
        this.vista.getBtnRegistrosMedicosCitas().addActionListener(this);
        this.vista.getBtnAgendarcitas().addActionListener(this);
        this.vista.getBtnHistorialPaciente().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

      
        if (e.getSource() == vista.getBtnBuscar()) {
            
            if (vista.getTxtIngresarNombreMascota().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de la mascota para consultar su expediente clínico.");
                return;
            }

            modelo.setNombreMascota(vista.getTxtIngresarNombreMascota().getText().trim());

            if (consultas.buscarExpedientePorNombre(modelo)) {
                vista.getTxtContactodeEmergencia().setText(modelo.getContactoEmergencia());
                vista.getTxtCondicionesPasadas().setText(modelo.getCondicionesPasadas());
                vista.getTxtAlergias().setText(modelo.getAlergias());
                
                JOptionPane.showMessageDialog(null, "¡Expediente clínico recuperado y cargado con éxito!");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún expediente registrado para una mascota con ese nombre.");
                limpiar();
            }
        }

       

        if (e.getSource() == vista.getBtnRegistrosMedicosCitas()) {
            RegistroMedicoCitas vistaMedico = new RegistroMedicoCitas();
            Modelo.Mascota modeloMas = new Modelo.Mascota();
            Modelo.ConsultasMascota conMas = new Modelo.ConsultasMascota();
    
            CtrlRegistroMedicoCitas ctrlMedico = new CtrlRegistroMedicoCitas(modeloMas, conMas, vistaMedico);
            
            vistaMedico.setLocationRelativeTo(null);
            vistaMedico.setVisible(true);
            this.vista.dispose(); 
        }

     
        if (e.getSource() == vista.getBtnAgendarcitas()) {
            Modelo.Cita modeloCita = new Modelo.Cita();
            Modelo.ConsultasCita consultasCita = new Modelo.ConsultasCita();
            AgendarCita vistaAgendar = new AgendarCita();
            
      
            CtrlAgendarCita ctrlAgendar = new CtrlAgendarCita(modeloCita, consultasCita, vistaAgendar);
            
            vistaAgendar.setLocationRelativeTo(null);
            vistaAgendar.setVisible(true);
            this.vista.dispose(); 
        }
        
     
        if (e.getSource() == vista.getBtnHistorialPaciente()) {
            JOptionPane.showMessageDialog(null, "Usted ya se encuentra visualizando la sección de Historial de Pacientes.");
        }
    }

   
    public void limpiar() {
        vista.getTxtIngresarNombreMascota().setText("");
        vista.getTxtContactodeEmergencia().setText("");
        vista.getTxtCondicionesPasadas().setText("");
        vista.getTxtAlergias().setText("");
        vista.getTxtIngresarNombreMascota().requestFocus(); 
    }
}
