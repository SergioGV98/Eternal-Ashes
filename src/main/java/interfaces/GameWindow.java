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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GameWindow extends JPanel{
	
	private GeneralWindow window;

	public GameWindow(GeneralWindow w) {
		
		setPreferredSize(new Dimension(1650, 1000));
		this.window = w;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{34, -122, 0, 225, 456, 286, 0, 0};
		gridBagLayout.rowHeights = new int[]{201, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel jugadorName = new JLabel("");
		jugadorName.setFont(new Font("HYWenHei-85W", Font.PLAIN, 30));
		jugadorName.setText(window.jugadorPrincipal.getNombre());
		GridBagConstraints gbc_jugadorName = new GridBagConstraints();
		gbc_jugadorName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jugadorName.insets = new Insets(0, 0, 0, 5);
		gbc_jugadorName.gridx = 3;
		gbc_jugadorName.gridy = 0;
		add(jugadorName, gbc_jugadorName);
		
		JLabel armaActual = new JLabel("");
		armaActual.setFont(new Font("HYWenHei-85W", Font.PLAIN, 30));
		armaActual.setText(window.jugadorPrincipal.getArma().getNombre() + " | Daño " + window.jugadorPrincipal.getArma().getDaño());
		GridBagConstraints gbc_armaActual = new GridBagConstraints();
		gbc_armaActual.insets = new Insets(0, 0, 0, 5);
		gbc_armaActual.gridwidth = 3;
		gbc_armaActual.gridx = 3;
		gbc_armaActual.gridy = 0;
		add(armaActual, gbc_armaActual);
		
		JLabel jugadorVida = new JLabel("");
		jugadorVida.setFont(new Font("HYWenHei-85W", Font.PLAIN, 30));
		jugadorVida.setText(String.valueOf("Vida: " + this.window.jugadorPrincipal.getVida() + "/100"));
		GridBagConstraints gbc_jugadorVida = new GridBagConstraints();
		gbc_jugadorVida.insets = new Insets(0, 0, 0, 5);
		gbc_jugadorVida.fill = GridBagConstraints.HORIZONTAL;
		gbc_jugadorVida.gridx = 5;
		gbc_jugadorVida.gridy = 0;
		add(jugadorVida, gbc_jugadorVida);

		
	}
}
