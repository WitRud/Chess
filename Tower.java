import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Vector;

public class Tower extends Figure{

	public Tower(double i, double j) {
		super(i, j);
	}
	
	
	Shape get(){
		double a = x+50;
		double b = y+10;
		polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 3);
		polyline.moveTo(a+50, b);
		polyline.lineTo(a+30, b);
		polyline.lineTo(a+25, b+60);
		polyline.lineTo(a+35, b+60);
		polyline.lineTo(a+35, b+70);
		polyline.lineTo(a-35, b+70);
		polyline.lineTo(a-35, b+60);
		polyline.lineTo(a-25, b+60);
		polyline.lineTo(a-30, b);
		polyline.closePath();
		return polyline;
	};

	
	public boolean checkMovement(double i, double j,ArrayList<Figure> figures,ArrayList<Figure> enemy){
		ArrayList<Figure> all = new ArrayList<Figure>();
		all.addAll(figures);
		all.addAll(enemy);
		boolean trigger = true;
		if(i == this.x){
			
			double Y = this.y;
			
			do{
				
				if(Y<j) Y += 100;
				else Y -= 100;
				
				for(Figure fig : all){
					
					if(i == fig.getX() && Y == fig.getY() && fig != this){
						trigger = false;
						break;
					
					}
				}
			}while(Y != j);
		}
		else {
			if(j == this.y){
				
				double X = this.x;
				
				do{
					
					if(X<i) X += 100;
					else X -= 100;
					
					for(Figure fig : all){
						
						if(X == fig.getX() && j == fig.getY() && fig != this){
							
							trigger = false;
							break;
						
						}
					}

				}while(X != i);
			} else trigger = false;
		}
		
		return trigger;	
	}
}
