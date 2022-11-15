/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subasta.Objetos;

import Subasta.Cliente.Cliente;
import Utils.ID;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscfr
 */
public class Oferente extends Usuario{
    public Oferente(String nick, Cliente c) {
        this.setNick(nick);
        this.setC(c);
    }

    public void ofertar (float oferta,int key){
        this.getC().hiloCliente.escribir(ID.OFERTA);
        this.getC().hiloCliente.escribir(key);
        this.getC().hiloCliente.escribir(getNick());
        this.getC().hiloCliente.escribir(oferta);
        System.out.println("Termina de enviar");
        
    };
}
