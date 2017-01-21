package guerra.aeronaves.editor.mapa;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class ElementoRotatorio extends ElementoMapa {
       
    private Direccion direccion;
    
    public ElementoRotatorio(String rutaTextura, int id) {
        super(rutaTextura, id);
        this.direccion = Direccion.NORTE;
    } 
    
    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    public void girarIzquierda() {
        switch (direccion) {
        case NORTE:
            direccion = Direccion.OESTE;
            break;
        case ESTE:
            direccion = Direccion.SUR;
            break;
        case SUR:
            direccion = Direccion.ESTE;
            break;
        default:
            direccion = Direccion.NORTE;
            break;
        }
        
        getImage().setOrigin(getImage().getWidth()/2, getImage().getHeight()/2);
        setOrigin(getWidth()/2, getHeight()/2);   
        
        System.out.println("Rotation 1 = " + getImage().getRotation());
        getImage().setRotation(getImage().getRotation() + 90);
        System.out.println("Rotation 2 = " + getImage().getRotation());
    }

}
