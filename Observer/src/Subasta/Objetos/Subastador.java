/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subasta.Objetos;

import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author oscfr
 */
public class Subastador extends Usuario{
    public Subastador(String nick) {
        this.nick = nick;
    }
    
    void colocarProducto (String nombre, String descripcion, ImageIcon imagen, int PrecioIni, int PrecioFinal, Date fechaProg){
        Producto producto = new Producto(nombre,descripcion,imagen, PrecioIni,PrecioFinal,fechaProg);
    }
    void aceptarOferta (float precio,Oferente oferente){}
    void cerrarSubasta (){}
    void cancelarSubasta (){}
    void enviarFelicitacion (String felicitacion,Oferente oferente){}

    
}
