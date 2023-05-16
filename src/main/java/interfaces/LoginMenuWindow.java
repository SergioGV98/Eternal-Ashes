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
import java.sql.SQLException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class LoginMenuWindow extends JPanel {

	private GeneralWindow window;
	private JTextField textFieldUser;
	private JPasswordField passwordField;

	public LoginMenuWindow(GeneralWindow w) {
		setPreferredSize(new Dimension(1650, 1000));
		this.window = w;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{98, 37, 227, 86, 46, 0, 0, 33, 0, 0};
		gridBagLayout.rowHeights = new int[]{32, 138, 72, 28, 27, 28, 0, 0, 0, 37, 125, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
								
										JLabel titleMainMenu = new JLabel("Eternal Ashes");
										titleMainMenu.setForeground(new Color(255, 255, 255));
										titleMainMenu.setFont(new Font("HYWenHei-85W", Font.PLAIN, 80));
										GridBagConstraints gbc_titleMainMenu = new GridBagConstraints();
										gbc_titleMainMenu.insets = new Insets(0, 0, 5, 5);
										gbc_titleMainMenu.gridwidth = 5;
										gbc_titleMainMenu.gridx = 3;
										gbc_titleMainMenu.gridy = 1;
										add(titleMainMenu, gbc_titleMainMenu);
						
								JLabel usuarioLabel = new JLabel("Usuario");
								usuarioLabel.setFont(new Font("HYWenHei-85W", Font.PLAIN, 29));
								GridBagConstraints gbc_usuarioLabel = new GridBagConstraints();
								gbc_usuarioLabel.anchor = GridBagConstraints.EAST;
								gbc_usuarioLabel.insets = new Insets(0, 0, 5, 5);
								gbc_usuarioLabel.gridx = 3;
								gbc_usuarioLabel.gridy = 3;
								add(usuarioLabel, gbc_usuarioLabel);
								
										textFieldUser = new JTextField();
										textFieldUser.setFont(new Font("HYWenHei-85W", Font.PLAIN, 18));
										GridBagConstraints gbc_textFieldUser = new GridBagConstraints();
										gbc_textFieldUser.fill = GridBagConstraints.HORIZONTAL;
										gbc_textFieldUser.insets = new Insets(0, 0, 5, 5);
										gbc_textFieldUser.gridx = 5;
										gbc_textFieldUser.gridy = 3;
										add(textFieldUser, gbc_textFieldUser);
										textFieldUser.setColumns(10);
						
								JLabel passwordLabel = new JLabel("Contraseña");
								passwordLabel.setFont(new Font("HYWenHei-85W", Font.PLAIN, 29));
								GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
								gbc_passwordLabel.anchor = GridBagConstraints.EAST;
								gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
								gbc_passwordLabel.gridx = 3;
								gbc_passwordLabel.gridy = 5;
								add(passwordLabel, gbc_passwordLabel);
				
						passwordField = new JPasswordField();
						passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
						GridBagConstraints gbc_passwordField = new GridBagConstraints();
						gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
						gbc_passwordField.insets = new Insets(0, 0, 5, 5);
						gbc_passwordField.gridx = 5;
						gbc_passwordField.gridy = 5;
						add(passwordField, gbc_passwordField);
						
								JButton registButton = new JButton("Registrarse");
								registButton.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										window.cambiarPantalla(RegistrarseWindow.class);
									}
								});
								
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
										GridBagConstraints gbc_loginButton = new GridBagConstraints();
										gbc_loginButton.insets = new Insets(0, 0, 5, 5);
										gbc_loginButton.gridx = 5;
										gbc_loginButton.gridy = 7;
										add(loginButton, gbc_loginButton);
								registButton.setFont(new Font("HYWenHei-85W", Font.BOLD, 20));
								GridBagConstraints gbc_registButton = new GridBagConstraints();
								gbc_registButton.insets = new Insets(0, 0, 5, 5);
								gbc_registButton.gridx = 5;
								gbc_registButton.gridy = 8;
								add(registButton, gbc_registButton);
						
								JLabel closeButton = new JLabel("aaa");
								closeButton.setBackground(new Color(255, 128, 128));
								closeButton.setIcon(new ImageIcon("images\\botonMainMenuCerrar.png"));
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
								
										GridBagConstraints gbc_closeButton = new GridBagConstraints();
										gbc_closeButton.insets = new Insets(0, 0, 0, 5);
										gbc_closeButton.gridx = 1;
										gbc_closeButton.gridy = 11;
										add(closeButton, gbc_closeButton);

	}
}
