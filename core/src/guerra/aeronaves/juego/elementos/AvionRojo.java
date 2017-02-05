package guerra.aeronaves.juego.elementos;

import guerra.aeronaves.Direccion;
import java.awt.Point;

public class AvionRojo extends Avion {
    
    public AvionRojo(Point posicion, Direccion dir) {
        super("avion_rojo.png", posicion, dir);
    }

}