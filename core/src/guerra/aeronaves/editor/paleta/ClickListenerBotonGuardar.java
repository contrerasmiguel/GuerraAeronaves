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
    
    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        
        FileHandle[] ListaArchivos = Gdx.files.local("mapas").list();
        
        FileHandle file = Gdx.files.local("mapas/mapa"+(ListaArchivos.length+1)+".txt");
        Array<Cell> aux = mapa.getCells();
        String contenido = "";
        int n = 0;
        for(int i=0;i<GuerraAeronaves.NUM_FILAS;i++) {
            contenido += "\n";
            for(int j=0;j<GuerraAeronaves.NUM_COLUMNAS;j++) {
                contenido += ((ElementoMapa)aux.get(n).getActor()).getId()+" ";
                n++;
            }
        }
        file.writeString(contenido, false);
    }

    void setListener(Mapa mapa) {
        this.mapa = mapa;
    }
}
