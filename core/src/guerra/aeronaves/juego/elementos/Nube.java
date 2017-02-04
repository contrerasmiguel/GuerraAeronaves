package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class Nube extends Elemento {
    
    public Nube(Vector2 posInicial) {
        super("nube.png", GuerraAeronaves.ID_NUBE, posInicial, GuerraAeronaves.VIDA_INFINITA);
    }
    
    @Override
    public final void colocarEnPosicionInicial() {
        super.colocarEnPosicionInicial();
    } 
    
}
