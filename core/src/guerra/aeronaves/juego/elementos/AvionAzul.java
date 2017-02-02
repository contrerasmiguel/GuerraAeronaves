package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class AvionAzul extends Elemento {
    
    private Direccion dir;
    private Direccion proxDir;
    private boolean destruido;
    private Direccion dirInicial;
    
    public AvionAzul(Vector2 posInicial, Direccion dir) {
        super("avion_azul.png", GuerraAeronaves.ID_AVION_AZUL, posInicial);
        destruido = false;
        this.dir = dir;
        proxDir = this.dir;
        dirInicial = this.dir;
        colocarEnPosicionInicial();
        setOrigin(getWidth()/2, getHeight()/2);
    }

    public void mover() {
        actualizarRotacion();
        actualizarPosicion();
    }

    public void actualizarDireccion() {
        dir = proxDir;
    }
    
    public void cambiarDireccion(Direccion d) {
        if(d == Direccion.ARRIBA && dir != Direccion.ABAJO || d == Direccion.DERECHA && dir != Direccion.IZQUIERDA
                || d == Direccion.ABAJO && dir != Direccion.ARRIBA || d == Direccion.IZQUIERDA && dir != Direccion.DERECHA) {
            proxDir = d;
        }
    }
    
    public Direccion obtenerDireccion() {
        return dir;
    }

    public boolean isDestruido() {
        return destruido;
    }

    public void setDestruido(boolean destruido) {
        this.destruido = destruido;
    }

    @Override
    public final void colocarEnPosicionInicial() {
        dir = dirInicial;
        proxDir = dir;
        actualizarRotacion();
        super.colocarEnPosicionInicial();
    }
    
    private void actualizarRotacion() {
        switch (dir) {
            case ARRIBA:
                setRotation(0);
                break;
            case ABAJO:
                setRotation(180);
                break;
            case DERECHA:
                setRotation(270);
                break;
            default:
                setRotation(90);
                break;
        }        
    }
    
    private void actualizarPosicion() {
        switch (dir) {
            case ARRIBA:
                moveBy(0, GuerraAeronaves.VELOCIDAD_AVION);
                break;
            case ABAJO:
                moveBy(0, -GuerraAeronaves.VELOCIDAD_AVION);
                break;
            case DERECHA:
                moveBy(GuerraAeronaves.VELOCIDAD_AVION, 0);
                break;
            default:
                moveBy(-GuerraAeronaves.VELOCIDAD_AVION, 0);
                break;
        }           
    }

    public Direccion getDirInicial() {
        return dirInicial;
    }

    public void setDirInicial(Direccion dirInicial) {
        this.dirInicial = dirInicial;
    }

    @Override
    public boolean esColisionable() {
        return true;
    }
    
}
