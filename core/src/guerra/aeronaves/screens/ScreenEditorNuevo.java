package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.utils.viewport.*;
import guerra.aeronaves.*;

public class ScreenEditorNuevo implements Screen{
    
    private Grid pantalla;
    private ScreenViewport viewport;
    private Camera cam;
    
    private Music music;
    
    guerraAeronaves game;
    
    public ScreenEditorNuevo(guerraAeronaves game) {
        this.game = game;
        cam = new OrthographicCamera();
        viewport = new ScreenViewport(cam);
        resize(game.anchuraPantalla + (game.tamañoCasilla*2),game.alturaPantalla);
        pantalla = new Grid();
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