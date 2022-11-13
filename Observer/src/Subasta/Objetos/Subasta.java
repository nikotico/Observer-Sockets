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
        Hashoferentes.put(Hashoferentes.size()+1,oferente);
    };
    void updateOferente (Oferente oferente, float oferta){
        //Hashoferentes.get(oferente).
    };
    

    public Subasta(Producto producto, Date inicio, Date finalProg) {
        this.producto = producto;
        this.inicio = inicio;
        this.finalProg = finalProg;
    }

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

}
