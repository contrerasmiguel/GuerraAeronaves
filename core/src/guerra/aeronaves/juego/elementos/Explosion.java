package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class Explosion extends Elemento {
    
    public Explosion(String rutaSprite, Vector2 posInicial) {
        super(rutaSprite, GuerraAeronaves.ID_EXPLOSION, posInicial, GuerraAeronaves.VIDA_INFINITA);
    }
    
}
