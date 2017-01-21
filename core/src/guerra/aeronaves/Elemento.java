package guerra.aeronaves;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import java.awt.Point;

abstract public class Elemento extends Actor {
    
    protected int id;
    protected Point posicion;
    protected boolean visible;
    protected int vida;
    private Image img;
    
    public Elemento(int id, int x, int y, Image i, boolean v) {
        this.id = id; posicion.x = x; posicion.y = y; img = i; visible = v;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getPosicion() {
        return posicion;
    }

    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public Image getImg() {
        return img;
    }
    
    public void setImg(Image i) {
        img = i;
    }
    
}