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
    
    public void cambiarPaleta() {
        /*
            avionAzul = 1
            avionRojo = 5
            montaña = 10
            edificio = 15
        */
        tablero = new Casilla[3][2];
        
        Texture t = new Texture("paleta/vaciod.png");
        tablero[0][0] = new Casilla(0,0,0);
        tablero[0][0].setImg(t);
        
        t = new Texture("paleta/avion_azuld.png");
        tablero[0][1] = new Casilla(1,0,1);
        tablero[0][1].setImg(t);
        
        t = new Texture("paleta/avion_rojod.png");
        tablero[1][0] = new Casilla(5,1,0);
        tablero[1][0].setImg(t);
        
        t = new Texture("paleta/montanad.png");
        tablero[1][1] = new Casilla(10,1,1);
        tablero[1][1].setImg(t);
        
        t = new Texture("paleta/edificiod.png");
        tablero[2][0] = new Casilla(15,2,0);
        tablero[2][0].setImg(t);
        
        t = new Texture("paleta/vaciod.png");
        tablero[2][1] = new Casilla(0,2,1);
        tablero[2][1].setImg(t);
        
    }
}
