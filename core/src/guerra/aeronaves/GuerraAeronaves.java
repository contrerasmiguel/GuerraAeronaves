package guerra.aeronaves;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import guerra.aeronaves.screens.*;

public class GuerraAeronaves extends Game {
    
    public SpriteBatch batch;
    
    private ScreenEditorNuevo sc_editor;
    
    private Music music_menu, music_edicion, music_juego;
    
    public static final float VELOCIDAD = 60;
    public static final int ALTURA_BOTON = 82;
    public static final int ANCHO_BOTON = 284;
    public static final int TAMANO_CASILLA = 46;
    public static final int TAMANO_CASILLA_EDITOR = 46;
    public static final int NUM_COLUMNAS = 19;
    public static final int NUM_FILAS = 14;
    public static final int NUM_COLUMNAS_PALETA = 2;
    public static final int NUM_FILAS_PALETA = NUM_FILAS;
    
    @Override
    public void create () {
        batch = new SpriteBatch();

        music_menu = Gdx.audio.newMusic(Gdx.files.internal("sonidos/musica_menu.mp3"));
        music_edicion = Gdx.audio.newMusic(Gdx.files.internal("sonidos/musica_edicion.mp3"));
        music_juego = Gdx.audio.newMusic(Gdx.files.internal("sonidos/musica_juego.mp3"));

        setScreenMenuPrincipal();
    }

    @Override
    public void render () {
        super.render();
    }

    @Override
    public void dispose () {
        super.dispose();
    }

    public void setScreenMenuPrincipal() {
        setScreen(new ScreenMenuPrincipal(this));
        setMusica(music_menu);
    }
    public void setScreenJuego() {
        setScreen(new ScreenJuego(this));
        setMusica(music_juego);
    }
    public void setScreenMenuEditar() {
        setScreen(new ScreenMenuEditar(this));
        setMusica(music_menu);
    }
    public void setScreenEditor() {
        setScreen(new ScreenExploradorArchivos(this));
        setMusica(music_edicion);
    }
    public void setScreenEditorNuevo() {
        sc_editor = new ScreenEditorNuevo(this);
        setScreen(sc_editor);
        setMusica(music_edicion);
    }
    
    public ScreenEditorNuevo getScreenEditorNuevo() {
        return sc_editor;
    }

    public void setMusica(Music m) {
        m.setVolume(0.1f);
        m.setLooping(true);
        if(m.equals(music_menu)) {
            music_edicion.stop();
            music_juego.stop();
        } else if (m.equals(music_edicion)) {
            music_menu.stop();
            music_juego.stop();
        } else {
            music_menu.stop();
            music_edicion.stop();
        }
        if(!(m.equals(music_menu) && music_menu.isPlaying())) {
            m.play();
        }
    }
    
    public static final int getAnchoVentana() {
        return NUM_COLUMNAS * TAMANO_CASILLA;
    }
    
    public static final int getAltoVentana() {
        return NUM_FILAS * TAMANO_CASILLA;
    }
    
    public static final int getNumColumnasEditor() {
        return NUM_COLUMNAS + NUM_COLUMNAS_PALETA;
    }
    
    public static final int getNumFilasEditor() {
        return NUM_FILAS;
    }
    
    public static final int getAnchoVentanaEditor() {
        return getNumColumnasEditor() * TAMANO_CASILLA_EDITOR;
    }
    
    public static final int getAltoVentanaEditor() {
        return getNumFilasEditor() * TAMANO_CASILLA_EDITOR + 1;
    }    
    
}
