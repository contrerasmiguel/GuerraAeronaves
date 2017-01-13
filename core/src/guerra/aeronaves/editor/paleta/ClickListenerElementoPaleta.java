package guerra.aeronaves.editor.paleta;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ClickListenerElementoPaleta extends ClickListener {
    private ElementoPaleta botonSeleccionado;
    
    public ClickListenerElementoPaleta() {
        deseleccionarBotonActual();
    }
    
    public boolean hayBotonSeleccionado() {
        return botonSeleccionado != null;
    }

    public ElementoPaleta getBotonSeleccionado() {
        return botonSeleccionado;
    }

    public final void deseleccionarBotonActual() {
        if (botonSeleccionado != null) {
            botonSeleccionado.setSeleccionado(false);
            botonSeleccionado = null;           
        }
    }
    
    public final void seleccionarBoton(ElementoPaleta nuevoBoton) {
        botonSeleccionado = nuevoBoton;
        botonSeleccionado.setSeleccionado(true);
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        
        ElementoPaleta botonPrevio = botonSeleccionado;
        deseleccionarBotonActual();
        if (botonPrevio == null || !botonPrevio.equals((ElementoPaleta)event.getListenerActor())) {
            seleccionarBoton((ElementoPaleta)event.getListenerActor());
        }        
    }
    
}
