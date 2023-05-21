package interfaces;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import clases.Enemigo;
import clases.Pregunta;
import clases.Trivial;
import utils.Config;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class DebugWindow extends JPanel {

	private GeneralWindow window;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String respuesta;
	private Enemigo enemigo;
	private Trivial trivial;
	private String respuestaCorrecta;

	public DebugWindow(GeneralWindow w) {
		setPreferredSize(new Dimension(1300, 700));
		this.window = w;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbl_interfazJugador.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_interfazJugador.rowHeights = new int[]{0, 0, 0, 0};
		gbl_interfazJugador.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_interfazJugador.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		interfazJugador.setLayout(gbl_interfazJugador);
		
		JLabel jugadorName = new JLabel("New label");
		jugadorName.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		jugadorName.setText(window.jugador.getNombre());
		GridBagConstraints gbc_jugadorName = new GridBagConstraints();
		gbc_jugadorName.gridwidth = 5;
		gbc_jugadorName.insets = new Insets(0, 0, 5, 5);
		gbc_jugadorName.gridx = 1;
		gbc_jugadorName.gridy = 1;
		interfazJugador.add(jugadorName, gbc_jugadorName);
		
		JLabel armaActual = new JLabel("New label");
		armaActual.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		armaActual.setText(window.jugador.getArma().getNombre() + " | Daño " + window.jugador.getArma().getDaño());
		GridBagConstraints gbc_armaActual = new GridBagConstraints();
		gbc_armaActual.gridwidth = 2;
		gbc_armaActual.insets = new Insets(0, 0, 5, 5);
		gbc_armaActual.gridx = 7;
		gbc_armaActual.gridy = 1;
		interfazJugador.add(armaActual, gbc_armaActual);
		
		JLabel jugadorVida = new JLabel("New label");
		jugadorVida.setText(String.valueOf("Vida: " + window.jugador.getVida() + "/100"));
		jugadorVida.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		GridBagConstraints gbc_jugadorVida = new GridBagConstraints();
		gbc_jugadorVida.insets = new Insets(0, 0, 5, 5);
		gbc_jugadorVida.gridx = 10;
		gbc_jugadorVida.gridy = 1;
		interfazJugador.add(jugadorVida, gbc_jugadorVida);
		
		JPanel interfazGeneral = new JPanel();
		interfazGeneral.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		GridBagConstraints gbc_interfazGeneral = new GridBagConstraints();
		gbc_interfazGeneral.gridheight = 3;
		gbc_interfazGeneral.gridwidth = 10;
		gbc_interfazGeneral.insets = new Insets(0, 0, 5, 5);
		gbc_interfazGeneral.fill = GridBagConstraints.BOTH;
		gbc_interfazGeneral.gridx = 1;
		gbc_interfazGeneral.gridy = 3;
		add(interfazGeneral, gbc_interfazGeneral);
		GridBagLayout gbl_interfazGeneral = new GridBagLayout();
		gbl_interfazGeneral.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_interfazGeneral.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_interfazGeneral.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_interfazGeneral.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		interfazGeneral.setLayout(gbl_interfazGeneral);
		
		JLabel enunciadoTitle = new JLabel("aaaaaaaaaaa");
		enunciadoTitle.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		GridBagConstraints gbc_enunciadoTitle = new GridBagConstraints();
		gbc_enunciadoTitle.insets = new Insets(0, 0, 5, 0);
		gbc_enunciadoTitle.gridwidth = 9;
		gbc_enunciadoTitle.gridx = 0;
		gbc_enunciadoTitle.gridy = 1;
		interfazGeneral.add(enunciadoTitle, gbc_enunciadoTitle);
		
		JRadioButton respuesta1 = new JRadioButton("New radio button");
		respuesta1.setFont(new Font("HYWenHei-85W", Font.PLAIN, 15));
		buttonGroup.add(respuesta1);
		GridBagConstraints gbc_respuesta1 = new GridBagConstraints();
		gbc_respuesta1.insets = new Insets(0, 0, 5, 5);
		gbc_respuesta1.gridx = 4;
		gbc_respuesta1.gridy = 2;
		interfazGeneral.add(respuesta1, gbc_respuesta1);
		
		JRadioButton respuesta2 = new JRadioButton("New radio button");
		respuesta2.setFont(new Font("HYWenHei-85W", Font.PLAIN, 15));
		buttonGroup.add(respuesta2);
		GridBagConstraints gbc_respuesta2 = new GridBagConstraints();
		gbc_respuesta2.insets = new Insets(0, 0, 5, 5);
		gbc_respuesta2.gridx = 4;
		gbc_respuesta2.gridy = 3;
		interfazGeneral.add(respuesta2, gbc_respuesta2);
		
		JRadioButton respuesta3 = new JRadioButton("New radio button");
		respuesta3.setFont(new Font("HYWenHei-85W", Font.PLAIN, 15));
		buttonGroup.add(respuesta3);
		GridBagConstraints gbc_respuesta3 = new GridBagConstraints();
		gbc_respuesta3.insets = new Insets(0, 0, 5, 5);
		gbc_respuesta3.gridx = 4;
		gbc_respuesta3.gridy = 4;
		interfazGeneral.add(respuesta3, gbc_respuesta3);
		
		JRadioButton respuesta4 = new JRadioButton("New radio button");
		respuesta4.setFont(new Font("HYWenHei-85W", Font.PLAIN, 15));
		buttonGroup.add(respuesta4);
		GridBagConstraints gbc_respuesta4 = new GridBagConstraints();
		gbc_respuesta4.insets = new Insets(0, 0, 5, 5);
		gbc_respuesta4.gridx = 4;
		gbc_respuesta4.gridy = 5;
		interfazGeneral.add(respuesta4, gbc_respuesta4);
		
		JButton contestarButton = new JButton("Contestar");
		contestarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				respuesta = buttonGroup.getSelection().toString();
				if(window.jugador.jugadorVivo() == true || enemigo.enemigovivo() == true) {
					if(respuesta.equals(respuestaCorrecta)) {
						enemigo.restarVidaEnemigo(window.jugador);
					} else {
						window.jugador.restarVidaJugador(enemigo);
					}
				}
			}
		});
		GridBagConstraints gbc_contestarButton = new GridBagConstraints();
		gbc_contestarButton.insets = new Insets(0, 0, 5, 5);
		gbc_contestarButton.gridx = 5;
		gbc_contestarButton.gridy = 6;
		interfazGeneral.add(contestarButton, gbc_contestarButton);
		
		JLabel prueba = new JLabel("New label");
		GridBagConstraints gbc_prueba = new GridBagConstraints();
		gbc_prueba.insets = new Insets(0, 0, 5, 5);
		gbc_prueba.gridx = 0;
		gbc_prueba.gridy = 6;
		add(prueba, gbc_prueba);
		
		JButton enemigoRandom = new JButton("Enemigo random");
		enemigoRandom.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					enemigo = new Enemigo("Paco", (short) 100, (short) 5, trivial);
					//enunciadoTitle.setText(trivial.getPreguntas().get(0).getEnunciado());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				while (enemigo.getVida() >= 0) {
					try {
						enemigo = new Enemigo("Paco", (short) enemigo.getVida(), (short) 5, new Trivial());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Pregunta pregunta = enemigo.getTrivial().getPreguntas().get(0);
					HashMap<String, Boolean> respuestas = pregunta.getRespuestas();

					for (Map.Entry<String, Boolean> entry : respuestas.entrySet()) {
					    if (entry.getValue()) {
					        respuestaCorrecta = entry.getKey();
					        break;
					    }
					}
					enunciadoTitle.setText(trivial.getPreguntas().get(0).getEnunciado());
					
				}
			}
		});
		GridBagConstraints gbc_enemigoRandom = new GridBagConstraints();
		gbc_enemigoRandom.insets = new Insets(0, 0, 5, 5);
		gbc_enemigoRandom.gridx = 0;
		gbc_enemigoRandom.gridy = 5;
		add(enemigoRandom, gbc_enemigoRandom);
		
		
		JPanel interfazChat = new JPanel();
		interfazChat.setBorder(UIManager.getBorder("DesktopIcon.border"));
		GridBagConstraints gbc_interfazChat = new GridBagConstraints();
		gbc_interfazChat.gridheight = 4;
		gbc_interfazChat.gridwidth = 12;
		gbc_interfazChat.fill = GridBagConstraints.BOTH;
		gbc_interfazChat.gridx = 0;
		gbc_interfazChat.gridy = 7;
		add(interfazChat, gbc_interfazChat);
	}
}
