package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class PowerupMuniciones extends Elemento {
    
    public PowerupMuniciones(Vector2 posicion) {
        super("powerup_municion.png", GuerraAeronaves.ID_POWERUP_MUNICIONES, posicion, Direccion.ARRIBA, GuerraAeronaves.VIDA_INFINITA);
    }

}