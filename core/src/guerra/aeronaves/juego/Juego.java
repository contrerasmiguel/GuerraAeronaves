package guerra.aeronaves.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Juego extends Task {
    private final Avion rojo;
    private final ArrayList<Elemento> elementos;
    
    public Juego(Stage stage, int matrizMapa[][]) {
        Image fondo = new Image(new SpriteDrawable(new Sprite(new Texture(
                Gdx.files.internal("cielo1.png")))));
        fondo.setSize(GuerraAeronaves.getAnchoVentana(),GuerraAeronaves.getAltoVentana());
        
        fondo.setZIndex(GuerraAeronaves.INDICE_FONDO);
        stage.addActor(fondo);
        
        elementos = new ArrayList<Elemento>();
        Vector2 posInicialRojo = new Vector2(obtenerCentroCasillas().get(0).x
                ,obtenerCentroCasillas().get(0).y);
        
        rojo = new Avion(new SpriteDrawable(new Sprite(new Texture(
                Gdx.files.internal("avion_rojo.png")))), GuerraAeronaves.ID_AVION_ROJO
                , posInicialRojo, Direccion.DERECHA);
        
        rojo.setZIndex(GuerraAeronaves.INDICE_MEDIO);
        stage.addActor(rojo); 
    }
    
    public void iniciar() {
        new Timer().scheduleTask(this, 0, GuerraAeronaves.TIEMPO_RELOJ);
    }

    @Override
    public void run() {
        if (!rojo.isDestruido()) {
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

            if (colisiono(rojo)) {
                destruirAeronave(rojo);
                crearExplosion(rojo, GuerraAeronaves.TIEMPO_EXPLOSION);
                
                new Timer().scheduleTask(new Task() {
                    @Override
                    public void run() {
                        rojo.colocarEnPosicionInicial();
                        rojo.setDestruido(false);
                        rojo.setVisible(true);
                    }
                }, GuerraAeronaves.TIEMPO_REAPARICION, 0, 0);
            }
            else {
                rojo.mover();
            }            
        }
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
        return centro.x == x && centro.y == y;
    }
    
    private boolean colisiono(Avion a) {
        ArrayList<Vector2> centroObjetosSolidos = obtenerCentroObjetosSolidos();
        
        // Determinar si colisionó con el borde del mapa
        if (a.getX() < 0 || a.getX() >= GuerraAeronaves.getAnchoVentana()
                || a.getY() < 0 || a.getY() > GuerraAeronaves.getAltoVentana()) {
            return true;
        }
        
        // Determinar si colisionó con otro objeto sólido 
        else {
            for (Vector2 centroObjetoSolido : centroObjetosSolidos) {
                if (centroObjetoSolido.x == a.getX() && centroObjetoSolido.y == a.getY())
                    return true;
            }            
        }
      
        return false;
    }
    
    private ArrayList<Vector2> obtenerCentroObjetosSolidos() {
        ArrayList<Vector2> centroObjetosSolidos = new ArrayList<Vector2>();
        
        for (Elemento elemento : elementos) {
            if (esObjetoSolido(elemento))
                centroObjetosSolidos.add(new Vector2(elemento.getX(), elemento.getY()));
        }
        
        return centroObjetosSolidos;
    }
    
    private boolean esObjetoSolido(Elemento elemento) {
        return elemento.getId() == GuerraAeronaves.ID_AVION_AZUL 
                || elemento.getId() == GuerraAeronaves.ID_AVION_ROJO
                || elemento.getId() == GuerraAeronaves.ID_EDIFICIO
                || elemento.getId() == GuerraAeronaves.ID_MONTANA;
    }
    
    private void destruirAeronave(Avion a) {
        a.setDestruido(true);
    }
    
    private void crearExplosion(final Elemento e, float tiempo) {
        final float tiempoSprite = tiempo / 6;
        final ArrayDeque<String> rutaExplosiones = new ArrayDeque<String>(
                GuerraAeronaves.RUTA_EXPLOSIONES);
        final Drawable spriteInicial = e.getDrawable();
        
        new Timer().scheduleTask(new Task() {
            @Override
            public void run() {
                if (!rutaExplosiones.isEmpty()) {
                    e.setDrawable(new SpriteDrawable(new Sprite(new Texture(
                            Gdx.files.internal(rutaExplosiones.pop())))));
                }
                else {
                    e.setVisible(false);
                    e.setDrawable(spriteInicial);
                }
            }
        }, 0, tiempoSprite, GuerraAeronaves.RUTA_EXPLOSIONES.size() + 1);
    }
    
}
