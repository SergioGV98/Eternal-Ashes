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
import exceptions.NombreVacioException;
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

public class IntroWindow extends JPanel {

	private GeneralWindow window;
	private JTextField textFieldName;

	public IntroWindow(GeneralWindow w) {
		setPreferredSize(new Dimension(1300, 700));
		this.window = w;
		setLayout(null);

		JLabel historiaIntro = new JLabel(
				"<html>Hace mil años, en un mundo en el que humanos y criaturas mágicas vivían en paz y armonía, un día una raza poderosa de seres demoníacos invadió el planeta, desatando el caos y la destrucción en todo su camino.<br>"
						+ "<br>Los humanos y las criaturas mágicas se unieron para hacer frente a la invasión y, tras una ardua batalla, lograron repeler a los demonios y sellarlos en su propio reino.<br>"
						+ "<br>Para llevar a cabo este acto de valentía, un grupo de héroes se aventuró a través de los territorios enemigos, portando un artefacto mágico ancestral que les permitiría completar el sello y proteger al mundo."
						+ "</html>");
		historiaIntro.setForeground(new Color(0, 0, 0));
		historiaIntro.setVerticalAlignment(SwingConstants.TOP);
		historiaIntro.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		historiaIntro.setHorizontalAlignment(SwingConstants.CENTER);
		historiaIntro.setBounds(145, 11, 1112, 234);
		historiaIntro.setVisible(true);
		add(historiaIntro);

		JLabel historiaIntro2 = new JLabel(
				"<html>Sin embargo, durante el proceso de sellado, el artefacto mágico explotó, matando a todos los héroes, excepto uno que quedó gravemente herido.<br>"
						+ "<br>Para evitar que los demonios escaparan del sello incompleto, los sobrevivientes tomaron la difícil decisión de colocar al último héroe restante en un sueño mágico profundo, donde permanecería hasta que fuera el momento adecuado para completar la tarea.<br></html>");
		historiaIntro2.setVerticalAlignment(SwingConstants.TOP);
		historiaIntro2.setHorizontalAlignment(SwingConstants.CENTER);
		historiaIntro2.setForeground(Color.BLACK);
		historiaIntro2.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		historiaIntro2.setBounds(145, 260, 1112, 183);
		historiaIntro2.setVisible(false);
		add(historiaIntro2);

		JLabel historiaIntro3 = new JLabel(
				"<html>Mil años después, el mundo ha cambiado drásticamente. La gente ha olvidado la invasión de los demonios y la historia de los héroes que los salvaron.<br>"
						+ "<br>Sin embargo, los demonios han encontrado la forma de liberarse de su prisión y han comenzado a invadir el mundo de nuevo.<br></html>");
		historiaIntro3.setVerticalAlignment(SwingConstants.TOP);
		historiaIntro3.setHorizontalAlignment(SwingConstants.CENTER);
		historiaIntro3.setForeground(Color.BLACK);
		historiaIntro3.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		historiaIntro3.setBounds(145, 430, 1112, 234);
		historiaIntro3.setVisible(false);
		add(historiaIntro3);

		JLabel historiaIntro4 = new JLabel(
				"<html>Despierta, héroe, es hora de cumplir tu destino y salvar al mundo una vez más.<br></html>");
		historiaIntro4.setVerticalAlignment(SwingConstants.TOP);
		historiaIntro4.setHorizontalAlignment(SwingConstants.CENTER);
		historiaIntro4.setForeground(Color.BLACK);
		historiaIntro4.setFont(new Font("HYWenHei-85W", Font.PLAIN, 40));
		historiaIntro4.setBounds(272, 230, 832, 234);
		historiaIntro4.setVisible(false);
		add(historiaIntro4);

		JLabel nameLabel = new JLabel("¿Recuerdas tu nombre, eterno?");
		nameLabel.setFont(new Font("HYWenHei-85W", Font.PLAIN, 50));
		nameLabel.setBounds(245, 124, 1112, 138);
		nameLabel.setVisible(false);
		add(nameLabel);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		textFieldName.setBounds(350, 300, 607, 60);
		textFieldName.setVisible(false);
		add(textFieldName);
		textFieldName.setColumns(10);

		JLabel reglasLabel = new JLabel(
				"<html>Por favor, ten en cuenta que el uso de nombres sin números<br> y de una longitud no mayor a 15 caracteres.<html>");
		reglasLabel.setForeground(new Color(255, 0, 0));
		reglasLabel.setFont(new Font("HYWenHei-85W", Font.PLAIN, 15));
		reglasLabel.setBounds(352, 360, 600, 60);
		reglasLabel.setVisible(false);
		add(reglasLabel);

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
					 window.jugador = new Jugador(nombre, (short) 100, armaInicial);
					if(Config.verboseMode && window.jugador != null) {
						System.out.println(window.jugador.getNombre() + " | " + window.jugador.getArma());
					}
					//window.cambiarPantalla(GameWindow.class);
					window.cambiarPantalla(TrivialGameWindow.class);
				} catch (NombreConNumeroException | NombreLargoException | NombreVacioException e1) {
					JOptionPane.showMessageDialog(window, "Ese nombre no es valido", "Nombre invalido", JOptionPane.ERROR_MESSAGE);
					textFieldName.setText("");
					e1.printStackTrace();
				}
			}
		});
		continuarButton.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		continuarButton.setBounds(950, 570, 280, 50);
		continuarButton.setEnabled(false);
		continuarButton.setVisible(false);
		add(continuarButton);

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
		siguienteButton.setBounds(950, 570, 280, 50);
		siguienteButton.setVisible(true);
		add(siguienteButton);

	}
}
