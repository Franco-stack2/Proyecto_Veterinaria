/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Usuario
 */

import Modelo.ConsultasUsuario;
import Modelo.Usuario;
import Modelo.Duenio;             
import Modelo.ConsultasDuenio;       
import Modelo.Veterinario;         
import Modelo.ConsultasVeterinario; 
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.FrmFormularioRegistro;

public class CtrlFormularioRegistro implements ActionListener {


 private final Usuario modelo;
    private final ConsultasUsuario consultas;
    private final FrmFormularioRegistro vista;

    public CtrlFormularioRegistro(Usuario modelo, ConsultasUsuario consultas, FrmFormularioRegistro vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        
       
        this.vista.getBtnRegistrarUsuario().addActionListener(this);
    }

    public void limpiar() {
       // Limpieza de campos utilizando métodos Getters que se hicieron en vista :/
        vista.getTxtNombre().setText("");
        vista.getTxtCorreoElectronico().setText("");
        vista.getTxtContrasena().setText("");
        vista.getTxtNumTelefonico().setText("");
        vista.getCmbTipoUsuario().setSelectedIndex(0);
        vista.getTxtNombre().requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

        if (e.getSource() == vista.getBtnRegistrarUsuario()) {
            
      
            if (vista.getCmbTipoUsuario().getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione un tipo de usuario válido.");
                return;
            }

            // Mapeamos los datos de la interfaz al modelo utilizando métodos Getters
            modelo.setNombre(vista.getTxtNombre().getText().trim());
            modelo.setEmail(vista.getTxtCorreoElectronico().getText().trim());
            modelo.setContrasena(vista.getTxtContrasena().getText().trim());
            modelo.setNumTelefono(vista.getTxtNumTelefonico().getText().trim());
            
            // Obtenemos el rol seleccionado mediante el Getter del ComboBox
            String rolSeleccionado = vista.getCmbTipoUsuario().getSelectedItem().toString().trim();
            modelo.setTipoUsuario(rolSeleccionado);

     
            if (consultas.registrar(modelo)) {
                
                boolean insercionHijaCorrecta = true;

            
                if (rolSeleccionado.equalsIgnoreCase("Dueño") || rolSeleccionado.equalsIgnoreCase("Duenio") || rolSeleccionado.equalsIgnoreCase("Veterinario")) {
                    
         
                    if (consultas.buscar(modelo)) {
                        int nuevoIdUsuario = modelo.getId_usuario(); 
                        
   
                        if (rolSeleccionado.equalsIgnoreCase("Dueño") || rolSeleccionado.equalsIgnoreCase("Duenio")) {
                            Duenio due = new Duenio();
                            ConsultasDuenio conDue = new ConsultasDuenio(); 
                            due.setId_usuario(nuevoIdUsuario);
                            insercionHijaCorrecta = conDue.registrar(due);
                        } 
 
                        else if (rolSeleccionado.equalsIgnoreCase("Veterinario")) {
                            Veterinario vet = new Veterinario();
                            ConsultasVeterinario conVet = new ConsultasVeterinario();
                            vet.setId_usuario(nuevoIdUsuario);
                            insercionHijaCorrecta = conVet.registrar(vet);
                        }
                    } else {
                        insercionHijaCorrecta = false;
                    }
                }

   
                if (insercionHijaCorrecta) { // esta linea funciona como interruptor de seguridad del sistema dependiendo del rol seleccionado 
                    JOptionPane.showMessageDialog(null, "¡Registro guardado con éxito! Tipo: " + rolSeleccionado);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Se creó el usuario base, pero hubo un fallo al indexarlo en la tabla secundaria.");
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el usuario. Verifique si el correo ya existe.");
            }
        }
    } 
}