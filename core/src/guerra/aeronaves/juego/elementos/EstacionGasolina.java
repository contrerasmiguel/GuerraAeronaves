package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class EstacionGasolina extends Elemento {
    
    public EstacionGasolina(String rutaSprite, int idElemento, Vector2 posicion) {
        super(rutaSprite, idElemento, posicion, Direccion.ARRIBA, GuerraAeronaves.VIDA_ESTACION_GASOLINA);
    }
    
}
