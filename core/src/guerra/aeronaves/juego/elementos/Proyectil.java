package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class Proyectil extends Elemento {
    
    private final Direccion direccion;
    
    public Proyectil(Direccion direccion, Vector2 posInicial) {
        super("proyectil.png", GuerraAeronaves.ID_PROYECTIL, posInicial, GuerraAeronaves.VIDA_PROYECTIL);
        this.direccion = direccion;
        setOrigin(getWidth()/2, getHeight()/2);
    }   
    
    @Override
    public final void colocarEnPosicionInicial() {
        super.colocarEnPosicionInicial();
    }  
    
}
