package guerra.aeronaves.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import guerra.aeronaves.GuerraAeronaves;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.title = "Guerra de Aeronaves";
                config.foregroundFPS = 60;
                config.height = guerra.aeronaves.GuerraAeronaves.alturaPantalla;
                config.width = guerra.aeronaves.GuerraAeronaves.anchuraPantalla;
                config.resizable = false;
                config.addIcon("icon.png", Files.FileType.Internal);
		new LwjglApplication(new GuerraAeronaves(), config);
	}
}