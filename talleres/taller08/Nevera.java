

/**
 * @author Sebastian Guerra, Jacobo Rave 
 * @version 1
 */
public class Nevera{
    private int codigo;
    private String marca;
    
    public Nevera(int codigo, String marca) {
        this.codigo = codigo;
        this.marca = marca;
    }
    
    public int getCodigo(){
        return this.codigo;
    }

    public String getMarca() {
        return this.marca;
    }
}

