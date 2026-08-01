/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_veterinaria;

/**
 * Grupo 1 
Franco Sanchez Mico
Vanessa Ulloa Martinez
Kerry Alfaro Brenes
Jimena Echeverria Sabean
 */

import Modelo.Usuario;
import Modelo.ConsultasUsuario;
import Vista.FrmInicioSesion;
import Controlador.CtrlInicioSesion;

public class Proyecto_Veterinaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
              // Inicializamos las tres capas esenciales del Login
        Usuario modUsuario = new Usuario();
        ConsultasUsuario conUsuario = new ConsultasUsuario();
        FrmInicioSesion frmLogin = new FrmInicioSesion();
        
        // Inyectamos las capas al controlador
        CtrlInicioSesion ctrlLogin = new CtrlInicioSesion(modUsuario, conUsuario, frmLogin);
        
        // Arrancamos la aplicación
        ctrlLogin.iniciar();
    }
}
    
   