
/**
 * Al introducir enteros se guardan en un lista para ser imprimida de forma invertida
 * 
 * @author (Jacobo Rave y Juan Sebastian Guerra) 
 * @version (2020/09/04)
 * 
 */
import java.util.Scanner;
import java.util.ArrayList;
public class MiArrayLista
{

    Scanner scan = new Scanner(System.in); 
    public static ArrayList<String> array = new ArrayList<String>();
    public String imprimirArreglo[];

     /**
     * 
     * El método main ejecuta el programa
     * 
     */
    public static void main(String args[]){
        MiArrayLista a = new MiArrayLista();
        a.llenar();
        a.Invertir();
        System.out.print(array);
        a.Imprimir();
    }

    /**
     * 
     * El método llenar llena la lista con los enteros que ingrese el usuario.
     * La complejidad de introducir n enteros es de O(n)
     * La complejidad de agregar n enteros es de O(n)
     * La complejidad del algoritmo es O(n^2)
     */
    public void llenar(){
        System.out.println("Llenar lista: ingrese números " +
            "\nIngrese -1 para confirmar que la lista está llena");
        while(scan.hasNextInt()){ //O(n)

            int leerNum = scan.nextInt();
            if(leerNum!=-1){
                String agregar= Integer.toString(leerNum);
                array.add(agregar);//  O(n) 

            }
            else{
                System.out.println("¡Lista llena!");
                break;
            }
        }
        this.imprimirArreglo= new String[array.size()];
        // T(n) = O(n*n) 
        // T(n) = O(n^2) 
    }
    
     /**
     * 
     * El método Invertir invierte la lista con los enteros que ingrese el usuario.
     * La complejidad de invertir n enteros de la cadena es O(n)
     * 
     */
    public void Invertir(){
        System.out.print("Cadena para Invertir");

        for(int i = 0; i<array.size(); i++){//O(n)
            String a = array.get(i);
            imprimirArreglo[array.size()-i-1] = a;
        }
        // T(n) = O(n) 

    }

     /**
     * 
     * El método Imprimir imprime la lista invertida con los enteros que ingrese el usuario.
     * La complejidad de imprimir n enteros invertidos de la cadena es O(n)
     * 
     */
    public void Imprimir(){
        System.out.print("\nResultado: [");
        for(int j = 0 ; j < imprimirArreglo.length ; j++ ){//O(n)
            System.out.print(imprimirArreglo[j]);
            if(j != imprimirArreglo.length-1){
                System.out.print(", ");
            }            

        }
        System.out.print("]");
        // T(n) = O(n) 

    }
}
