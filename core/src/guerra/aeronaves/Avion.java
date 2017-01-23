package guerra.aeronaves;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Avion extends Elemento {
    
    private boolean esRojo;
    private int direccion;
    private int gasolina;
    private int municion;

    public Avion(int id, Image i, boolean v) {
        super(id, i, v);
        setVida(GuerraAeronaves.VIDA_INICIAL);
        gasolina = GuerraAeronaves.GASOLINA_INICIAL;
        municion = GuerraAeronaves.MUNICION_INICIAL;
        
        setHeight(i.getHeight());
        setWidth(i.getWidth());
    }

    public boolean isEsRojo() {
        return esRojo;
    }

    public void setEsRojo(boolean esRojo) {
        this.esRojo = esRojo;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public int getGasolina() {
        return gasolina;
    }

    public void setGasolina(int gasolina) {
        this.gasolina = gasolina;
    }

    public int getMunicion() {
        return municion;
    }

    public void setMunicion(int municion) {
        this.municion = municion;
    }
}