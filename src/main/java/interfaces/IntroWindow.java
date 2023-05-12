package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntroWindow extends JPanel {

	private GeneralWindow window;
	private Timer timer;

	public IntroWindow(GeneralWindow w) {
		setPreferredSize(new Dimension(1650, 1000));
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
		historiaIntro.setBounds(300, 65, 1112, 234);
		historiaIntro.setVisible(false);
		add(historiaIntro);

		JLabel historiaIntro2 = new JLabel(
				"<html>Sin embargo, durante el proceso de sellado, el artefacto mágico explotó, matando a todos los héroes, excepto uno que quedó gravemente herido.<br>"
						+ "<br>Para evitar que los demonios escaparan del sello incompleto, los sobrevivientes tomaron la difícil decisión de colocar al último héroe restante en un sueño mágico profundo, donde permanecería hasta que fuera el momento adecuado para completar la tarea.<br></html>");
		historiaIntro2.setVerticalAlignment(SwingConstants.TOP);
		historiaIntro2.setHorizontalAlignment(SwingConstants.CENTER);
		historiaIntro2.setForeground(Color.BLACK);
		historiaIntro2.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		historiaIntro2.setBounds(300, 321, 1112, 183);
		historiaIntro2.setVisible(false);
		add(historiaIntro2);

		JLabel historiaIntro3 = new JLabel(
				"<html>Mil años después, el mundo ha cambiado drásticamente. La gente ha olvidado la invasión de los demonios y la historia de los héroes que los salvaron.<br>"
						+ "<br>Sin embargo, los demonios han encontrado la forma de liberarse de su prisión y han comenzado a invadir el mundo de nuevo.<br></html>");
		historiaIntro3.setVerticalAlignment(SwingConstants.TOP);
		historiaIntro3.setHorizontalAlignment(SwingConstants.CENTER);
		historiaIntro3.setForeground(Color.BLACK);
		historiaIntro3.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		historiaIntro3.setBounds(300, 515, 1112, 234);
		historiaIntro3.setVisible(false);
		add(historiaIntro3);

		JLabel historiaIntro4 = new JLabel(
				"<html>Despierta, héroe, es hora de cumplir tu destino y salvar al mundo una vez más.<br></html>");
		historiaIntro4.setVerticalAlignment(SwingConstants.TOP);
		historiaIntro4.setHorizontalAlignment(SwingConstants.CENTER);
		historiaIntro4.setForeground(Color.BLACK);
		historiaIntro4.setFont(new Font("HYWenHei-85W", Font.PLAIN, 40));
		historiaIntro4.setBounds(427, 728, 832, 234);
		historiaIntro4.setVisible(false);
		add(historiaIntro4);
		
		JButton continuar = new JButton("Continuar");
		continuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.cambiarPantalla(GameWindow.class);
			}
		});
		continuar.setFont(new Font("HYWenHei-85W", Font.PLAIN, 18));
		continuar.setBounds(1361, 869, 236, 50);
		continuar.setVisible(false);
		add(continuar);

		JLabel[] labelsHistoria = {historiaIntro, historiaIntro2, historiaIntro3, historiaIntro4};
		
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				historiaIntro.setVisible(true);
			}
		});
		timer.start();

		timer = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				historiaIntro2.setVisible(true);

			}
		});

		timer.start();
		timer = new Timer(10000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				historiaIntro3.setVisible(true);
			}
		});

		timer.start();
		timer = new Timer(15000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				historiaIntro4.setVisible(true);
				continuar.setVisible(true);
			}
		});
		timer.start();
		
		


	}

}
