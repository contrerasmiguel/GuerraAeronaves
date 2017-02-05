package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class Nube extends Elemento {
    
    public Nube(Vector2 posicion, Direccion direccion) {
        super("nube.png", GuerraAeronaves.ID_NUBE, posicion, direccion, GuerraAeronaves.VIDA_INFINITA);
        this.direccion = direccion;
    }
    
}
