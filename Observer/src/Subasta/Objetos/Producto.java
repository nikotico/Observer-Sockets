/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subasta.Objetos;

import java.io.Serializable;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author oscfr
 */
public class Producto implements Serializable{
    String nombre;
    String descripcion;
    ImageIcon imagen;
    int PrecioIni;
    int PreciFinal;
    Date fecha;

    public int getPrecioIni() {
        return PrecioIni;
    }

    public void setPrecioIni(int PrecioIni) {
        this.PrecioIni = PrecioIni;
    }

    public int getPreciFinal() {
        return PreciFinal;
    }

    public void setPreciFinal(int PreciFinal) {
        this.PreciFinal = PreciFinal;
    }

    public Producto(String nombre, String descripcion, ImageIcon imagen, int PrecioIni, int PreciFinal,Date fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.PrecioIni = PrecioIni;
        this.PreciFinal = PreciFinal;
        this.fecha = fecha;
    }
    
    public Producto(String nombre, String descripcion, int PrecioIni, int PreciFinal,Date fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.PrecioIni = PrecioIni;
        this.PreciFinal = PreciFinal;
        this.fecha = fecha;
    }
}
