package interfaces;

import javax.swing.JFrame;

import clases.Jugador;

public class GeneralWindow extends JFrame {
	
	protected Jugador jugador;

	public GeneralWindow() {
		this.setTitle("Eternal Ashes");
		this.setSize(1300, 700);
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
		} else if (clase.equals(IntroWindow.class)) {
			this.setContentPane(new IntroWindow(this));
		} else if(clase.equals(GameWindow.class)) {
			this.setContentPane(new GameWindow(this));
		} else if(clase.equals(TrivialGameWindow.class)) {
			this.setContentPane(new TrivialGameWindow(this));
		}
		this.getContentPane().setVisible(true);
	}

}
