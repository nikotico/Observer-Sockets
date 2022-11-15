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
    Status status;
    String subastador;

    public void setStatus(Status status) {
        this.status = status;
    }
    HashMap<Integer,Oferente> Hashoferentes = new HashMap<>();
    public enum Status {
        VENDIDA,
        CERRADA,
        CANCELADA
    }
    public Subasta(Producto producto, Date inicio, Date finalProg, String subastador) {
        this.producto = producto;
        this.inicio = inicio;
        this.finalProg = finalProg;
        this.precioActual = producto.getPrecioIni();
        this.subastador = subastador;
        this.status = null;
    }

    public String getSubastador() {
        return subastador;
    }

    public void setSubastador(String subastador) {
        this.subastador = subastador;
    }

        
    void addOferente (Oferente oferente){
        Hashoferentes.put(Hashoferentes.size()+1,oferente);
        this.addObserver(oferente);
    };
    void updateOferente (Oferente oferente, float oferta){
        //Hashoferentes.get(oferente).set
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
