package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Timer;
import guerra.aeronaves.GuerraAeronaves;
import java.util.ArrayDeque;

public class Elemento extends Image {
    
    private final int id;
    
    public Elemento(Drawable d, int id) {
        super(d);
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public boolean esColisionable() {
        return id == GuerraAeronaves.ID_AVION_AZUL 
                || id == GuerraAeronaves.ID_AVION_ROJO
                || id == GuerraAeronaves.ID_EDIFICIO
                || id == GuerraAeronaves.ID_MONTANA;
    }
    
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
                }
                else {
                    setVisible(false);
                    setDrawable(spriteInicial);
                }
            }
        }, 0, tiempoSprite, GuerraAeronaves.RUTA_EXPLOSIONES.size() + 1);
    }    
 
}
