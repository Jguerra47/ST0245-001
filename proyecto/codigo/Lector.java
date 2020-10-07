import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
* La clase Lector contiene el metodo para leer un archivo CSV
* @author Sebastian Guerra, Jacobo Rave
* @version 2
*/
public class Lector{    
    public static void main(String[] args) {
        ArrayList<String[]> matriz = leerCSV();
        for(String[] a : matriz){           
            System.out.println(Arrays.asList(a));
        }
    }

    public static ArrayList<String[]> leerCSV(){
        ArrayList<String[]> datos = new ArrayList<String[]>();
        File archivo = new File("4_train_balanced_135000.csv");//4_train_balanced_135000.csv y 0_test_balanced_5000.csv
        try {
            Reader r = new FileReader(archivo);
            BufferedReader lector = new BufferedReader(r);
            String linea;
            int numFila = 0;
            while ((linea = lector.readLine())!=null){ //O(m)
                if(numFila != 0){
                    datos.add(linea.split(";")); //O(m * n)
                }
                numFila++;
            } 
            lector.close();
        } 
        catch (IOException e) {
            e.getMessage();
        }
        return datos;
    }   //Complejidad de O(m * n)    
    
}
