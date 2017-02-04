package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class PickupGasolina extends Elemento {
    
    public PickupGasolina(Vector2 posInicial) {
        super("gasolina.png", GuerraAeronaves.ID_PICKUP_GASOLINA, posInicial, GuerraAeronaves.VIDA_INFINITA);
    }
    
    @Override
    public final void colocarEnPosicionInicial() {
        super.colocarEnPosicionInicial();
    }
    
}