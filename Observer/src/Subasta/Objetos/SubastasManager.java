/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subasta.Objetos;

import Utils.IObservable;
import Utils.IObserver;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author oscfr
 */
public class SubastasManager implements IObservable{
    ArrayList<Subasta> ListaSubastas = new ArrayList<Subasta>();
    
    void agregarSubastador(String nombre, String descripcion, ImageIcon imagen, Subastador subastador, Producto producto, Date finalProg){}
    void aceptarOferta(float precio, Oferente oferente, Subasta subasta){}
    void cerrarOferta(Subasta subasta){}
    void cancelarOferta(Subasta subasta){}
    void enviarNotificacion(String notificacion, Oferente oferente){}
    void ofertarProducto(Oferente oferente, float oferta, Subasta subasta){}

    @Override
    public void addObserver(IObserver io) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeObserver(IObserver io) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void notifyAllObservers(String string, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
