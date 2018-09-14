
public class Punto {
	
	
	private static int cantCreados=0;
	private double coordx;
	private double coordy;
	private int id;
	
	public Punto(double x, double y) {
		coordx=x;
		coordy=y;
		id=cantCreados;
		cantCreados++;
	}
	
	public double getCoordx() {
		return coordx;
	}
	
	public double getCoordy() {
		return coordy;
	}
	
	public int getId() {
		return id;
	}

}
