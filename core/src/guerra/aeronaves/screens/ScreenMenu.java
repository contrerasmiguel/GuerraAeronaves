package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import guerra.aeronaves.GuerraAeronaves;

public abstract class ScreenMenu extends ScreenAdapter {

    protected final Stage stage;
    
    public ScreenMenu() {
        Image imgFondo = new Image(new Texture(Gdx.files
                .internal("FondoMenu01.png")));
        imgFondo.setPosition(0, 0);
        imgFondo.setZIndex(0);        
        
        stage = new Stage();
        stage.addActor(imgFondo);
        
        Gdx.input.setInputProcessor(stage);
    }
    
    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();
    }    
    
    protected final ImageButton agregarBoton(String rutaTextura) {
        ImageButton ib = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture(Gdx
                .files.internal(rutaTextura)))));
        ib.setSize(GuerraAeronaves.btnAnchura, GuerraAeronaves.btnAltura);
        ib.setX(GuerraAeronaves.getAnchoVentana()/2 - GuerraAeronaves
                .btnAnchura/2);
        ib.setZIndex(1);
        stage.addActor(ib);
        return ib;
    }    
    
}
