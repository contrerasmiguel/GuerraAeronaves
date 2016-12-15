package guerra.aeronaves.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import guerra.aeronaves.GuerraAeronaves;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.title = "Guerra Aeronaves";
                config.width = 874;
                config.height = 644;
                config.resizable = false;
		new LwjglApplication(new GuerraAeronaves(), config);
	}
}
