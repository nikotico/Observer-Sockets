
package Servidor;

import Utils.ID;
import Cliente.ThreadCliente;
import Utils.AbstractObservable;
import Utils.AbstractObserver;
import Utils.IObservable;
import Utils.IObserver;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadServidor extends Thread {
    //Traspaso de datos
    private Socket socketRef;
    public ObjectInputStream readerObj;
    public ObjectOutputStream writerObj;
    public DataInputStream readerNormal;
    public DataOutputStream writerNormal;
    //Funcionamiento del hilo
    private boolean running = true;
    private Servidor server;

    //CONSTRUCTOR
    public ThreadServidor(Socket socketRef, Servidor server) throws IOException {
        this.socketRef = socketRef;
        this.server = server;
        //el nombre se envia desde la pantallaI->threadCliente->threadServidor
        writerObj = new ObjectOutputStream(socketRef.getOutputStream());
        readerObj = new ObjectInputStream(socketRef.getInputStream());
        
        writerNormal = new DataOutputStream(socketRef.getOutputStream());
        readerNormal = new DataInputStream(socketRef.getInputStream());
    }
    
    public void escribir(ID id){
        try {
            //envía la instrucción indicada
            writerObj.reset();
            writerObj.writeObject(id);
        } catch (IOException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
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
    public void escribir(String str){
        try {
            writerNormal.flush();
            writerNormal.writeUTF(str);
        } catch (IOException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(int numero){
        try {
            writerNormal.flush();
            writerNormal.writeInt(numero);
        } catch (IOException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    public void escribir(int [] array){
        try {
            writerObj.reset();
            writerObj.writeObject(array);
        } catch (IOException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
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
    public void escribir(float numero){
        try {
            writerNormal.flush();
            writerNormal.writeFloat(numero);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run (){
        ID id;
        String mensajeChat="",enviar="";
        int keyO = 0;
        String nick = null;
        float oferta = 0;
        int key = 0;
        String nombre = "";
        AbstractObservable subasta = null;
        Boolean op = null;
        AbstractObserver ob = null;
        while (running){
            try {
                id = (ID)readerObj.readObject(); // esperar hasta que reciba un entero
                switch (id){
                    case SETNAME:
                        nombre = readerNormal.readUTF();
                        server.AddUser(nombre);
                    break;
                    case CHAT:
                        mensajeChat = readerNormal.readUTF();
                        enviar = "Mensaje >> "+":"+mensajeChat;
                        server.enviarMensajeATodos(enviar);
                    break;
                    case BITACORA:
                        String mensajeBitacora = readerNormal.readUTF();
                        server.mensajeBitacora(mensajeBitacora);
                    break;
                    case SETSUBASTA:
                        subasta = (AbstractObservable)readerObj.readObject();
                        nombre = readerNormal.readUTF();
                        server.AddSubasta(subasta);
                        server.SendkeySubasta(nombre,ID.SETSUBASTA);
                        server.SendSubastaToOfer(ID.SUBASTA);
                    break;
                    case SUBASTA:
                        subasta = (AbstractObservable)readerObj.readObject();
                        enviar = "Servidor dice >> "+": Hay una nueva subasta";
                        server.AddSubasta(subasta);
                        server.SendInfoAll(enviar,ID.SUBASTA);
                    break;
                    case CANCELADA:
                        key = readerNormal.readInt();
                        subasta = server.getSubasta(key);
                        writerObj.writeObject(ID.CANCELADA);
                        writerObj.writeObject(subasta);
                        subasta = (AbstractObservable)readerObj.readObject();
                        server.setSubasta(key, subasta);
                        server.enviarMensajeATodos("La subasta #"+key+" ha sido cancelada");
                    break;
                    case OFERTA:
                        keyO = readerNormal.readInt();
                        nick = readerNormal.readUTF();
                        oferta = readerNormal.readFloat();
                        writerObj.writeObject(ID.OFERTA);
                        writerObj.writeObject(server.getSubasta(keyO));
                    break;
                    case GETNICKS:
                        String nickS = readerNormal.readUTF();
                        server.SendOferta(nickS, ID.RECIOFERTA, nick,keyO,oferta);
                    break;
                    case RESPOFERTA:
                        key = readerNormal.readInt();
                        subasta = server.getSubasta(key);
                        writerObj.writeObject(subasta);
                        op = readerNormal.readBoolean();
                        if (op){
                            subasta = (AbstractObservable)readerObj.readObject();
                            server.setSubasta(key, subasta);
                            float tope = readerNormal.readFloat();
                            server.enviarMensajeATodos("La subasta #"+ key +" tiene nueva nuevo tope de $" + tope);
                        }
                        else{
                            nombre = readerNormal.readUTF();
                            server.SendSpecificMessage(nombre, "No se pueden realizar mas ofertas a esta subasta", ID.NOTIF);
                        }
                    break;
                    case CANOFERTA:
                        nombre = readerNormal.readUTF();
                        server.SendSpecificMessage(nombre, "Su oferta ha sido rechazada", ID.NOTIF);
                    break;
                    case CERRADA:
                        key = readerNormal.readInt();
                        subasta = server.getSubasta(key);
                        writerObj.writeObject(ID.CERRADA);
                        writerObj.writeObject(subasta);
                        subasta = (AbstractObservable)readerObj.readObject();
                        server.setSubasta(key, subasta);
                        op = readerNormal.readBoolean();
                        if (op){
                            nombre = readerNormal.readUTF();
                            server.enviarMensajeATodos("La subasta #" + key + " ha cerrado");
                            server.SendSpecificMessage(nombre, "Felicitaciones ha ganado la subasta#"+ key +"!!!", ID.NOTIF);
                        }
                        else{
                            server.enviarMensajeATodos("La subasta #" + key + " ha cerrado sin ganador");
                        }
                    break;
                    case SETARTISTA:
                        op = readerNormal.readBoolean();
                        if (op){
                            ob = ((AbstractObserver)readerObj.readObject());
                            server.AddArtista(ob);
                        }
                        else{
                            ob = (AbstractObserver)readerObj.readObject();
                            //artistas.remove(ob);
                        }
                    break;
                    case GETARTISTA:
                        escribir(ID.GETARTISTA);
                        writerObj.reset();
                        writerObj.writeObject(server.getArtistas());
                    break;
                    case PUBLICAR:
                        ob = (AbstractObserver)readerObj.readObject();
                        nombre = readerNormal.readUTF();
                        server.updateArtista(ob, nombre);
                        server.publicarTodos(ID.PUBLICAR, nombre, ob);
                    break;
                    case BAJA:
                        ob = (AbstractObserver)readerObj.readObject();
                        nombre = readerNormal.readUTF();
                        server.updateArtista(ob, nombre);
                    break;
                    case LIKES:
                        ob = (AbstractObserver)readerObj.readObject();
                        nombre = readerNormal.readUTF();
                        server.updateArtista(ob, nombre);
                        server.publicarTodos(ID.PUBLICAR, nombre , ob);
                    break;
                    case NOTIF10:
                        mensajeChat = readerNormal.readUTF();
                        nombre = readerNormal.readUTF();
                        server.notif10(ID.NOTIF10, nombre, mensajeChat);
                    break;
                }
            } catch (IOException ex) { 
                System.out.println("ERROR EN EL TREADSERVIDOR"); //lo desconecta para que no salga este mensaje infinitas veces
                running = false;
                System.out.println("SE DESCONECTÓ");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } //END RUN()
}
