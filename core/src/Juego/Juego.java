package Juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import guerra.aeronaves.GuerraAeronaves;

public class Juego extends Task{
    
    public Juego(Stage stage, int matrizMapa[][]) {
        Image fondo = new Image(new SpriteDrawable(new Sprite(new Texture(
                Gdx.files.internal("cielo1.png")))));
        fondo.setSize(GuerraAeronaves.getAnchoVentana(),GuerraAeronaves.getAltoVentana());
        fondo.setZIndex(GuerraAeronaves.INDICE_FONDO);
        stage.addActor(fondo);
        
        Avion rojo = new Avion(new SpriteDrawable(new Sprite(new Texture(
                Gdx.files.internal("avion_rojo.png")))));
        rojo.setPosition(GuerraAeronaves.getAnchoVentana() / 2, GuerraAeronaves.getAltoVentana() / 2);
        rojo.setZIndex(GuerraAeronaves.INDICE_MEDIO);
        stage.addActor(rojo);
        
    }
    
    public void iniciar() {
        Timer timer = new Timer();
        timer.scheduleTask(this, 0, GuerraAeronaves.VELOCIDAD);
    }

    @Override
    public void run() {
        System.out.println("Holaaaaaa");
    }
    
}
