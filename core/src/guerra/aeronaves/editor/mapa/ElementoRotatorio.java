package guerra.aeronaves.editor.mapa;

public class ElementoRotatorio extends ElementoMapa {
       
    private Direccion direccion;
    
    public ElementoRotatorio(String rutaTextura) {
        super(rutaTextura);
        this.direccion = Direccion.NORTE;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    public void rotarDerecha() {
        switch (direccion) {
        case NORTE:
            direccion = Direccion.ESTE;
            break;
        case ESTE:
            direccion = Direccion.SUR;
            break;
        case SUR:
            direccion = Direccion.OESTE;
            break;
        default:
            direccion = Direccion.NORTE;
            break;
        }
    }
    
}
