import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Vector;

public class King extends Figure{
	public King(double i , double j){
		super(i,j);
	}
	
	
	Shape get(){
		double a = x;
		double b = y+10;
		polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 3);
		polyline.moveTo(a+50, b);
		polyline.lineTo(a+80, b);
		polyline.lineTo(a+80, b+15);
		polyline.curveTo(a+80, b+15, a+90, b+100, a+60, b+40);
		polyline.curveTo(a+60, b+40, a+50, b+100, a+40, b+40);
		polyline.curveTo(a+40, b+40, a+10, b+100, a+20, b+15);
		polyline.lineTo(a+20, b);
		polyline.closePath();
		return polyline;
	}

	
	public boolean checkMovement(double i, double j,ArrayList<Figure> figures,ArrayList<Figure> enemy){
		boolean trigger = false;
		if((Math.abs(i-x) < 200  && Math.abs(y-j) < 200)){			
			trigger = true;
			double X = this.x;
			double Y = this.y;

			if(X!=i) X = i;
			if(Y!=j) Y = j;
				
			for(Figure fig : figures){
				if(fig.getX() == X && fig.getY() == Y && fig != this){
					trigger = false;
					break;
				}
			}
			
		}
		return trigger;
	}
	
	
	public boolean check(ArrayList<Figure> enemy,ArrayList<Figure> figures){
		for(Figure fig : enemy){
			if(fig.checkMovement(x, y, enemy, figures)) return false;
		}
		return true;
	}
	
}
