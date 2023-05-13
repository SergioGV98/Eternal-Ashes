package interfaces;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameWindow extends JPanel{
	
	private GeneralWindow window;


	public GameWindow(GeneralWindow w) {
		
		setPreferredSize(new Dimension(1650, 1000));
		this.window = w;
		setLayout(null);

		
	}
}
