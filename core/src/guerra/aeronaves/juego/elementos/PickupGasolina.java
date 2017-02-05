package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class PickupGasolina extends Elemento {
    
    public PickupGasolina(Vector2 posicion) {
        super("gasolina.png", GuerraAeronaves.ID_PICKUP_GASOLINA, posicion, Direccion.ARRIBA, GuerraAeronaves.VIDA_INFINITA);
    }
    
}