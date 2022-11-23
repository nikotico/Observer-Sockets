

package Subasta.Cliente;




import Utils.*;
import Subasta.JFrames.*;
import Subasta.Objetos.*;
import Utils.AbstractObservable;
import static Utils.ID.GETNICKS;
import Utils.IObservable;
import Utils.IObserver;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
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
            writerObj.writeObject(id);
            writerObj.flush();
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(AbstractObservable iobservable){
        //envía la instrucción indicada
        try {
            writerObj.writeObject(iobservable);
            writerObj.flush();
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(IObservable iobservable){
        //envía la instrucción indicada
        try {
            writerObj.writeObject(iobservable);
            writerObj.flush();
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(IObserver iobserver){
        //envía la instrucción indicada
        try {
            writerObj.writeObject(iobserver);
            writerObj.flush();
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(Object object){
        //envía la instrucción indicada
        try {
            writerObj.writeObject(object);
            writerObj.flush();
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(String str){
        try {
            writerNormal.writeUTF(str);
            writerNormal.flush();
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(int numero){
        try {
            writerNormal.writeInt(numero);
            writerNormal.flush();
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(int [] array){
        try {
            writerObj.writeObject(array);
            writerObj.flush();
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(double numero){
        try {
            writerNormal.writeDouble(numero);
            writerNormal.flush();
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(float numero){
        try {
            writerNormal.writeFloat(numero);
            writerNormal.flush();
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void denegarConexion(){
        //Muestra el mensaje
        JOptionPane.showMessageDialog(null, "Ya comenzó la partida o está llena.");
        refPantalla.setVisible(false);
        //Desconecta al jugador
        running = false;
        System.out.println("SE DESCONECTÓ");
    }
    
    private void iniciarConexion() throws IOException, ClassNotFoundException{
        ( (JFrameIniciarSesion)refPantalla).appendConsola("Ingrese un nombre : Name- Tu nombre.");
    }

    public void run (){
        ID id;
        String mensajeChat = null;
        Subasta subasta = null;
        int key = 0;
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
                        ( (JFrameIniciarSesion)refPantalla).appendConsola("No se pudo realizar la acción.");
                    break;
                    case MESSAGE:
                        mensajeChat = readerNormal.readUTF();
                        if (c.getRefPantalla() instanceof JFrameSubastador){
                            ((JFrameSubastador)c.getRefPantalla()).appendASub(mensajeChat);
                        }
                        else if (c.getRefPantalla() instanceof JFrameOferente){
                            ((JFrameOferente)c.getRefPantalla()).notifASub(mensajeChat);
                        }
                        else{
                            ((JFrameIniciarSesion)refPantalla).appendConsola(mensajeChat);
                        }
                    break;
                    case NOTIF:
                        mensajeChat = readerNormal.readUTF();
                        if (c.getRefPantalla() instanceof JFrameSubastador){
                            ((JFrameSubastador)c.getRefPantalla()).appendASub(mensajeChat);
                        }
                        else if (c.getRefPantalla() instanceof JFrameOferente){
                            ((JFrameOferente)c.getRefPantalla()).notifSub(mensajeChat);
                        }
                        else{
                            ((JFrameIniciarSesion)refPantalla).appendConsola(mensajeChat);
                        }
                    break;
                    case BITACORA:
                        mensajeChat = readerNormal.readUTF();
                        ((JFrameIniciarSesion)refPantalla).appendConsola(mensajeChat);
                    break;
                    case CHAT:
                        mensajeChat = readerNormal.readUTF();
                        ( (JFrameIniciarSesion)refPantalla).appendConsola(mensajeChat);
                    break;
                    case SETSUBASTA:
                        key = readerNormal.readInt();
                        subasta = (Subasta)readerObj.readObject();
                        if (c.getRefPantalla() instanceof JFrameSubastador){
                            ((JFrameSubastador)c.getRefPantalla()).getSubastador().addSubasta(key, subasta);
                            ((JFrameSubastador)c.getRefPantalla()).addItem(key);
                            ((JFrameSubastador)c.getRefPantalla()).appendASub("Subasta #"+key);
                        }

                    break;
                    case SUBASTA:
                        key = readerNormal.readInt();
                        subasta = (Subasta)readerObj.readObject();
                        if (c.getRefPantalla() instanceof JFrameOferente){
                            ((JFrameOferente)c.getRefPantalla()).getOferente().addSubasta(key, subasta);
                            ((JFrameOferente)c.getRefPantalla()).addItem(key);
                            ((JFrameOferente)c.getRefPantalla()).appendASub("Subasta #"+key+" Con un precio inicial de ",key);
                        }
                    break;
                    case CANCELADA:
                        try {
                            subasta = (Subasta)c.hiloCliente.readerObj.readObject();
                            subasta.setStatus(Subasta.Status.CANCELADA);
                            subasta.setFinalProg(new Date());
                            c.hiloCliente.escribir(subasta);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Subastador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    break;
                    case OFERTA:
                        try {
                            subasta = (Subasta)c.hiloCliente.readerObj.readObject();
                            String nickS = subasta.getSubastador();
                            c.hiloCliente.escribir(GETNICKS);
                            c.hiloCliente.escribir(nickS);
                        } catch (IOException ex) {
                            Logger.getLogger(Oferente.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Oferente.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    break;
                    case RECIOFERTA:
                        String nick = readerNormal.readUTF();
                        key = readerNormal.readInt();
                        float oferta = readerNormal.readFloat();
                        c.hiloCliente.escribir(ID.RESPOFERTA);
                        c.hiloCliente.escribir(key);
                        System.out.println(key);
                        subasta = (Subasta)readerObj.readObject();
                        if ((c.getRefPantalla() instanceof JFrameSubastador) && (subasta.getStatus() == null)){
                            c.hiloCliente.writerNormal.writeBoolean(true);
                            ((JFrameSubastador)c.getRefPantalla()).getSubastador().aceptarOferta(oferta,nick,key, subasta);
                        }
                        else{
                            c.hiloCliente.writerNormal.writeBoolean(false);
                            c.hiloCliente.escribir(nick);
                        }
                    break;
                    case CERRADA:
                        try {
                            subasta = (Subasta)c.hiloCliente.readerObj.readObject();
                            subasta.setStatus(Subasta.Status.CERRADA);
                            subasta.setFinalProg(new Date());
                            c.hiloCliente.escribir(subasta);
                            if (subasta.getOferenteActual() != null){ 
                                c.hiloCliente.writerNormal.writeBoolean(true);
                                c.hiloCliente.escribir(subasta.getOferenteActual());
                            }else{
                                c.hiloCliente.writerNormal.writeBoolean(false);
                            }
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Subastador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    break;
                    case RESPOFERTA:
                        
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
