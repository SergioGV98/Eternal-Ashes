package interfaces;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenuWindow extends JPanel {

    private GeneralWindow window;
    private Timer timer;

    public MainMenuWindow(GeneralWindow w) {
        setPreferredSize(new Dimension(1650, 1000));
        this.window = w;
        setLayout(null);
        JLabel titleMainMenu = new JLabel("Eternal Ashes");
        titleMainMenu.setForeground(new Color(255, 255, 255));
        titleMainMenu.setFont(new Font("HYWenHei-85W", Font.PLAIN, 80));
        titleMainMenu.setBounds(570, 32, 638, 138);
        add(titleMainMenu);
        
        JLabel backgroundMainMenu = new JLabel("");
        backgroundMainMenu.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		window.cambiarPantalla(LoginMenuWindow.class);
        	}
        });
		backgroundMainMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		backgroundMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundMainMenu.setIcon(new ImageIcon("images\\mainwallpaper.jpg"));
		backgroundMainMenu.setMaximumSize(new Dimension(1650, 1000));
		backgroundMainMenu.setSize(new Dimension(1650, 1000));
		backgroundMainMenu.setBounds(-95, -25, 2110, 1086);
        
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
        
        JLabel labelStart = new JLabel("Clic para empezar");
        labelStart.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
        labelStart.setForeground(new Color(255, 255, 255));
        labelStart.setBounds(797, 648, 403, 68);
        timer = new Timer(20, new ActionListener() {
            private int opacity = 255;
            private int delta = -5; 
            @Override
            public void actionPerformed(ActionEvent e) {
                opacity += delta;
                if (opacity <= 0 || opacity >= 255) {
                    delta = -delta; 
                }
                labelStart.setForeground(new Color(255, 255, 255, opacity));
            }
        });

        timer.setRepeats(true);
        timer.start();
        add(labelStart);
        add(closeButton);
        add(backgroundMainMenu);
        
    }
    
}

