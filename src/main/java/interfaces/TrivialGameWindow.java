package interfaces;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import clases.Enemigo;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;

public class TrivialGameWindow extends JPanel {

	private GeneralWindow window;
	private String respuesta;
	private Enemigo enemigo;
	private String respuestaCorrecta;
	JLabel enunciadoTitle;
	JLabel jugadorVida;
	JLabel enemigoDaño;
	JLabel enemigoName;
	JLabel enemigoVida;
	JButton contestarButton1;
	JButton contestarButton2;
	JButton contestarButton3;
	JButton contestarButton4;
	JButton botonSiguientePregunta;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public TrivialGameWindow(GeneralWindow w) {
		setPreferredSize(new Dimension(1300, 700));
		this.window = w;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 100, 0, 0, 0, 100, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel interfazJugador = new JPanel();
		interfazJugador.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagConstraints gbc_interfazJugador = new GridBagConstraints();
		gbc_interfazJugador.gridwidth = 12;
		gbc_interfazJugador.insets = new Insets(0, 0, 5, 0);
		gbc_interfazJugador.fill = GridBagConstraints.BOTH;
		gbc_interfazJugador.gridx = 0;
		gbc_interfazJugador.gridy = 1;
		add(interfazJugador, gbc_interfazJugador);
		GridBagLayout gbl_interfazJugador = new GridBagLayout();
		gbl_interfazJugador.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 147, 0, 0, 0, 0, 0, 0, 0 };
		gbl_interfazJugador.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_interfazJugador.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_interfazJugador.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		interfazJugador.setLayout(gbl_interfazJugador);

		JLabel jugadorName = new JLabel("New label");
		jugadorName.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		jugadorName.setText(window.jugador.getNombre() + " | ");
		GridBagConstraints gbc_jugadorName = new GridBagConstraints();
		gbc_jugadorName.gridwidth = 6;
		gbc_jugadorName.insets = new Insets(0, 0, 5, 5);
		gbc_jugadorName.gridx = 1;
		gbc_jugadorName.gridy = 1;
		interfazJugador.add(jugadorName, gbc_jugadorName);

		JLabel armaActual = new JLabel("New label");
		armaActual.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		armaActual.setText(
				window.jugador.getArma().getNombre() + " | Daño " + window.jugador.getArma().getDaño() + " | ");
		GridBagConstraints gbc_armaActual = new GridBagConstraints();
		gbc_armaActual.gridwidth = 3;
		gbc_armaActual.insets = new Insets(0, 0, 5, 5);
		gbc_armaActual.gridx = 8;
		gbc_armaActual.gridy = 1;
		interfazJugador.add(armaActual, gbc_armaActual);

		JLabel jugadorVidaText = new JLabel("New label");
		jugadorVidaText.setText("Vida:");
		jugadorVidaText.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		GridBagConstraints gbc_jugadorVidaText = new GridBagConstraints();
		gbc_jugadorVidaText.gridwidth = 2;
		gbc_jugadorVidaText.insets = new Insets(0, 0, 5, 5);
		gbc_jugadorVidaText.gridx = 12;
		gbc_jugadorVidaText.gridy = 1;
		interfazJugador.add(jugadorVidaText, gbc_jugadorVidaText);

		jugadorVida = new JLabel("0");
		jugadorVida.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		GridBagConstraints gbc_jugadorVida = new GridBagConstraints();
		gbc_jugadorVida.insets = new Insets(0, 0, 5, 5);
		gbc_jugadorVida.gridx = 14;
		gbc_jugadorVida.gridy = 1;
		interfazJugador.add(jugadorVida, gbc_jugadorVida);

		JLabel jugadorVidaMaxima = new JLabel("/100");
		jugadorVidaMaxima.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		GridBagConstraints gbc_jugadorVidaMaxima = new GridBagConstraints();
		gbc_jugadorVidaMaxima.insets = new Insets(0, 0, 5, 5);
		gbc_jugadorVidaMaxima.gridx = 15;
		gbc_jugadorVidaMaxima.gridy = 1;
		interfazJugador.add(jugadorVidaMaxima, gbc_jugadorVidaMaxima);

		JPanel interfazEnemigo = new JPanel();
		interfazEnemigo.setBorder(UIManager.getBorder("InternalFrame.border"));
		GridBagConstraints gbc_interfazEnemigo = new GridBagConstraints();
		gbc_interfazEnemigo.gridwidth = 12;
		gbc_interfazEnemigo.insets = new Insets(0, 0, 5, 0);
		gbc_interfazEnemigo.fill = GridBagConstraints.BOTH;
		gbc_interfazEnemigo.gridx = 0;
		gbc_interfazEnemigo.gridy = 5;
		add(interfazEnemigo, gbc_interfazEnemigo);
		GridBagLayout gbl_interfazEnemigo = new GridBagLayout();
		gbl_interfazEnemigo.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_interfazEnemigo.rowHeights = new int[] { 0, 49, 0, 0 };
		gbl_interfazEnemigo.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, Double.MIN_VALUE };
		gbl_interfazEnemigo.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		interfazEnemigo.setLayout(gbl_interfazEnemigo);

		enemigoName = new JLabel("<dynamic> | ");
		enemigoName.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		GridBagConstraints gbc_enemigoName = new GridBagConstraints();
		gbc_enemigoName.insets = new Insets(0, 0, 5, 5);
		gbc_enemigoName.gridx = 1;
		gbc_enemigoName.gridy = 1;
		interfazEnemigo.add(enemigoName, gbc_enemigoName);

		JLabel enemigoDañoText = new JLabel("Daño: ");
		enemigoDañoText.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		GridBagConstraints gbc_enemigoDañoText = new GridBagConstraints();
		gbc_enemigoDañoText.insets = new Insets(0, 0, 5, 5);
		gbc_enemigoDañoText.gridx = 3;
		gbc_enemigoDañoText.gridy = 1;
		interfazEnemigo.add(enemigoDañoText, gbc_enemigoDañoText);

		enemigoDaño = new JLabel("");
		enemigoDaño.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		GridBagConstraints gbc_enemigoDaño = new GridBagConstraints();
		gbc_enemigoDaño.insets = new Insets(0, 0, 5, 5);
		gbc_enemigoDaño.gridx = 4;
		gbc_enemigoDaño.gridy = 1;
		interfazEnemigo.add(enemigoDaño, gbc_enemigoDaño);

		JLabel enemigoVidaText = new JLabel("Vida:");
		enemigoVidaText.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		GridBagConstraints gbc_enemigoVidaText = new GridBagConstraints();
		gbc_enemigoVidaText.insets = new Insets(0, 0, 5, 5);
		gbc_enemigoVidaText.gridx = 5;
		gbc_enemigoVidaText.gridy = 1;
		interfazEnemigo.add(enemigoVidaText, gbc_enemigoVidaText);

		enemigoVida = new JLabel("0");
		enemigoVida.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		GridBagConstraints gbc_enemigoVida = new GridBagConstraints();
		gbc_enemigoVida.insets = new Insets(0, 0, 5, 5);
		gbc_enemigoVida.gridx = 6;
		gbc_enemigoVida.gridy = 1;
		interfazEnemigo.add(enemigoVida, gbc_enemigoVida);

		JLabel enemigoVidaMaxima = new JLabel("/100");
		enemigoVidaMaxima.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		GridBagConstraints gbc_enemigoVidaMaxima = new GridBagConstraints();
		gbc_enemigoVidaMaxima.insets = new Insets(0, 0, 5, 5);
		gbc_enemigoVidaMaxima.gridx = 7;
		gbc_enemigoVidaMaxima.gridy = 1;
		interfazEnemigo.add(enemigoVidaMaxima, gbc_enemigoVidaMaxima);

		JPanel interfazGeneral = new JPanel();
		interfazGeneral.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		GridBagConstraints gbc_interfazGeneral = new GridBagConstraints();
		gbc_interfazGeneral.gridheight = 2;
		gbc_interfazGeneral.gridwidth = 12;
		gbc_interfazGeneral.insets = new Insets(0, 0, 5, 0);
		gbc_interfazGeneral.fill = GridBagConstraints.BOTH;
		gbc_interfazGeneral.gridx = 0;
		gbc_interfazGeneral.gridy = 3;
		add(interfazGeneral, gbc_interfazGeneral);
		GridBagLayout gbl_interfazGeneral = new GridBagLayout();
		gbl_interfazGeneral.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_interfazGeneral.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_interfazGeneral.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_interfazGeneral.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		interfazGeneral.setLayout(gbl_interfazGeneral);

		enunciadoTitle = new JLabel("Enunciado");
		enunciadoTitle.setFont(new Font("HYWenHei-85W", Font.PLAIN, 28));
		GridBagConstraints gbc_enunciadoTitle = new GridBagConstraints();
		gbc_enunciadoTitle.insets = new Insets(0, 0, 5, 0);
		gbc_enunciadoTitle.gridwidth = 9;
		gbc_enunciadoTitle.gridx = 0;
		gbc_enunciadoTitle.gridy = 1;
		interfazGeneral.add(enunciadoTitle, gbc_enunciadoTitle);

		contestarButton1 = new JButton("Contestar");
		contestarButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				respuesta = contestarButton1.getText();
				if (respuesta.equals(respuestaCorrecta)) {
					System.out.println("Respuesta Correcta" + " enemigo: " + enemigo.getVida());
					enemigo.restarVidaEnemigo(window.jugador);
					enemigoVida.setText("" + enemigo.getVida());
					desactivarBotones();
					botonSiguientePregunta.setEnabled(true);
				} else {
					System.out.println("Respuesta Incorrecta" + " jugador: " + window.jugador.getVida());
					window.jugador.restarVidaJugador(enemigo);
					jugadorVida.setText("" + window.jugador.getVida());
					desactivarBotones();
					botonSiguientePregunta.setEnabled(true);

				}
			}
		});
		contestarButton1.setFont(new Font("HYWenHei-85W", Font.PLAIN, 18));
		buttonGroup.add(contestarButton1);
		GridBagConstraints gbc_contestarButton1 = new GridBagConstraints();
		gbc_contestarButton1.gridwidth = 9;
		gbc_contestarButton1.insets = new Insets(0, 0, 5, 5);
		gbc_contestarButton1.gridx = 0;
		gbc_contestarButton1.gridy = 3;
		interfazGeneral.add(contestarButton1, gbc_contestarButton1);

		contestarButton2 = new JButton("Contestar");
		contestarButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				respuesta = contestarButton2.getText();
				if (respuesta.equals(respuestaCorrecta)) {
					System.out.println("Respuesta Correcta" + " enemigo: " + enemigo.getVida());
					enemigo.restarVidaEnemigo(window.jugador);
					enemigoVida.setText("" + enemigo.getVida());
					desactivarBotones();
					botonSiguientePregunta.setEnabled(true);
				} else {
					System.out.println("Respuesta Incorrecta" + " jugador: " + window.jugador.getVida());
					window.jugador.restarVidaJugador(enemigo);
					jugadorVida.setText("" + window.jugador.getVida());
					desactivarBotones();
					botonSiguientePregunta.setEnabled(true);

				}
			}
		});
		contestarButton2.setFont(new Font("HYWenHei-85W", Font.PLAIN, 18));
		buttonGroup.add(contestarButton2);
		GridBagConstraints gbc_contestarButton2 = new GridBagConstraints();
		gbc_contestarButton2.gridwidth = 9;
		gbc_contestarButton2.insets = new Insets(0, 0, 5, 5);
		gbc_contestarButton2.gridx = 0;
		gbc_contestarButton2.gridy = 4;
		interfazGeneral.add(contestarButton2, gbc_contestarButton2);

		contestarButton3 = new JButton("Contestar");
		contestarButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				respuesta = contestarButton3.getText();

				if (respuesta.equals(respuestaCorrecta)) {
					System.out.println("Respuesta Correcta" + " enemigo: " + enemigo.getVida());
					enemigo.restarVidaEnemigo(window.jugador);
					enemigoVida.setText("" + enemigo.getVida());
					desactivarBotones();
					botonSiguientePregunta.setEnabled(true);
				} else {
					System.out.println("Respuesta Incorrecta" + " jugador: " + window.jugador.getVida());
					window.jugador.restarVidaJugador(enemigo);
					jugadorVida.setText("" + window.jugador.getVida());
					desactivarBotones();
					botonSiguientePregunta.setEnabled(true);

				}
			}
		});
		contestarButton3.setFont(new Font("HYWenHei-85W", Font.PLAIN, 18));
		buttonGroup.add(contestarButton3);
		GridBagConstraints gbc_contestarButton3 = new GridBagConstraints();
		gbc_contestarButton3.gridwidth = 9;
		gbc_contestarButton3.insets = new Insets(0, 0, 5, 5);
		gbc_contestarButton3.gridx = 0;
		gbc_contestarButton3.gridy = 5;
		interfazGeneral.add(contestarButton3, gbc_contestarButton3);

		contestarButton4 = new JButton("Contestar");
		contestarButton4.setFont(new Font("HYWenHei-85W", Font.PLAIN, 18));
		buttonGroup.add(contestarButton4);
		contestarButton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				respuesta = contestarButton4.getText();

				if (respuesta.equals(respuestaCorrecta)) {
					System.out.println("Respuesta Correcta" + " enemigo: " + enemigo.getVida());
					enemigo.restarVidaEnemigo(window.jugador);
					enemigoVida.setText("" + enemigo.getVida());
					desactivarBotones();
					botonSiguientePregunta.setEnabled(true);
				} else {
					System.out.println("Respuesta Incorrecta" + " jugador: " + window.jugador.getVida());
					window.jugador.restarVidaJugador(enemigo);
					jugadorVida.setText("" + window.jugador.getVida());
					desactivarBotones();
					botonSiguientePregunta.setEnabled(true);

				}
			}
		});
		GridBagConstraints gbc_contestarButton4 = new GridBagConstraints();
		gbc_contestarButton4.gridwidth = 9;
		gbc_contestarButton4.insets = new Insets(0, 0, 5, 5);
		gbc_contestarButton4.gridx = 0;
		gbc_contestarButton4.gridy = 6;
		interfazGeneral.add(contestarButton4, gbc_contestarButton4);

		botonSiguientePregunta = new JButton("Siguiente Pregunta");
		botonSiguientePregunta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					siguientePregunta();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		GridBagConstraints gbc_botonSiguientePregunta = new GridBagConstraints();
		gbc_botonSiguientePregunta.insets = new Insets(0, 0, 5, 5);
		gbc_botonSiguientePregunta.gridx = 9;
		gbc_botonSiguientePregunta.gridy = 6;
		add(botonSiguientePregunta, gbc_botonSiguientePregunta);

	}

	public void invocarEnemigo(String nombre, Short vida, Short daño) throws SQLException {
		enemigo = new Enemigo(nombre, vida, daño);
		// Inicializamos el nombre y daño del enemigo
		enemigoDaño.setText("" + enemigo.getAtaque() + " | ");
		enemigoName.setText(enemigo.getNombre() + " | ");
		botonSiguientePregunta.setEnabled(false);
		actualizarInformacion();
	}

	public String ajustarTexto() {
		short cadenaVacio = 0;
		String enunciado = enemigo.getTrivial().getPreguntas().get(0).getEnunciado();
		for (short i = (short) (enunciado.length() / 2); i < enunciado.length(); i++) {
			if (enunciado.charAt(i) == ' ') {
				cadenaVacio = i;
				break;
			}
		}
		String enunciado1 = enunciado.substring(0, cadenaVacio);
		String enunciado2 = enunciado.substring(cadenaVacio, enunciado.length());
		return enunciado = "<html>" + enunciado1 + "<br>" + enunciado2 + "</html>";
	}

	public void actualizarInformacion() {
		ArrayList<String> respuestas = enemigo.getTrivial().respuestas(enemigo.getTrivial());
		respuestaCorrecta = enemigo.getTrivial().respuestaCorrecta(enemigo.getTrivial());

		// Rellenamos el texto del enunciado y los botones
		enunciadoTitle.setText(ajustarTexto());
		contestarButton1.setText(respuestas.get(0));
		contestarButton2.setText(respuestas.get(1));
		contestarButton3.setText(respuestas.get(2));
		contestarButton4.setText(respuestas.get(3));

		ajustarVida();
	}

	public void ajustarVida() {
		if (window.jugador.getVida() > 0) {
			jugadorVida.setText("" + window.jugador.getVida());
		} else if (window.jugador.getVida() <= 0) {
			jugadorVida.setText("0");
		}

		if (enemigo.getVida() > 0) {
			enemigoVida.setText("" + enemigo.getVida());
		} else if (enemigo.getVida() <= 0) {
			enemigoVida.setText("0");
		}
	}

	public void siguientePregunta() throws SQLException {
		if (window.jugador.jugadorVivo() && enemigo.enemigovivo()) {
			enemigo = new Enemigo(enemigo.getNombre(), enemigo.getVida(), enemigo.getAtaque());
			actualizarInformacion();
			activarBotones();
			botonSiguientePregunta.setEnabled(false);
		} else if (window.jugador.jugadorVivo() == false) {
			System.out.println("Jugador muerto");
		} else {
			System.out.println("Enemigo muerto");
		}
	}

	public void desactivarBotones() {
		contestarButton1.setEnabled(false);
		contestarButton2.setEnabled(false);
		contestarButton3.setEnabled(false);
		contestarButton4.setEnabled(false);
	}

	public void activarBotones() {
		contestarButton1.setEnabled(true);
		contestarButton2.setEnabled(true);
		contestarButton3.setEnabled(true);
		contestarButton4.setEnabled(true);
	}

}
