package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Timer;
import guerra.aeronaves.GuerraAeronaves;
import java.util.ArrayDeque;

public abstract class Elemento extends Image {
    
    protected final int id;
    protected Vector2 posInicial;
    
    public Elemento(String rutaSprite, int id, Vector2 posInicial) {
        super(new SpriteDrawable(new Sprite(new Texture(Gdx.files
                .internal(rutaSprite)))));
        this.id = id;
        this.posInicial = posInicial;
    }

    public int getId() {
        return id;
    }
    
    public abstract boolean esColisionable();
    
    public void crearExplosion(float tiempo) {
        final float tiempoSprite = tiempo / 6;
        final ArrayDeque<String> rutaExplosiones = new ArrayDeque<String>(
                GuerraAeronaves.RUTA_EXPLOSIONES);
        final Drawable spriteInicial = getDrawable();
        
        new Timer().scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                if (!rutaExplosiones.isEmpty()) {
                    setDrawable(new SpriteDrawable(new Sprite(new Texture(
                            Gdx.files.internal(rutaExplosiones.pop())))));
                    setZIndex(GuerraAeronaves.INDICE_ALTO);
                }
                else {
                    setZIndex(GuerraAeronaves.INDICE_INTERMEDIO);
                    setVisible(false);
                    setDrawable(spriteInicial);
                }
            }
        }, 0, tiempoSprite, GuerraAeronaves.RUTA_EXPLOSIONES.size() + 1);
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
 
}
