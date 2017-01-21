package guerra.aeronaves.editor.paleta;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import guerra.aeronaves.editor.ElementoSeleccionable;

public class BotonPaleta extends ElementoSeleccionable {

    private boolean seleccionado;
    private final ShapeRenderer rectanguloSeleccion;
    private final float DISTANCIA_A_BORDE = 1.0f;
    
    public BotonPaleta(String rutaTextura) {
        super(rutaTextura);
        seleccionado = false;
        this.rectanguloSeleccion = new ShapeRenderer();
    }

    public boolean getSeleccionado() {
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
        rectanguloSeleccion.begin(ShapeRenderer.ShapeType.Line);
        rectanguloSeleccion.setColor(Color.WHITE);
        rectanguloSeleccion.rect(
                getX() + DISTANCIA_A_BORDE
                , getY() + DISTANCIA_A_BORDE
                , getWidth() - DISTANCIA_A_BORDE * 2
                , getHeight() - DISTANCIA_A_BORDE * 2);
        rectanguloSeleccion.end();        
    }    
}
