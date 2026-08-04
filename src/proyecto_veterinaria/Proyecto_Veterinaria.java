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
import Modelo.Mascota;
import Modelo.ConsultasMascota;
import Vista.RegistroMascotas;
import Controlador.CtrlRegistroMascotas;

public class Proyecto_Veterinaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
           
        Usuario modUsuario = new Usuario();
        ConsultasUsuario conUsuario = new ConsultasUsuario();
        FrmInicioSesion frmLogin = new FrmInicioSesion();
        

        CtrlInicioSesion ctrlLogin = new CtrlInicioSesion(modUsuario, conUsuario, frmLogin);
        
        
        ctrlLogin.iniciar();
        
        Mascota modelo = new Mascota(); 
        ConsultasMascota consultas = new ConsultasMascota(); 
        RegistroMascotas vista = new RegistroMascotas();
        
        CtrlRegistroMascotas controlador = new CtrlRegistroMascotas(modelo, consultas, vista);
        
        
        
        
        
    }
}
    
   