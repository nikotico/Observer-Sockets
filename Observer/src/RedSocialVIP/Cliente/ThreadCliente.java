

package RedSocialVIP.Cliente;




import Subasta.Cliente.*;
import Utils.ID;
import Interface.MainInterface;
import RedSocialVIP.JFrames.JFrameArtista;
import RedSocialVIP.JFrames.JFrameFan;
import RedSocialVIP.JFrames.JFrameIniciarSesion;
import RedSocialVIP.Objetos.Artista;
import RedSocialVIP.Objetos.Publicacion;
import Utils.AbstractObservable;
import Utils.IObservable;
import Utils.IObserver;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ThreadCliente extends Thread{
    
    //Transferencia de datos
    private Socket socketRef;
    public ObjectInputStream readerObj;
    public ObjectOutputStream writerObj;
    public DataInputStream readerNormal;
    public DataOutputStream writerNormal;
    
    //Ref al cliente
    public Cliente c;

    //Funcionamiento del thread
    private boolean running = true;
    private JFrame refPantalla;

    public JFrame getRefPantalla() {
        return refPantalla;
    }

    public void setRefPantalla(JFrame refPantalla) {
        this.refPantalla = refPantalla;
    }
    
    //CONSTRUCTOR
    public ThreadCliente(Socket socketRef, JFrame refPantalla, Cliente c) throws IOException {
        this.socketRef = socketRef;
        this.refPantalla = refPantalla;
        this.c = c;
        //para escribir y leer datos
        writerObj = new ObjectOutputStream(socketRef.getOutputStream());
        readerObj = new ObjectInputStream(socketRef.getInputStream());
        writerNormal = new DataOutputStream(socketRef.getOutputStream());
        readerNormal = new DataInputStream(socketRef.getInputStream());
    }
    
    public void setPantalla( JFrame pantalla){
        this.refPantalla = pantalla;
    }

    public void escribir(ID id){
        //envía la instrucción indicada
        try {
            writerObj.reset();
            writerObj.writeObject(id);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(AbstractObservable iobservable){
        //envía la instrucción indicada
        try {
            writerObj.reset();
            writerObj.writeObject(iobservable);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(IObservable iobservable){
        //envía la instrucción indicada
        try {
            writerObj.reset();
            writerObj.writeObject(iobservable);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(IObserver iobserver){
        //envía la instrucción indicada
        try {
            writerObj.reset();
            writerObj.writeObject(iobserver);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(Object object){
        //envía la instrucción indicada
        try {
            writerObj.reset();
            writerObj.writeObject(object);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(String str){
        try {
            writerNormal.flush();
            writerNormal.writeUTF(str);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(int numero){
        try {
            writerNormal.flush();
            writerNormal.writeInt(numero);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(int [] array){
        try {
            writerObj.reset();
            writerObj.writeObject(array);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(double numero){
        try {
            writerNormal.flush();
            writerNormal.writeDouble(numero);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(boolean bin){
        try {
            writerNormal.flush();
            writerNormal.writeBoolean(bin);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void denegarConexion(){
        //Muestra el mensaje
        JOptionPane.showMessageDialog(null, "Error al entrar");
        refPantalla.setVisible(false);
        //Desconecta al jugador
        running = false;
        System.out.println("SE DESCONECTÓ");
    }
    private int getObject(String name, ArrayList<Artista> artistas){
        for (int i=0;i<artistas.size();i++) {
            if (artistas.get(i).getNick() == name){
                return i;
            }
        }
        return 0;
    }
    
    private void iniciarConexion() throws IOException, ClassNotFoundException{
    }

    public void run (){
        ID id;
        String mensajeChat = "";
        String nombre = "";
        Artista artista;
        ArrayList<Artista> artistas;
        ArrayList<Publicacion> ListaPublicaciones;
        int n;
        while (running){
            try {
                id = (ID) readerObj.readObject(); // esperar hasta que reciba un entero
                switch (id){
                    case CONEXIONDENEGADA:
                        denegarConexion();
                    break;
                    case INICIARCONEXION:
                        iniciarConexion();
                    break;
                    case DENEGARACCION:
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la accion!!!");
                    break;
                    case MESSAGE:
                        mensajeChat = readerNormal.readUTF();
                        JOptionPane.showMessageDialog(null, mensajeChat);
                    break;
                    case BITACORA:
                        mensajeChat = readerNormal.readUTF();
                        JOptionPane.showMessageDialog(null, mensajeChat);
                    break;
                    case CHAT:
                        mensajeChat = readerNormal.readUTF();
                        JOptionPane.showMessageDialog(null, mensajeChat);
                    break;
                    case GETARTISTA:
                        artistas = (ArrayList<Artista>) c.hiloCliente.readerObj.readObject();
                        if (!artistas.isEmpty()){
                            ((JFrameFan)c.getRefPantalla()).addArtistas(artistas);
                        }
                    break;
                    case PUBLICAR:
                        nombre = readerNormal.readUTF();
                        artista = (Artista)readerObj.readObject();
                        if (c.getRefPantalla() instanceof JFrameFan){
                            c.hiloCliente.escribir(ID.GETARTISTA);
                        }
                        else if(c.getRefPantalla() instanceof JFrameArtista && ((JFrameArtista)c.getRefPantalla()).getArtista().getNick().equals(nombre)){
                            ((JFrameArtista)c.getRefPantalla()).updateArtista(nombre, artista);
                        }
                    break;
                    case NOTIF10:
                        nombre = readerNormal.readUTF();
                        mensajeChat = readerNormal.readUTF();
                        if (c.getRefPantalla() instanceof JFrameFan){
                            ((JFrameFan)c.getRefPantalla()).addNotif(nombre,mensajeChat);
                        }
                        if (c.getRefPantalla() instanceof JFrameArtista){
                            
                        }
                    break;
                }
            } catch (IOException ex) { 
                System.out.println("ERROR THREAD CLIENTE");  //lo desconecta para que no salga este mensaje infinitas veces
                running = false;
                System.out.println("SE DESCONECTÓ");
                
            } catch (ClassNotFoundException ex) { Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex); }
        }//end: while(running)
    }//end: run()

}
