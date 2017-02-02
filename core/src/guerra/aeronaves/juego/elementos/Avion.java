package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public class Avion extends Elemento {
    
    private Direccion dir;
    private Direccion proxDir;
    private boolean destruido;
    private Vector2 posInicial;
    private Direccion dirInicial;
    
    public Avion(Drawable d, int id, Vector2 posInicial, Direccion dir) {
        super(d, id);
        destruido = false;
        this.dir = dir;
        proxDir = this.dir;
        this.posInicial = posInicial;
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

    public Vector2 getPosInicial() {
        return posInicial;
    }

    public void setPosInicial(Vector2 posInicial) {
        this.posInicial = posInicial;
    }

    public final void colocarEnPosicionInicial() {
        dir = dirInicial;
        proxDir = dir;
        actualizarRotacion();
        setPosition(posInicial.x, posInicial.y);
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
                setPosition(getX(),getY()+GuerraAeronaves.VELOCIDAD_AVION);
                break;
            case ABAJO:
                setPosition(getX(),getY()-GuerraAeronaves.VELOCIDAD_AVION);
                break;
            case DERECHA:
                setPosition(getX()+GuerraAeronaves.VELOCIDAD_AVION,getY());
                break;
            default:
                setPosition(getX()-GuerraAeronaves.VELOCIDAD_AVION,getY());
                break;
        }           
    }

    public Direccion getDirInicial() {
        return dirInicial;
    }

    public void setDirInicial(Direccion dirInicial) {
        this.dirInicial = dirInicial;
    }
    
}
