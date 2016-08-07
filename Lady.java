import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Vector;

public class Lady extends Figure{
	public Lady(double i, double j){
		super(i,j);
	}
	
	
	Shape get(){

		double a = x;
		double b = y+10;
		polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 3);
		polyline.moveTo(a+50, b);
		polyline.lineTo(a+80, b);
		polyline.lineTo(a+90, b+80);
		polyline.lineTo(a+70, b+50);
		polyline.lineTo(a+50, b+80);
		polyline.lineTo(a+30, b+50);
		polyline.lineTo(a+10, b+80);
		polyline.lineTo(a+20, b);
		polyline.closePath();
		return polyline;
	}
	
	
	public boolean checkMovement(double i, double j,ArrayList<Figure> figures,ArrayList<Figure> enemy){
		boolean trigger = false;
		if(i == x || j == y || Math.abs(i-x) == Math.abs(j-y)){
			
			trigger = true;
			double X = this.x;
			double Y = this.y;
			do{
				
				if(X<i){
					X += 100;
					if(Y<j) Y += 100;
					 else if(Y>j) Y -= 100;						
					}
				else{
					if(X>i){
						X -= 100;
						if(Y<j) Y += 100;
						 else if(Y>j) Y -= 100;	
					} else{
						if(Y<j) Y += 100;
						 else if(Y>j) Y -= 100;	
					}
					}	
				for(Figure fig : figures){
					if(fig.getX() == X && fig.getY() == Y && fig != this){
						trigger = false;
						break;
					}
				}
				}while(X!=i && Y!=j);
			

			
		}
		return trigger;
	}
}
