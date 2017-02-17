package guerra.aeronaves.comunicacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class ConexionAmbiente extends Conexion {

    private final ServerSocket serverSocket;
    private Socket socket;
    private final List<ConexionAmbienteListener> listeners;
    
    public ConexionAmbiente(String host, int puerto) {
        super(host, puerto);
        serverSocket = Gdx.net.newServerSocket(Net.Protocol.TCP, puerto, null);
        listeners = new ArrayList<ConexionAmbienteListener>();
    }

    @Override
    public void iniciar() {
        /*new Thread() {
            @Override
            public void run() {
                try {
                    socket = serverSocket.accept(null);
                }
                catch (GdxRuntimeException e) {  }
                
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        for (ConexionAmbienteListener cal : listeners) {
                            cal.alEstablecerConexion();
                        }                  
                    }
                });
            }
        }.start();*/
    }

    public List<ConexionAmbienteListener> getListeners() {
        return listeners;
    }
    
}
