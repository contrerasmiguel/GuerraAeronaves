package guerra.aeronaves.juego;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class Proyectil extends Elemento {
    
    private final Direccion direccion;
    
    public Proyectil(Drawable d, int id, Direccion direccion) {
        super(d, id);
        this.direccion = direccion;
        setOrigin(getWidth()/2, getHeight()/2);
    }
    
    private void actualizarPosicion() {
        switch (direccion) {
            case ARRIBA:
                setPosition(getX(),getY()+GuerraAeronaves.VELOCIDAD_PROYECTIL);
                break;
            case ABAJO:
                setPosition(getX(),getY()-GuerraAeronaves.VELOCIDAD_PROYECTIL);
                break;
            case DERECHA:
                setPosition(getX()+GuerraAeronaves.VELOCIDAD_PROYECTIL,getY());
                break;
            default:
                setPosition(getX()-GuerraAeronaves.VELOCIDAD_PROYECTIL,getY());
                break;
        }           
    }    
    
}
