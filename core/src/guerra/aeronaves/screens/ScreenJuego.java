package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import guerra.aeronaves.Avion;
import guerra.aeronaves.GuerraAeronaves;
import guerra.aeronaves.editor.mapa.Mapa;
import java.util.Scanner;

public class ScreenJuego extends ScreenAdapter {
    
    private final Stage stage;
    private Mapa mapa;
    private Avion Rojo, Azul;

    public ScreenJuego(GuerraAeronaves guerraAeronaves) {
        
        Gdx.graphics.setWindowedMode(GuerraAeronaves.getAnchoVentana()
                , GuerraAeronaves.getAltoVentana());
        
        Table tablaContenedora = new Table();
        tablaContenedora.setSize(GuerraAeronaves.NUM_COLUMNAS * GuerraAeronaves.TAMANO_CASILLA, 
                GuerraAeronaves.NUM_FILAS * GuerraAeronaves.TAMANO_CASILLA);
        
        tablaContenedora.add(mapa).size(GuerraAeronaves.NUM_COLUMNAS * GuerraAeronaves.TAMANO_CASILLA
                , GuerraAeronaves.NUM_FILAS * GuerraAeronaves.TAMANO_CASILLA);
        
        int[][] matrizMapa = new int[GuerraAeronaves.NUM_FILAS][GuerraAeronaves.NUM_COLUMNAS];
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
        
        mapa = new Mapa();
        crearElementos(matrizMapa, tablaContenedora);
        
        stage = new Stage();
        stage.addActor(tablaContenedora);
        Gdx.input.setInputProcessor(stage);
    }
    
    @Override
    public void hide() {
        super.hide();
        Gdx.graphics.setWindowedMode(GuerraAeronaves.getAnchoVentanaEditor()
                , GuerraAeronaves.getAltoVentanaEditor());          
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
        for(int i=0;i<GuerraAeronaves.NUM_FILAS;i++) {
            System.out.print("\n");
            for(int j=0;j<GuerraAeronaves.NUM_COLUMNAS;j++) {
                //System.out.print(""+matriz[i][j]+" ");
                if(matriz[i][j] == GuerraAeronaves.ID_AVION_ROJO) {
                    //Por defecto los aviones son rojos. Para hacerlos azules llamar a setEsRojo()
                    Image iRojo = new Image(new TextureRegion(new Texture("avion_rojo.png")));
                    Rojo = new Avion(GuerraAeronaves.ID_AVION_ROJO,iRojo,true);
                    //Rojo.setPosition(j*GuerraAeronaves.TAMANO_CASILLA, i*GuerraAeronaves.TAMANO_CASILLA);
                    //tablita.add(Rojo);
                }
            }
        }
    }
    
}
