package guerra.aeronaves.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import guerra.aeronaves.GuerraAeronaves;

public class ClickListenerBotonPaleta extends ClickListener{
    protected GuerraAeronaves guerraAeronaves;
    
    public ClickListenerBotonPaleta(GuerraAeronaves guerr) {
        guerraAeronaves = guerr;
    }
    
    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        guerraAeronaves.getScreenEditorNuevo().setUltimoClickeado(event.getListenerActor());
    }  
}
