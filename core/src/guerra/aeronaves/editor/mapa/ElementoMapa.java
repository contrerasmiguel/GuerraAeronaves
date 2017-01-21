package guerra.aeronaves.editor.mapa;

import guerra.aeronaves.editor.ElementoSeleccionable;

public abstract class ElementoMapa extends ElementoSeleccionable {
    
    private final int id;
    
    public ElementoMapa(String rutaTextura, int id) {
        super(rutaTextura);
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}
