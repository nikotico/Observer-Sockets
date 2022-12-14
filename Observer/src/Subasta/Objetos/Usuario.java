/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subasta.Objetos;

import Subasta.Cliente.Cliente;
import Utils.AbstractObservable;
import Utils.IObserver;
import java.util.HashMap;

/**
 *
 * @author oscfr
 */
public class Usuario implements IObserver{
    private String nick;
    private Cliente c;
    public HashMap<Integer,Subasta> subastas = new HashMap<>();
    
    public Cliente getC() {
        return c;
    }

    public void addSubasta(int key, Subasta subasta){
        this.subastas.put(key, subasta);
    }
    
    public Subasta getSubasta(int key){
        return (Subasta) this.subastas.get(key);
    }
    
    public void setC(Cliente c) {
        this.c = c;
    }
   
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public void notifyObserver(String string, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
