import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Vector;

public class Knight extends Figure{
	public Knight(double i, double j){
		super(i,j);
	}
	
	
	Shape get(){
		double a = x+20;
		double b = y+10;
		polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 3);
		polyline.moveTo(a+50, b);
		polyline.lineTo(a+30, b);
		polyline.curveTo(a+30, b, a-15, b+35, a+60, b+70);
		polyline.lineTo(a+60, b+45);
		polyline.lineTo(a+45, b+45);
		polyline.closePath();
		return polyline;
	}

	
	public boolean checkMovement(double i, double j,ArrayList<Figure> figures,ArrayList<Figure> enemy){
		boolean trigger = false;
		if((Math.abs(i-x) == 100  && Math.abs(y-j) == 200) || (Math.abs(i-x) == 200  && Math.abs(y-j) == 100)){		
			
			trigger = true;
			for(Figure fig : figures){
				if(fig.getX() == i && fig.getY() == j){
					trigger = false;
					break;
				}
			}
			

		}
		return trigger;
	}
}
