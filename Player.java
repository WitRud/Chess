import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Vector;

public class Player {
	public Player(ArrayList<Rectangle2D> Pola, int i,boolean trigger){
		
			figures.add(new King(Pola.get(3+i).getX(),Pola.get(3+i).getY()));
			figures.add(new Tower(Pola.get(0+i).getX(),Pola.get(0+i).getY()));
			figures.add(new Tower(Pola.get(7+i).getX(),Pola.get(7+i).getY()));
			figures.add(new Knight(Pola.get(1+i).getX(),Pola.get(1+i).getY()));
			figures.add(new Knight(Pola.get(6+i).getX(),Pola.get(6+i).getY()));
			figures.add(new Bishop(Pola.get(2+i).getX(),Pola.get(2+i).getY()));
			figures.add(new Bishop(Pola.get(5+i).getX(),Pola.get(5+i).getY()));
			figures.add(new Lady(Pola.get(4+i).getX(),Pola.get(4+i).getY()));
			
			for(int j = 8;j<16;j++) figures.add(new Pawn(Pola.get(Math.max(i-16, 0)+j).getX(), Pola.get(Math.max(i-16, 0)+j).getY(),trigger));
			
			active = trigger;
			
		}
	
	
	ArrayList<Figure> figures = new ArrayList<Figure>();
	boolean active;
	
	public ArrayList<Figure> show_figures(){
		return figures;
	}
	
	public boolean show_status(){
		return active;
	}
	
	public void change_status(){
		active = this.active? false : true;
	}
}
