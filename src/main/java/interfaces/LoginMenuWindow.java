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
		setSize(new Dimension(1300, 700));

		this.window = w;
		setLayout(null);

		JLabel titleMainMenu = new JLabel("Eternal Ashes");
		titleMainMenu.setForeground(new Color(255, 255, 255));
		titleMainMenu.setFont(new Font("HYWenHei-85W", Font.PLAIN, 80));
		titleMainMenu.setBounds(406, 29, 638, 138);
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
		closeButton.setBounds(97, 536, 50, 50);
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
		usuarioLabel.setBounds(425, 317, 149, 28);
		add(usuarioLabel);

		JLabel passwordLabel = new JLabel("Contraseña");
		passwordLabel.setFont(new Font("HYWenHei-85W", Font.PLAIN, 29));
		passwordLabel.setBounds(406, 412, 168, 28);
		add(passwordLabel);

		textFieldUser = new JTextField();
		textFieldUser.setFont(new Font("HYWenHei-85W", Font.PLAIN, 13));
		textFieldUser.setBounds(610, 317, 275, 28);
		add(textFieldUser);
		textFieldUser.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
		passwordField.setBounds(610, 412, 275, 28);
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
						window.cambiarPantalla(IntroWindow.class);
					}
				} catch (SQLException | UsuarioNoExisteExceptions e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(window, "Usuario invalido","Usuario invalido",JOptionPane.WARNING_MESSAGE);
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
		loginButton.setBounds(710, 499, 234, 50);
		add(loginButton);

		JButton registButton = new JButton("Registrarse");
		registButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.cambiarPantalla(RegistrarseWindow.class);
			}
		});
		registButton.setFont(new Font("HYWenHei-85W", Font.BOLD, 20));
		registButton.setBounds(458, 499, 234, 50);
		add(registButton);

		add(closeButton);
		add(wallpaperLabel);

	}
}
