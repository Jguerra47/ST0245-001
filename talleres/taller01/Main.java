import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	
     System.out.println("--------------------------------MENÚ--------------------------------");
     System.out.println("Ejecutar contador: 1, Ejecutar Fichero Puntos2D: 2, Ejecutar Fechas: 3, Ejecutar Linea2D: 4");
     Scanner r = new Scanner(System.in);
     int opción = r.nextInt();
     
     switch(opción) {
     case 1:
    	 Cont(); break;
    	 
     case 2:
    	 Fichero(); break;
    	 
     case 3:
    	 Fecha(); break;
    	 
     case 4:
    	 Linea2D(); break;
    	 
       default:
    	   System.out.println("Numero incompatibel, Hasta luego!");

     }
    }



    
    private static void Cont() {    	
    	
    	System.out.print("Ingrese entero para incrementar esa cantidad de unidades del contador");
		Scanner a = new Scanner(System.in);
    	int al = a.nextInt();
    	
        Contador c = new Contador("test");
        for (int i = 0; i < 10; ++i)
            c.incrementar(al);
        // 10
        System.out.println(c);
    	
    }
    
    
    private static void Fichero() {    	
    	
    	 System.out.println("Ingresa la ruta del fichero: ");
         Scanner s = new Scanner(System.in);
         String solicitud = s.nextLine();
         File archivo = new File(solicitud);

         try{
             Scanner scan = new Scanner(archivo);
             while(scan.hasNextLine()){
                 Scanner lineaActual  =  new Scanner(scan.nextLine());
                 String copia = lineaActual.next();
                 if(!Character.isLetter(copia.charAt(0))){
                     long id = Long.parseLong(copia);
                     double x = Double.parseDouble(lineaActual.next());
                     double y = Double.parseDouble(lineaActual.next());

                     Punto p = new Punto(x, y);
                     // 0,0
                     System.out.printf("Punto: {%f, %f}\n", p.x(), p.y());
                     // 1*sqrt(2)
                     System.out.println("Radio Polar: " + p.radioPolar());
                     // -45
                     System.out.println("Angulo Polar: " + Math.toDegrees(p.anguloPolar()));
                     // 2
                     System.out.println("Distancia euclidiana: " + p.distanciaEuclidiana(new Punto(5, 5))+"\n");
                 }
             }
         }
         catch(FileNotFoundException error){
             System.out.println(error.getMessage());
         }        

         System.out.println("Realizado con éxito :)\n");
    	
    }
    
    
    
    private static void Fecha() {
    	
    	Fecha f1 = new Fecha(1, 8, 2017);
        Fecha f2 = new Fecha(2, 5, 2016);
        System.out.println(f1);
        System.out.println(f2);
        
        // 1
        System.out.println(f1.compararFechas(f2));
    	
    	
    }
    
    /*
	 * Profe pruebe con estos puntos (1,1) y (15,8)
	 * 
	 * 
	 * */
    private static void Linea2D() {
    	
    	
    	Punto p1 = new Punto(0,0);
    	Punto p2 = new Punto(3,3);
    	Linea2D linea = new Linea2D(p1,p2);
    	linea.EncontrarPuntos();
    }
}
