package interfaces;

import javax.swing.JFrame;

import clases.Jugador;

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

	public void cambiarPantalla(Class<?> clase, Jugador jugador) {
		this.getContentPane().setVisible(false);
		if (clase.equals(MainMenuWindow.class)) {
			this.setContentPane(new MainMenuWindow(this));
		} else if (clase.equals(LoginMenuWindow.class)) {
			this.setContentPane(new LoginMenuWindow(this));
		} else if (clase.equals(RegistrarseWindow.class)) {
			this.setContentPane(new RegistrarseWindow(this));
		} else if (clase.equals(IntroWindow.class)) {
			this.setContentPane(new IntroWindow(this));
		} else if(clase.equals(GameWindow.class)) {
			this.setContentPane(new GameWindow(this,jugador));
		}
		this.getContentPane().setVisible(true);
	}

}
