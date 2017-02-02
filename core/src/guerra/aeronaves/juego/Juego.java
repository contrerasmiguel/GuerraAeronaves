package guerra.aeronaves.juego;

import guerra.aeronaves.juego.elementos.Elemento;
import guerra.aeronaves.juego.elementos.AvionRojo;
import com.badlogic.gdx.Gdx;
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
import guerra.aeronaves.juego.elementos.AvionAzul;
import guerra.aeronaves.juego.elementos.Edificio;
import guerra.aeronaves.juego.elementos.EstacionGasolinaAzul;
import guerra.aeronaves.juego.elementos.EstacionGasolinaRojo;
import guerra.aeronaves.juego.elementos.EstacionMunicionAzul;
import guerra.aeronaves.juego.elementos.EstacionMunicionRojo;
import guerra.aeronaves.juego.elementos.Montana;
import guerra.aeronaves.juego.elementos.Nube;
import guerra.aeronaves.juego.elementos.PickupGasolina;
import guerra.aeronaves.juego.elementos.PickupMunicion;
import guerra.aeronaves.juego.elementos.PickupVida;
import guerra.aeronaves.juego.elementos.PowerupMunicion;
import guerra.aeronaves.juego.elementos.PowerupVida;
import java.util.ArrayList;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

public class Juego extends Task {
    
    private final Stage stage;
    private final ArrayList<Elemento> elementos;
    private final ArrayList<Vector2> centroCasillas;
    private final ArrayList<Elemento> elementosColisionables;
    private final AvionAzul avionAzul;
    private final AvionRojo avionRojo;
    
    public Juego(Stage stage, int matrizMapa[][]) {
        this.stage = stage;
        
        Image fondo = new Image(new SpriteDrawable(new Sprite(new Texture(
                Gdx.files.internal("cielo1.png")))));
        fondo.setFillParent(true);
        
        fondo.setZIndex(GuerraAeronaves.INDICE_FONDO);
        stage.addActor(fondo);
        
        centroCasillas = obtenerCentroCasillas();
        elementos = crearElementosMapa(matrizMapa);
        
        avionAzul = buscarAvionAzul(elementos);
        avionRojo = buscarAvionRojo(elementos);
        
        elementosColisionables = buscarElementosColisionables(elementos);
        
        agregarElementos(stage, elementos);
        
        stage.addActor(fondo);
    }
    
    public void iniciar() {
        new Timer().scheduleTask(this, 0, GuerraAeronaves.TIEMPO_RELOJ);
    }

    @Override
    public void run() {
        if (avionAzul != null && !avionAzul.isDestruido()) {
            
        }
        
        if (avionRojo != null && !avionRojo.isDestruido()) {
            if(Gdx.input.isKeyPressed(Keys.UP))
                avionRojo.cambiarDireccion(Direccion.ARRIBA);
            
            else if(Gdx.input.isKeyPressed(Keys.DOWN))
                avionRojo.cambiarDireccion(Direccion.ABAJO);
            
            else if(Gdx.input.isKeyPressed(Keys.LEFT))
                avionRojo.cambiarDireccion(Direccion.IZQUIERDA);
            
            else if(Gdx.input.isKeyPressed(Keys.RIGHT))
                avionRojo.cambiarDireccion(Direccion.DERECHA);
            
            if (estaCentroCasilla(avionRojo)) {
                avionRojo.actualizarDireccion();
            }
            
            if (colisiono(avionRojo)) {
                avionRojo.setDestruido(true);
                avionRojo.crearExplosion(GuerraAeronaves.TIEMPO_EXPLOSION);
                
                new Timer().scheduleTask(new Task() {
                    @Override
                    public void run() {
                        avionRojo.colocarEnPosicionInicial();
                        avionRojo.setDestruido(false);
                        avionRojo.setVisible(true);
                    }
                }, GuerraAeronaves.TIEMPO_REAPARICION, 0, 0);                
            }
            else {
                avionRojo.mover();
            }
        }
    }
      
    private boolean estaCentroCasilla(AvionRojo avior) {
        ArrayList<Vector2> centros = centroCasillas;
        
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
                centros.add(new Vector2(j * GuerraAeronaves.calcularTamañoCasilla(stage.getWidth(), stage.getHeight()),
                i * GuerraAeronaves.calcularTamañoCasilla(stage.getWidth(), stage.getHeight())));
            }
        }
        return centros;
    }
    
    private boolean estaEnElCentro(float x, float y, Vector2 centro) {
        return centro.x == x && centro.y == y;
    }
    
    // Determinar si el elemento colisión con otro elemento o con el borde del 
    // mapa
    private boolean colisiono(AvionRojo a) {       
        // Determinar si colisionó con el borde del mapa
        if (a.getX() < 0 || a.getX() > stage.getWidth() - GuerraAeronaves
                .calcularTamañoCasilla(stage.getWidth(), stage.getHeight())
                || a.getY() < 0 || a.getY() > stage.getHeight() 
                - GuerraAeronaves.calcularTamañoCasilla(stage.getWidth(), stage.getHeight())) {
            return true;
        }
        
        // Determinar si colisionó con otro objeto sólido 
        else {
            for (Elemento e : elementosColisionables) {
                if (a != e && a.getX() == e.getX() && a.getY() == e.getY()) {
                    return true;
                }
            }          
        }
      
        return false;
    }
   
    // Método que convierte los ID de la matriz de elementos leidos del 
    // archivo de texto en objetos de tipo Elemento
    private ArrayList<Elemento> crearElementosMapa(int[][] matrizMapa) {
        ArrayList<Elemento> elementosMapa = new ArrayList<Elemento>();
        
        // Recorremos cada elemento de la matriz
        for (int i = 0; i < matrizMapa.length; ++i) {
            for (int j = 0; j < matrizMapa[0].length; ++j) {
                int indiceArregloCentros = (matrizMapa.length - 1 - i) * matrizMapa[0].length + j;
                
                Elemento e = crearElemento(matrizMapa[i][j], new Vector2(centroCasillas
                        .get(indiceArregloCentros).x, centroCasillas.get(indiceArregloCentros).y));
                
                if (e != null) {
                    if (e instanceof Nube) {
                        e.setZIndex(GuerraAeronaves.INDICE_ALTO);
                    }
                    else {
                        e.setZIndex(GuerraAeronaves.INDICE_MEDIO);
                    }
                    elementosMapa.add(e);                    
                }
            }
        }
        
        return elementosMapa;
    }

    // Método que recibe el ID de un tipo de elemento y una posición 
    // inicial y construye un elemento en base a ello.
    private Elemento crearElemento(int idElemento, Vector2 posInicial) {        
        switch (idElemento) {            
            case GuerraAeronaves.ID_AVION_AZUL:
                return new AvionAzul(posInicial, Direccion.DERECHA);
                
            case GuerraAeronaves.ID_AVION_ROJO:
                return new AvionRojo(posInicial, Direccion.IZQUIERDA); 
                
            case GuerraAeronaves.ID_EDIFICIO:
                return new Edificio(posInicial);
                
            case GuerraAeronaves.ID_ESTACION_GASOLINA_AZUL:
                return new EstacionGasolinaAzul(posInicial);
                
            case GuerraAeronaves.ID_ESTACION_GASOLINA_ROJO:
                return new EstacionGasolinaRojo(posInicial);
                
            case GuerraAeronaves.ID_ESTACION_MUNICION_AZUL:
                return new EstacionMunicionAzul(posInicial);
                
            case GuerraAeronaves.ID_ESTACION_MUNICION_ROJO:
                return new EstacionMunicionRojo(posInicial);
                
            case GuerraAeronaves.ID_MONTANA:
                return new Montana(posInicial);
                
            case GuerraAeronaves.ID_NUBE:
                return new Nube(posInicial);
                
            case GuerraAeronaves.ID_PICKUP_GASOLINA:
                return new PickupGasolina(posInicial);
                
            case GuerraAeronaves.ID_PICKUP_MUNICION:
                return new PickupMunicion(posInicial);
                
            case GuerraAeronaves.ID_PICKUP_VIDA:
                return new PickupVida(posInicial);
                
            case GuerraAeronaves.ID_POWERUP_MUNICION:
                return new PowerupMunicion(posInicial);
                
            case GuerraAeronaves.ID_POWERUP_VIDA:
                return new PowerupVida(posInicial);  
        }
        
        return null;
    }    
    
    // Agrega todos los elemento de un arreglo de elementos a un stage, tomando 
    // en cuenta que un elemento es un actor.
    private void agregarElementos(Stage stage, ArrayList<Elemento> elementos) {
        for (Elemento e : elementos) {
            stage.addActor(e);
        }
    }

    // Retorna el primer avión azul que consiga en un arreglo de elementos. 
    // Si no encuentra ninguno, devuelve null.
    private AvionAzul buscarAvionAzul(ArrayList<Elemento> elementos) {
        return (AvionAzul)elementos.stream().filter(new Predicate<Elemento>() {
            @Override
            public boolean test(Elemento e) {
                return e instanceof AvionAzul;
            }
        }).findFirst().orElseGet(new Supplier<Elemento>() {
            @Override
            public Elemento get() {
                return null;
            }
        });
    }

    // Retorna el primer avión rojo que consiga en un arreglo de elementos. 
    // Si no encuentra ninguno, devuelve null.    
    private AvionRojo buscarAvionRojo(ArrayList<Elemento> elementos) {
        return (AvionRojo)elementos.stream()
                .filter(new Predicate<Elemento>() {
                    @Override
                    public boolean test(Elemento e) {
                        return e instanceof AvionRojo;
                    }
                })
                .findFirst().orElseGet(new Supplier<Elemento>() {
                    @Override
                    public Elemento get() {
                        return null;
                    }
                });       
    }

    // Devuelve un arreglo con todos los elementos colisionables.
    private ArrayList<Elemento> buscarElementosColisionables(ArrayList<Elemento> elementos) {
        ArrayList<Elemento> ec = new ArrayList<Elemento>();
        
        for (Elemento e : elementos) {
            if (e.esColisionable())
                ec.add(e);
        }
        
        return ec;
    }

}
