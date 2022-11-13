/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Cliente;

import Interface.MainInterface;

/**
 *
 * @author Usuario
 */
public class MainCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                try{
            //Crea el cliente
            Cliente c = new Cliente();
            
            //Muestra la pantalla de jugador
            MainInterface pJ = new MainInterface(c);
            pJ.setVisible(true);
            
            //Coloca la ref a la pantalla en el cliente y lo conecta
            c.setPantalla(pJ);
            c.conectar();
        }
        catch(Exception e){ }
    }
    
}
