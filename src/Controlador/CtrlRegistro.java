/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConsultasUsuario;
import Modelo.Usuario;
import Vista.FrmRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlRegistro implements ActionListener {

    private final Usuario modelo;
    private final ConsultasUsuario consultas;
    private final FrmRegistro vista;

    public CtrlRegistro(Usuario modelo, ConsultasUsuario consultas, FrmRegistro vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;

        this.vista.btnRegistro.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Registro de Usuario");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public void limpiar() {
        vista.txtNombre.setText("");
        vista.txtEmail.setText("");
        vista.txtNumTelefono.setText("");
        vista.txtContrasena.setText("");
        vista.cmbTipoUsuario.setSelectedIndex(0);
        vista.txtNombre.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnRegistro) {
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setEmail(vista.txtEmail.getText());
            modelo.setNumTelefono(Integer.parseInt(vista.txtNumTelefono.getText()));
            modelo.setContrasena(String.valueOf(vista.txtContrasena.getPassword()));
            modelo.setTipoUsuario(vista.cmbTipoUsuario.getSelectedItem().toString());

            if (consultas.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "Usuario registrado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar");
                limpiar();
            }
        }
    }
}