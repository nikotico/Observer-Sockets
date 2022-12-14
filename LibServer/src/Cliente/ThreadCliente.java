    

package Cliente;



import Utils.ID;
import Interface.MainInterface;
import Utils.IObservable;
import Utils.IObserver;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ThreadCliente extends Thread{
    
    //Transferencia de datos
    private Socket socketRef;
    public ObjectInputStream readerObj;
    public ObjectOutputStream writerObj;
    private DataInputStream readerNormal;
    public DataOutputStream writerNormal;
    
    //Ref al cliente
    public Cliente jugador;

    //Funcionamiento del thread
    private boolean running = true;
    private JFrame refPantalla;
    
    //CONSTRUCTOR
    public ThreadCliente(Socket socketRef, JFrame refPantalla, Cliente jugador) throws IOException {
        this.socketRef = socketRef;
        this.refPantalla = refPantalla;
        this.jugador = jugador;
        //para escribir y leer datos
        writerObj = new ObjectOutputStream(socketRef.getOutputStream());
        readerObj = new ObjectInputStream(socketRef.getInputStream());
        writerNormal = new DataOutputStream(socketRef.getOutputStream());
        readerNormal = new DataInputStream(socketRef.getInputStream());
    }

    public void escribir(ID id){
        //envía la instrucción indicada
        try {
            writerObj.writeObject(id);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(IObservable iobservable){
        //envía la instrucción indicada
        try {
            writerObj.writeObject(iobservable);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(IObserver iobserver){
        //envía la instrucción indicada
        try {
            writerObj.writeObject(iobserver);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(String str){
        try {
            writerNormal.writeUTF(str);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(int numero){
        try {
            writerNormal.writeInt(numero);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(int [] array){
        try {
            writerObj.writeObject(array);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir(double numero){
        try {
            writerNormal.writeDouble(numero);
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
        ((MainInterface)refPantalla).appendConsola("Ingrese un nombre : Name- Tu nombre.");
    }

    public void run (){
        ID id;
        String mensajeChat = null;
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
                         ((MainInterface)refPantalla).appendConsola("No se pudo realizar la acción.");
                    break;
                    case MESSAGE:
                        mensajeChat = readerNormal.readUTF();
                        ((MainInterface)refPantalla).appendConsola(mensajeChat);
                    break;
                    case BITACORA:
                        mensajeChat = readerNormal.readUTF();
                         ((MainInterface)refPantalla).appendBitacora(mensajeChat);
                    break;
                    case CHAT:
                        mensajeChat = readerNormal.readUTF();
                         ((MainInterface)refPantalla).appendConsola(mensajeChat);
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
