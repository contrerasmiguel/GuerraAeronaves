package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class PowerupMuniciones extends Elemento {
    
    public PowerupMuniciones(Vector2 posInicial) {
        super("powerup_municion.png", GuerraAeronaves.ID_POWERUP_MUNICIONES, posInicial, GuerraAeronaves.VIDA_INFINITA);
    }
    
    @Override
    public final void colocarEnPosicionInicial() {
        super.colocarEnPosicionInicial();
    }

}