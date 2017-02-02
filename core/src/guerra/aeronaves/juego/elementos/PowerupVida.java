package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class PowerupVida extends Elemento {
    
    public PowerupVida(Vector2 posInicial) {
        super("powerup_vida.png", GuerraAeronaves.ID_POWERUP_VIDA, posInicial);
        colocarEnPosicionInicial();
    }
    
    @Override
    public final void colocarEnPosicionInicial() {
        super.colocarEnPosicionInicial();
    }
    
    @Override
    public boolean esColisionable() {
        return false;
    }
    
}