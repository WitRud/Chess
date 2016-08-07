import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Site extends JFrame{
	public Site(){
		super("Chess");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(0, 0);
		board = new Board();
		add(board);
		pack();
		setVisible(true);
	}
	
	
	static JPanel board;

	public static void main(String[] args) {
		
	EventQueue.invokeLater(new Runnable() {


	@Override
	public void run() {
		new Site();
	}

	});

}
}