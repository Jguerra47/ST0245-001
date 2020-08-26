/**
* La clase Subsecuencia esta diseñada para realizar análisis a cadenas de caracteres y sus subsecuencias
* @author Jacobo Rave y Sebastián Guerra
* @version 2.0
*/

public class Subsecuencia{ 

/**
* El método maxAux sirve de auxiliar para la ejecución del método {@link #maxLength(String, String, int, int)}
* @param A la primera cadena de caracteres
* @param B la segunda cadena de caracteres
* @return La longitud de la subsecuencia común más larga
*/

  public static int maxAux(String A, String B){
    return maxLength(A, B, A.length(), B.length()); 
  }
  
 /* 
 * Title: Método g() [source code]
 * Author: Toro, M
 * Date: 2020
 * Code version: 1.0
 * Availability: http://www.interactiva.eafit.edu.co
 */

/**
* El método maxLength busca la longitud de la subsecuencia con mayor cantidad de caracteres en común con orden relativo respecto a dos cadenas de caracteres
* @param A la primera cadena de caracteres
* @param B la segunda cadena de caracteres
* @param n el tamaño de la primera cadena de caracteres
* @param m el tamaño de la segunda cadena de caracteres
* @return La longitud de la subsecuencia común más larga
*/

  private static int maxLength(String A, String B, int n, int m){
    if(n==0 || m==0){
      return 0;
    }
    if(A.charAt(n) == B.charAt(m)){
      return maxLength(A, B, n-1, m-1) + 1;
    }
    else{
      return Math.max(maxLength(A, B, n-1, m), maxLength(A, B, n, m-1));
    }
  } 
}
