package guerra.aeronaves.editor.paleta;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ClickListenerBotonGirar extends ClickListener {
    
    private boolean botonGirarSeleccionado;
    
    public ClickListenerBotonGirar() {
        botonGirarSeleccionado = false;
    }

    public boolean isBotonGirarSeleccionado() {
        return botonGirarSeleccionado;
    }
    
    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        botonGirarSeleccionado = !botonGirarSeleccionado;
        //System.out.println("botonGirarSeleccionado = " + botonGirarSeleccionado);
    }
    
}
