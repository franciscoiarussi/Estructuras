
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
	
	public Punto(double x, double y, int idRec) {
		coordx=x;
		coordy=y;
		id=idRec;
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
	
	public void setCoordx(double coordx) {
		this.coordx = coordx;
	}
	
	public void setCoordy(double coordy) {
		this.coordy = coordy;
	}
}
