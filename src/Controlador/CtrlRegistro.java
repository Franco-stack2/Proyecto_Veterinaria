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
        this.vista.btnRegistrar.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Registro");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public void limpiar() {
        vista.txtNombre.setText("");
        vista.txtEmail.setText("");
        vista.txtTelefono.setText("");
        vista.txtContrasena.setText("");
        vista.txtNombre.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnRegistrar) {

            modelo.setNombre(vista.txtNombre.getText());
            modelo.setEmail(vista.txtEmail.getText());
            modelo.setNumTelefono(Integer.parseInt(vista.txtTelefono.getText()));
            modelo.setContrasena(String.valueOf(vista.txtContrasena.getPassword()));

            if (consultas.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar usuario");
            }
        }
    }
}
