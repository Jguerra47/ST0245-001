
import java.util.Stack;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.ArrayList;
/**
 * La clase Prueba esta destinada para probar los métodos del Taller 8.
 * @author Sebastian Guerra, Jacobo Rave 
 * @version 2
 */
public class Prueba
{
    public static void main(String[] args) throws Exception{
        System.out.println("Taller 8 de Estructura de datos y algoritmos 1");

        System.out.println("\nPrimer punto (Notación polaca inversa):");
        int a = Taller8.notacionPolacaInversa("6 5 - 4 +");
        System.out.println("El resultado es: "+ a);

        System.out.println("\nSegundo punto (Asignacion de neveras):");

        ArrayList<Asignacion> lista = datosPrueba1(); //Probar con datosPrueba2();

        System.out.print("<");
        for (int i =0; i<lista.size(); i++){
            if(i == lista.size()-1){
                System.out.println(lista.get(i).toStringJS()+">");
            }
            else{
                System.out.println(lista.get(i).toStringJS());
            }
        }
    }

    private static ArrayList<Asignacion> datosPrueba1() throws Exception{
        Stack<Nevera> almacen = new Stack<Nevera>();
        LinkedBlockingQueue<Solicitud> solicitudes = new LinkedBlockingQueue<Solicitud>();     

        //---[Agregamos neveras de prueba]-----
        almacen.push(new Nevera(1, "Haceb"));
        almacen.push(new Nevera(2, "LG"));
        almacen.push(new Nevera(3, "IBM"));
        almacen.push(new Nevera(4, "Haceb"));
        almacen.push(new Nevera(5, "LG"));
        almacen.push(new Nevera(6, "IBM"));
        almacen.push(new Nevera(7, "Haceb"));
        almacen.push(new Nevera(8, "LG"));
        almacen.push(new Nevera(9, "IBM"));
        almacen.push(new Nevera(8, "LG"));
        almacen.push(new Nevera(9, "IBM"));

        //---[Agregamos solicitudes de prueba]-----
        solicitudes.offer(new Solicitud("Exito", 1));
        solicitudes.offer(new Solicitud("Olimpica", 4));
        solicitudes.offer(new Solicitud("la14", 2));        
        solicitudes.offer(new Solicitud("La eafit xd", 10));
        solicitudes.offer(new Solicitud("Google", 1));
        solicitudes.offer(new Solicitud("Facebook", 5));

        return Taller8.asignarNeveras(almacen, solicitudes);
    }

    private static ArrayList<Asignacion> datosPrueba2() throws Exception{
        Stack<Nevera> almacen = new Stack<Nevera>();
        LinkedBlockingQueue<Solicitud> solicitudes = new LinkedBlockingQueue<Solicitud>();     

        //---[En este caso no agregamos neveras]-----        

        //---[Agregamos solicitudes de prueba]-----
        solicitudes.offer(new Solicitud("Exito", 1));
        solicitudes.offer(new Solicitud("Olimpica", 4));
        solicitudes.offer(new Solicitud("la14", 2));        
        solicitudes.offer(new Solicitud("EAFIT", 10));
        solicitudes.offer(new Solicitud("Google", 1));
        solicitudes.offer(new Solicitud("Facebook", 5));

        return Taller8.asignarNeveras(almacen, solicitudes);
    }
}

