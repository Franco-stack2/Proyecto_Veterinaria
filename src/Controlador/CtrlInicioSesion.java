/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConsultasUsuario;
import Modelo.Usuario;
import Vista.FrmInicioSesion;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlInicioSesion implements ActionListener {

    private final Usuario modelo;
    private final ConsultasUsuario consultas;
    private final FrmInicioSesion vista;

    public CtrlInicioSesion(Usuario modelo, ConsultasUsuario consultas, FrmInicioSesion vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.getBtnIniciarSesion().addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Inicio de Sesión");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public void limpiar() {
        vista.txtEmail.setText("");
        vista.txtContrasena.setText("");
        vista.txtEmail.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getBtnIniciarSesion()) {

            modelo.setEmail(vista.txtEmail.getText());
            modelo.setContrasena(
                String.valueOf(vista.txtContrasena.getPassword())
            );

            if (consultas.iniciarSesion(modelo)) {

                JOptionPane.showMessageDialog(
                    null,
                    "Bienvenido " + modelo.getNombre()
                );

                limpiar();

            } else {

                JOptionPane.showMessageDialog(
                    null,
                    "Correo o contraseña incorrectos"
                );

                limpiar();
            }
        }
    }
    
  
  
}