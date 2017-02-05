package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class PickupVida extends Elemento {

    public PickupVida(Vector2 posicion) {
        super("reparacion.png", GuerraAeronaves.ID_PICKUP_VIDA, posicion, Direccion.ARRIBA, GuerraAeronaves.VIDA_INFINITA);
    }
    
}