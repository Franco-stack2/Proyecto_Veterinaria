/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Mascota;
import Modelo.ConsultasMascota;
import Vista.RegistroMedicoCitas; 
import Vista.AgendarCita;
import Vista.HistorialPacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlRegistroMedicoCitas implements ActionListener {
    
    private final Mascota modelo;
    private final ConsultasMascota consultas;
    private final RegistroMedicoCitas vista;
    
   
    public CtrlRegistroMedicoCitas(Modelo.Mascota modelo, Modelo.ConsultasMascota consultas, Vista.RegistroMedicoCitas vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;

    
        this.vista.getTxtNombremascota().addActionListener(this); 
        this.vista.getBtnAgregar().addActionListener(this);
        this.vista.getBtnCancelar().addActionListener(this);
        
        // Escuchadores del menú lateral izquierdo (Navegación)
        this.vista.getBtnAgendarCitas().addActionListener(this);
        this.vista.getBtnHistorialdepaciente().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       
        if (e.getSource() == vista.getBtnAgendarCitas()) {
            Modelo.Cita modeloCita = new Modelo.Cita();
            Modelo.ConsultasCita consultasCita = new Modelo.ConsultasCita();
            Vista.AgendarCita vistaAgendar = new Vista.AgendarCita();
            
            
            Controlador.CtrlAgendarCita ctrlAgendar = new Controlador.CtrlAgendarCita(modeloCita, consultasCita, vistaAgendar);
            
            vistaAgendar.setLocationRelativeTo(null);
            vistaAgendar.setVisible(true);
            this.vista.dispose(); 
        }

    
        if (e.getSource() == vista.getBtnHistorialdepaciente()) { 
            Vista.HistorialPacientes vistaHistorial = new Vista.HistorialPacientes();
            Modelo.Expediente modeloExpediente = new Modelo.Expediente();
            Modelo.ConsultasExpediente consultasExpediente = new Modelo.ConsultasExpediente();


            Controlador.CtrlHistorialPacientes ctrlHistorial = new Controlador.CtrlHistorialPacientes(
                modeloExpediente, 
                consultasExpediente, 
                vistaHistorial
            );

            vistaHistorial.setLocationRelativeTo(null);
            vistaHistorial.setVisible(true);
            this.vista.dispose(); 
        }       
     
    
        if (e.getSource() == vista.getTxtNombremascota()) {
            if (vista.getTxtNombremascota().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de la mascota para buscar.");
                return;
            }

            modelo.setNombreMascota(vista.getTxtNombremascota().getText().trim());

            if (consultas.buscarPorNombreMascota(modelo)) {
                vista.getTxtRazadelaMascota().setText(modelo.getRazaMascota());
                vista.getTxtVacunas().setText(modelo.getVacunas());
                vista.getTxtServicios().setText(modelo.getServicios());
                vista.getTxtMedicamentosrecetados().setText(modelo.getMedicamentos());
                
                JOptionPane.showMessageDialog(null, "¡Paciente localizado! Historial cargado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna mascota registrada con ese nombre.");
                limpiar();
            }
        }

    
        if (e.getSource() == vista.getBtnAgregar()) {
            
            if (modelo.getId_mascota() == 0) {
                JOptionPane.showMessageDialog(null, "Por favor, busque primero una mascota válida presionando Enter en su nombre.");
                return;
            }

            modelo.setVacunas(vista.getTxtVacunas().getText().trim());
            modelo.setServicios(vista.getTxtServicios().getText().trim());
            modelo.setMedicamentos(vista.getTxtMedicamentosrecetados().getText().trim());

            if (consultas.actualizarHistorialCita(modelo)) {
                JOptionPane.showMessageDialog(null, "¡Registro médico actualizado con éxito!");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos médicos en la base de datos.");
            }
        }


        if (e.getSource() == vista.getBtnCancelar()) {
            limpiar();
        }
    }

    public void limpiar() {
        vista.getTxtNombremascota().setText("");
        vista.getTxtRazadelaMascota().setText("");
        vista.getTxtVacunas().setText("");
        vista.getTxtServicios().setText("");
        vista.getTxtMedicamentosrecetados().setText("");
        
        modelo.setId_mascota(0);
        vista.getTxtNombremascota().requestFocus(); 
    }
}