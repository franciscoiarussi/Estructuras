
public class Rectangulo {
	
	private static int cantRecCreados=0;
	private Punto p1;
	private Punto p2;
	private int idRec;
	
	public Rectangulo(Punto primero, Punto segundo) {
		this.p1=primero;
		this.p2=segundo;
		this.idRec=cantRecCreados;
		cantRecCreados++;
	}
	
	public Rectangulo(Punto primero, Punto segundo, int id) {
		this.p1=primero;
		this.p2=segundo;
		this.idRec=id;
	}
	
	public Punto getP1() {
		return p1;
	}
	
	public Punto getP2() {
		return p2;
	}
	
	public int getIdRec() {
		return idRec;
	}
	
	public double getArea() {
		return(abs(p1.getCoordx()-p2.getCoordx())*abs(p1.getCoordy()-p2.getCoordy()));
	}

	private double abs(double d) {
		if(d<0)
			return -d;
		return d;
	}
	
	public boolean isInside(Punto p) {
		if(((p.getCoordx()>=p1.getCoordx())&&(p.getCoordx()<=p2.getCoordx()))||((p.getCoordx()>=p2.getCoordx())&&(p.getCoordx()<=p1.getCoordx())))
			if(((p.getCoordy()>=p1.getCoordy())&&(p.getCoordy()<=p2.getCoordy()))||((p.getCoordy()>=p2.getCoordy())&&(p.getCoordy()<=p1.getCoordy())))
				return true;
		return false;	
	}
	
	//area expandida-area original
	public double areaAExpandir(Punto p) {
		if(isInside(p))
			return 0;
		if(abs(p.getCoordx()-p1.getCoordx())<abs(p.getCoordx()-p2.getCoordx()))
			if(abs(p.getCoordy()-p1.getCoordy())<abs(p.getCoordy()-p2.getCoordy())) {
				Rectangulo aux=new Rectangulo(p,p2,0);
				return aux.getArea();
			}
			else
			{
				Punto aux1=new Punto(p.getCoordx(),p1.getCoordy(), idRec);
				Punto aux2=new Punto(p2.getCoordx(), p.getCoordy(), idRec);
				Rectangulo aux=new Rectangulo(aux1, aux2, 0);
				return aux.getArea();
			}
		else
		{
			if(abs(p.getCoordy()-p2.getCoordy())<abs(p.getCoordy()-p1.getCoordy())) {
				Rectangulo aux=new Rectangulo(p1, p, 0);
				return aux.getArea();
			}
			else
			{
				Punto aux1=new Punto(p1.getCoordx(),p.getCoordy(), idRec);
				Punto aux2=new Punto(p.getCoordx(), p2.getCoordy(), idRec);
				Rectangulo aux=new Rectangulo(aux1, aux2, 0);
				return aux.getArea();
			}
		}	
	}
	
	public void expandir(Punto p) {
		if(isInside(p))
			return;
		if(abs(p.getCoordx()-p1.getCoordx())<abs(p.getCoordx()-p2.getCoordx()))
			if(abs(p.getCoordy()-p1.getCoordy())<abs(p.getCoordy()-p2.getCoordy())) {
				p1.setCoordx(p.getCoordx());
				p1.setCoordy(p.getCoordy());
			}
			else
			{
				p1.setCoordx(p.getCoordx());
				p2.setCoordy(p.getCoordy());
			}
		else
		{
			if(abs(p.getCoordy()-p2.getCoordy())<abs(p.getCoordy()-p1.getCoordy())) {
				p2.setCoordx(p.getCoordx());
				p2.setCoordy(p.getCoordy());
			}
			else
			{
				p1.setCoordy(p.getCoordy());
				p2.setCoordx(p.getCoordx());
			}
		}
	}
	

}
