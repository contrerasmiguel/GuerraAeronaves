package guerra.aeronaves.juego;

import guerra.aeronaves.juego.elementos.Elemento;
import guerra.aeronaves.juego.elementos.AvionRojo;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
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
import guerra.aeronaves.Ganador;
import guerra.aeronaves.GuerraAeronaves;
import guerra.aeronaves.juego.elementos.Avion;
import guerra.aeronaves.juego.elementos.AvionAzul;
import guerra.aeronaves.juego.elementos.Edificio;
import guerra.aeronaves.juego.elementos.EstacionGasolina;
import guerra.aeronaves.juego.elementos.EstacionGasolinaAzul;
import guerra.aeronaves.juego.elementos.EstacionGasolinaRojo;
import guerra.aeronaves.juego.elementos.EstacionMunicion;
import guerra.aeronaves.juego.elementos.EstacionMunicionAzul;
import guerra.aeronaves.juego.elementos.EstacionMunicionRojo;
import guerra.aeronaves.juego.elementos.Montana;
import guerra.aeronaves.juego.elementos.Nube;
import guerra.aeronaves.juego.elementos.PickupGasolina;
import guerra.aeronaves.juego.elementos.PickupMunicion;
import guerra.aeronaves.juego.elementos.PickupVida;
import guerra.aeronaves.juego.elementos.PowerupMunicion;
import guerra.aeronaves.juego.elementos.PowerupVida;
import guerra.aeronaves.juego.elementos.Proyectil;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Juego extends Task {
    
    private final Stage stage;
    private final ArrayList<Elemento> elementos;
    private final ArrayList<Vector2> centroCasillas;
    
    private final AvionAzul avionAzul;
    private final AvionRojo avionRojo;
    
    private final Sound sonidoExplosion;
    private JuegoListener juegoListener;
    
    private final Timer timer;
    
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
        
        sonidoExplosion = Gdx.audio.newSound(Gdx.files.internal("sonidos/snd_explosion.wav"));
        
        agregarElementos(stage, elementos);
        
        stage.addActor(fondo);
        
        timer = new Timer();
    }
    
    // Inicia el reloj del juego.
    public void iniciar() {
        timer.scheduleTask(this, 0, GuerraAeronaves.TIEMPO_RELOJ);
    }

    // Reloj (se ejecuta cada GuerraAeronaves.TIEMPO_RELOJ)
    @Override
    public void run() {
        actualizarMovimientoAvion(avionAzul, Keys.W, Keys.S, Keys.A, Keys.D, Keys.SPACE);
        actualizarMovimientoAvion(avionRojo, Keys.UP, Keys.DOWN, Keys.LEFT, Keys.RIGHT, Keys.CONTROL_RIGHT);
        detectarColisiones(elementos);
    }
    
    // Determina si un elemento está centrado en una casilla.
    private boolean estaCentroCasilla(Elemento e) {
        ArrayList<Vector2> centros = centroCasillas;
        
        for (Vector2 centro : centros) {
            if(estaEnElCentro(e.getX(), e.getY(), centro)) {
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
    
    // Función auxiliar que determina si un punto (posiblemente correspondiente 
    // a la posición de un elemento) está posicionado en la esquina superior 
    // izquierda de una casilla.
    private boolean estaEnElCentro(float x, float y, Vector2 centro) {
        return centro.x == x && centro.y == y;
    }
    
    private boolean colisionoConPared(Elemento e) {
        return e.getX() < 0 || e.getX() > stage.getWidth() - GuerraAeronaves
                .calcularTamañoCasilla(stage.getWidth(), stage.getHeight())
                || e.getY() < 0 || e.getY() > stage.getHeight() 
                - GuerraAeronaves.calcularTamañoCasilla(stage.getWidth(), stage.getHeight());
    }
    
    // Determinar si el elemento colisión con otro elemento o con el borde del 
    // mapa
    private Elemento buscarElementoColisionado(Elemento e) {       
        for (Elemento ec : elementos) {
            if (e != ec && e.getX() == ec.getX() && e.getY() == ec.getY()) {
                return ec;
            }
        }
        return null;
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
                    e.colocarEnPosicionInicial();
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
        for (int i=0;i<elementos.size();i++) {
            if(elementos.get(i) instanceof Edificio || elementos.get(i) instanceof Montana 
                    || elementos.get(i) instanceof EstacionGasolinaAzul || elementos.get(i) instanceof EstacionGasolinaRojo
                    || elementos.get(i) instanceof EstacionMunicionAzul || elementos.get(i) instanceof EstacionMunicionRojo
                    || elementos.get(i) instanceof PickupMunicion || elementos.get(i) instanceof PickupVida
                    || elementos.get(i) instanceof PickupGasolina || elementos.get(i) instanceof PowerupVida
                    || elementos.get(i) instanceof PowerupMunicion) {
                stage.addActor(elementos.get(i));
            }
        }
        for (int i=0;i<elementos.size();i++) {
            if(elementos.get(i) instanceof AvionAzul || elementos.get(i) instanceof AvionRojo) {
                stage.addActor(elementos.get(i));
            }
        }
        for (int i=0;i<elementos.size();i++) {
            if(elementos.get(i) instanceof Nube) {
                stage.addActor(elementos.get(i));
            }
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
        })
        .findFirst().orElseGet(new Supplier<Elemento>() {
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

    // Actualiza las propiedades del avión en función de las teclas que 
    // presionó el usuario y el estado actual del juego.
    private void actualizarMovimientoAvion(final Avion avion, int TECLA_ARRIBA, int TECLA_ABAJO
            , int TECLA_IZQUIERDA, int TECLA_DERECHA, int TECLA_DISPARAR) {
        if (avion != null && avion.getVida() > 0) {
            if(Gdx.input.isKeyPressed(TECLA_ARRIBA))
                actualizarDireccionAvion(avion, Direccion.ARRIBA);
            
            else if(Gdx.input.isKeyPressed(TECLA_ABAJO))
                actualizarDireccionAvion(avion, Direccion.ABAJO);
            
            else if(Gdx.input.isKeyPressed(TECLA_IZQUIERDA))
                actualizarDireccionAvion(avion, Direccion.IZQUIERDA);
            
            else if(Gdx.input.isKeyPressed(TECLA_DERECHA))
                actualizarDireccionAvion(avion, Direccion.DERECHA);
            
            if (estaCentroCasilla(avion)) {
                avion.setDireccion(avion.getProximaDireccion());
            }
            
            switch (avion.getDireccion()) {
                case ARRIBA:
                    avion.moveBy(0, GuerraAeronaves.VELOCIDAD_AVION);
                    break;
                case DERECHA:
                    avion.moveBy(GuerraAeronaves.VELOCIDAD_AVION, 0);
                    break;
                case ABAJO:
                    avion.moveBy(0, -GuerraAeronaves.VELOCIDAD_AVION);
                    break;
                default:
                    avion.moveBy(-GuerraAeronaves.VELOCIDAD_AVION, 0);
            }             
        }
    }
    
    // Verifica si la dirección es válida. En caso de serlo, es fijada como
    // próxima dirección del avión.
    private void actualizarDireccionAvion(Avion a, Direccion d) {
        if(d == Direccion.ARRIBA && a.getDireccion() != Direccion.ABAJO 
                || d == Direccion.DERECHA && a.getDireccion() != Direccion.IZQUIERDA
                || d == Direccion.ABAJO && a.getDireccion() != Direccion.ARRIBA 
                || d == Direccion.IZQUIERDA && a.getDireccion() != Direccion.DERECHA) {
            a.setProximaDireccion(d);
        }        
    }
    
    // Remplaza el sprite del elemento por sprites de explosión durante un 
    // tiempo en segundos.
    private void crearExplosionEnElemento(final Elemento e, float tiempo) {
        final float tiempoSprite = tiempo / 6;
        final ArrayDeque<String> rutaExplosiones = new ArrayDeque<String>(
                GuerraAeronaves.RUTA_EXPLOSIONES);
        final Drawable spriteInicial = e.getDrawable();
        
        sonidoExplosion.play(0.2f);
        new Timer().scheduleTask(new Timer.Task() {
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

    public void setJuegoListener(JuegoListener jl) {
        juegoListener = jl;
    }

    // Realiza las tareas antes de terminar el juego y dispara el evento 
    // del listener correspondiente.
    private void terminar(final Avion a) {
        timer.stop();
        
        new Timer().scheduleTask(new Task() {
            @Override
            public void run() {
                if (juegoListener != null) {
                    if (a instanceof AvionAzul) {
                        juegoListener.alTerminar(Ganador.ROJO);
                    }
                    else {
                        juegoListener.alTerminar(Ganador.AZUL);
                    }
                }                
            }
        }, GuerraAeronaves.TIEMPO_FINALIZACION, 0, 0);
    }

    // Recorre cada elemento, buscando si ha colisionado con otro elemento o una 
    // pared.
    private void detectarColisiones(ArrayList<Elemento> elementos) {
        for (Elemento e : elementos) {
            if (e.getVida() > 0) {
                if (colisionoConPared(e)) {
                    alColisionarConPared(e);
                }
                else {
                    Elemento elementoColisionado = buscarElementoColisionado(e);
                    
                    if (elementoColisionado != null && elementoColisionado.getVida() > 0) {
                        alColisionarElementos(e, elementoColisionado);
                    }
                }
            }
        }
    }

    // Llamado cuando un elemento choca con una pared.
    private void alColisionarConPared(Elemento e) {
        if (e instanceof Avion) {
            crearExplosionEnElemento(e, GuerraAeronaves.TIEMPO_EXPLOSION);
            e.setVida(0);
            terminar((Avion)e);
        }
        else if (e instanceof Nube) {
            
        }
    }

    // Llamado cuando un elemento choca con otro elemento.
    private void alColisionarElementos(Elemento e1, Elemento e2) {
        if (e1 instanceof Proyectil && recibeDañoProyectil(e2) 
                || recibeDañoProyectil(e1) && e2 instanceof Proyectil
                || esElementoSolido(e1) && esElementoSolido(e2)) {
            float daño = Math.min(e1.getVida(), e2.getVida());
            intentarDestruir(e1, daño);
            intentarDestruir(e2, daño);
        }
    }

    // Determina si un elemento puede recibir daño de un proyectil.
    private boolean recibeDañoProyectil(Elemento e) {
        return e instanceof Avion || e instanceof Edificio 
                || e instanceof EstacionGasolina || e instanceof EstacionMunicion 
                || e instanceof Montana || e instanceof Proyectil;
    }
    
    // Quita vida al elemento y crea una explosión si la vida llega a cero.
    private void intentarDestruir(Elemento e, float daño) {
        e.setVida(e.getVida() - daño);
        if (e.getVida() <= 0) {
            crearExplosionEnElemento(e, GuerraAeronaves.TIEMPO_EXPLOSION);
            terminar((Avion)e);
        }
    }
    
    // Determina si un elemento es destruido al colisionar con otro elemento.
    private boolean esElementoSolido(Elemento e) {
        return e instanceof Avion || e instanceof Edificio || e instanceof Montana 
                || e instanceof Proyectil;
    }
    
}
