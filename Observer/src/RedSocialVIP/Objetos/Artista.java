/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RedSocialVIP.Objetos;

import RedSocialVIP.Cliente.Cliente;
import Utils.ID;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author oscfr
 */
public class Artista extends Usuario implements Serializable{
    ArrayList<Publicacion> ListaPublicaciones;
    ArrayList<Fan> ListaSeguidores;
    int seguidores;
    private final String nick;
    public Boolean activo;
    
    public Artista(String nick, Cliente c) {
        this.nick = nick;
        this.setC(c);
        this.activo = true;
        this.seguidores = 0;
        ListaSeguidores = new ArrayList<Fan>();
        ListaPublicaciones = new ArrayList<Publicacion>();
    }
    
    public Artista(String nick, Cliente c, ArrayList<Publicacion> publi) {
        this.nick = nick;
        this.setC(c);
        this.activo = true;
        this.seguidores = 12;
        ListaSeguidores = new ArrayList<Fan>();
        ListaPublicaciones = publi;
    }

    public String getNick() {
        return nick;
    }
    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }
    
    public void sendLikesandDislikes(String name, Artista artista){
        this.getC().hiloCliente.escribir(ID.LIKES);
        this.getC().hiloCliente.escribir(artista);
        this.getC().hiloCliente.escribir(name);
    }
    
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public ArrayList<Publicacion> getListaPublicaciones() {
        return ListaPublicaciones;
    }

    public void setListaPublicaciones(ArrayList<Publicacion> ListaPublicaciones) {
        this.ListaPublicaciones = ListaPublicaciones;
    }
    public void notif10(String mensaje, String artista){
        this.getC().hiloCliente.escribir(ID.NOTIF10);
        this.getC().hiloCliente.escribir(mensaje);
        this.getC().hiloCliente.escribir(artista);
    }
    public ArrayList<Fan> getListaSeguidores() {
        return ListaSeguidores;
    }

    public void setListaSeguidores(ArrayList<Fan> ListaSeguidores) {
        this.ListaSeguidores = ListaSeguidores;
    }
    public void postearMensaje(String mensaje){
        if(activo){
            Publicacion publi = new Publicacion(mensaje);
            anadirPublicacion(publi);
            this.getC().hiloCliente.escribir(ID.PUBLICAR);
            this.getC().hiloCliente.escribir(this);
            this.getC().hiloCliente.escribir(this.getNick());
        }
        else{
            JOptionPane.showMessageDialog(null, "Si se dio de baja ya no puede publicar!!");
        }
    }
    public void anadirSeguidor (Fan seguidor){
        ListaSeguidores.add(seguidor);
        seguidores++;
    }
    public void anadirSeguidor (){
        ListaSeguidores.add(new Fan("Bot",new Cliente()));
        seguidores++;
        this.getC().hiloCliente.escribir(ID.PUBLICAR);
        this.getC().hiloCliente.escribir(this);
        this.getC().hiloCliente.escribir(this.getNick());
    }
    
    public void anadirPublicacion (Publicacion publi){
        ListaPublicaciones.add(publi);
    }
    public void darseDeBaja(){
        this.activo = false;
        this.getC().hiloCliente.escribir(ID.BAJA);
        this.getC().hiloCliente.escribir(this);
        this.getC().hiloCliente.escribir(this.getNick());
    }
    void notificarSeguidores(String notificacion){}
    
    @Override
    public String toString(){
        return this.getNick();
    }
}
