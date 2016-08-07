import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel implements MouseListener{
		public Board(){
			SIZE = 900;
			setPreferredSize(new Dimension(SIZE,SIZE));
			addMouseListener(this);
			Fields = new ArrayList(); 
			
			
			for(int j = 0 ; j<8 ; j++){
				for(int i = 0 ; i<8 ; i++){
					Fields.add(new Rectangle2D.Double(i*100+50, 50+j*100, 100, 100));
				}
			}//Creating whole board from 64(8*8) separeted fields
			

			player1 = new Player(Fields,0,false);//creating first player
			player2 = new Player(Fields,56,true);//creating second player
							
		}
		
		private Player player1,player2;
		private int choose, SIZE;
		private double a,b;
		private ArrayList<Rectangle2D> Fields;
		
		
		@Override
		protected void paintComponent(Graphics g){
			this.removeAll();//cleaning screen
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			for(int j = 0 ; j<8 ; j++){
				for(int i = 0 ; i<8 ; i++){
					if((i+j) % 2 == 1) g2d.setColor(Color.RED);
					else g2d.setColor(Color.yellow);
					g2d.fill(Fields.get(i+j*8));
				}
			}//drawing 64 squares
			g2d.setColor(Color.black);
			for(Figure fig : player1.show_figures()) g2d.fill(fig.get());//drawing player 1 figures
			
			g2d.setColor(Color.white);
			for(Figure fig : player2.show_figures()) g2d.fill(fig.get());//drawing player 2 figures
	}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			a = e.getX();
			b = e.getY();
			for(Rectangle2D pola : Fields){
				if(pola.contains(a, b)){//checking which field player select
					if(player1.show_status()){
						
						for(Figure fig : player1.show_figures()){
							fig.comparePoint(pola.getX(), pola.getY());//checking which figure has been selected
						}
					}
					
					else{
						for(Figure fig : player2.show_figures()){
							fig.comparePoint(pola.getX(), pola.getY());//checking which figure has been selected
						}
					}
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			for(Rectangle2D pola : Fields){
				if(pola.contains(e.getX(), e.getY())){  //checking in which field player want to drop figure
					for(Figure fig : player1.show_figures()){
						if(fig.actioncheck()){  //searching for selected figure
							if(fig.checkMovement(pola.getX(), pola.getY(),player1.show_figures(),player2.show_figures())){//trying to movefigure
								fig.move(pola.getX(), pola.getY());
								player1.change_status();
								player2.change_status();
								//if movement is possible, current player'll be changed
							}
							int index = 0;
							for(Figure fig2 : player2.show_figures()){
								
								if(fig2.getX() == fig.getX() && fig2.getY() == fig.getY()) break;
								index++;
								//checks if it is a figure to remove from board
							}
							if(index<player2.show_figures().size()) player2.show_figures().remove(index); // removing figure
							fig.deactive();//deactivate selected figure
							
							
						}
					}
					
					for(Figure fig : player2.show_figures()){
						if(fig.actioncheck()){
							
							if(fig.checkMovement(pola.getX(), pola.getY(),player2.show_figures(),player1.show_figures())){
								fig.move(pola.getX(), pola.getY());
								player1.change_status();
								player2.change_status();
								
							}
							int index = 0;
							for(Figure fig2 : player1.show_figures()){
								
								if(fig2.getX() == fig.getX() && fig2.getY() == fig.getY()) break;
								index++;
								
							}
							
							if(index<player1.show_figures().size()) player1.show_figures().remove(index);
							fig.deactive();
							

						}
					}
				}
			}
			if(!player2.show_figures().get(0).check(player1.show_figures(),player2.show_figures()))  new Check(SIZE);
			if(!player1.show_figures().get(0).check(player2.show_figures(),player1.show_figures())) new Check(SIZE);
			repaint();

		}
}