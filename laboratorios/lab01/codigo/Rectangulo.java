/**
* La clase Rectangulo contiene métodos sobre la construcción de rectángulos a partir de determinadas dimensiones
* @author Jacobo Rave y Sebastián Guerra
* @version 1.01
*/

public class Rectangulo{
  
/**
* El método rectWays busca la cantidad de formas en las que se puede llenar un rectángulo de 2 x n cm^2, utilizando como pieza de construcción rectángulos de 2 x 1 cm^2
* @param n la magnitud del lado del rectángulo
* @return la cantidad de formas que hay para construir ese rectángulo
*/ 
  public int rectWays(int n){
    if (n <= 2){
      return n;
    }
    else{
      return rectWays(n-1) + rectWays(n-2);
    }  
  }
}
