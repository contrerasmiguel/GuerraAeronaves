package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class Edificio extends Elemento {  
    
    public Edificio(Vector2 posInicial) {
        super("edificio.png", GuerraAeronaves.ID_EDIFICIO, posInicial, GuerraAeronaves.VIDA_EDIFICIO);
    }
    
    @Override
    public final void colocarEnPosicionInicial() {
        super.colocarEnPosicionInicial();
    }   
    
}