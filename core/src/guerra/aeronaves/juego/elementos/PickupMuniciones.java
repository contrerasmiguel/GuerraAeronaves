package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class PickupMuniciones extends Elemento {
    
    public PickupMuniciones(Vector2 posInicial) {
        super("municion", GuerraAeronaves.ID_PICKUP_MUNICIONES, posInicial, GuerraAeronaves.VIDA_INFINITA);
    }
    
    @Override
    public final void colocarEnPosicionInicial() {
        super.colocarEnPosicionInicial();
    }
    
}