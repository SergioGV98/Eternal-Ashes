package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import clases.Arma;
import clases.Jugador;
import exceptions.NombreConNumeroException;
import exceptions.NombreLargoException;
import utils.Config;
import utils.DAO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class IntroWindow extends JPanel {

	private GeneralWindow window;
	private JTextField textFieldName;

	public IntroWindow(GeneralWindow w) {
		setPreferredSize(new Dimension(1650, 1000));
		this.window = w;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{300, 96, 376, 418, 0, 0};
		gridBagLayout.rowHeights = new int[]{65, 251, 0, 171, 194, 0, -166, 60, 21, 120, 93, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
				JLabel historiaIntro4 = new JLabel(
						"<html>Despierta, héroe, es hora de cumplir tu destino y salvar al mundo una vez más.<br></html>");
				historiaIntro4.setVerticalAlignment(SwingConstants.TOP);
				historiaIntro4.setHorizontalAlignment(SwingConstants.CENTER);
				historiaIntro4.setForeground(Color.BLACK);
				historiaIntro4.setFont(new Font("HYWenHei-85W", Font.PLAIN, 40));
				historiaIntro4.setVisible(false);
				
						textFieldName = new JTextField();
						textFieldName.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
						textFieldName.setVisible(false);
						
								JLabel historiaIntro2 = new JLabel(
										"<html>Sin embargo, durante el proceso de sellado, el artefacto mágico explotó, matando a todos los héroes, excepto uno que quedó gravemente herido.<br>"
												+ "<br>Para evitar que los demonios escaparan del sello incompleto, los sobrevivientes tomaron la difícil decisión de colocar al último héroe restante en un sueño mágico profundo, donde permanecería hasta que fuera el momento adecuado para completar la tarea.<br></html>");
								historiaIntro2.setVerticalAlignment(SwingConstants.TOP);
								historiaIntro2.setHorizontalAlignment(SwingConstants.CENTER);
								historiaIntro2.setForeground(Color.BLACK);
								historiaIntro2.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
								historiaIntro2.setVisible(false);
								
										JLabel historiaIntro = new JLabel(
												"<html>Hace mil años, en un mundo en el que humanos y criaturas mágicas vivían en paz y armonía, un día una raza poderosa de seres demoníacos invadió el planeta, desatando el caos y la destrucción en todo su camino.<br>"
														+ "<br>Los humanos y las criaturas mágicas se unieron para hacer frente a la invasión y, tras una ardua batalla, lograron repeler a los demonios y sellarlos en su propio reino.<br>"
														+ "<br>Para llevar a cabo este acto de valentía, un grupo de héroes se aventuró a través de los territorios enemigos, portando un artefacto mágico ancestral que les permitiría completar el sello y proteger al mundo."
														+ "</html>");
										historiaIntro.setForeground(new Color(0, 0, 0));
										historiaIntro.setVerticalAlignment(SwingConstants.TOP);
										historiaIntro.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
										historiaIntro.setHorizontalAlignment(SwingConstants.CENTER);
										historiaIntro.setVisible(true);
										
												JLabel nameLabel = new JLabel("¿Recuerdas tu nombre, eterno?");
												nameLabel.setFont(new Font("HYWenHei-85W", Font.PLAIN, 50));
												nameLabel.setVisible(false);
												GridBagConstraints gbc_nameLabel = new GridBagConstraints();
												gbc_nameLabel.anchor = GridBagConstraints.SOUTH;
												gbc_nameLabel.fill = GridBagConstraints.HORIZONTAL;
												gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
												gbc_nameLabel.gridwidth = 2;
												gbc_nameLabel.gridx = 1;
												gbc_nameLabel.gridy = 2;
												add(nameLabel, gbc_nameLabel);
										GridBagConstraints gbc_historiaIntro = new GridBagConstraints();
										gbc_historiaIntro.anchor = GridBagConstraints.NORTH;
										gbc_historiaIntro.fill = GridBagConstraints.HORIZONTAL;
										gbc_historiaIntro.insets = new Insets(0, 0, 5, 5);
										gbc_historiaIntro.gridwidth = 3;
										gbc_historiaIntro.gridx = 1;
										gbc_historiaIntro.gridy = 3;
										add(historiaIntro, gbc_historiaIntro);
								GridBagConstraints gbc_historiaIntro2 = new GridBagConstraints();
								gbc_historiaIntro2.fill = GridBagConstraints.BOTH;
								gbc_historiaIntro2.insets = new Insets(0, 0, 5, 5);
								gbc_historiaIntro2.gridwidth = 3;
								gbc_historiaIntro2.gridx = 1;
								gbc_historiaIntro2.gridy = 4;
								add(historiaIntro2, gbc_historiaIntro2);
						GridBagConstraints gbc_textFieldName = new GridBagConstraints();
						gbc_textFieldName.anchor = GridBagConstraints.SOUTH;
						gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
						gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
						gbc_textFieldName.gridx = 1;
						gbc_textFieldName.gridy = 4;
						add(textFieldName, gbc_textFieldName);
						textFieldName.setColumns(10);
				
						JLabel reglasLabel = new JLabel(
								"<html>Por favor, ten en cuenta que el uso de nombres sin números<br> y de una longitud no mayor a 15 caracteres.<html>");
						reglasLabel.setForeground(new Color(255, 0, 0));
						reglasLabel.setFont(new Font("HYWenHei-85W", Font.PLAIN, 15));
						reglasLabel.setVisible(false);
						
								JLabel historiaIntro3 = new JLabel(
										"<html>Mil años después, el mundo ha cambiado drásticamente. La gente ha olvidado la invasión de los demonios y la historia de los héroes que los salvaron.<br>"
												+ "<br>Sin embargo, los demonios han encontrado la forma de liberarse de su prisión y han comenzado a invadir el mundo de nuevo.<br></html>");
								historiaIntro3.setVerticalAlignment(SwingConstants.TOP);
								historiaIntro3.setHorizontalAlignment(SwingConstants.CENTER);
								historiaIntro3.setForeground(Color.BLACK);
								historiaIntro3.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
								historiaIntro3.setVisible(false);
								GridBagConstraints gbc_historiaIntro3 = new GridBagConstraints();
								gbc_historiaIntro3.fill = GridBagConstraints.BOTH;
								gbc_historiaIntro3.insets = new Insets(0, 0, 5, 5);
								gbc_historiaIntro3.gridwidth = 3;
								gbc_historiaIntro3.gridx = 1;
								gbc_historiaIntro3.gridy = 5;
								add(historiaIntro3, gbc_historiaIntro3);
						GridBagConstraints gbc_reglasLabel = new GridBagConstraints();
						gbc_reglasLabel.anchor = GridBagConstraints.WEST;
						gbc_reglasLabel.fill = GridBagConstraints.VERTICAL;
						gbc_reglasLabel.insets = new Insets(0, 0, 5, 5);
						gbc_reglasLabel.gridx = 1;
						gbc_reglasLabel.gridy = 5;
						add(reglasLabel, gbc_reglasLabel);
				
						JButton continuarButton = new JButton("Continuar");
						continuarButton.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								LinkedHashSet<String> consulta = new LinkedHashSet<String>();
								consulta.add("nombre");
								consulta.add("daño");
								HashMap<String, Object> restricciones = new HashMap<String, Object>();
								restricciones.put("nombre", "Garrote oxidado");
								ArrayList<Object> informacion = null;
								try {
									informacion = DAO.consultar("armas", restricciones, consulta);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								if (Config.verboseMode) {
									System.out.println(informacion);
								}
								Arma armaInicial = new Arma((String) informacion.get(0), (int) informacion.get(1));
								
								try {
									String nombre = textFieldName.getText();
									window.jugadorPrincipal = new Jugador(nombre, (short) 100, armaInicial);
									if(Config.verboseMode && window.jugadorPrincipal != null) {
										System.out.println(window.jugadorPrincipal.getNombre() + " | " + window.jugadorPrincipal.getArma());
									}
									window.cambiarPantalla(GameWindow.class);
								} catch (NombreConNumeroException | NombreLargoException e1) {
									JOptionPane.showMessageDialog(window, "Ese nombre no es valido");
									textFieldName.setText("");
									e1.printStackTrace();
								}
							}
						});
						continuarButton.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
						continuarButton.setEnabled(false);
						continuarButton.setVisible(false);
						GridBagConstraints gbc_continuarButton = new GridBagConstraints();
						gbc_continuarButton.fill = GridBagConstraints.VERTICAL;
						gbc_continuarButton.insets = new Insets(0, 0, 5, 5);
						gbc_continuarButton.gridx = 1;
						gbc_continuarButton.gridy = 7;
						add(continuarButton, gbc_continuarButton);
				GridBagConstraints gbc_historiaIntro4 = new GridBagConstraints();
				gbc_historiaIntro4.fill = GridBagConstraints.BOTH;
				gbc_historiaIntro4.insets = new Insets(0, 0, 0, 5);
				gbc_historiaIntro4.gridheight = 3;
				gbc_historiaIntro4.gridx = 1;
				gbc_historiaIntro4.gridy = 8;
				add(historiaIntro4, gbc_historiaIntro4);

		JLabel[] etiquetas = { historiaIntro, historiaIntro2, historiaIntro3, historiaIntro4 };
		
				JButton siguienteButton = new JButton("Siguiente");
				siguienteButton.addActionListener(new ActionListener() {
					byte contador = 0;

					@Override
					public void actionPerformed(ActionEvent e) {
						if (contador < etiquetas.length - 1) {
							etiquetas[contador].setVisible(false);
							contador++;
							etiquetas[contador].setVisible(true);
						} else {
							historiaIntro4.setVisible(false);
							siguienteButton.setEnabled(false);
							siguienteButton.setVisible(false);
							nameLabel.setVisible(true);
							textFieldName.setVisible(true);
							reglasLabel.setVisible(true);
							continuarButton.setVisible(true);
							continuarButton.setEnabled(true);
						}
					}
				});
				
						siguienteButton.setFont(new Font("HYWenHei-85W", Font.PLAIN, 18));
						siguienteButton.setVisible(true);
						GridBagConstraints gbc_siguienteButton = new GridBagConstraints();
						gbc_siguienteButton.insets = new Insets(0, 0, 0, 5);
						gbc_siguienteButton.anchor = GridBagConstraints.NORTH;
						gbc_siguienteButton.fill = GridBagConstraints.HORIZONTAL;
						gbc_siguienteButton.gridx = 3;
						gbc_siguienteButton.gridy = 10;
						add(siguienteButton, gbc_siguienteButton);

	}
}
