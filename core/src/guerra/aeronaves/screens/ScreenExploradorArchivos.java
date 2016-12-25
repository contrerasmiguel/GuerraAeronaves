package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import guerra.aeronaves.FileChooser;
import guerra.aeronaves.FileChooser.ResultListener;
import guerra.aeronaves.GuerraAeronaves;
import java.io.File;
import java.io.FileFilter;

public class ScreenExploradorArchivos extends ScreenAdapter {

    private final Stage stage;
    
    public ScreenExploradorArchivos(final GuerraAeronaves guerraAeronaves) {
        stage = new Stage();  
        
        Skin skinDialogo = new Skin(Gdx.files.internal("skins/uiskin.json"));
        final FileChooser dialog = FileChooser.createPickDialog("Lista de Mapas"
                , skinDialogo, Gdx.files.internal("mapas"));
        dialog.setResultListener(new ResultListener() {
            @Override
            public boolean result(boolean success, FileHandle result) {
                if (success) {
                    // Aquí lo que sucede cuando se selecciona el archivo
                }
                else {
                    dialog.hide();
                    guerraAeronaves.setScreenMenuEditar();
                }
                return true;
            }
        });
        dialog.disableDirectoryBrowsing();
        dialog.setOkButtonText("Seleccionar");
        dialog.setCancelButtonText("Regresar");
        dialog.setFilter(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String path = pathname.getPath();
                return path.matches(".*(?:txt)");
            }
        });
        dialog.show(stage);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        super.show();
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