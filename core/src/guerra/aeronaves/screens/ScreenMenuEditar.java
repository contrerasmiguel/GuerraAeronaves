package guerra.aeronaves.screens;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import guerra.aeronaves.GuerraAeronaves;

public class ScreenMenuEditar extends ScreenMenu {
    
    public ScreenMenuEditar(GuerraAeronaves guerraAeronaves) {
        ImageButton btnCrearMapa = agregarBoton("boton_crear_mapa.png");
        btnCrearMapa.setY(240);
        btnCrearMapa.addListener(new ClickListenerBotonCrearMapa(guerraAeronaves));
        
        ImageButton btnCargarMapa = agregarBoton("boton_cargar_mapa.png");
        btnCargarMapa.setY(140);
        btnCargarMapa.addListener(new ClickListenerBotonCargarMapa(guerraAeronaves));
        
        ImageButton btnRegresar = agregarBoton("boton_regresar.png");
        btnRegresar.setY(40);
        btnRegresar.addListener(new ClickListenerBotonRegresar(guerraAeronaves));
    }
    
}