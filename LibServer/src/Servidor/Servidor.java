
package Servidor;


import Utils.AbstractObservable;
import Utils.AbstractObserver;
import Utils.ID;
import Utils.IObserver;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    //Funcionamiento del Servidor
    private ServerSocket srv;
    private boolean running = true;
    public ArrayList<ThreadServidor> conexiones;
    public ArrayList<String> usuarios;
    public HashMap<Integer,AbstractObservable> subastas;
    public ArrayList<AbstractObserver> artistas;
    private Integer CantSubast;
    public void setArtistas(ArrayList<AbstractObserver> artistas) {
        this.artistas = artistas;
    }
    

    public ArrayList<AbstractObserver> getArtistas() {
        return artistas;
    }
    public void updateArtista(AbstractObserver ob, String name){
        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).toString().equals(name)){
                artistas.set(i,ob);
            }
        }
    }
    
    public Servidor() {  //CONSTRUCTOR
        conexiones = new ArrayList<ThreadServidor>();
        usuarios = new ArrayList<String>();
        subastas = new HashMap<Integer,AbstractObservable>();
        artistas = new ArrayList<AbstractObserver>();
        CantSubast = 0;
    }
    
    public void stopserver(){
        running = false;
    }
    
    // Inicio Codigo de la subasta
    public void AddSubasta(AbstractObservable subasta){
        this.subastas.put(++CantSubast, subasta);
    }
    
    public void AddArtista(AbstractObserver artista){
        this.artistas.add( artista);
    }
    
    public AbstractObservable getSubasta(int key){
        return this.subastas.get(key);
    }
    public void setSubasta(int key, AbstractObservable subasta){
        this.subastas.put(key, subasta);
    }
    
    public void SendSpecificMessage(String user,String message,ID id){
        for (int i = 0; i < conexiones.size(); i++) {
            if(usuarios.get(i).equals(user)){
                conexiones.get(i).escribir(id);
                conexiones.get(i).escribir(message);
            }
        }
    }
    
    public void SendkeySubasta(String user,ID id){
        for (int i = 0; i < conexiones.size(); i++) {
            if(usuarios.get(i).equals(user)){
                conexiones.get(i).escribir(id);
                conexiones.get(i).escribir(CantSubast);
                conexiones.get(i).escribir(this.subastas.get(CantSubast));
            }
        }
    }
    
    public void SendSubastaToOfer(ID id){
        for (int i = 0; i < conexiones.size(); i++) {
                conexiones.get(i).escribir(id);
                conexiones.get(i).escribir(CantSubast);
                conexiones.get(i).escribir(this.subastas.get(CantSubast));
        }
    }
    public void publicarTodos(ID id,String  nombre ,AbstractObserver ob){
        for (int i = 0; i < conexiones.size(); i++) {
            conexiones.get(i).escribir(id);
            conexiones.get(i).escribir(nombre);
            conexiones.get(i).escribir(ob);
        }
    }
    public void notif10(ID id, String nombre, String mensaje){
        for (int i = 0; i < conexiones.size(); i++) {
            conexiones.get(i).escribir(id);
            conexiones.get(i).escribir(nombre);
            conexiones.get(i).escribir(mensaje);
        }
    }
    public void SendOferta(String user, ID id, String nick, int key, float oferta){
        for (int i = 0; i < conexiones.size(); i++) {
            if(usuarios.get(i).equals(user)){
                conexiones.get(i).escribir(id);
                conexiones.get(i).escribir(nick);
                conexiones.get(i).escribir(key);
                conexiones.get(i).escribir(oferta);
                System.out.println("Server 3: " +this.subastas.get(CantSubast));
            }
        }
    }
    
    public void AddUser(String name){
        this.usuarios.add(name);
    }
    // FIN Codigo de la subasta
    
    //Metodo reutilizable
    public void SendInfoAll(String mensaje, ID id){
        for (int i = 0; i < conexiones.size(); i++) {
            conexiones.get(i).escribir(id);
            conexiones.get(i).escribir(mensaje);
        }
    }
    public void enviarMensajeATodos(String mensaje){
        for (int i = 0; i < conexiones.size(); i++) {
            conexiones.get(i).escribir(ID.MESSAGE);
            conexiones.get(i).escribir(mensaje);
            
        }
    }
    
    public void mensajeBitacora(String mensaje){
        for (int i = 0; i < conexiones.size(); i++) {
            conexiones.get(i).escribir(ID.BITACORA);
            conexiones.get(i).escribir(mensaje);
        }
    }
    
    public void runServer(){
        int contadorDeConexiones = 0;
        try{
            srv = new ServerSocket(35577);
            
            while (running){
                //Acepta conexiones
                System.out.println("::Esperando conexión ...");
                Socket nuevaConexion = srv.accept();
                contadorDeConexiones++;

                //Crear el threadServidor para conectarse con el cliente
                ThreadServidor newThread = new ThreadServidor(nuevaConexion, this);
                newThread.start();
                
                conexiones.add(newThread);              //se añade a las conexiones
                //inicia la conexion
                newThread.escribir(ID.INICIARCONEXION); //instruccion para iniciar conexion
                //Envia la civilizacion que le toca;
                System.out.println(":Conexión " + contadorDeConexiones + " aceptada");

            }
        }
        catch(Exception e) { System.out.println(e.getMessage()); }
    }
    

    
    
    
}
