/**
 * La clase Punto tiene la intención de representar coordenadas en el espacio y calcular su distancia.
 *
 * @author Mauricio Toro, Andres Paez, Jacobo Rave, Sebastián Guerra
 * @version 1.1
 */

public class Punto {
    private double x, y;

    /**
     * Se inicializan los atributos de clase
     */
    public Punto(double x, double y) {
        this.x=x;
        this.y=y;
    }

    /**
     * Método para obtener la variable global x.
     *
     * @return eje coordenado x
     */
    public double x() {
        return this.x;
    }

    /**
     * Método para obtener la variable global y.
     *
     * @return eje coordenado y
     */
    public double y(){
        return this.y;
    }

    /**
     * Método para obtener el radio polar, en este caso se puede obtener por medio del teorema de pitágoras.
     *
     *
     * @return radio polar
     *
     * @see <a href="http://mathworld.wolfram.com/PolarCoordinates.html"> Ver más <a/>
     */

    public double radioPolar(){
        double radioPolar = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return radioPolar;
    }

    /**
     * Método para obtener el ángulo polar, en este caso se puede obtener por medio de la tangente inversa.
     *
     *
     * @return angulo polar
     *
     * @see <a href="http://mathworld.wolfram.com/PolarCoordinates.html"> Ver más <a/>
     */
    public double anguloPolar() {
        double anguloPolar = Math.atan2(y, x);
        return anguloPolar;        
    }

    /**
     * Método para obtener la distacia euclidiana. La distacia
     * euclidiana o euclídea es la distancia "ordinaria" (que se mediría con una regla) entre
     * dos puntos de un espacio euclídeo, la cual se deduce a partir del teorema de Pitágoras.
     * En otras palabras es halla el radio polar a la diferencia entre los dos puntos.
     *
     *
     *
     * @return distancia euclidiana (radio polar a la diferencia de dos puntos)
     *
     * @param otro Este parámetro hace referencia a otro Punto en el espacio con es cual se desea
     * comparar el Punto desde el cual fue llamado.
     * @see <a href="http://mathworld.wolfram.com/Distance.html"> Ver más <a/>
     */

    public double distanciaEuclidiana(Punto otro) {
        double distanciaEuclidiana = Math.sqrt(Math.pow((otro.x - this.x), 2 ) + Math.pow( (otro.y - this.y), 2 ) );
        return distanciaEuclidiana;
    }
}
