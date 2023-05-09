package interfaces;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MainMenuWindow extends JPanel{
	
	private GeneralWindow window;
	
	public MainMenuWindow(GeneralWindow w) {
		setSize(new Dimension(1920, 1080));
		setMaximumSize(new Dimension(1920, 1080));
		this.window = w;
		setLayout(null);
		
		JLabel titleMainMenu = new JLabel("Eternal Ashes");
		titleMainMenu.setForeground(new Color(255, 255, 255));
		titleMainMenu.setFont(new Font("HYWenHei-85W", Font.PLAIN, 80));
		titleMainMenu.setBounds(399, 11, 638, 138);
		add(titleMainMenu);
		
		JLabel backgroundMainMenu = new JLabel("");
		backgroundMainMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		backgroundMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundMainMenu.setIcon(new ImageIcon("C:\\Users\\1DAW\\Desktop\\GitHub\\Eternal-Ashes\\images\\mainwallpaper.jpg"));
		backgroundMainMenu.setMaximumSize(new Dimension(1920, 1080));
		backgroundMainMenu.setSize(new Dimension(1920, 1080));
		backgroundMainMenu.setBounds(-95, -25, 1459, 774);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setMinimumSize(new Dimension(100, 100));
		lblNewLabel_2.setMaximumSize(new Dimension(100, 100));
		lblNewLabel_2.setPreferredSize(new Dimension(100, 100));
		lblNewLabel_2.setSize(new Dimension(100, 100));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\1DAW\\Desktop\\GitHub\\Eternal-Ashes\\images\\botonMainMenuCerrar.png"));
		lblNewLabel_2.setBounds(97, 247, 192, 128);
		add(lblNewLabel_2);
		add(backgroundMainMenu);
	}
}
