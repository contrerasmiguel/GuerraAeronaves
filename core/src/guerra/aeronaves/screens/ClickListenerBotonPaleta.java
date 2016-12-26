package guerra.aeronaves.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import guerra.aeronaves.GuerraAeronaves;

public class ClickListenerBotonPaleta extends ClickListener{
    private int aux;
    
    public ClickListenerBotonPaleta() { 
        aux = 0;
    }
    
    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        //System.out.println(event.getListenerActor().getName());
        for(int i=0;i==Integer.parseInt(event.getListenerActor().getName());i++) aux = i;
    }
    
    public int getAux() {
        return aux;
    }
    
}
