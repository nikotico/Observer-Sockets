/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Subasta;
import Subasta.JFrames.JFrameIniciarSesion;


public class MainSub {

    public static void main(String[] args) {
            //Crea el cliente
            Subasta.Cliente.Cliente c = new Subasta.Cliente.Cliente();
            
            //Muestra la pantalla de iniciar seccion
            JFrameIniciarSesion pJ = new JFrameIniciarSesion(c);
            pJ.setVisible(true);
            
            //Coloca la ref a la pantalla en el cliente y lo conecta
            c.setPantalla(pJ);
            c.conectar();
    }
    
}
