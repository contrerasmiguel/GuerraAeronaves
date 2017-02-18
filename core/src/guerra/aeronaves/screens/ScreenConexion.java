package guerra.aeronaves.screens;

import guerra.aeronaves.GuerraAeronaves;
import guerra.aeronaves.comunicacion.Conexion;
import guerra.aeronaves.comunicacion.ConexionListener;

public class ScreenConexion extends ScreenMenu implements ConexionListener {

    private final GuerraAeronaves guerraAeronaves;
    private final Conexion conexion;

    public ScreenConexion(GuerraAeronaves guerraAeronaves, Conexion conexion) {
        this.guerraAeronaves = guerraAeronaves;
        this.conexion = conexion;
        
        conexion.getListeners().clear();
        
        // Para el callback alEstablecerConexiones
        conexion.getListeners().add(this);
        
        System.out.println("Ambiente conectándose a " + conexion.getDatosConexion().getHostCliente()
                + ":" + conexion.getDatosConexion().getPuertoCliente() + "...");        
        conexion.iniciar();
    }
    
    // Este método no es llamado en el hilo principal.
    @Override
    public void alEstablecerConexion() {
        System.out.println("Ambiente conectado a " + conexion.getDatosConexion().getHostCliente()
                + ":" + conexion.getDatosConexion().getPuertoCliente() + ".");  
        guerraAeronaves.setScreenJuego();
    }

}
