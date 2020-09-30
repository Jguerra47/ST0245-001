
/**
 * @author Sebastian Guerra, Jacobo Rave 
 * @version 1
 */
public class Asignacion
{
    private String nombreTienda;
    private Nevera[] neverasAsignadas;
    
    public Asignacion(String nombreTienda, Nevera[] neverasAsignadas){
        this.nombreTienda = nombreTienda;
        this.neverasAsignadas = neverasAsignadas;
    }
    
    /**
     * El método toStringJS imprime el nombre de la tienda con sus respectivas neveras asignadas
     * @return una cadena de texto con la informacion de sus atributos
     */
    public String toStringJS(){
        String neveras = "[";
        for(Nevera n : neverasAsignadas){
            neveras = neveras + "("+n.getCodigo() + ", " + n.getMarca()+"), ";
        }       
        
        neveras = neveras.substring(0, neveras.length()-2);
        String msg = "{"+this.nombreTienda + ", "+neveras+"]}";
        return msg;
    }    
    
}
