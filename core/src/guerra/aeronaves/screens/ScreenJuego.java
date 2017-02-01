package guerra.aeronaves.screens;

import Juego.Juego;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import guerra.aeronaves.GuerraAeronaves;
import guerra.aeronaves.editor.mapa.ElementoNoRotatorio;
import guerra.aeronaves.editor.mapa.Mapa;
import java.util.Scanner;

public class ScreenJuego extends ScreenAdapter {
    
    private final Stage stage;
    private final Juego juego;

    public ScreenJuego(GuerraAeronaves guerraAeronaves) {
        
        stage = new Stage();
        juego = new Juego(stage, leerMapa());
        juego.iniciar();
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

    private void crearElementos(int matriz[][], Table tablita) {
        
    }
    
    private int[][] leerMapa() {
        int matrizMapa[][] = new int[GuerraAeronaves.NUM_FILAS][GuerraAeronaves.NUM_COLUMNAS];
        FileHandle archivoMapa = Gdx.files.local("mapas/mapa1.txt");
        String mapaLeido = archivoMapa.readString();
        Scanner sc = new Scanner(mapaLeido);
        String aux = "";
        for(int i=0;i<GuerraAeronaves.NUM_FILAS;i++) {
            for(int j=0;j<GuerraAeronaves.NUM_COLUMNAS;j++) {
                if(sc.hasNextInt()) aux = ""+sc.nextInt();
                matrizMapa[i][j] = Integer.parseInt(aux);
            }
        }
        return matrizMapa;
    }
    
}
