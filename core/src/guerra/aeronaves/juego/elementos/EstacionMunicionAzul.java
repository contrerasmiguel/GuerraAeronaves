package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class EstacionMunicionAzul extends EstacionMunicion {   
    
    public EstacionMunicionAzul(Vector2 posInicial) {
        super("estacion_misiles_azul.png", GuerraAeronaves.ID_ESTACION_MUNICION_AZUL, posInicial);
    }
    
}