package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public abstract class Avion extends Elemento {
    private Direccion direccion;
    private Direccion proximaDireccion;
    private Direccion direccionInicial;
    private int municiones;
    private int gasolina;
    
    public Avion(String rutaSprite, Vector2 posInicial, Direccion dir) {
        super(rutaSprite, GuerraAeronaves.ID_AVION_AZUL, posInicial, GuerraAeronaves.VIDA_AVION);
        this.direccion = dir;
        proximaDireccion = this.direccion;
        direccionInicial = this.direccion;
        municiones = GuerraAeronaves.MUNICIONES_AVION;
        gasolina = GuerraAeronaves.GASOLINA_AVION;
    }

    @Override
    public final void colocarEnPosicionInicial() {
        direccion = direccionInicial;
        proximaDireccion = direccion;
        setDireccion(direccion);
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
        direccion = d;
        setOrigin(getWidth()/2, getHeight()/2);
        setRotation(direccionARotacion(direccion));
    }
    
    public Direccion getDireccion() {
        return direccion;
    }
    
    public void setProximaDireccion(Direccion d) {
        proximaDireccion = d;
    }
    
    public Direccion getProximaDireccion() {
        return proximaDireccion;
    }

    public int getMuniciones() {
        return municiones;
    }

    public void setMuniciones(int municiones) {
        this.municiones = municiones;
    }

    public int getGasolina() {
        return gasolina;
    }

    public void setGasolina(int gasolina) {
        this.gasolina = gasolina;
    }
    
}
