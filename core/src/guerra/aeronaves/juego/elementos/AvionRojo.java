package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;

public class AvionRojo extends Avion {
    
    public AvionRojo(Vector2 posInicial, Direccion dir) {
        super("avion_rojo.png", posInicial, dir);
    }

}