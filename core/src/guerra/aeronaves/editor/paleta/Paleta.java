package guerra.aeronaves.editor.paleta;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import guerra.aeronaves.GuerraAeronaves;
import guerra.aeronaves.editor.mapa.Mapa;

public class Paleta extends Table { 
    
    private final ClickListenerElementoPaleta clickListenerElementoPaleta;
    private final ClickListenerBotonLimpiar clickListenerBotonLimpiar;
    private final ClickListenerBotonGuardar clickListenerBotonGuardar;
    private final ClickListenerBotonGirar clickListenerBotonGirar;
    
    public Paleta() { 
        clickListenerElementoPaleta = new ClickListenerElementoPaleta();
        clickListenerBotonLimpiar = new ClickListenerBotonLimpiar();
        clickListenerBotonGuardar = new ClickListenerBotonGuardar();
        clickListenerBotonGirar = new ClickListenerBotonGirar();
        
        row();
        agregarElementoNoRotatorio("paleta/vaciod.png", "cielo1.png", GuerraAeronaves.ID_CIELO);
        agregarElementoNoRotatorio("paleta/nubed.png", "nube.png", GuerraAeronaves.ID_NUBE);
        row();
        agregarElementoRotatorio("paleta/avion_azuld.png", "avion_azul.png", GuerraAeronaves.ID_AVION_AZUL);
        agregarElementoRotatorio("paleta/avion_rojod.png", "avion_rojo.png", GuerraAeronaves.ID_AVION_ROJO);
        row();
        agregarElementoNoRotatorio("paleta/edificiod.png", "edificio.png", GuerraAeronaves.ID_EDIFICIO);
        agregarElementoNoRotatorio("paleta/montanad.png", "montana.png", GuerraAeronaves.ID_MONTANA);
        row();
        agregarElementoNoRotatorio("paleta/est_gasolina_azuld.png"
                , "estacion_gasolina_azul.png", GuerraAeronaves.ID_ESTACION_GASOLINA_AZUL);
        agregarElementoNoRotatorio("paleta/est_gasolina_rojod.png"
                , "estacion_gasolina_rojo.png", GuerraAeronaves.ID_ESTACION_GASOLINA_ROJO);
        row();
        agregarElementoNoRotatorio("paleta/est_municion_azuld.png"
                , "estacion_misiles_azul.png", GuerraAeronaves.ID_ESTACION_MUNICION_AZUL);
        agregarElementoNoRotatorio("paleta/est_municion_rojod.png"
                , "estacion_misiles_rojo.png", GuerraAeronaves.ID_ESTACION_MUNICION_ROJO);
        row();
        agregarElementoNoRotatorio("paleta/pickup_gasolinad.png", "gasolina.png"
                , GuerraAeronaves.ID_PICKUP_GASOLINA);
        agregarElementoNoRotatorio("paleta/pickup_vidad.png", "reparacion.png"
                , GuerraAeronaves.ID_PICKUP_VIDA);
        row();
        // Por ahora, el powerup de munición tiene el mismo sprite que el pickup de munición
        // TO-DO: crear sprite de powerup de munición.
        agregarElementoNoRotatorio("paleta/pickup_municiond.png", "municion.png"
                , GuerraAeronaves.ID_POWERUP_MUNICION);
        agregarElementoNoRotatorio("paleta/pickup_municiond.png", "municion.png"
                , GuerraAeronaves.ID_PICKUP_MUNICION);
        row();
        agregarElementoNoRotatorio("paleta/powerup_vidad.png", "powerup_vida.png"
                , GuerraAeronaves.ID_POWERUP_VIDA);
        agregarElementoNoRotatorio("paleta/vaciod.png", "cielo1.png", GuerraAeronaves.ID_CIELO);
        row();
        agregarBoton("paleta/btn_guardar.png", clickListenerBotonGuardar);
        row();
        agregarBoton("paleta/btn_girar.png", clickListenerBotonGirar);
        row();
        agregarBoton("paleta/btn_limpiar.png", clickListenerBotonLimpiar);
        
        setTouchable(Touchable.enabled);
        center().top();
    }
     
    private void agregarElementoNoRotatorio(String rutaTexturaPaleta
            , String rutaTexturaMapa, int id) {
        ImageButton ib = new ElementoNoRotatorio(rutaTexturaPaleta, rutaTexturaMapa, id);
        ib.addListener(clickListenerElementoPaleta);
        add(ib).size(GuerraAeronaves.TAMANO_CASILLA_EDITOR);
    }
    
    private void agregarElementoRotatorio(String rutaTexturaPaleta
            , String rutaTexturaMapa, int id) {
        ImageButton ib = new ElementoRotatorio(rutaTexturaPaleta, rutaTexturaMapa, id);
        ib.addListener(clickListenerElementoPaleta);
        add(ib).size(GuerraAeronaves.TAMANO_CASILLA_EDITOR);
    }
    
    private void agregarBoton(String rutaTextura, ClickListener clickListenerBoton) {
        ImageButton ib = new BotonPaleta(rutaTextura);
        ib.addListener(clickListenerBoton);
        add(ib).size(GuerraAeronaves.TAMANO_CASILLA_EDITOR * 2, GuerraAeronaves
                .TAMANO_CASILLA_EDITOR).colspan(2);
    }

    public ClickListenerElementoPaleta getClickListenerElementoPaleta() {
        return clickListenerElementoPaleta;
    }

    public ClickListenerBotonGirar getClickListenerBotonGirar() {
        return clickListenerBotonGirar;
    }

    public void setClickPaletaListener(Mapa mapa) {
        clickListenerBotonLimpiar.setListener(mapa);
        clickListenerBotonGuardar.setListener(mapa);
    }
}
