
public class Vertice {    
    Long id;
    //double x; //Según los parámetros en el lab, estos datos son irrelevantes por ahora
    //double y;
    //String name;
    
    /**
     *Este constructor inicializa el id
     *@param id establece el id de un vertice
     */
    public Vertice(Long id) {
        this.id = id;
        //this.x = x;
        //this.y = y;
        //this.name = name;
    }
    
    /**
    *Este método convierte los vertices a String para ser imprimidos
    *
    */
    public String toString(){
        return "{Vertice: [Id->"+id.toString()+"]}";
    }
}
