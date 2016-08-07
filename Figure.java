import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Vector;

public abstract class Figure {
	public Figure(double i,double j){
		x = i;
		y = j;
		active = false;
	}
	
	
	protected boolean active;//trigger if figure is already selected
	protected double x,y;//position
	protected GeneralPath polyline;//shape of figure
	
	
	abstract Shape get();
	
	public void comparePoint(double i, double j){
		if(i == x && j == y) active = true;
	}
	
	public boolean actioncheck(){
		return active;
	}
	
	
	public boolean check(ArrayList<Figure> enemy,ArrayList<Figure> figures){return false;};
	
	public void move(double i, double j){
		x = i;
		y = j;
	}
	
	abstract boolean checkMovement(double i, double j,ArrayList<Figure> figury,ArrayList<Figure> wrog);
	
	public void deactive() { active = false; }
	
	public double getX(){ return x; }
	
	public double getY(){ return y; }
	
}
