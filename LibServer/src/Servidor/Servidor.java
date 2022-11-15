
package Servidor;


import Utils.AbstractObservable;
import Utils.ID;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Servidor {
    //Funcionamiento del Servidor
    private ServerSocket srv;
    private boolean running = true;
    public ArrayList<ThreadServidor> conexiones;
    public ArrayList<String> usuarios;
    public HashMap<Integer,AbstractObservable> subastas;
    private Integer CantSubast;

    public Servidor() {  //CONSTRUCTOR
        conexiones = new ArrayList<ThreadServidor>();
        usuarios = new ArrayList<String>();
        subastas = new HashMap<Integer,AbstractObservable>();
        CantSubast = 0;
    }
    
    public void stopserver(){
        running = false;
    }
    
    // Inicio Codigo de la subasta
    public void AddSubasta(AbstractObservable subasta){
        this.subastas.put(++CantSubast, subasta);
    }
    
    public AbstractObservable getSubasta(int key){
        return this.subastas.get(key);
    }
    public void setSubasta(int key, AbstractObservable subasta){
        this.subastas.put(key, subasta);
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
                System.out.println("Server 2: " +this.subastas.get(CantSubast) );
        }
    }
    public void SendOferta(String user, ID id, String nick, int key, float oferta){
        for (int i = 0; i < conexiones.size(); i++) {
            if(usuarios.get(i).equals(user)){
                conexiones.get(i).escribir(id);
                conexiones.get(i).escribir(nick);
                conexiones.get(i).escribir(key);
                conexiones.get(i).escribir(oferta);
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
