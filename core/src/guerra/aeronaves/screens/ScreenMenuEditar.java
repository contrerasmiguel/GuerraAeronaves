package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import guerra.aeronaves.guerraAeronaves;

public class ScreenMenuEditar implements Screen{
    
    guerraAeronaves game;
    
    Texture fondo_menu;
    Texture btn_crear;
    Texture btn_cargar;
    Texture btn_regresar;
    
    Sound beep;
    
    public ScreenMenuEditar(guerraAeronaves game) {
        this.game = game;
        
        fondo_menu = new Texture(Gdx.files.internal("FondoMenu01.png"));
        btn_crear = new Texture(Gdx.files.internal("boton_crear_mapa.png"));
        btn_cargar = new Texture(Gdx.files.internal("boton_cargar_mapa.png"));
        btn_regresar = new Texture(Gdx.files.internal("boton_regresar.png"));
        
        
        beep = Gdx.audio.newSound(Gdx.files.internal("sonidos/snd_select.wav"));
    }

    @Override
    public void show() {}

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            
        game.batch.begin();
        
        game.batch.draw(fondo_menu, 0, 0);
        game.batch.draw(btn_crear, ((game.anchuraPantalla/2) - (game.btnAnchura/2)), 240);
        game.batch.draw(btn_cargar, ((game.anchuraPantalla/2) - (game.btnAnchura/2)), 140);
        game.batch.draw(btn_regresar, ((game.anchuraPantalla/2) - (game.btnAnchura/2)), 40);
        
        if(Gdx.input.getX() > ((game.anchuraPantalla/2) - (game.btnAnchura/2)) && Gdx.input.getX() < ((game.anchuraPantalla/2) + (game.btnAnchura/2))
        && (game.alturaPantalla - Gdx.input.getY()) > 240 && (game.alturaPantalla - Gdx.input.getY()) < (240+game.btnAltura)){
            //System.out.println("¡Estas sobre el boton Crear!");
            game.batch.draw(btn_crear, ((game.anchuraPantalla/2) - (game.btnAnchura/2)), 242);
            if(Gdx.input.isTouched()) {
                //System.out.println("¡Presionaste el boton Crear!");
                beep.play(0.2f);
                game.setScreenEditorNuevo();
            }         
        }
        
        if(Gdx.input.getX() > ((game.anchuraPantalla/2) - (game.btnAnchura/2)) && Gdx.input.getX() < ((game.anchuraPantalla/2) + (game.btnAnchura/2))
        && (game.alturaPantalla - Gdx.input.getY()) > 140 && (game.alturaPantalla - Gdx.input.getY()) < (140+game.btnAltura)){
            //System.out.println("¡Estas sobre el boton Cargar!");
            game.batch.draw(btn_cargar, ((game.anchuraPantalla/2) - (game.btnAnchura/2)), 142);
            if(Gdx.input.isTouched()) {
                System.out.println("¡Presionaste el boton Cargar!");
                //Aqui te debe abrir el explorador de Windows para seleccionar el mapa que se va a leer
                beep.play(0.2f);
                game.setScreenEditor();
            }         
        }
        
        if(Gdx.input.getX() > ((game.anchuraPantalla/2) - (game.btnAnchura/2)) && Gdx.input.getX() < ((game.anchuraPantalla/2) + (game.btnAnchura/2))
        && (game.alturaPantalla - Gdx.input.getY()) > 40 && (game.alturaPantalla - Gdx.input.getY()) < (40+game.btnAltura)){
            //System.out.println("¡Estas sobre el boton Regresar!");
            game.batch.draw(btn_regresar, ((game.anchuraPantalla/2) - (game.btnAnchura/2)), 42);
            if(Gdx.input.isTouched()) {
                beep.play(0.2f);
                game.setScreenMenuPrincipal();
                
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
        beep.dispose();
    }
    
}