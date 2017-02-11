package guerra.aeronaves;

import guerra.aeronaves.juego.TeclasPresionadas;
import java.net.*;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    final int PUERTO;
    ServerSocket sc;
    Socket so;
    DataOutputStream salida;
    String mensajeRecibido;
    
    public Servidor(int p) {
        PUERTO = p;
    }

    //SERVIDOR
    public void iniciarConexion(){
        try {
            sc = new ServerSocket(PUERTO);/* crea socket servidor que escuchara en puerto 5000*/
            so = new Socket();
            so = sc.accept();
        }
        catch(Exception e ) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void cerrarConexion() {
       if (sc != null) {
           try {
               sc.close();
           } catch (IOException ex) {
               Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
           }
       } 
    }
    
    public TeclasPresionadas recibirMensajeTeclas() {
        if (so != null) {
            try {
                ObjectInputStream mensaje = new ObjectInputStream(so.getInputStream());
                return (TeclasPresionadas)mensaje.readObject();
            } 
            catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (ClassNotFoundException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public boolean isConexionActiva() {
        return !sc.isClosed();
    }
    
}