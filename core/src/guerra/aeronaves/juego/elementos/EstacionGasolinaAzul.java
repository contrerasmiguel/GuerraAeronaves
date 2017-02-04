package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class EstacionGasolinaAzul extends EstacionGasolina {
    
    public EstacionGasolinaAzul(Vector2 posInicial) {
        super("estacion_gasolina_azul.png", GuerraAeronaves.ID_ESTACION_GASOLINA_AZUL, posInicial);
    }
    
}