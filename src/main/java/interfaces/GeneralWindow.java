package interfaces;

import javax.swing.JFrame;

public class GeneralWindow extends JFrame {

	public GeneralWindow() {
		this.setTitle("Eternal Ashes");
		this.setSize(1650, 1000);
		this.setContentPane(new MainMenuWindow(this));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void cambiarPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if (clase.equals(MainMenuWindow.class)) {
			this.setContentPane(new MainMenuWindow(this));
		} else if (clase.equals(LoginMenuWindow.class)) {
			this.setContentPane(new LoginMenuWindow(this));
		} else if (clase.equals(RegistrarseWindow.class)) {
			this.setContentPane(new RegistrarseWindow(this));
		}
		this.getContentPane().setVisible(true);
	}

}
