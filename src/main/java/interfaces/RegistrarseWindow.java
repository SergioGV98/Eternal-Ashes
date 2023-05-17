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
import utils.Config;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class RegistrarseWindow extends JPanel {

	private GeneralWindow window;
	private JTextField textFieldUsuario;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;

	public RegistrarseWindow(GeneralWindow w) {
		setPreferredSize(new Dimension(1300, 700));
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

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("HYWenHei-85W", Font.PLAIN, 29));
		lblUsuario.setBounds(434, 241, 263, 60);
		add(lblUsuario);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("HYWenHei-85W", Font.PLAIN, 29));
		lblEmail.setBounds(434, 312, 263, 60);
		add(lblEmail);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("HYWenHei-85W", Font.PLAIN, 29));
		lblContrasea.setBounds(434, 383, 263, 60);
		add(lblContrasea);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("HYWenHei-85W", Font.PLAIN, 13));
		textFieldUsuario.setBounds(664, 257, 275, 34);
		add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("HYWenHei-85W", Font.PLAIN, 13));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(664, 324, 275, 34);
		add(textFieldEmail);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 13));
		passwordField.setBounds(664, 396, 275, 34);
		add(passwordField);

		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    try {
			        char[] passwordChars = passwordField.getPassword();
			        String passwordString = new String(passwordChars);
			        String usuarioTexto = textFieldUsuario.getText();
			        String emailTexto = textFieldEmail.getText();

			        // Verificar si los campos están vacíos
			        if (usuarioTexto.isEmpty() || emailTexto.isEmpty() || passwordString.isEmpty()) {
			            JOptionPane.showMessageDialog(window, "Por favor complete todos los campos","Campos vacios",JOptionPane.ERROR_MESSAGE);
			            return;
			        }

			        Usuario usuario = new Usuario(usuarioTexto, emailTexto, passwordString);
			        if (usuario != null) {
			        	if(Config.verboseMode) {
			        		System.out.println("Cliente registrado con exito");
			        	}
			            JOptionPane.showMessageDialog(window, "Registro completado con exito","Exito",JOptionPane.INFORMATION_MESSAGE);
			            window.cambiarPantalla(LoginMenuWindow.class);
			        }
			    } catch(SQLIntegrityConstraintViolationException e2) {
			    	JOptionPane.showMessageDialog(window, "Usuario ya registrado","Error", JOptionPane.ERROR_MESSAGE);
			    	e2.printStackTrace();
			    }catch (SQLException e3) {
			        e3.printStackTrace();
			        JOptionPane.showMessageDialog(window, "Registro fallido", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			    textFieldUsuario.setText("");
			    textFieldEmail.setText("");
			    passwordField.setText("");
			}
		});
		btnNewButton.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		btnNewButton.setBounds(533, 496, 245, 34);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.cambiarPantalla(LoginMenuWindow.class);
			}
		});
		btnNewButton_1.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
		btnNewButton_1.setBounds(119, 623, 151, 34);
		add(btnNewButton_1);

		add(wallpaperLabel);
	}
}
