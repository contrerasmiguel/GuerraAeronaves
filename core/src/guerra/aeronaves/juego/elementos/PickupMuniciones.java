package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class PickupMuniciones extends Elemento {
    
    public PickupMuniciones(Vector2 posicion) {
        super("municion", GuerraAeronaves.ID_PICKUP_MUNICIONES, posicion, Direccion.ARRIBA, GuerraAeronaves.VIDA_INFINITA);
    }
    
}