package guerra.aeronaves.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import guerra.aeronaves.Servidor;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import guerra.aeronaves.GuerraAeronaves;
import java.util.Scanner;

public class ClickListenerBotonJugar extends ClickListenerBoton {
    private Servidor ser;

    public ClickListenerBotonJugar(GuerraAeronaves guerraAeronaves) {
        super(guerraAeronaves);
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        
        FileHandle archivoConexion = Gdx.files.local("config/conexion.txt");
        String datosConexion = archivoConexion.readString();
        Scanner sc = new Scanner(datosConexion);
        String ip = sc.next();
        String port = sc.next();
        ser = new Servidor(Integer.parseInt(port));
        ser.initServer();
        
        guerraAeronaves.setScreenJuego(ser);
    }
    
}
