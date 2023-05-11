package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import clases.Usuario;
import exceptions.ContraseñaInvalidaException;
import exceptions.UsuarioNoExisteExceptions;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class LoginMenuWindow extends JPanel {

	private GeneralWindow window;
	private JTextField textFieldUser;
	private JPasswordField passwordField;

	public LoginMenuWindow(GeneralWindow w) {
		setPreferredSize(new Dimension(1650, 1000));
		this.window = w;
		setLayout(null);

		JLabel titleMainMenu = new JLabel("Eternal Ashes");
		titleMainMenu.setForeground(new Color(255, 255, 255));
		titleMainMenu.setFont(new Font("HYWenHei-85W", Font.PLAIN, 80));
		titleMainMenu.setBounds(570, 32, 638, 138);
		add(titleMainMenu);

		JLabel wallpaperLabel = new JLabel("");
		wallpaperLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		wallpaperLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wallpaperLabel.setIcon(new ImageIcon("images\\mainwallpaper.jpg"));
		wallpaperLabel.setMaximumSize(new Dimension(1650, 1000));
		wallpaperLabel.setSize(new Dimension(1650, 1000));
		wallpaperLabel.setBounds(-95, -25, 2110, 1086);

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

		JLabel usuarioLabel = new JLabel("Usuario");
		usuarioLabel.setFont(new Font("HYWenHei-85W", Font.PLAIN, 29));
		usuarioLabel.setBounds(620, 506, 149, 28);
		add(usuarioLabel);

		JLabel passwordLabel = new JLabel("Contraseña");
		passwordLabel.setFont(new Font("HYWenHei-85W", Font.PLAIN, 29));
		passwordLabel.setBounds(601, 601, 168, 28);
		add(passwordLabel);

		textFieldUser = new JTextField();
		textFieldUser.setFont(new Font("HYWenHei-85W", Font.PLAIN, 13));
		textFieldUser.setBounds(803, 506, 275, 28);
		add(textFieldUser);
		textFieldUser.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
		passwordField.setBounds(803, 601, 275, 28);
		add(passwordField);
		
		JButton loginButton = new JButton("Entrar");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char[] passwordChars = passwordField.getPassword();
				String passwordString = new String(passwordChars);
				try {
					Usuario usuario = new Usuario(textFieldUser.getText(), passwordString);
					if (usuario != null) {
						window.cambiarPantalla(MainMenuWindow.class);
					}
				} catch (SQLException | UsuarioNoExisteExceptions e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(window, "Datos introducidos incorrectos");
				} catch(ContraseñaInvalidaException e2) {
					e2.printStackTrace();
					e2.printStackTrace();
				}
				textFieldUser.setText("");
				passwordField.setText("");
			}
		});

		loginButton.setIcon(null);
		loginButton.setFont(new Font("HYWenHei-85W", Font.BOLD, 20));
		loginButton.setBounds(875, 696, 234, 50);
		add(loginButton);

		JButton registButton = new JButton("Registrarse");
		registButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.cambiarPantalla(RegistrarseWindow.class);
			}
		});
		registButton.setFont(new Font("HYWenHei-85W", Font.BOLD, 20));
		registButton.setBounds(610, 696, 234, 50);
		add(registButton);

		add(closeButton);
		add(wallpaperLabel);

	}
}
