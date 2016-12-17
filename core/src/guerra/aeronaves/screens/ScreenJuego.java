package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import guerra.aeronaves.*;

public class ScreenJuego implements Screen{
    
    Texture img;
    Grid pantalla;
    
    private String filePath;
    
    guerraAeronaves game;
    
    public ScreenJuego(guerraAeronaves game) {
        this.game = game;
        pantalla = new Grid();
        filePath = "";
        
    }
    
    @Override
    public void show() {
        img = new Texture("badlogic.jpg");
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
            
        game.batch.end();
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
        img.dispose();
    }
    
    private void leerEntradas() {
        if(Gdx.input.isKeyPressed(Keys.W)) {
            
        }
        if(Gdx.input.isKeyPressed(Keys.S)) {
            
        }
        if(Gdx.input.isKeyPressed(Keys.D)) {
            
        }
        if(Gdx.input.isKeyPressed(Keys.A)) {
            
        }
    }
    
}
