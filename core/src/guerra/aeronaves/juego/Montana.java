package guerra.aeronaves.juego;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Montana extends Image{
    int id;
    
    public Montana(Drawable d, int id) {
        super(d);
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
}
