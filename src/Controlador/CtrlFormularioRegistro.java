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
import Vista.FrmFormularioRegistro;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.*;


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

   
            modelo.setNombre(vista.getTxtNombre().getText());
            modelo.setEmail(vista.getTxtCorreoElectronico().getText());
            modelo.setContrasena(vista.getTxtContrasena().getText());
            modelo.setNumTelefono(vista.getTxtNumTelefonico().getText());
            modelo.setTipoUsuario(vista.getCmbTipoUsuario().getSelectedItem().toString());

  
            if (consultas.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "¡Usuario registrado con éxito en la base de datos!");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el usuario. Verifique la conexión.");
            }
        }
    }
}