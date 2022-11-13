/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subasta.Objetos;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author oscfr
 */
public class SubastasManager {
    ArrayList<Subasta> ListaSubastas = new ArrayList<Subasta>();
    
    void agregarSubastador(String nombre, String descripcion, ImageIcon imagen, Subastador subastador, Producto producto, Date finalProg){}
    void aceptarOferta(float precio, Oferente oferente, Subasta subasta){}
    void cerrarOferta(Subasta subasta){}
    void cancelarOferta(Subasta subasta){}
    void enviarNotificacion(String notificacion, Oferente oferente){}
    void ingresarOferente(Oferente oferente, Subasta subasta){}
    void ofertarProducto(Oferente oferente, float oferta, Subasta subasta){}
    
}
