/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RedSocialVIP.Objetos;

import java.util.ArrayList;

/**
 *
 * @author oscfr
 */
public class Artista {
    ArrayList<Fan> ListaPublicaciones = new ArrayList<Fan>();
    ArrayList<Fan> ListaSeguidores = new ArrayList<Fan>();
    
    void postearMensaje(){}
    void anadirSeguidor (Fan seguidor){
        ListaSeguidores.add(seguidor);
    }
    void notificarSeguidores(String notificacion){}
}
