package guerra.aeronaves.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;
import java.util.ArrayList;

public class Juego extends Task{
    private Avion rojo;
    
    public Juego(Stage stage, int matrizMapa[][]) {
        Image fondo = new Image(new SpriteDrawable(new Sprite(new Texture(
                Gdx.files.internal("cielo1.png")))));
        fondo.setSize(GuerraAeronaves.getAnchoVentana(),GuerraAeronaves.getAltoVentana());
        fondo.setZIndex(GuerraAeronaves.INDICE_FONDO);
        stage.addActor(fondo);
        
        rojo = new Avion(new SpriteDrawable(new Sprite(new Texture(
                Gdx.files.internal("avion_rojo.png")))),Direccion.DERECHA);
        rojo.setPosition(obtenerCentroCasillas().get(0).x,obtenerCentroCasillas().get(0).y);
        rojo.setZIndex(GuerraAeronaves.INDICE_MEDIO);
        stage.addActor(rojo);
        
    }
    
    public void iniciar() {
        Timer relojJuego = new Timer();
        relojJuego.scheduleTask(this, 0, GuerraAeronaves.VELOCIDAD);
    }

    @Override
    public void run() {
        if(estaCentroCasilla(rojo)) {
            rojo.actualizarDireccion();
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            rojo.cambiarDireccion(Direccion.ARRIBA);
        } else if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            rojo.cambiarDireccion(Direccion.ABAJO);
        } else if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            rojo.cambiarDireccion(Direccion.IZQUIERDA);
         } else if(Gdx.input.isKeyPressed(Keys.RIGHT))
             rojo.cambiarDireccion(Direccion.DERECHA);
        rojo.actualizar();
    }
    
    private boolean estaCentroCasilla(Avion avior) {
        ArrayList<Vector2> centros = obtenerCentroCasillas();
        for (Vector2 centro : centros) {
            if(estaEnElCentro(avior.getX(), avior.getY(), centro)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Vector2> obtenerCentroCasillas() {
        ArrayList<Vector2> centros = new ArrayList<Vector2>();
        for (int i = 0; i < GuerraAeronaves.NUM_FILAS; i++) {
            for (int j = 0; j < GuerraAeronaves.NUM_COLUMNAS; j++) {
                centros.add(new Vector2(j*GuerraAeronaves.TAMANO_CASILLA,
                i*GuerraAeronaves.TAMANO_CASILLA));
            }
        }
        return centros;
    }
    
    private boolean estaEnElCentro(float x, float y, Vector2 centro) {
        if(centro.x == x && centro.y == y) return true;
        return false;
    }
    
}
