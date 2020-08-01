public class Linea2D{
	
    private final Punto p1, p2 ;
    private final double pendiente;
	
    
	public Linea2D(Punto p1, Punto p2) {
		
		this.p1=p1;
		this.p2=p2;
		this.pendiente = (p2.y()-p1.y()) / (p2.x()-p1.x());
		
		
	}
	 
    
	public void EncontrarPuntos() {
		
		double y;

		for(double i = p1.x() ; i<=p2.x() ; i++) {
			
			y=(pendiente*(i-p1.x()))+p1.y();
		
			
			if(y%1==0) {
				System.out.println("{"+ (int )i + ", "+ (int) y +"}");
			}
			else {
				
		     y=0;
			}
			
		}
				
	}
	
	
}