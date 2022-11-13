
package Servidor;


import Utils.ID;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class Servidor {
    //Funcionamiento del Servidor
    private ServerSocket srv;
    private boolean running = true;
    public ArrayList<ThreadServidor> conexiones;

    public Servidor() {  //CONSTRUCTOR
        conexiones = new ArrayList<ThreadServidor>();
    }
    
    public void stopserver(){
        running = false;
    }
    
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
    
    public ThreadServidor getConexion(String nombreCivilizacion){
        for (int i = 0; i < conexiones.size(); i++) {
            if(conexiones.get(i).nombre.equals(nombreCivilizacion)){
                return conexiones.get(i);
            }
        }
        System.out.println("RETORNÓ NULL EN GETCONEXION, XQ NO EXISTE EL NOMBRE BUSCADO: " + nombreCivilizacion);
        return null;
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
