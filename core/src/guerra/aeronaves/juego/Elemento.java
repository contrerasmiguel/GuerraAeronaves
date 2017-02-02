package guerra.aeronaves.juego;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Elemento extends Image {
    
    private final int id;
    
    public Elemento(Drawable d, int id) {
        super(d);
        this.id = id;
    }

    public int getId() {
        return id;
    }
 
}
