/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subasta.Objetos;

import Subasta.Cliente.Cliente;
import Utils.ID;
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
    
    //Crea la subasta y la manda al servidor
    public void createSubasta (String nombre, String descripcion, ImageIcon imagen, int PrecioIni, int PrecioFinal, Date fechaProg){
//      Producto producto = new Producto(nombre,descripcion,imagen, PrecioIni,PrecioFinal,fechaProg);
        Producto producto = new Producto(nombre,descripcion, PrecioIni,PrecioFinal,fechaProg);
        Subasta subasta = new Subasta(producto,new Date(),new Date());
        this.getC().hiloCliente.escribir(ID.SETSUBASTA);
        this.getC().hiloCliente.escribir(subasta);
        System.out.println("Se fue" + subasta);
        this.getC().hiloCliente.escribir(getNick());
    }
    
    void aceptarOferta (float precio,Oferente oferente){}
    void cerrarSubasta (){}
    void cancelarSubasta (){}
    void enviarFelicitacion (String felicitacion,Oferente oferente){}

    
}
