package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class Explosion extends Elemento {
    
    public Explosion(String rutaSprite, Vector2 posicion) {
        super(rutaSprite, GuerraAeronaves.ID_EXPLOSION, posicion, Direccion.ARRIBA, GuerraAeronaves.VIDA_INFINITA);
    }
    
}
