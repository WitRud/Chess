import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Vector;

public class Bishop extends Figure{
	public Bishop(double i , double j){
		super(i,j);
	}
	
	
	Shape get(){

		double a = x+20;
		double b = y+10;
		polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 3);
		polyline.moveTo(a, b);
		polyline.lineTo(a+60, b);
		polyline.lineTo(a+50, b+10);
		polyline.curveTo(a+50, b+10, a+30, b+125, a+10, b+10);
		polyline.lineTo(a, b);
		polyline.closePath();
		return polyline;
	}
	
	
	public boolean checkMovement(double i, double j,ArrayList<Figure> figures,ArrayList<Figure> enemy){
		boolean trigger = false;
		if(Math.abs(i-x) == Math.abs(j-y)){

			trigger = true;
			double X = this.x;
			double Y = this.y;
			do{
				
				if(X<i) X += 100;
				else X -= 100;
				
				if(Y<j) Y += 100;
				else Y -= 100;
				
				for(Figure fig : figures){
					if(fig.getX() == X && fig.getY() == Y && fig != this){
						trigger = false;
						break;
					}
				}
				
				if(i != X && j != Y){
				for(Figure fig : enemy){
					if(fig.getX() == X && fig.getY() == Y && fig != this){
						trigger = false;
						break;
					}
				}
				}
			}while(i != X && j != Y);
			

		}
		return trigger;
	}
}
