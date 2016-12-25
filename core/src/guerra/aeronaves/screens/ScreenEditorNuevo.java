package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import guerra.aeronaves.GuerraAeronaves;

public class ScreenEditorNuevo extends ScreenAdapter {

    private final Stage stage;
    
    public ScreenEditorNuevo(GuerraAeronaves guerraAeronaves) {
        
        Gdx.graphics.setWindowedMode(GuerraAeronaves.getAnchoVentanaEditor()
            , GuerraAeronaves.getAltoVentanaEditor());   
        
        Table tablaPaleta = new Table();
        Table tablaMapa = new Table();
        
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
    }
    
}
