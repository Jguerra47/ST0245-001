/**
* En esta clase se pueden encontrar todos los ejercicios de CodingBat - Recursion 2
* @author Jacobo Rave y Sebastián Guerra
* @version 1.02
*/

public class Recursion2{

/**
* El método groupSum5 busca una posible combinación de números que sumados den un target. Sin embargo, presenta las siguientes condiciones: si hay un número multiplo de 5 en
el arreglo, debe de estar en la combinación; si es múltiplo de 5 y en la siguiente posición hay un 1, no tomar en cuenta ese 1 como elemento para la combinación
* @param start el iterador para navegar en el arreglo (inicia en 0)
* @param nums el arreglo del que se quiere generar grupos
* @param target el resultado de la suma que se quiere conseguir
* @return Valor booleano sobre si existe una combinación que de con el target
*/

  public boolean groupSum5(int start, int[] nums, int target) {
      if (start >= nums.length){
          return target == 0;
      }  
      if(nums[start] % 5 == 0){
          return groupSum5(start + 1, nums, target - nums[start]);
      }  
      else if (start > 0 && (nums[start] == 1 && nums[start - 1] % 5 == 0)){
          return groupSum5(start + 1, nums, target);
      }  
      return groupSum5(start+1, nums, target - nums[start]) || groupSum5(start+1, nums, target);
  }
  
  /*
  * Title: Java. Recursion-2 [source code]
  * Author: Ulm, G
  * Date: 2013
  * Code version: 1.0
  * Availability: www.gregorulm.com/codingbat-java-recursion-2/  
  */
  
/**
* El método groupSum6 busca una posible combinación de números que sumados den un target. Sin embargo, presenta las siguientes condiciones: si hay un número 6, debe de
estar en la combinación
* @param start el iterador para navegar en el arreglo (inicia en 0)
* @param nums el arreglo del que se quiere generar grupos
* @param target el resultado de la suma que se quiere conseguir
* @return Valor booleano sobre si existe una combinación que de con el target
*/
 
  public boolean groupSum6(int start, int[] nums, int target) {
      if (start >= nums.length){
          return target == 0;
      }
      if (nums[start] == 6){
          return groupSum6(start + 1, nums, target - nums[start]);
      }
    
      return groupSum6(start + 1, nums, target - nums[start]) || groupSum6(start + 1, nums, target);
  }
  
/**
* El método groupNoAdj busca una posible combinación de números que sumados den un target. Sin embargo, presenta las siguientes condiciones: si elige un número para la
combinación, el siguiente no puede ser tenido en cuenta
* @param start el iterador para navegar en el arreglo (inicia en 0)
* @param nums el arreglo del que se quiere generar grupos
* @param target el resultado de la suma que se quiere conseguir
* @return Valor booleano sobre si existe una combinación que de con el target
*/
  
  public boolean groupNoAdj(int start, int[] nums, int target) {
      if (start >= nums.length){
          return target == 0;
      }
      return groupNoAdj(start + 2, nums, target - nums[start]) || groupNoAdj(start + 1, nums, target);
  }
  
/**  
* El método splitOdd10 se encarga de recibir un arreglo para que sea analizado en {@link #helper(int, int[], int, int)}
* @param nums el arreglo del que se quiere generar grupos
* @return valor booleano sobre si existe una posible división del arreglo
*/

  public boolean splitOdd10(int[] nums) {
      return helper(0, nums, 0, 0);
  }

/**
* El método helper busca si existe una posible división de los elementos de un arreglo en el que un grupo de múltiplo de 10 y en el otro un número impar
* @param start el iterador para navegar en el arreglo (inicia en 0)
* @param nums el arreglo del que se quiere generar grupos
* @param sum1 atributo donde se almacena los elementos del grupo 1
* @param sum2 atributo donde se almacena los elementos del grupo 2
* @return Valor booleano sobre si existe una posible división del arreglo
*/

  private boolean helper(int start, int[] nums, int sum1, int sum2) {
      if (start >= nums.length){
          return sum1 % 10 == 0 && sum2 % 2 == 1;
      }
      return helper(start + 1, nums, sum1 + nums[start], sum2)|| helper(start + 1, nums, sum1, sum2 + nums[start]);
  }
  
/**  
* El método split53 se encarga de recibir un arreglo para que sea analizado en {@link #helper2(int, int[], int, int)}
* @param nums el arreglo del que se quiere generar grupos
* @return Valor booleano sobre si existe una posible división del arreglo
*/
  
  public boolean split53(int[] nums) {
      return helper2(0, nums, 0, 0);
  }
  
/**
* El método helper2 busca si existe una posible división de los elementos en los que la suma de los dos grupos sea igual. Además, los elementos que son múltiplos de 5 van al 
grupo 1, mientras que los que son múltiplos de 3 (pero no de 5) van al grupo 2
* @param start el iterador para navegar en el arreglo (inicia en 0)
* @param nums el arreglo del que se quiere generar grupos
* @param sum1 atributo donde se almacena los elementos del grupo 1
* @param sum2 atributo donde se almacena los elementos del grupo 2
* @return Valor booleano sobre si existe una posible división del arreglo
*/
 
  private boolean helper2(int start, int[] nums, int sum1, int sum2) {
      if (start >= nums.length){
          return sum1 == sum2;
      }
      if (nums[start] % 5 == 0){
          return helper2(start + 1, nums, sum1 + nums[start], sum2);
      }
      else if (nums[start] % 3 == 0){
          return helper2(start + 1, nums, sum1, sum2 + nums[start]);
      }
    
      return helper2(start + 1, nums, sum1 + nums[start], sum2) || helper2(start + 1, nums, sum1, sum2 + nums[start]);
  }
}
