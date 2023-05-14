package interfaces;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Jugador;
import exceptions.NombreConNumeroException;
import exceptions.NombreLargoException;
import java.awt.Font;
import javax.swing.ImageIcon;

public class GameWindow extends JPanel{
	
	private GeneralWindow window;
	private Jugador jugador;


	public GameWindow(GeneralWindow w, Jugador jugador) {
		
		setPreferredSize(new Dimension(1650, 1000));
		this.window = w;
		this.jugador = jugador;
		setLayout(null);
		
		JLabel jugadorImagen = new JLabel("");
		jugadorImagen.setIcon(new ImageIcon("images\\profile.png"));
		jugadorImagen.setBounds(34, 23, 217, 201);
		add(jugadorImagen);
		
		JLabel jugadorName = new JLabel("");
		jugadorName.setFont(new Font("HYWenHei-85W", Font.PLAIN, 30));
		jugadorName.setBounds(328, 87, 360, 55);
		jugadorName.setText(this.jugador.getNombre());
		add(jugadorName);
		
		JLabel armaActual = new JLabel("");
		armaActual.setFont(new Font("HYWenHei-85W", Font.PLAIN, 30));
		armaActual.setBounds(600, 87, 548, 55);
		armaActual.setText(jugador.getArma().getNombre() + " | Daño " + jugador.getArma().getDaño());
		add(armaActual);
		
		JLabel jugadorVida = new JLabel("");
		jugadorVida.setFont(new Font("HYWenHei-85W", Font.PLAIN, 30));
		jugadorVida.setBounds(1144, 76, 286, 77);
		jugadorVida.setText(String.valueOf("Vida: " + this.jugador.getVida() + "/100"));
		add(jugadorVida);

		
	}
}
