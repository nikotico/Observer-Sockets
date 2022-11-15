/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subasta.Objetos;

import Subasta.Cliente.Cliente;
import Subasta.Objetos.Subasta.Status;
import Utils.ID;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
        Producto producto = new Producto(nombre,descripcion, PrecioIni,PrecioFinal,fechaProg);
        Subasta subasta = new Subasta(producto,new Date(),new Date(),this.getNick());
        this.getC().hiloCliente.escribir(ID.SETSUBASTA);
        this.getC().hiloCliente.escribir(subasta);
        System.out.println("Se fue" + subasta);
        System.out.println(getNick());
        this.getC().hiloCliente.escribir(getNick());
    }
    
    public void aceptarOferta (float precio,String oferente, int key){
        int resp = JOptionPane.showConfirmDialog(null, "El oferente "+ oferente +" ha hecho una oferta de $"+ precio +" en la subasta #"+key+"\n"+"¿Quiere aceptar la oferta?","Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (resp == 0){
            this.getC().hiloCliente.escribir(ID.RESPOFERTA);
            this.getC().hiloCliente.escribir(key);
            try {
                Subasta subasta = (Subasta)this.getC().hiloCliente.readerObj.readObject(); 
                this.getC().hiloCliente.escribir(subasta);
            } catch (IOException ex) {
                Logger.getLogger(Subastador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Subastador.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        else{
            this.getC().hiloCliente.escribir(ID.CANOFERTA);
            this.getC().hiloCliente.escribir(oferente);
        }
    }
    public void cerrarSubasta (){
    
    }
    
    
    public void cancelarSubasta (int key) throws IOException{
        this.getC().hiloCliente.escribir(ID.CANCELADA);
        this.getC().hiloCliente.escribir(key);
                  
    }
    public void enviarFelicitacion (String felicitacion,Oferente oferente){}

    
}
