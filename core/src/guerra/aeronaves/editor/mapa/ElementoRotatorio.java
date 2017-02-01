package guerra.aeronaves.editor.mapa;

import guerra.aeronaves.Direccion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class ElementoRotatorio extends ElementoMapa {
       
    private Direccion direccion;
    
    public ElementoRotatorio(String rutaTextura, int id) {
        super(rutaTextura, id);
        this.direccion = Direccion.ARRIBA;
    } 
    
    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    public void girarIzquierda() {
        switch (direccion) {
        case ARRIBA:
            direccion = Direccion.IZQUIERDA;
            break;
        case DERECHA:
            direccion = Direccion.ABAJO;
            break;
        case ABAJO:
            direccion = Direccion.DERECHA;
            break;
        default:
            direccion = Direccion.ARRIBA;
            break;
        }
        
        getImage().setOrigin(getImage().getWidth()/2, getImage().getHeight()/2);
        setOrigin(getWidth()/2, getHeight()/2);   
        
        System.out.println("Rotation 1 = " + getImage().getRotation());
        getImage().setRotation(getImage().getRotation() + 90);
        System.out.println("Rotation 2 = " + getImage().getRotation());
    }

}
