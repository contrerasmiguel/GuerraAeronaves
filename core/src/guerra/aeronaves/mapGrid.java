package guerra.aeronaves;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import guerra.aeronaves.guerraAeronaves;
import java.util.ArrayList;

public class mapGrid {
    
    public boolean mapGrid[][];
    public int mapWidth, mapHeight;
    
    public ArrayList entidades;
    
    public mapGrid(int w, int h) {
        
        mapGrid = new boolean[w][h];
        
        mapWidth = w * guerra.aeronaves.guerraAeronaves.tamañoCasilla;
        mapHeight = h * guerra.aeronaves.guerraAeronaves.tamañoCasilla;
    }
    
    public void render(ShapeRenderer render) {
        
        for(int i=0;i<mapGrid.length;i++) {
            for(int j=0;j<mapGrid[i].length;j++) {
                render.line(i*guerra.aeronaves.guerraAeronaves.tamañoCasilla,0,i*guerra.aeronaves.guerraAeronaves.tamañoCasilla,j*guerra.aeronaves.guerraAeronaves.tamañoCasilla);
                render.line(0,j*guerra.aeronaves.guerraAeronaves.tamañoCasilla,i*guerra.aeronaves.guerraAeronaves.tamañoCasilla,j*guerra.aeronaves.guerraAeronaves.tamañoCasilla);
            }
        }
    }
}
