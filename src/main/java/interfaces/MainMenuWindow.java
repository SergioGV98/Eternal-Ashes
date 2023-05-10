package interfaces;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class MainMenuWindow extends JPanel {

    private GeneralWindow window;

    public MainMenuWindow(GeneralWindow w) {
        setPreferredSize(new Dimension(1920, 1080));
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
        
        JLabel closeButton = new JLabel("");
        closeButton.setBackground(new Color(255, 128, 128));
        closeButton.setHorizontalAlignment(SwingConstants.CENTER);
        closeButton.setHorizontalTextPosition(SwingConstants.CENTER);
        closeButton.setIcon(new ImageIcon("C:\\Users\\1DAW\\Desktop\\GitHub\\Eternal-Ashes\\images\\botonMainMenuCerrar.png"));
        closeButton.setBounds(51, 624, 50, 50);
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButton.setIcon(new ImageIcon("C:\\Users\\1DAW\\Desktop\\GitHub\\Eternal-Ashes\\images\\botonMainMenuCerrarHover.png"));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButton.setIcon(new ImageIcon("C:\\Users\\1DAW\\Desktop\\GitHub\\Eternal-Ashes\\images\\botonMainMenuCerrar.png"));
            }
        });
        
        JLabel labelStart = new JLabel("Clic para empezar");
        labelStart.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
        labelStart.setForeground(new Color(255, 255, 255));
        labelStart.setBounds(610, 442, 403, 68);
        Timer timer = new Timer(20, new ActionListener() {
            private int opacity = 255;
            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 5;
                labelStart.setForeground(new Color(255, 255, 255, opacity));
                if (opacity <= 0) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.setRepeats(true);
        timer.start();
        add(labelStart);
        add(closeButton);
        add(backgroundMainMenu);
        
    }
    
}

