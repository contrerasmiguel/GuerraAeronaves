package guerra.aeronaves.editor.paleta;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import guerra.aeronaves.editor.ElementoSeleccionable;
import guerra.aeronaves.editor.mapa.ElementoMapa;

public abstract class ElementoPaleta extends ElementoSeleccionable {
    
    protected final String rutaTexturaMapa;
    protected final int id;
    private final ShapeRenderer rectanguloSeleccion;
    private final float DISTANCIA_A_BORDE = 1.0f;
    private boolean seleccionado;
    
    public ElementoPaleta(String rutaTexturaPaleta, String rutaTexturaMapa, int id) {
        super(rutaTexturaPaleta);
        this.rutaTexturaMapa = rutaTexturaMapa;
        this.rectanguloSeleccion = new ShapeRenderer();
        seleccionado = false;
        this.id = id;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.end();
        if (seleccionado) {
            dibujarRectangulo(batch);
        }
        batch.begin();
    }
    
    private void dibujarRectangulo(Batch batch) {
        rectanguloSeleccion.setProjectionMatrix(batch.getProjectionMatrix());
        rectanguloSeleccion.begin(ShapeType.Line);
        rectanguloSeleccion.setColor(Color.WHITE);
        rectanguloSeleccion.rect(
                getX() + DISTANCIA_A_BORDE
                , getY() + DISTANCIA_A_BORDE
                , getWidth() - DISTANCIA_A_BORDE * 2
                , getHeight() - DISTANCIA_A_BORDE * 2);
        rectanguloSeleccion.end();        
    }
    
    public abstract ElementoMapa producirElementoMapa();
    
}
