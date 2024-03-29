
/**
 * La clase Tripla es una n-tupla de tamaño 3: junta 3 objetos para formar un tipo de dato.
 *
 * @author Mauricio Toro, Sebastián Guerra, Jacobo Rave
 * @version 1
 */
public class Tripla <A, B, C> { 
    public final A x;
    public final B y; 
    public final C z; //Distancia
    
    
    /**
    *El constructor inicializa el X Y Z
    *
    *@param recibe un x para un vertice
    *@param recibe un y para un vertice
    *@param recibe un z para un vertice
    */
    public Tripla(A x, B y, C z) { 
        this.x = x; 
        this.y = y; 
        this.z = z;
    } 
    
    /**
    *El método toString convierte cada parte del grafo a String
    *
    */
    public String toStringJS(){
        String msg = "["+x.toString()+","+y.toString()+", Distancia: "+z.toString()+"]";
        return msg;
    }
} 

