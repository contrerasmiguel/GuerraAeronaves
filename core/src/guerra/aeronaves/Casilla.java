package guerra.aeronaves;

import com.badlogic.gdx.graphics.Texture;

public class Casilla {
    
    protected int id, posX, posY;
    protected Texture img;
    
    public Casilla(int i, int x, int y) {
        id = i; posX = x; posY = y;
        img = new Texture("cielo1.png");
    }
    
    public void setId(int i) {
        id = i;
    }
    public void setX(int x) {
        posX = x;
    }
    public void setY(int y) {
        posY = y;
    }
    public void setId(Texture t) {
        img = t;
    }
    public int getId() {
        return id;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public Texture getTexture() {
        return img;
    }
}
