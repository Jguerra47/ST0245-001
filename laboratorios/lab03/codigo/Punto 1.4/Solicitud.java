
/**
 * @author Sebastian Guerra, Jacobo Rave 
 * @version 1
 */
public class Solicitud
{
    private String nombreTienda;
    private int numNeveras;
    
    public Solicitud(String nombreTienda, int numNeveras) {
        this.nombreTienda = nombreTienda;
        this.numNeveras = numNeveras;
    }
    
    public String getNombreTienda(){
        return this.nombreTienda;
    }

    public int getNumNeveras() {
        return this.numNeveras;
    }    
}
