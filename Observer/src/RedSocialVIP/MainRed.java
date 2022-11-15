/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RedSocialVIP;

import RedSocialVIP.JFrames.JFrameIniciarSesion;

/**
 *
 * @author oscfr
 */
public class MainRed {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crea el cliente
            RedSocialVIP.Cliente.Cliente c = new RedSocialVIP.Cliente.Cliente();
            
            //Muestra la pantalla de iniciar seccion
            JFrameIniciarSesion pJ = new JFrameIniciarSesion();
            pJ.setVisible(true);
            
            //Coloca la ref a la pantalla en el cliente y lo conecta
            c.setPantalla(pJ);
            c.conectar();
    }
    
}
