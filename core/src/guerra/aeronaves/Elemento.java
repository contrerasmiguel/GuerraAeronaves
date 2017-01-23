package guerra.aeronaves;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import java.awt.Point;

abstract public class Elemento extends Actor {
    
    protected int id;
    protected boolean visible;
    protected int vida;
    private Image img;
    
    public Elemento(int idx, Image i, boolean v) {
        this.id = idx;
        img = i;
        visible = v;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public Image getImg() {
        return img;
    }
    
    public void setImg(Image i) {
        img = i;
    }
    /*
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(1, 1, 1, parentAlpha);
        batch.draw((TextureRegion)img.getDrawable(), getX(), getY()); // MALO
    }
    */
}