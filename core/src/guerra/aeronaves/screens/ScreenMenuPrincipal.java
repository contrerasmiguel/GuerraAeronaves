package guerra.aeronaves.screens;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import guerra.aeronaves.GuerraAeronaves;

public class ScreenMenuPrincipal extends ScreenMenu {
    
    public ScreenMenuPrincipal(GuerraAeronaves guerraAeronaves) {
        
        ImageButton btnJugar = agregarBoton("boton_jugar.png");
        btnJugar.setY(220);
        btnJugar.addListener(new ClickListenerBotonJugar(guerraAeronaves));
        
        ImageButton btnEditarMapa = agregarBoton("boton_editar_mapa.png");
        btnEditarMapa.setY(80);
        btnEditarMapa.addListener(new ClickListenerBotonEditarMapa(
                guerraAeronaves));
    }
    
}