package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import guerra.aeronaves.GuerraAeronaves;

public class ScreenEditorNuevo extends ScreenAdapter {

    private final Stage stage;
    
    public ScreenEditorNuevo(GuerraAeronaves guerraAeronaves) {
        
        Gdx.graphics.setWindowedMode(GuerraAeronaves.getAnchoVentanaEditor()
            , GuerraAeronaves.getAltoVentanaEditor());   
        
        Table tablaPaleta = new Table();
        
        /*
        for (int filas = 0; filas < GuerraAeronaves.NUM_FILAS_PALETA; ++filas) {
            tablaPaleta.row();
            for (int columnas = 0; columnas < GuerraAeronaves.NUM_COLUMNAS_PALETA; ++columnas) {
                tablaPaleta.add(new Image(new Texture("paleta/vaciod.png"))).size(GuerraAeronaves.tamañoCasilla);
            }
        }
        */
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("paleta/vaciod.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("paleta/nubed.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("paleta/avion_azuld.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("paleta/avion_rojod.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("paleta/edificiod.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("paleta/montanad.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("paleta/est_gasolina_azuld.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("paleta/est_gasolina_rojod.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("paleta/est_municion_azuld.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("paleta/est_municion_rojod.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("paleta/pickup_gasolinad.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("paleta/pickup_vidad.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("paleta/pickup_municiond.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("paleta/powerup_vidad.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("paleta/btn_guardar.png"))).colspan(2);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.add(new Image(new Texture("cielo1.png"))).size(GuerraAeronaves.tamañoCasilla);
        tablaPaleta.row();
        tablaPaleta.add(new Image(new Texture("paleta/btn_limpiar.png"))).colspan(2);
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
    
}
