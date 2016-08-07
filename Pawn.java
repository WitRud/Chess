import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;

public class Pawn extends Figure{
	public Pawn(double i, double j,boolean trigger){
		super(i,j);
		if(trigger) move = 100;
		else move = -100;
	}
	
	
	private int move;
	
	Shape get(){
		double a = x+50;
		double b = y+30;
		polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 3);
		polyline.moveTo(a+50, b);
		polyline.lineTo(a+30, b);
		polyline.lineTo(a+15, b+30);
		polyline.curveTo(a+15, b+30, a+20, b+45, a, b+60);
		polyline.curveTo(a, b+60, a-20, b+45, a-15, b+30);
		polyline.lineTo(a-30, b);
		polyline.closePath();
		return polyline;
	}

	
	public boolean checkMovement(double i, double j,ArrayList<Figure> figury,ArrayList<Figure> enemy){
		boolean trigger = true;
		if(i == x && j+move == y){
			for(Figure fig : figury){
				if(i == fig.getX() && j == fig.getY() && fig != this) trigger = false;
			}
			
			for(Figure fig : enemy){
				if(i == fig.getX() && j == fig.getY()) trigger = false;
			}
			
		}
		else if((i-x == 100 || i-x == -100) && j+move == y){
			for(Figure fig : enemy){
				if( i == fig.getX() && j == fig.getY()){
					x = i;
					y = j;
				} else trigger = false;
			}
		} else trigger = false;
		return trigger;
	}
	
}