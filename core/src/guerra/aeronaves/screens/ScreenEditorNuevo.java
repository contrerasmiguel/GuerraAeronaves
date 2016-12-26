package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import guerra.aeronaves.GuerraAeronaves;

public class ScreenEditorNuevo extends ScreenAdapter {

    private final Stage stage;
    
    public ScreenEditorNuevo(GuerraAeronaves guerraAeronaves) {
        
        Gdx.graphics.setWindowedMode(GuerraAeronaves.getAnchoVentanaEditor()
            , GuerraAeronaves.getAltoVentanaEditor());   
        
        Table tablaPaleta = new Table();
        tablaPaleta.setTouchable(Touchable.enabled);
        
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        agregarElementoPaleta(tablaPaleta,"paleta/vaciod.png",new ClickListenerBotonPaleta()).size(GuerraAeronaves.tamañoCasilla);
        agregarElementoPaleta(tablaPaleta,"paleta/nubed.png",new ClickListenerBotonPaleta()).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        agregarElementoPaleta(tablaPaleta,"paleta/avion_azuld.png",new ClickListenerBotonPaleta()).size(GuerraAeronaves.tamañoCasilla);
        agregarElementoPaleta(tablaPaleta,"paleta/avion_azuld.png",new ClickListenerBotonPaleta()).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        agregarElementoPaleta(tablaPaleta,"paleta/edificiod.png",new ClickListenerBotonPaleta()).size(GuerraAeronaves.tamañoCasilla);
        agregarElementoPaleta(tablaPaleta,"paleta/montanad.png",new ClickListenerBotonPaleta()).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        agregarElementoPaleta(tablaPaleta,"paleta/est_gasolina_azuld.png",new ClickListenerBotonPaleta()).size(GuerraAeronaves.tamañoCasilla);
        agregarElementoPaleta(tablaPaleta,"paleta/est_gasolina_rojod.png",new ClickListenerBotonPaleta()).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        agregarElementoPaleta(tablaPaleta,"paleta/est_municion_azuld.png",new ClickListenerBotonPaleta()).size(GuerraAeronaves.tamañoCasilla);
        agregarElementoPaleta(tablaPaleta,"paleta/est_municion_rojod.png",new ClickListenerBotonPaleta()).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        agregarElementoPaleta(tablaPaleta,"paleta/pickup_gasolinad.png",new ClickListenerBotonPaleta()).size(GuerraAeronaves.tamañoCasilla);
        agregarElementoPaleta(tablaPaleta,"paleta/pickup_vidad.png",new ClickListenerBotonPaleta()).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        agregarElementoPaleta(tablaPaleta,"paleta/pickup_municiond.png",new ClickListenerBotonPaleta()).size(GuerraAeronaves.tamañoCasilla);
        agregarElementoPaleta(tablaPaleta,"paleta/powerup_vidad.png",new ClickListenerBotonPaleta()).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        agregarElementoPaleta(tablaPaleta,"paleta/btn_guardar.png",new ClickListenerBotonPaleta()).colspan(2);
        tablaPaleta.row();
        agregarElementoPaleta(tablaPaleta,"paleta/btn_girar.png",new ClickListenerBotonPaleta()).colspan(2);
        tablaPaleta.row();
        agregarElementoPaleta(tablaPaleta,"paleta/btn_limpiar.png",new ClickListenerBotonPaleta()).colspan(2);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        
        Table tablaMapa = new Table();
        
        // Código de prueba para agregar elementos a la tabla del mapa
        tablaMapa.setDebug(true); // Líneas de la grilla
        for (int filas = 0; filas < GuerraAeronaves.casillasV; ++filas) {
            tablaMapa.row();
            for (int columnas = 0; columnas < GuerraAeronaves.casillasH; ++columnas) {
                tablaMapa.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
            }
        }
        // Fin de código de prueba
        
        Table tablaContenedora = new Table();
        tablaContenedora.setSize(GuerraAeronaves.getNumColumnasEditor() 
                * GuerraAeronaves.tamañoCasilla
                , GuerraAeronaves.getNumFilasEditor() 
                * GuerraAeronaves.tamañoCasilla);
        tablaContenedora.add(tablaPaleta).size(
                  GuerraAeronaves.NUM_COLUMNAS_PALETA * GuerraAeronaves.tamañoCasilla
                , GuerraAeronaves.NUM_FILAS_PALETA * GuerraAeronaves.tamañoCasilla);
        tablaContenedora.add(tablaMapa).size(
                  GuerraAeronaves.casillasH * GuerraAeronaves.tamañoCasilla
                , GuerraAeronaves.casillasV * GuerraAeronaves.tamañoCasilla);
        
        stage = new Stage();
        stage.addActor(tablaContenedora);
        Gdx.input.setInputProcessor(stage);
    }
   
    @Override
    public void hide() {
        super.hide();
        Gdx.graphics.setWindowedMode(GuerraAeronaves.getAnchoVentana()
                , GuerraAeronaves.getAltoVentana());          
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
    }
    
    private Cell<Image> agregarElementoPaleta(Table tabla, String rutaTextura, ClickListenerBotonPaleta listener) {
        Image image = new Image(new Texture(rutaTextura));
        image.addListener(listener);
        return tabla.add(image);
    }
}
