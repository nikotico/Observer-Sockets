/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RedSocialVIP.Objetos;

import RedSocialVIP.Cliente.Cliente;
import java.util.ArrayList;


/**
 *
 * @author oscfr
 */
public class Fan extends Usuario{
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
    @Override
    public void notifyObserver(String string, Object o) {
        this.getC().getRefPantalla();
    }
}
