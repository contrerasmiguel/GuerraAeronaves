package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import guerra.aeronaves.GuerraAeronaves;
import guerra.aeronaves.editor.mapa.Mapa;
import guerra.aeronaves.editor.paleta.Paleta;

public class ScreenEditorNuevo extends ScreenAdapter {

    private final Stage stage;
    
    public ScreenEditorNuevo(GuerraAeronaves guerraAeronaves) {  
        stage = new Stage(new StretchViewport(GuerraAeronaves.calcularTamañoCasillaEditor(Gdx
                .graphics.getWidth(), Gdx.graphics.getHeight()) * GuerraAeronaves.getNumColumnasEditor()
                , GuerraAeronaves.calcularTamañoCasillaEditor(Gdx.graphics.getWidth()
                        , Gdx.graphics.getHeight()) * GuerraAeronaves.getNumFilasEditor()));

        Image fondo = new Image(new SpriteDrawable(new Sprite(new Texture(
                Gdx.files.internal("cielo1.png")))));
        fondo.setZIndex(GuerraAeronaves.INDICE_FONDO);
        fondo.setFillParent(true);
        stage.addActor(fondo);
        
        Paleta paleta = new Paleta(stage);
        
        Mapa mapa = new Mapa(paleta, stage);
        
        Table tablaContenedora = new Table();
        tablaContenedora.setZIndex(GuerraAeronaves.INDICE_MEDIO);
        tablaContenedora.setSize(GuerraAeronaves.getNumColumnasEditor() 
                * GuerraAeronaves.calcularTamañoCasillaEditor(stage.getWidth(), stage.getHeight())
                , GuerraAeronaves.getNumFilasEditor() 
                * GuerraAeronaves.calcularTamañoCasillaEditor(stage.getWidth(), stage.getHeight()));
        tablaContenedora.add(paleta).size(GuerraAeronaves.NUM_COLUMNAS_PALETA * GuerraAeronaves.calcularTamañoCasillaEditor(stage.getWidth(), stage.getHeight())
                , GuerraAeronaves.NUM_FILAS_PALETA * GuerraAeronaves.calcularTamañoCasillaEditor(stage.getWidth(), stage.getHeight()));
        tablaContenedora.add(mapa).size(GuerraAeronaves.NUM_COLUMNAS * GuerraAeronaves.calcularTamañoCasillaEditor(stage.getWidth(), stage.getHeight())
                , GuerraAeronaves.NUM_FILAS * GuerraAeronaves.calcularTamañoCasillaEditor(stage.getWidth(), stage.getHeight()));
        
        stage.addActor(tablaContenedora);
        Gdx.input.setInputProcessor(stage);
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
