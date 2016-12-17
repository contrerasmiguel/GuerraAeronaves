package guerra.aeronaves.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import guerra.aeronaves.guerraAeronaves;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.title = "Guerra de Aeronaves";
                config.foregroundFPS = 60;
                config.height = guerra.aeronaves.guerraAeronaves.alturaPantalla;
                config.width = guerra.aeronaves.guerraAeronaves.anchuraPantalla;
                config.resizable = false;
		new LwjglApplication(new guerraAeronaves(), config);
	}
}