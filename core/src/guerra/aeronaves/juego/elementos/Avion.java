package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public abstract class Avion extends Elemento {
    private Direccion direccionActual;
    private Direccion proximaDireccion;
    private Direccion direccionInicial;
    
    public Avion(String rutaSprite, Vector2 posInicial, Direccion dir) {
        super(rutaSprite, GuerraAeronaves.ID_AVION_AZUL, posInicial, GuerraAeronaves.VIDA_AVION);
        this.direccionActual = dir;
        proximaDireccion = this.direccionActual;
        direccionInicial = this.direccionActual;
    }

    @Override
    public final void colocarEnPosicionInicial() {
        direccionActual = direccionInicial;
        proximaDireccion = direccionActual;
        setDireccion(direccionActual);
        super.colocarEnPosicionInicial();
    }
    
    private static float direccionARotacion(Direccion d) {
        switch (d) {
            case ARRIBA:
                return 0;
            case ABAJO:
                return 180;
            case DERECHA:
                return 270;
            default:
                return 90;
        }                
    }
    
    public void setDireccionInicial(Direccion d) {
        direccionInicial = d;
    }
    
    public Direccion getDireccionInicial() {
        return direccionInicial;
    }
    
    public void setDireccion(Direccion d) {
        direccionActual = d;
        setOrigin(getWidth()/2, getHeight()/2);
        setRotation(direccionARotacion(direccionActual));
    }
    
    public Direccion getDireccion() {
        return direccionActual;
    }
    
    public void setProximaDireccion(Direccion d) {
        proximaDireccion = d;
    }
    
    public Direccion getProximaDireccion() {
        return proximaDireccion;
    }
    
}
