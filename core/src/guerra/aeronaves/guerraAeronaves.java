package guerra.aeronaves;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import guerra.aeronaves.screens.*;

public class guerraAeronaves extends Game {
    
    public SpriteBatch batch;
    
    private Music music_menu, music_edicion, music_juego;
    
        public static final float velocidad = 60;
        public static final int alturaPantalla = 644;
        public static final int anchuraPantalla = 874;
        public static final int btnAltura = 82;
        public static final int btnAnchura = 284;
        public static final int tamañoCasilla = 46;
        public static final int tamañoCasillaEditor = 32;
        public static final int casillasH = 19;
        public static final int casillasV = 14;
	
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
            setScreen(new ScreenEditor(this));
            setMusica(music_edicion);
        }
        public void setScreenEditorNuevo() {
            setScreen(new ScreenEditorNuevo(this));
            setMusica(music_edicion);
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
}
