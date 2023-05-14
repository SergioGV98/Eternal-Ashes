package interfaces;

import java.awt.Dimension;

import javax.swing.JPanel;

public class DebugWindow extends JPanel {

	private GeneralWindow window;

	public DebugWindow(GeneralWindow w) {
		setPreferredSize(new Dimension(1650, 1000));
		this.window = w;
		setLayout(null);
	}

}
