package guerra.aeronaves.juego.elementos;

import com.badlogic.gdx.math.Vector2;
import guerra.aeronaves.Direccion;
import guerra.aeronaves.GuerraAeronaves;

public abstract class Avion extends Elemento {
    private int municiones;
    private int gasolina;
    
    public Avion(String rutaSprite, Vector2 posicion, Direccion direccion) {
        super(rutaSprite, GuerraAeronaves.ID_AVION_AZUL, posicion, direccion, GuerraAeronaves.VIDA_AVION);
        this.direccion = direccion;
        proximaDireccion = this.direccion;
        municiones = GuerraAeronaves.MUNICIONES_AVION;
        gasolina = GuerraAeronaves.GASOLINA_AVION;
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
