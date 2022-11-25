/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RedSocialVIP.Objetos;


import RedSocialVIP.Cliente.Cliente;
import Utils.AbstractObserver;


/**
 *
 * @author oscfr
 */
public class Usuario extends AbstractObserver{
    private Cliente c;
    public String nick;
    
    public Cliente getC() {
        return c;
    }
    
    public void setC(Cliente c) {
        this.c = c;
    }

    @Override
    public void notifyObserver(String string, Object o) {
        
    }   
}
