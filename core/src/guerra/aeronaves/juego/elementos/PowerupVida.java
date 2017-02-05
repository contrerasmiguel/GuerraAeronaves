package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class PowerupVida extends Elemento {
    
    public PowerupVida(Vector2 posicion) {
        super("powerup_vida.png", GuerraAeronaves.ID_POWERUP_VIDA, posicion, Direccion.ARRIBA, GuerraAeronaves.VIDA_INFINITA);
    }
    
}