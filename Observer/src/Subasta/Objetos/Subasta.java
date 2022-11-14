/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subasta.Objetos;

import Utils.AbstractObservable;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author oscfr
 */
public class Subasta extends AbstractObservable implements Serializable{
    Producto producto;
    int precioActual;
    Date inicio;
    Date finalProg;
    Oferente oferenteGanador;
    HashMap<Integer,Oferente> Hashoferentes = new HashMap<>();
    
    public Subasta(Producto producto, Date inicio, Date finalProg) {
        this.producto = producto;
        this.inicio = inicio;
        this.finalProg = finalProg;
        this.precioActual = producto.getPrecioIni();
    }
        
    void addOferente (Oferente oferente){
        Hashoferentes.put(Hashoferentes.size()+1,oferente);
        this.addObserver(oferente);
    };
    void updateOferente (Oferente oferente, float oferta){
        //Hashoferentes.get(oferente).
    };
    
    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFinalProg() {
        return finalProg;
    }

    public void setFinalProg(Date finalProg) {
        this.finalProg = finalProg;
    }

    public int getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(int precioActual) {
        this.precioActual = precioActual;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    

}
