/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Subasta;

import Cliente.Cliente;
import Interface.MainInterface;
import Subasta.JFrames.JFrameSubasta;


/**
 *
 * @author oscfr
 */
public class MainSub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Crea el cliente
        Cliente c = new Cliente();

        //Muestra la pantalla de jugador
        MainInterface pJ = new MainInterface(c);
        pJ.setVisible(true);

        //Coloca la ref a la pantalla en el cliente y lo conecta
        c.setPantalla(pJ);
        c.conectar();
    }
    
}
