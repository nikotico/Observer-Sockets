/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subasta.Objetos;

import Subasta.Cliente.Cliente;

/**
 *
 * @author oscfr
 */
public class Oferente extends Usuario{
    public Oferente(String nick, Cliente c) {
        this.setNick(nick);
        this.setC(c);
    }
    void ingresarSubasta (Subasta subasta){}
    void ofertar (float oferta,Subasta subasta){};
}
