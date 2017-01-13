package guerra.aeronaves.editor.mapa;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import guerra.aeronaves.GuerraAeronaves;
import guerra.aeronaves.editor.paleta.Paleta;

public class Mapa extends Table {
    
    private final ClickListenerCasillaMapa clickListenerCasillaMapa;
    
    public Mapa(Paleta paleta) {
        this.clickListenerCasillaMapa = new ClickListenerCasillaMapa(paleta);
        setDebug(true);
        setTouchable(Touchable.enabled);
        for (int filas = 0; filas < GuerraAeronaves.NUM_FILAS; ++filas) {
            row();
            for (int columnas = 0; columnas < GuerraAeronaves.NUM_COLUMNAS; ++columnas) {
                ImageButton ib = new ElementoNoRotatorio("cielo1.png");
                ib.addListener(clickListenerCasillaMapa);
                add(ib).size(GuerraAeronaves.TAMANO_CASILLA_EDITOR);
            }
        }
    }
    
    public class ClickListenerCasillaMapa extends ClickListener {

        private final Paleta paleta;

        public ClickListenerCasillaMapa(Paleta paleta) {
            this.paleta = paleta;
        }

        @Override
        public void clicked(InputEvent event, float x, float y) {
            super.clicked(event, x, y);
            if (paleta.getClickListenerElementoPaleta().hayBotonSeleccionado()) {
                ElementoMapa em = paleta.getClickListenerElementoPaleta()
                        .getBotonSeleccionado().producirElementoMapa();
                em.addListener(this);
                getCell(event.getListenerActor()).setActor(em);
            }
        }

    }    
    
}
