package guerra.aeronaves.editor.paleta;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import guerra.aeronaves.GuerraAeronaves;
import guerra.aeronaves.editor.mapa.ElementoMapa;
import guerra.aeronaves.editor.mapa.Mapa;

public class ClickListenerBotonGuardar extends ClickListener{
    
    private Mapa mapa;
    private int dirRojo, dirAzul;
    
    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        
        //FileHandle[] ListaArchivos = Gdx.files.local("mapas").list();
        
        FileHandle file = Gdx.files.local("mapas/mapa1.txt");
        Array<Cell> aux = mapa.getCells();
        String contenido = "";
        int n = 0;
        for(int i=0;i<GuerraAeronaves.NUM_FILAS;i++) {
            contenido += "\n";
            for(int j=0;j<GuerraAeronaves.NUM_COLUMNAS;j++) {
                if(((ElementoMapa)aux.get(n).getActor()).getId() == GuerraAeronaves.ID_AVION_ROJO) {
                switch((int)Math.round(((ElementoMapa)aux.get(n).getActor()).getImage().getRotation())) {
                    case 0:
                        dirRojo = 0;
                        break;
                    case 90:
                        dirRojo = 1;
                        break;
                    case 180:
                        dirRojo = 2;
                        break;
                    case 270:
                        dirRojo = 3;
                        break;
                }
            } else if(((ElementoMapa)aux.get(n).getActor()).getId() == GuerraAeronaves.ID_AVION_AZUL) {
                switch((int)Math.round(((ElementoMapa)aux.get(n).getActor()).getImage().getRotation())) {
                    case 0:
                        dirAzul = 0;
                        break;
                    case 90:
                        dirAzul = 1;
                        break;
                    case 180:
                        dirAzul = 2;
                        break;
                    case 270:
                        dirAzul = 3;
                        break;
                }
            }
                contenido += ((ElementoMapa)aux.get(n).getActor()).getId()+" ";
                n++;
            }
        }
        contenido += "\n";
        contenido += dirRojo;
        contenido += " "+ dirAzul;
        file.writeString(contenido, false);
    }

    void setListener(Mapa mapa) {
        this.mapa = mapa;
    }
}
