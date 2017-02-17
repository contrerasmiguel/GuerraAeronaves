package guerra.aeronaves.screens;

import guerra.aeronaves.GuerraAeronaves;
import guerra.aeronaves.comunicacion.ConexionAmbiente;
import guerra.aeronaves.comunicacion.ConexionAmbienteListener;

public class ScreenConexion extends ScreenMenu implements ConexionAmbienteListener {

    private final GuerraAeronaves guerraAeronaves;
    private final ConexionAmbiente conexionAmbiente;

    public ScreenConexion(GuerraAeronaves guerraAeronaves, ConexionAmbiente ca) {
        this.guerraAeronaves = guerraAeronaves;
        this.conexionAmbiente = ca;
        
        conexionAmbiente.getListeners().clear();
        
        // Para el callback alEstablecerConexiones
        conexionAmbiente.getListeners().add(this);
        
        System.out.println("Ambiente conectándose a " + conexionAmbiente.getHost() 
                + ":" + conexionAmbiente.getPuerto() + "...");        
        conexionAmbiente.iniciar();
    }
    
    // Este método no es llamado en el hilo principal.
    @Override
    public void alEstablecerConexion() {
        guerraAeronaves.setScreenJuego();
        System.out.println("Ambiente conectado a " + conexionAmbiente
                .getHost() + ":" + conexionAmbiente.getPuerto() + ".");
    }

}
