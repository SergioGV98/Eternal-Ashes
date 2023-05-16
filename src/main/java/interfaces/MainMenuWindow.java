package interfaces;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenuWindow extends JPanel {

    private GeneralWindow window;
    private Timer timer;

    public MainMenuWindow(GeneralWindow w) {
        setPreferredSize(new Dimension(1650, 720));
        this.window = w;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{345, 112, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 163, 0, 0, 1445, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{195, 0, 68, 105, 0, 0, 0, 203, 55, 240, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel closeButton = new JLabel("");
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
        JLabel titleMainMenu = new JLabel("Eternal Ashes");
        titleMainMenu.setForeground(new Color(255, 255, 255));
        titleMainMenu.setFont(new Font("HYWenHei-85W", Font.PLAIN, 80));
        GridBagConstraints gbc_titleMainMenu = new GridBagConstraints();
        gbc_titleMainMenu.anchor = GridBagConstraints.SOUTHWEST;
        gbc_titleMainMenu.insets = new Insets(0, 0, 5, 5);
        gbc_titleMainMenu.gridx = 16;
        gbc_titleMainMenu.gridy = 1;
        add(titleMainMenu, gbc_titleMainMenu);
        
        JLabel labelStart = new JLabel("Clic para empezar");
        labelStart.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if(e.getClickCount() != 0) {
        			window.cambiarPantalla(LoginMenuWindow.class);
        		}
        	}
        });
        labelStart.setFont(new Font("HYWenHei-85W", Font.PLAIN, 20));
        labelStart.setForeground(new Color(255, 255, 255));
        GridBagConstraints gbc_labelStart = new GridBagConstraints();
        gbc_labelStart.fill = GridBagConstraints.VERTICAL;
        gbc_labelStart.insets = new Insets(0, 0, 5, 5);
        gbc_labelStart.gridx = 16;
        gbc_labelStart.gridy = 4;
        add(labelStart, gbc_labelStart);
        
        GridBagConstraints gbc_closeButton = new GridBagConstraints();
        gbc_closeButton.anchor = GridBagConstraints.WEST;
        gbc_closeButton.fill = GridBagConstraints.VERTICAL;
        gbc_closeButton.insets = new Insets(0, 0, 5, 5);
        gbc_closeButton.gridx = 2;
        gbc_closeButton.gridy = 8;
        add(closeButton, gbc_closeButton);
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
        
    }
    
}

