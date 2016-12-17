package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import guerra.aeronaves.guerraAeronaves;

public class ScreenMenuPrincipal implements Screen{
    
    guerraAeronaves game;
    
    Texture fondo_menu;
    Texture btn_jugar;
    Texture btn_editar;
    
    public ScreenMenuPrincipal(guerraAeronaves game) {
        this.game = game;
        
        fondo_menu = new Texture(Gdx.files.internal("FondoMenu01.png"));
        btn_jugar = new Texture(Gdx.files.internal("boton_jugar.png"));
        btn_editar = new Texture(Gdx.files.internal("boton_editar_mapa.png"));
        
    }

    @Override
    public void show() {}

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            
        game.batch.begin();
        
        game.batch.draw(fondo_menu, 0, 0);
        game.batch.draw(btn_jugar, ((game.anchuraPantalla/2) - (game.btnAnchura/2)), 220);
        game.batch.draw(btn_editar, ((game.anchuraPantalla/2) - (game.btnAnchura/2)), 80);
        
        if(Gdx.input.getX() > ((game.anchuraPantalla/2) - (game.btnAnchura/2)) && Gdx.input.getX() < ((game.anchuraPantalla/2) + (game.btnAnchura/2))
        && (game.alturaPantalla - Gdx.input.getY()) > 220 && (game.alturaPantalla - Gdx.input.getY()) < (220+game.btnAltura)){
            //System.out.println("¡Estas sobre el boton Jugar!");
            game.batch.draw(btn_jugar, ((game.anchuraPantalla/2) - (game.btnAnchura/2)), 222);
            if(Gdx.input.isTouched()) {
                game.setScreenJuego();
            }         
        }
        
        if(Gdx.input.getX() > ((game.anchuraPantalla/2) - (game.btnAnchura/2)) && Gdx.input.getX() < ((game.anchuraPantalla/2) + (game.btnAnchura/2))
        && (game.alturaPantalla - Gdx.input.getY()) > 80 && (game.alturaPantalla - Gdx.input.getY()) < (80+game.btnAltura)){
            //System.out.println("¡Estas sobre el boton Editar!");
            game.batch.draw(btn_editar, ((game.anchuraPantalla/2) - (game.btnAnchura/2)), 82);
            if(Gdx.input.isTouched()) {
                game.setScreenMenuEditar();
            }         
        }
            
        game.batch.end();
    }

    @Override
    public void resize(int i, int i1) {}

    @Override
    public void pause() {
    }

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        game.batch.dispose();
    }
    
}