package guerra.aeronaves;

import com.badlogic.gdx.graphics.Texture;

public class Grid {
    
    protected Casilla[][] tablero;
    
    public Grid() {
        tablero = new Casilla[14][19];
        for(int i=0;i<14;i++) {
            for(int j=0;j<19;j++) {
                tablero[i][j] = new Casilla(0,i,j);
            }
        }
    }
    
    public int contar(int idx) {
        int x = 0;
        for(int i=0;i<14;i++) {
            for(int j=0;j<19;j++) {
                if(tablero[i][j].getId() == idx) x++;
            }
        }
        return x;
    }
    
    public Casilla[][] getTablero() {
        return tablero;
    }
    
    public Casilla getCasilla(int x, int y) {
        return tablero[x][y];
    }
}
