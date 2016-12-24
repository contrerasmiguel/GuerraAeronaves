package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import guerra.aeronaves.*;

public class ScreenEditorNuevo implements Screen{
    
    private Grid pantalla;
    
    private OrthographicCamera cam;
    
    private Music music;
    
    GuerraAeronaves game;
    
    private ShapeRenderer render;
    private mapGrid grid;
    
    private jugador rojo;
    
    public ScreenEditorNuevo(GuerraAeronaves game) {
        this.game = game;
        cam = new OrthographicCamera(game.anchuraPantalla, game.anchuraPantalla);
        cam.setToOrtho(true, game.anchuraPantalla, game.alturaPantalla);
        cam.update();
        pantalla = new Grid();
        
        render = new ShapeRenderer();
        render.setAutoShapeType(true);
        grid = new mapGrid(20,15);
 
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
        
        render.begin();
        grid.render(render);
        render.end();
    }

    @Override
    public void resize(int i, int i1) {}

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
