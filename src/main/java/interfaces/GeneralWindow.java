package interfaces;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class GeneralWindow extends JFrame {

	public GeneralWindow() {
		this.setTitle("Eternal Ashes");
		this.setContentPane(new MainMenuWindow(this));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Obtener la resolución de pantalla
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        // Establecer el tamaño y la posición de la ventana
        this.setSize(width, height);
        this.setLocation(0, 0);

        // Establecer la ventana en modo pantalla completa
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Mostrar la ventana
        this.setVisible(true);
    }
}
