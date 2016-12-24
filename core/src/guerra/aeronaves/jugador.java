package guerra.aeronaves;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class jugador {
    
    protected Vector2 pos; 
    protected Sprite spr;
    
    public jugador(int x, int y, Texture t) {
        pos = new Vector2(x,y);
        spr = new Sprite(t);
    }
    
    public void update() {
        
        //Movimiento
        
        spr.setPosition(pos.x, pos.y);
    }
    
    public void render(SpriteBatch batch) {
        spr.draw(batch);
    }
}
