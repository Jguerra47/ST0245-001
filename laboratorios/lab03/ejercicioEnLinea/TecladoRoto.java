import java.util.LinkedList;
/**
 * La clase TecladoRoto resuelve el problema del teclado roto con listas enlazadas * 
 * @author Jacobo Rave, Sebastian Guerra
 * @version 1
 */
public class TecladoRoto{
    /**
     * El metodo mostrarEnPantalla muestra como queda el texto despues de haber sido escrito en un teclado roto.
     * 
     * @param palabra secuencia de texto escrito
     * @return como se ve en pantalla ese texto
     **/
    public static String mostrarEnPantalla(String palabra){
        LinkedList<String> lista = new LinkedList<>();
        StringBuilder cadena = new StringBuilder("");

        boolean botonInicio = false;
        for(int i = 0; i < palabra.length(); i++){
            char caracter = palabra.charAt(i);
            if(caracter == '[' || caracter == ']'){
                if(!botonInicio){
                    lista.add(cadena.toString());
                }
                else{
                    lista.addFirst(cadena.toString()); 
                }      

                if(caracter == '['){
                    botonInicio = true;
                }
                else{
                    botonInicio = false;
                }

                cadena = new StringBuilder("");
            }
            else{
                cadena.append(caracter);
            }
        }

        if(!botonInicio){
            lista.add(cadena.toString());
        }
        else{
            lista.addFirst(cadena.toString());
        }

        String enPantalla = "";
        while(lista.size() > 0){
            enPantalla = enPantalla + lista.pollFirst();
        }

        return enPantalla;
    }
}
