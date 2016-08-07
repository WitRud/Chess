import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Check extends JFrame{
	public Check(int SIZE){
		super("Check");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(SIZE/2, SIZE/2);
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Check");
		label.setFont(new Font("Verdana",1,30));
		panel.add(label);
		add(panel);
		pack();
		setVisible(true);
	}

}
