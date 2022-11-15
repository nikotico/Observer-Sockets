

package RedSocialVIP.Cliente;
import java.net.Socket;
import javax.swing.JFrame;



public class Cliente {
    
    private Socket socketRef;
    public ThreadCliente hiloCliente;
    
    //Referencias a las pantallas
    private JFrame refPantalla;
    
    public void setPantalla(JFrame refPantalla){
        this.refPantalla = refPantalla;
    }

    public JFrame getRefPantalla() {
        return refPantalla;
    }
    
    public void conectar(){
        try{
            //Intenta/hace la conexión con el servidor
            socketRef = new Socket("localhost", 35577);
            
            //Crea el hiloCliente para comunicarse con el servidor
            hiloCliente = new ThreadCliente(socketRef, refPantalla, this);
            hiloCliente.start();
            
        } catch(Exception e) {  System.out.println(e.getMessage());  } 
    }
    
}
