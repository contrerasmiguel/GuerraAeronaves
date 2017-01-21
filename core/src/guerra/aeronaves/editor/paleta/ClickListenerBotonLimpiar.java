package guerra.aeronaves.editor.paleta;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import guerra.aeronaves.editor.mapa.Mapa;

public class ClickListenerBotonLimpiar extends ClickListener {

    private Mapa mapa;
    
    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        
        if (mapa != null) {
            mapa.limpiar();
        }        
    }

    void setListener(Mapa mapa) {
        this.mapa = mapa;
    }
    
}
