package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class PowerupMunicion extends Elemento {
    
    public PowerupMunicion(Vector2 posInicial) {
        super("municion.png", GuerraAeronaves.ID_POWERUP_MUNICION, posInicial);
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