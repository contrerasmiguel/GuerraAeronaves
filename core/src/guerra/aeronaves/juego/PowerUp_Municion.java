package guerra.aeronaves.juego;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class PowerUp_Municion extends Image{
    int id;
    
    public PowerUp_Municion(Drawable d, int id) {
        super(d);
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
}