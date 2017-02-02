package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class PickupMunicion extends Elemento {
    
    public PickupMunicion(Vector2 posInicial) {
        super("municion", GuerraAeronaves.ID_PICKUP_MUNICION, posInicial);
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