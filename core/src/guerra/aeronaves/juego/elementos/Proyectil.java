package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class Proyectil extends Elemento {
    
    private final Direccion direccion;
    
    public Proyectil(Direccion direccion, Vector2 posInicial) {
        super("proyectil.png", GuerraAeronaves.ID_PROYECTIL, posInicial);
        this.direccion = direccion;
        setOrigin(getWidth()/2, getHeight()/2);
        colocarEnPosicionInicial();
    }
    
    private void actualizarPosicion() {
        switch (direccion) {
            case ARRIBA:
                moveBy(0, GuerraAeronaves.VELOCIDAD_PROYECTIL);
                break;
            case ABAJO:
                moveBy(0, -GuerraAeronaves.VELOCIDAD_PROYECTIL);
                break;
            case DERECHA:
                moveBy(GuerraAeronaves.VELOCIDAD_PROYECTIL, 0);
                break;
            default:
                moveBy(-GuerraAeronaves.VELOCIDAD_PROYECTIL, 0);
                break;
        }           
    }    
    
    @Override
    public final void colocarEnPosicionInicial() {
        super.colocarEnPosicionInicial();
    }
    
    @Override
    public boolean esColisionable() {
        return true;
    }    
    
}
