/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Cita;
import Modelo.ConsultasCita;
import Vista.AgendarCita;
import Vista.RegistroMedicoCitas;
import Vista.HistorialPacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlAgendarCita implements ActionListener {

    private final Cita modelo;
    private final ConsultasCita consultas;
    private final AgendarCita vista;


    public CtrlAgendarCita(Cita modelo, ConsultasCita consultas, AgendarCita vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;

  
        this.vista.getBtnAgendar().addActionListener(this);
        this.vista.getBtnCancelar().addActionListener(this);
        this.vista.getBtnRegistrosMedicosCitas().addActionListener(this);
        this.vista.getBtnConsultarHistorialPacientes().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

     
        if (e.getSource() == vista.getBtnRegistrosMedicosCitas()) {
            RegistroMedicoCitas vistaMedico = new RegistroMedicoCitas();
            Modelo.Mascota modeloMas = new Modelo.Mascota();
            Modelo.ConsultasMascota conMas = new Modelo.ConsultasMascota();
            
            CtrlRegistroMedicoCitas ctrlMedico = new CtrlRegistroMedicoCitas(modeloMas, conMas, vistaMedico);
            
            vistaMedico.setLocationRelativeTo(null);
            vistaMedico.setVisible(true);
            this.vista.dispose(); 
        }
 
  
        if (e.getSource() == vista.getBtnConsultarHistorialPacientes()) {
            HistorialPacientes vistaHistorial = new HistorialPacientes();
            Modelo.Expediente modeloExpediente = new Modelo.Expediente();
            Modelo.ConsultasExpediente consultasExpediente = new Modelo.ConsultasExpediente();

            CtrlHistorialPacientes ctrlHistorial = new CtrlHistorialPacientes(
                modeloExpediente, 
                consultasExpediente, 
                vistaHistorial
            );

            vistaHistorial.setLocationRelativeTo(null);
            vistaHistorial.setVisible(true);
            this.vista.dispose(); 
        }    


        if (e.getSource() == vista.getBtnAgendar()) {
            
        
            if (vista.getTxtFechayHora().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la Fecha y Hora para agendar la cita.");
                return;
            }


            modelo.setFecha(vista.getTxtFechayHora().getText().trim());
            modelo.setTipoCita(vista.getCmbTipoCita().getSelectedItem().toString());

          
            if (consultas.registrar(modelo)) {
                // Recuperamos el ID autoincremental más alto asignado por la base de datos
                int numeroCitaGenerado = consultas.obtenerUltimoIdCita();
                
                // Lo desplegamos de inmediato en tu JTextField de la pantalla
                vista.getTxtNumerodeCita().setText(String.valueOf(numeroCitaGenerado));
                
                JOptionPane.showMessageDialog(null, "¡Cita agendada con éxito!\nNúmero de Cita generado: " + numeroCitaGenerado);
            } else {
                JOptionPane.showMessageDialog(null, "Error físico al intentar agendar la cita en el servidor.");
            }
        }


        if (e.getSource() == vista.getBtnCancelar()) {
            limpiar();
            JOptionPane.showMessageDialog(null, "Campos del formulario limpiados.");
        } 
    } 

    // MÉTODO AUXILIAR DE LIMPIEZA
    public void limpiar() {
        vista.getTxtFechayHora().setText("");
        vista.getTxtNumerodeCita().setText("");
        vista.getCmbTipoCita().setSelectedIndex(0);
        vista.getTxtFechayHora().requestFocus(); 
    }
}