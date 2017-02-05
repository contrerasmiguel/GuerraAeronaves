package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class Edificio extends Elemento {  
    
    public Edificio(Vector2 posicion) {
        super("edificio.png", GuerraAeronaves.ID_EDIFICIO, posicion, Direccion.ARRIBA, GuerraAeronaves.VIDA_EDIFICIO);
    }
    
}