package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginMenuWindow extends JPanel {

	private GeneralWindow window;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;

	public LoginMenuWindow(GeneralWindow w) {
		setPreferredSize(new Dimension(1650, 1000));
		this.window = w;
		setLayout(null);

		JLabel titleMainMenu = new JLabel("Eternal Ashes");
		titleMainMenu.setForeground(new Color(255, 255, 255));
		titleMainMenu.setFont(new Font("HYWenHei-85W", Font.PLAIN, 80));
		titleMainMenu.setBounds(610, 31, 638, 138);
		add(titleMainMenu);

		JLabel wallpaperLabel = new JLabel("");
		wallpaperLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		wallpaperLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wallpaperLabel.setIcon(new ImageIcon("images\\mainwallpaper.jpg"));
		wallpaperLabel.setMaximumSize(new Dimension(1650, 1000));
		wallpaperLabel.setSize(new Dimension(1650, 1000));
		wallpaperLabel.setBounds(-102, 22, 2110, 1086);

		JLabel closeButton = new JLabel("");
		closeButton.setBackground(new Color(255, 128, 128));
		closeButton.setHorizontalAlignment(SwingConstants.CENTER);
		closeButton.setHorizontalTextPosition(SwingConstants.CENTER);
		closeButton.setIcon(new ImageIcon("images\\botonMainMenuCerrar.png"));
		closeButton.setBounds(200, 821, 50, 50);
		closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				System.exit(0);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				closeButton.setIcon(new ImageIcon("images\\botonMainMenuCerrarHover.png"));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				closeButton.setIcon(new ImageIcon("images\\botonMainMenuCerrar.png"));
			}
		});

		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("HYWenHei-85W", Font.PLAIN, 29));
		emailLabel.setBounds(644, 501, 149, 28);
		add(emailLabel);
		
		JLabel passwordLabel = new JLabel("Contraseña");
		passwordLabel.setFont(new Font("HYWenHei-85W", Font.PLAIN, 29));
		passwordLabel.setBounds(601, 601, 168, 28);
		add(passwordLabel);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("HYWenHei-85W", Font.PLAIN, 11));
		textFieldEmail.setBounds(803, 506, 275, 28);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(803, 601, 275, 28);
		add(passwordField);
		
		JButton loginButton = new JButton("Entrar");
		loginButton.setIcon(null);
		loginButton.setFont(new Font("HYWenHei-85W", Font.BOLD, 20));
		loginButton.setBounds(875, 696, 234, 50);
		add(loginButton);
		
		JButton registButton = new JButton("Registrarse");
		registButton.setFont(new Font("HYWenHei-85W", Font.BOLD, 20));
		registButton.setBounds(610, 696, 234, 50);
		add(registButton);
		
		
		add(closeButton);
		add(wallpaperLabel);
		
		
	}
}
