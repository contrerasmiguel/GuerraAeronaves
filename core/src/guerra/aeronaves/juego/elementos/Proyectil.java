package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class Proyectil extends Elemento {
    
    public Proyectil(Direccion direccion, Vector2 posicion) {
        super("proyectil.png", GuerraAeronaves.ID_PROYECTIL, posicion, direccion, GuerraAeronaves.VIDA_PROYECTIL);
    }
    
}
