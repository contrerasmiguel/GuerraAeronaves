package guerra.aeronaves.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import guerra.aeronaves.GuerraAeronaves;

public abstract class ClickListenerBoton extends ClickListener {
    
    protected final GuerraAeronaves guerraAeronaves;
    private final Sound beep;
    
    public ClickListenerBoton(GuerraAeronaves guerraAeronaves) {
        this.guerraAeronaves = guerraAeronaves;
        beep = Gdx.audio.newSound(Gdx.files.internal("sonidos/snd_select.wav"));
    }
    
    @Override
    public void enter(InputEvent event, float x, float y, int pointer
            , Actor fromActor) {
        super.enter(event, x, y, pointer, fromActor);
        event.getListenerActor().setY(event.getListenerActor().getY() + 2);
    }

    @Override
    public void exit(InputEvent event, float x, float y, int pointer
            , Actor toActor) {
        super.exit(event, x, y, pointer, toActor);
        event.getListenerActor().setY(event.getListenerActor().getY() + 2);
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        beep.play(0.2f);
    }
    
}
