package guerra.aeronaves.editor.paleta;

import guerra.aeronaves.editor.mapa.ElementoMapa;

public class ElementoRotatorio extends ElementoPaleta {

    public ElementoRotatorio(String rutaTexturaPaleta, String rutaTexturaMapa, int id) {
        super(rutaTexturaPaleta, rutaTexturaMapa, id);
    }

    @Override
    public ElementoMapa producirElementoMapa() {
        return new guerra.aeronaves.editor.mapa
                .ElementoRotatorio(rutaTexturaMapa, id);
    }
}
