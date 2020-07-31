public class Main {

    public static void main(String[] args) {
        Contador c = new Contador("test");
        for (int i = 0; i < 10; ++i)
            c.incrementar();
        // 10
        System.out.println(c);

        System.out.println();

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

        Fecha f1 = new Fecha(1, 8, 2017);
        Fecha f2 = new Fecha(2, 5, 2016);
        System.out.println(f1);
        System.out.println(f2);
        // 1
        System.out.println(f1.comparar(f2));
    }

}
