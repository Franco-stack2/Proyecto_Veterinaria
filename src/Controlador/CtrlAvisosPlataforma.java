/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.ConsultasUsuario; 
import Modelo.Usuario;
import Vista.AvisosPlataforma;
import Vista.EdicionCitas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAvisosPlataforma implements ActionListener {
    
private final AvisosPlataforma vista;
    private final ConsultasUsuario consultas;

  
    public CtrlAvisosPlataforma(AvisosPlataforma vista) {
        this.vista = vista;
        this.consultas = new ConsultasUsuario(); 
        
     
        this.vista.getBtnEditarCitas().addActionListener(this);
        
   
        cargarTablonDeAvisos();
    }

   
    private void cargarTablonDeAvisos() {
        String textoAvisos = consultas.obtenerAvisosPlataforma();
        vista.getTxtAvisosTablon().setText(textoAvisos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
      
        if (e.getSource() == vista.getBtnEditarCitas()) {  // este es el boton para irse de vuelta a citas
            
            EdicionCitas vistaCitas = new EdicionCitas();
            Modelo.Cita modeloCita = new Modelo.Cita();
            Modelo.ConsultasCita consultasCita = new Modelo.ConsultasCita();
            
            CtrlEdicionCitas ctrlCitas = new CtrlEdicionCitas(modeloCita, consultasCita, vistaCitas);
            
            vistaCitas.setLocationRelativeTo(null);
            vistaCitas.setVisible(true);
            
            this.vista.dispose(); 
        }
    }
}
