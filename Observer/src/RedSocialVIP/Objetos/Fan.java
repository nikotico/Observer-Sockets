/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RedSocialVIP.Objetos;

import RedSocialVIP.Cliente.Cliente;
import Utils.ID;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author oscfr
 */
public class Fan extends Usuario implements Serializable{
    private final String nick;
    ArrayList<String> ListaArtistas = new ArrayList<String>();

    public ArrayList<String> getListaArtistas() {
        return ListaArtistas;
    }

    public void setListaArtistas(ArrayList<String> ListaArtistas) {
        this.ListaArtistas = ListaArtistas;
    }
    public void addListaArtistas(String artista) {
        this.ListaArtistas.add(artista);
    }
    public Fan(String nick, Cliente c) {
        this.nick = nick;
        this.setC(c);
    }
    public void notif10(String mensaje, String artista){
        this.getC().hiloCliente.escribir(ID.NOTIF10);
        this.getC().hiloCliente.escribir(mensaje);
        this.getC().hiloCliente.escribir(artista);
    }
    public void sendLikesandDislikes(String name, Artista artista){
        this.getC().hiloCliente.escribir(ID.LIKES);
        this.getC().hiloCliente.escribir(artista);
        this.getC().hiloCliente.escribir(name);
    }
    @Override
    public void notifyObserver(String string, Object o) {
        this.getC().getRefPantalla();
    }
}
