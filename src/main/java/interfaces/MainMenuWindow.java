package interfaces;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
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

        // Se crea un objeto JFXPanel para contener el video
        final JFXPanel fxPanel = new JFXPanel();
        fxPanel.setBounds(-95, -25, 1459, 774);
        add(fxPanel);

        // Se crea un objeto Media que contiene la URL del video
        Media media = new Media("C:\\Users\\1DAW\\Desktop\\GitHub\\Eternal-Ashes\\videos\\mainmenuvideo.mp4");

        // Se crea un objeto MediaPlayer y se lo configura para reproducirse en bucle
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
        });
        mediaPlayer.setAutoPlay(true);

        // Se crea un objeto MediaView y se lo agrega al JFXPanel
        MediaView mediaView = new MediaView(mediaPlayer);
        Group root = new Group();
        root.getChildren().add(mediaView);
        Scene scene = new Scene(root);
        fxPanel.setScene(scene);

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
        add(closeButton);
    }
}

