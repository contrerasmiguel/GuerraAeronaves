package guerra.aeronaves.juego;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import guerra.aeronaves.Direccion;

public class Avion extends Image{
    Direccion dir;
    Direccion proxDir;
    
    public Avion(Drawable d, Direccion dir) {
        super(d);
        this.dir = dir;
        proxDir = dir;
    }

    public void actualizar() {
        setOrigin(getWidth()/2, getHeight()/2);
        switch (dir) {
            case ARRIBA:
                setPosition(getX(),getY()+1);
                setRotation(0);
                break;
            case ABAJO:
                setPosition(getX(),getY()-1);
                setRotation(180);
                break;
            case DERECHA:
                setPosition(getX()+1,getY());
                setRotation(270);
                break;
            default:
                setPosition(getX()-1,getY());
                setRotation(90);
                break;
        }
    }

    public void actualizarDireccion() {
        dir = proxDir;
    }
    
    public void cambiarDireccion(Direccion d) {
        if(d == Direccion.ARRIBA && dir != Direccion.ABAJO || d == Direccion.DERECHA && dir != Direccion.IZQUIERDA
                || d == Direccion.ABAJO && dir != Direccion.ARRIBA || d == Direccion.IZQUIERDA && dir != Direccion.DERECHA) {
            proxDir = d;
        }
    }
    
    public Direccion obtenerDireccion() {
        return dir;
    }
}
