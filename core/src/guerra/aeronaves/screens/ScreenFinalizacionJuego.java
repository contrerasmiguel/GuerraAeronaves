package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import guerra.aeronaves.Ganador;
import guerra.aeronaves.GuerraAeronaves;

public class ScreenFinalizacionJuego extends ScreenAdapter {

    private final Stage stage;

    public ScreenFinalizacionJuego(GuerraAeronaves guerraAeronaves, Ganador ganador) {
        stage = new Stage(new FitViewport(GuerraAeronaves.calcularTamañoCasilla(Gdx
                .graphics.getWidth(), Gdx.graphics.getHeight()) * GuerraAeronaves.NUM_COLUMNAS
                , GuerraAeronaves.calcularTamañoCasilla(Gdx.graphics.getWidth()
                        , Gdx.graphics.getHeight()) * GuerraAeronaves.NUM_FILAS));
        
        String rutaSprite = (ganador == Ganador.AZUL)
                ? "FondoGanadorAzul.png"
                : "FondoGanadorRojo.png";
        
        Image spriteGanador = new Image(new SpriteDrawable(new Sprite(new Texture(Gdx.files
                .internal(rutaSprite)))));
        
        stage.addActor(spriteGanador);
        
        spriteGanador.setFillParent(true);
        
        ImageButton btnVolverJugar = agregarBoton("boton_volver_jugar.png");
        btnVolverJugar.setY(180);
        btnVolverJugar.addListener(new ClickListenerBotonJugar(guerraAeronaves));
        
        ImageButton btnVolverMenu = agregarBoton("boton_volver_menu.png");
        btnVolverMenu.setY(80);
        btnVolverMenu.addListener(new ClickListenerBotonVolverMenu(guerraAeronaves));
        
        Gdx.input.setInputProcessor(stage);
    }
    
    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
    }
    
    protected final ImageButton agregarBoton(String rutaTextura) {
        ImageButton ib = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture(Gdx.files.internal(rutaTextura)))));
        ib.setSize(GuerraAeronaves.ANCHO_BOTON, GuerraAeronaves.ALTURA_BOTON);
        ib.setX(stage.getWidth()/2 - GuerraAeronaves.ANCHO_BOTON/2);
        ib.setZIndex(1);
        stage.addActor(ib);
        return ib;
    }    
    
}
