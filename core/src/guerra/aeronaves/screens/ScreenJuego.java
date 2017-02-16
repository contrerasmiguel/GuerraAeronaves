package guerra.aeronaves.screens;

import guerra.aeronaves.juego.Juego;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import guerra.aeronaves.Ganador;
import guerra.aeronaves.GuerraAeronaves;
import guerra.aeronaves.Servidor;
import guerra.aeronaves.juego.HUD;
import guerra.aeronaves.juego.JuegoListener;
import java.util.Scanner;

public class ScreenJuego extends ScreenAdapter implements JuegoListener {
    
    private final Stage stage;
    private final Juego juego;
    private final GuerraAeronaves guerraAeronaves;
    private final HUD h;

    public ScreenJuego(GuerraAeronaves guerraAeronaves, Servidor s) {
        this.guerraAeronaves = guerraAeronaves;

        stage = new Stage(new FitViewport(GuerraAeronaves.calcularTamañoCasilla(Gdx
                .graphics.getWidth(), Gdx.graphics.getHeight()) * GuerraAeronaves.NUM_COLUMNAS
                , GuerraAeronaves.calcularTamañoCasilla(Gdx.graphics.getWidth()
                        , Gdx.graphics.getHeight()) * GuerraAeronaves.NUM_FILAS));
        
        juego = new Juego(stage, leerMapa(), s);
        juego.setJuegoListener(this);
        juego.iniciar();
        
        h = new HUD(guerraAeronaves.batch, juego);

        Gdx.input.setInputProcessor(stage);
    }  
    
    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();
        
        guerraAeronaves.batch.setProjectionMatrix(h.getEstado().getCamera().combined);
        
        h.updateRojo(Math.round(juego.getVidaAvionRojo()),juego.getGasAvionRojo(), juego.getMunicionAvionRojo());
        //Quitar este comentario para habilitar el HUD del avión Azul
        //h.updateAzul(juego.getVidaAvionRojo(),juego.getGasAvionRojo(), juego.getMunicionAvionRojo());
        
        h.getEstado().draw();
    }
    
    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
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

    @Override
    public void alTerminar(Ganador ganador) {
        guerraAeronaves.setScreenFinalizacionJuego(ganador);
    }
    
}
