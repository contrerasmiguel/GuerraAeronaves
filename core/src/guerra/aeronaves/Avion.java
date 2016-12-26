package guerra.aeronaves;

public class Avion extends Elemento {
    
    private boolean esRojo;
    private int direccion;
    private int gasolina;
    private int municion;

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