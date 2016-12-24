package guerra.aeronaves;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import guerra.aeronaves.GuerraAeronaves;
import java.util.ArrayList;

public class mapGrid {
    
    public boolean mapGrid[][];
    public int mapWidth, mapHeight;
    
    public ArrayList entidades;
    
    public mapGrid(int w, int h) {
        
        mapGrid = new boolean[w][h];
        
        mapWidth = w * guerra.aeronaves.GuerraAeronaves.tamañoCasilla;
        mapHeight = h * guerra.aeronaves.GuerraAeronaves.tamañoCasilla;
    }
    
    public void render(ShapeRenderer render) {
        
        for(int i=0;i<mapGrid.length;i++) {
            for(int j=0;j<mapGrid[i].length;j++) {
                render.line(i*guerra.aeronaves.GuerraAeronaves.tamañoCasilla,0,i*guerra.aeronaves.GuerraAeronaves.tamañoCasilla,j*guerra.aeronaves.GuerraAeronaves.tamañoCasilla);
                render.line(0,j*guerra.aeronaves.GuerraAeronaves.tamañoCasilla,i*guerra.aeronaves.GuerraAeronaves.tamañoCasilla,j*guerra.aeronaves.GuerraAeronaves.tamañoCasilla);
            }
        }
    }
}
