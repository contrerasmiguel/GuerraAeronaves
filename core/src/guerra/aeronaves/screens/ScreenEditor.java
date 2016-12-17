package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.*;
import guerra.aeronaves.*;
import guerra.aeronaves.FileChooser.ResultListener;
import java.io.File;
import java.io.FileFilter;

public class ScreenEditor implements Screen{
    
    private Grid pantalla;
    private ScreenViewport viewport;
    private Camera cam;
    
    Skin skin;
    
    guerraAeronaves game;
    
    public ScreenEditor(guerraAeronaves game) {
        this.game = game;
        skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
        cam = new OrthographicCamera();
        viewport = new ScreenViewport(cam);
        resize(game.anchuraPantalla + (game.tamañoCasilla*2),game.alturaPantalla);
        pantalla = new Grid();
        
        //Comienzo del FileChooser
        FileChooser dialog = FileChooser.createPickDialog("Add track", skin, Gdx.files.internal("mapas/"));
                dialog.setResultListener(new ResultListener() {
                    @Override
                    public boolean result(boolean success, FileHandle result) {
                        if(success){
                            // do stuff with result
                        }
                        return true;
                    }
                });
                dialog.disableDirectoryBrowsing();
                dialog.setOkButtonText("Add");
                dialog.setFilter(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        String path = pathname.getPath();
                        return path.matches(".*(?:ogg|mp3|wav)");
                    }
                });
                //¡¡¡¡ESTO DA ERROR!!!!!!!!!!!!!!!!!!!!!
                //dialog.show(stage);
        //Final del FileChooser
    }
    
    @Override
    public void show() {
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            
        game.batch.begin();
            
        for(int i=0;i<14;i++) {
            for(int j=0;j<19;j++) {
                game.batch.draw(pantalla.getCasilla(i, j).getTexture(), j * game.tamañoCasilla, i * game.tamañoCasilla);
            }
        }
        
        //System.out.println("X="+Gdx.input.getX()+", Y= "+Gdx.input.getY());
            
        game.batch.end();
    }

    @Override
    public void resize(int i, int i1) {
        Gdx.graphics.setWindowedMode(i, i1);
        viewport.update(game.anchuraPantalla, game.alturaPantalla);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        game.batch.dispose();
    }
    
}