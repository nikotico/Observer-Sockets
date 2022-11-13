/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subasta.Objetos;

import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author oscfr
 */
public class Subasta {
    String nombre;
    String descripcion;
    ImageIcon imagen;
    Producto producto;
    Date inicio;
    Date finalProg;
    
    Status status;
    public enum Status {
    CERRADA,
    VENDIDA,
    CANCELADA
}
    Oferente oferenteGanador;
    HashMap<Integer,Oferente> Hashoferentes = new HashMap<>();
    
    
    
    void addOferente (Oferente oferente){
        Hashoferentes.put(0,oferente);
    };
    void updateOferente (Oferente oferente, float oferta){};

    public Subasta(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
