package guerra.aeronaves.editor.paleta;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import guerra.aeronaves.GuerraAeronaves;

public class Paleta extends Table { 
    
    private final ClickListenerElementoPaleta clickListenerElementoPaleta;
    
    public Paleta() { 
        clickListenerElementoPaleta = new ClickListenerElementoPaleta();
        
        row();
        agregarElementoNoRotatorio("paleta/vaciod.png", "cielo1.png");
        agregarElementoNoRotatorio("paleta/nubed.png", "nube.png");
        row();
        agregarElementoRotatorio("paleta/avion_azuld.png", "avion_azul.png");
        agregarElementoRotatorio("paleta/avion_rojod.png", "avion_rojo.png");
        row();
        agregarElementoNoRotatorio("paleta/edificiod.png", "edificio.png");
        agregarElementoNoRotatorio("paleta/montanad.png", "montana.png");
        row();
        agregarElementoNoRotatorio("paleta/est_gasolina_azuld.png", "estacion_gasolina_azul.png");
        agregarElementoNoRotatorio("paleta/est_gasolina_rojod.png", "estacion_gasolina_rojo.png");
        row();
        agregarElementoNoRotatorio("paleta/est_municion_azuld.png", "estacion_misiles_azul.png");
        agregarElementoNoRotatorio("paleta/est_municion_rojod.png", "estacion_misiles_rojo.png");
        row();
        agregarElementoNoRotatorio("paleta/pickup_gasolinad.png", "gasolina.png");
        agregarElementoNoRotatorio("paleta/pickup_vidad.png", "reparacion.png");
        row();
        agregarElementoNoRotatorio("paleta/pickup_municiond.png", "municion.png");
        agregarElementoNoRotatorio("paleta/powerup_vidad.png", "powerup_vida.png");
        row();
        agregarBoton("paleta/btn_guardar.png");
        row();
        agregarBoton("paleta/btn_girar.png");
        row();
        agregarBoton("paleta/btn_limpiar.png");
        
        setTouchable(Touchable.enabled);
        center().top();
    }
     
    private void agregarElementoNoRotatorio(String rutaTexturaPaleta, String rutaTexturaMapa) {
        ImageButton ib = new ElementoNoRotatorio(rutaTexturaPaleta, rutaTexturaMapa);
        ib.addListener(clickListenerElementoPaleta);
        add(ib).size(GuerraAeronaves.TAMANO_CASILLA_EDITOR);
    }
    
    private void agregarElementoRotatorio(String rutaTexturaPaleta, String rutaTexturaMapa) {
        ImageButton ib = new ElementoRotatorio(rutaTexturaPaleta, rutaTexturaMapa);
        ib.addListener(clickListenerElementoPaleta);
        add(ib).size(GuerraAeronaves.TAMANO_CASILLA_EDITOR);
    }
    
    private void agregarBoton(String rutaTextura) {
        add(new BotonPaleta(rutaTextura)).size(GuerraAeronaves.TAMANO_CASILLA_EDITOR * 2
                , GuerraAeronaves.TAMANO_CASILLA_EDITOR).colspan(2);
    }

    public ClickListenerElementoPaleta getClickListenerElementoPaleta() {
        return clickListenerElementoPaleta;
    }
    
}
