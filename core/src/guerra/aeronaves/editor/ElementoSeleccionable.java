package guerra.aeronaves.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public abstract class ElementoSeleccionable extends ImageButton {   
    
    public ElementoSeleccionable(String rutaTextura) {
        super(new SpriteDrawable(new Sprite(new Texture(
                Gdx.files.internal(rutaTextura)))));
    }

}
