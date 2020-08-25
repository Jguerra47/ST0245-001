/**
* En esta clase se pueden encontrar todos los ejercicios de CodingBat - Recursion 1
* @author Jacobo Rave y Sebastián Guerra
* @version 1.0
*/

public class Recursion1{

/**
* El método factorial encuentra el factorial de un número entero
* @param n un número entero
* @return el factorial del número n
*/

  public int factorial(int n) {
    if(n == 1){
      return n;
    }
    else{
      return factorial(n-1) * n;
    }
  }

/**
* El método bunnyEars encuentra la cantidad de orejas en una determinada cantidad de conejos
* @param bunnies la cantidad de conejos
* @return número de orejas
*/

  public int bunnyEars(int bunnies) {
    if(bunnies == 0){
      return 0;
      }
    else{
      return bunnyEars(bunnies-1) + 2;
    }
  }

/**
* El método fibonacci nos determina el valor de a_n en la secuencia de fibonacci
* @param n la posición del valor que queremos saber
* @return el valor del elemento
*/

  public int fibonacci(int n){
    if (n <= 1){
      return n;
    }
    else{
      return fibonacci(n-1) + fibonacci(n-2);
    }
  }

/**
* El método bunnyEars2 nos determina la cantidad de orejas de un grupo de conejos numerados, solo que ahora los conejos enumerado con número par tienen 3 orejas
* @param bunnies la cantidad de conejos
* @return número de orejas
*/

  public int bunnyEars2(int bunnies){
    if(bunnies == 0){
      return 0;
    }
    if(bunnies % 2 == 0){
      return bunnyEars2(bunnies-1) + 3;
    }
    else{
      return bunnyEars2(bunnies-1) + 2;
    {
  }

/**
* El método triangle tiene en cuenta un triangulo construido por bloques, y a medida que van creciendo las filas en 1, la  nueva base tendrá una caja más (filas = cajas en la base)
* @param rows la cantidad de filas del triángulo
* @return número de bloques que conforman el triángulo
*/

  public int triangle(int rows) {
    if(rows == 0){
      return 0;
    }
    else{
      return triangle(rows-1) + rows;
    }
  }
}
