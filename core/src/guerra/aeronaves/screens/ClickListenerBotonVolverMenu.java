package guerra.aeronaves.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import guerra.aeronaves.GuerraAeronaves;

public class ClickListenerBotonVolverMenu extends ClickListenerBoton {
    
    public ClickListenerBotonVolverMenu(GuerraAeronaves guerraAeronaves) {
        super(guerraAeronaves);
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y); //To change body of generated methods, choose Tools | Templates.
        guerraAeronaves.setScreenMenuPrincipal();
    }
    
}
