package guerra.aeronaves.juego;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import guerra.aeronaves.Direccion;

public class Proyectil extends Image{
    int id;
    Direccion dir;
    Direccion proxDir;
    
    public Proyectil(Drawable d, int id) {
        super(d);
        this.id = id;
        this.dir = dir;
        proxDir = this.dir;
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
    
        public Direccion obtenerDireccion() {
        return dir;
    }
    
    public int getId() {
        return id;
    }
    
}