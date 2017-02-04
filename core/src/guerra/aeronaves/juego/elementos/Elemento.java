package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public abstract class Elemento extends Image {
    
    protected final int id;
    protected Vector2 posInicial;
    protected float vida;
    
    public Elemento(String rutaSprite, int id, Vector2 posInicial, float vida) {
        super(new SpriteDrawable(new Sprite(new Texture(Gdx.files
                .internal(rutaSprite)))));
        this.id = id;
        this.posInicial = posInicial;
        this.vida = vida;
    }

    public int getId() {
        return id;
    }
    
    public void colocarEnPosicionInicial() {
        setPosition(posInicial.x, posInicial.y);
    }

    public Vector2 getPosInicial() {
        return posInicial;
    }

    public void setPosInicial(Vector2 posInicial) {
        this.posInicial = posInicial;
    }

    public float getVida() {
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }
    
}
