package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class EstacionGasolinaRojo extends EstacionGasolina {
    
    public EstacionGasolinaRojo(Vector2 posInicial) {
        super("estacion_gasolina_rojo.png", GuerraAeronaves.ID_ESTACION_GASOLINA_ROJO, posInicial);
    }
    
}