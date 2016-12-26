package guerra.aeronaves.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import guerra.aeronaves.GuerraAeronaves;

public class ClickListenerBotonPaleta extends ClickListener{
    
    public ClickListenerBotonPaleta() { 
    }
    
    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        //System.out.println("I got clicked in X: "+x+", Y: "+y);
    }
    
}
