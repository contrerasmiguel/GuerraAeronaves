package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class EstacionMunicionesRojo extends EstacionMuniciones {   
    
    public EstacionMunicionesRojo(Vector2 posInicial) {
        super("estacion_misiles_rojo.png", GuerraAeronaves.ID_ESTACION_MUNICIONES_ROJO, posInicial);
    }
    
}