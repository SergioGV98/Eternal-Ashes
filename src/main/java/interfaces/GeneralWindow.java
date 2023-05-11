package interfaces;

import javax.swing.JFrame;

public class GeneralWindow extends JFrame {

	public GeneralWindow() {
		this.setTitle("Eternal Ashes");
		this.setContentPane(new MainMenuWindow(this));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
        this.setSize(1650, 1000);
        this.setVisible(true);
    }
}
