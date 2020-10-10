import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
/**
 * Dar solucion taller numero 9
 * Se recomienda hacer una clase o metodo main que instancie esta clase de manera que sirva como test
 * y desarrolle las actividades y cuestiones presentadas en el taller.
 * En esta clase se hará uso total de la clase HashMap:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html">HashMap API</a>
 * @version 1
 * @author Jacobo Rave Londoño, Juan Sebastian Guerra, Mauricio Toro
 */
public class Taller9{ 

    public static void main(String args[]){
        /*HashMap<String,String> empresas = new HashMap();
        agregar(empresas,"Google", "Estados Unidos");
        agregar(empresas,"La locura", "Colombia");
        agregar(empresas,"Nokia", "Finlandia");
        agregar(empresas,"Sony", "Japon");
        System.out.println(buscar(empresas, "Sony"));//return true
        System.out.println(buscar(empresas, "Nokia"));
        System.out.println (buscar(empresas, "Yahoo"));
        System.out.println(buscar(empresas, "Tesla"));
        System.out.println(contieneValue(empresas, "Colombia"));
        System.out.println(contieneValue(empresas, "Indonesia"));*/
        //-----------------------------------------------------
        Pedrito3();
        Pedrito4();
    }

    /** 
     * pedrito 2
     * @param empresas es el hashmap ya creado donde se guardaran los valores 
     * @param key es la llave en el conjunto
     * @param value es el valor asociado a la llave key
     * El metodo agregara un nuevo valor a empresas con los atributos key y value.
     */
    public static void agregar(HashMap empresas,String key, String value){
        empresas.put(key, value);
    }

    /** 
     * pedrito 3
     * @param empresas es el hashmap ya creado donde se guardaran los valores 
     * @param key es la llave en el conjunto
     * 
     * El metodo buscara el valor asociado a la llave key
     * @return true, si lo encuentra, false de lo contrario.
     */
    public static boolean buscar(HashMap empresas,String key){
        return empresas.containsKey(key);
    }

    /** 
     * pedrito 4
     * @param empresas es el hashmap ya creado donde se guardaran los valores 
     * @param value es el valor asociado a la llave key
     * El metodo nos dira si hay una llave asociado al valor value.
     * @return true, si lo encuentra, false de lo contrario.
     */
    public static boolean contieneValue(HashMap empresas,String value){
        return empresas.containsValue(value);
    } 

    public static void Pedrito3(){
        HashMap<String,String> empresasPedro = new HashMap();
        agregar(empresasPedro,"Google", "Estados Unidos");
        if(buscar(empresasPedro, "Google")){
            System.out.println(empresasPedro.get("Google"));}
        if(buscar(empresasPedro, "Motorola")){
            System.out.println(empresasPedro.get("Motorola"));}
    }

    public static void Pedrito4(){
        HashMap<String,String> empresasPedro = new HashMap();
        agregar(empresasPedro,"Google", "Estados Unidos");
        agregar(empresasPedro,"La locura", "Colombia");
        agregar(empresasPedro,"Nokia", "Finlandia");
        agregar(empresasPedro,"Sony", "Japon");

        Set<String> claves = empresasPedro.keySet();

        Collection<String> paises = empresasPedro.values();

        if(paises.contains("Estados Unidos")){

            for(String clave : claves){
                String paisActual = empresasPedro.get(clave);
                if(paisActual.equals("Estados Unidos")){
                    System.out.println(clave);

                }
            }

        }
        else{
            System.out.println("El pais no esta en el hashmap");
        }
        if(paises.contains("India")){

            for(String clave : claves){
                String paisActual = empresasPedro.get(clave);
                if(paisActual.equals("India")){
                    System.out.println(clave);

                }
            }
        }
        else{
            System.out.println("El pais no esta en el hashmap");
        }
    }
}
