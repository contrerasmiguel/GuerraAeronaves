package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class PickupGasolina extends Elemento {
    
    public PickupGasolina(Vector2 posInicial) {
        super("gasolina.png", GuerraAeronaves.ID_PICKUP_GASOLINA, posInicial);
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