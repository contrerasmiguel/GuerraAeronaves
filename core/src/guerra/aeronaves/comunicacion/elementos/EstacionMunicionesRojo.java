package guerra.aeronaves.comunicacion.elementos;

import guerra.aeronaves.GuerraAeronaves;
import guerra.aeronaves.juego.elementos.Elemento;
import java.awt.Point;

public class EstacionMunicionesRojo extends EstacionMuniciones {   

    public EstacionMunicionesRojo() {
    
    }
    
    public EstacionMunicionesRojo(Point posInicial) {
        super(GuerraAeronaves.ID_ESTACION_MUNICIONES_ROJO, posInicial);
    }

    @Override
    public Elemento crearElemento() {
        guerra.aeronaves.juego.elementos.EstacionMunicionesRojo ema = 
                new guerra.aeronaves.juego.elementos.EstacionMunicionesRojo(posicion);
        
        ema.setVida(vida);
        
        return ema;
    }
}