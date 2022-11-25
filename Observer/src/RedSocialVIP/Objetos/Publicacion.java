/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RedSocialVIP.Objetos;

import java.io.Serializable;

/**
 *
 * @author oscfr
 */
public class Publicacion implements Serializable{
    int key;
    String contenido;
    int likes;
    int dislikes;

    public Publicacion(String contenido) {
        this.contenido = contenido;
        this.likes = 0;
        this.dislikes = 0;
    }

    public int getLikes() {
        return likes;
    }
    
    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void addLikes() {
        this.likes = this.likes++;
    }
    
    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
    public void addDisikes() {
        this.dislikes = this.dislikes++;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
