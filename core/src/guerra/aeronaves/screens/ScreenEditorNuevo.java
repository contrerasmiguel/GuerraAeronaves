package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import guerra.aeronaves.GuerraAeronaves;
import guerra.aeronaves.editor.mapa.Mapa;
import guerra.aeronaves.editor.paleta.Paleta;

public class ScreenEditorNuevo extends ScreenAdapter {

    private final Stage stage;
    
    public ScreenEditorNuevo(GuerraAeronaves guerraAeronaves) {
        
        Gdx.graphics.setWindowedMode(GuerraAeronaves.getAnchoVentanaEditor()
                , GuerraAeronaves.getAltoVentanaEditor());
        
        Paleta paleta = new Paleta();
        Mapa mapa = new Mapa(paleta);
        
        Table tablaContenedora = new Table();
        tablaContenedora.setSize(GuerraAeronaves.getNumColumnasEditor() 
                * GuerraAeronaves.TAMANO_CASILLA_EDITOR
                , GuerraAeronaves.getNumFilasEditor() 
                * GuerraAeronaves.TAMANO_CASILLA_EDITOR);
        tablaContenedora.add(paleta).size(GuerraAeronaves.NUM_COLUMNAS_PALETA * GuerraAeronaves.TAMANO_CASILLA_EDITOR
                , GuerraAeronaves.NUM_FILAS_PALETA * GuerraAeronaves.TAMANO_CASILLA_EDITOR);
        tablaContenedora.add(mapa).size(GuerraAeronaves.NUM_COLUMNAS * GuerraAeronaves.TAMANO_CASILLA_EDITOR
                , GuerraAeronaves.NUM_FILAS * GuerraAeronaves.TAMANO_CASILLA_EDITOR);
        
        stage = new Stage();
        stage.addActor(tablaContenedora);
        Gdx.input.setInputProcessor(stage);
    }
   
    @Override
    public void hide() {
        super.hide();
        Gdx.graphics.setWindowedMode(GuerraAeronaves.getAnchoVentanaEditor()
                , GuerraAeronaves.getAltoVentanaEditor());          
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
}
