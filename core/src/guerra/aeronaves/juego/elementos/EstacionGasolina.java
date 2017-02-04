package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.GuerraAeronaves;

public class EstacionGasolina extends Elemento {
    
    public EstacionGasolina(String rutaSprite, int idElemento, Vector2 posInicial) {
        super(rutaSprite, idElemento, posInicial, GuerraAeronaves.VIDA_ESTACION_GASOLINA);
    }
    
    @Override
    public final void colocarEnPosicionInicial() {
        super.colocarEnPosicionInicial();
    }
    
}
