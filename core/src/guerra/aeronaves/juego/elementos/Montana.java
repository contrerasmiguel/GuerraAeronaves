package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class Montana extends Elemento {
   
    public Montana(Vector2 posicion) {
        super("montana.png", GuerraAeronaves.ID_MONTANA, posicion, Direccion.ARRIBA, GuerraAeronaves.VIDA_INFINITA);
    }
    
}
