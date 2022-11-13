/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subasta.Objetos;

import Subasta.Cliente.Cliente;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author oscfr
 */
public class Subastador extends Usuario{
    public Subastador(String nick, Cliente c) {
        this.setNick(nick);
        this.setC(c);
    }
    ArrayList<Subasta> MisSubastas = new ArrayList<Subasta>();

    public ArrayList<Subasta> getMisSubastas() {
        return MisSubastas;
    }

    public void setMisSubastas(ArrayList<Subasta> MisSubastas) {
        this.MisSubastas = MisSubastas;
    }
    
    public void addMisSubastas(Subasta subasta){
        this.MisSubastas.add(subasta);
    }
    
    void colocarProducto (String nombre, String descripcion, ImageIcon imagen, int PrecioIni, int PrecioFinal, Date fechaProg){
        Producto producto = new Producto(nombre,descripcion,imagen, PrecioIni,PrecioFinal,fechaProg);
    }
    void aceptarOferta (float precio,Oferente oferente){}
    void cerrarSubasta (){}
    void cancelarSubasta (){}
    void enviarFelicitacion (String felicitacion,Oferente oferente){}

    
}
