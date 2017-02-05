package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import guerra.aeronaves.Direccion;

public abstract class Elemento extends Image {
    
    protected final int id;
    protected Vector2 posicion;
    protected Vector2 proximaPosicion;
    protected Direccion direccion;
    protected Direccion proximaDireccion;
    protected float vida;
    
    public Elemento(String rutaSprite, int id, Vector2 posicion, Direccion direccion, float vida) {
        super(new SpriteDrawable(new Sprite(new Texture(Gdx.files
                .internal(rutaSprite)))));
        this.id = id;
        this.posicion = posicion;
        this.direccion = direccion;
        this.vida = vida;
    }

    public int getId() {
        return id;
    }
    
    public float getVida() {
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public Vector2 getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector2 posicion) {
        this.posicion = posicion;
        setPosition(posicion.x, posicion.y);
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
        
        setOrigin(getWidth() / 2, getHeight() / 2);
        switch (this.direccion) {
            case ARRIBA:
                setRotation(0);
                break;
            case ABAJO:
                setRotation(180);
                break;
            case DERECHA:
                setRotation(270);
                break;
            default:
                setRotation(90);
        }        
    }
    
    public Vector2 getPosicionEnFrente() {
        float x = getX(), y = getY();
        
        switch (direccion) {
            case ARRIBA:
                y += 1;
                break;
            case DERECHA:
                x += 1;
                break;
            case ABAJO:
                y -= 1;
                break;
            default:
                x -= 1;
        }
        
        return new Vector2(x, y);
    }

    public Vector2 getProximaPosicion() {
        return proximaPosicion;
    }

    public void setProximaPosicion(Vector2 proximaPosicion) {
        this.proximaPosicion = proximaPosicion;
    }

    public Direccion getProximaDireccion() {
        return proximaDireccion;
    }

    public void setProximaDireccion(Direccion proximaDireccion) {
        this.proximaDireccion = proximaDireccion;
    }    
    
}
