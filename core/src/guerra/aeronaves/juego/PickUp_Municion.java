package guerra.aeronaves.juego;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class PickUp_Municion extends Image{
    int id;
    
    public PickUp_Municion(Drawable d, int id) {
        super(d);
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
}